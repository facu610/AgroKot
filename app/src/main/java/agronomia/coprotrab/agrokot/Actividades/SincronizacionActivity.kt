package agronomia.coprotrab.agrokot.Actividades

import agronomia.coprotrab.agrokot.Clases.DataResources.DBHelper
import agronomia.coprotrab.agrokot.Clases.DataResources.DataAccess_RegistroAgrotecnico_App
import agronomia.coprotrab.agrokot.Clases.DataResources.database
import agronomia.coprotrab.agrokot.Clases.Entidades.AgroFertilizantes
import agronomia.coprotrab.agrokot.Clases.Entidades.FichaGeneral
import agronomia.coprotrab.agrokot.Clases.Entidades.Instructor
import agronomia.coprotrab.agrokot.Clases.Entidades.MaeSocio
import agronomia.coprotrab.agrokot.Clases.Network
import agronomia.coprotrab.agrokot.R
import agronomia.coprotrab.agrokot.R.drawable.button_border
import android.annotation.SuppressLint
import android.database.sqlite.SQLiteDatabase
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.StrictMode
import android.support.v4.content.ContextCompat
import android.view.View
import android.support.v7.widget.Toolbar
import android.widget.*
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.github.kittinunf.fuel.android.extension.responseJson
import com.github.kittinunf.fuel.core.FuelManager
import com.github.kittinunf.fuel.httpPost
import com.google.gson.Gson
import org.jetbrains.anko.*
import org.jetbrains.anko.db.insert
import java.io.InputStream
import java.net.URL
import javax.net.ssl.HttpsURLConnection

class SincronizacionActivity : AppCompatActivity() {

    var fgralesToSincro: ArrayList<FichaGeneral>? = null
    var numToSincro:Int = 0
    var toolbar:Toolbar? =null


    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sincronizacion)
        toolbar = findViewById(R.id.tb_act_sincro)
        toolbar?.title = "Sincronización"
        toolbar?.setTitleMargin(10,10,10,10)
        setSupportActionBar(toolbar)


        FuelManager.instance.basePath = "http://demosmushtaq.16mb.com"



        val bSincroInstr = findViewById<Button>(R.id.b_SincroInstr)
        val bPruebaConex = findViewById<Button>(R.id.b_PruebaConex)
        val bSincroSoc = findViewById<Button>(R.id.b_SincroSocios)
        val bSincroFic = findViewById<Button>(R.id.b_SincroFichas)
        val bNoSincroFic = findViewById<Button>(R.id.b_NoSincroFichas)

        val tv_sincro_tosincro = findViewById<TextView>(R.id.tv_Sincro_ToSincro)


        fgralesToSincro = DataAccess_RegistroAgrotecnico_App(this).select_FGeneralesToSincro()
        numToSincro = fgralesToSincro!!.count()

        if (numToSincro != 0){

            tv_sincro_tosincro.text = "Fichas a Sincronizar: " + numToSincro.toString()
            bSincroFic.visibility = View.VISIBLE
            bNoSincroFic.visibility = View.INVISIBLE
            bSincroFic.setBackgroundColor(ContextCompat.getColor(this, R.color.primaryLightColor))
        }
        else{
            tv_sincro_tosincro.text = ""
            bSincroFic.visibility = View.INVISIBLE
            bNoSincroFic.visibility = View.VISIBLE

     }

        bPruebaConex.setOnClickListener{
            val dialog = indeterminateProgressDialog(message = "Por favor espere un momento…", title = "Estableciendo conexión")
            dialog.setCancelable(false)
            if (Network.isConecctedToCoop()) {
                bSincroInstr.visibility = View.VISIBLE
                bSincroSoc.visibility = View.VISIBLE
                dialog.dismiss()
                Toast.makeText(this, "Conexíon a Coprotab estable.", Toast.LENGTH_LONG).show()
            }else {
                dialog.dismiss()
                Toast.makeText(this, "Compruebe su conexión con Coprotab.", Toast.LENGTH_LONG).show()
            }
        }

        bSincroInstr.setOnClickListener {
            val dialog = indeterminateProgressDialog(message = "Por favor espere un momento…", title = "Descargando complementarios")
            dialog.setCancelable(false)
            doAsync {
                val respuesta = URL("http://192.168.50.108/AppAgronomia/api/AA_Instructores").readText()
                val gson = Gson()
                val instructores = gson.fromJson(respuesta, Array<Instructor>::class.java)
                DataAccess_RegistroAgrotecnico_App(applicationContext).delete_Instructores()
                database.use {
                    instructores.forEach {
                        insert("AA_Instructores",
                                "ID_Instr" to it.ID_Instr,
                                "User_Instr" to it.User_Instr,
                                "Nombre_Instr" to it.Nombre_Instr,
                                "Zona_Instr" to it.Zona_Instr,
                                "Issuper_Instr" to it.Issuper_Instr,
                                "Idvehiculo_Instr" to it.Idvehiculo_Instr,
                                "Idmovil_Instr" to it.Idmovil_Instr,
                                "Pass_Instr" to it.Pass_Instr)
                    }
                }

                uiThread { longToast("Instructores Sincronizados") }

            }
            doAsync {
                val respuesta = URL("http://192.168.50.108/AppAgronomia/api/AgroFertilizantes").readText()
                val gson = Gson()
                val agrofertilizantes = gson.fromJson(respuesta, Array<AgroFertilizantes>::class.java)

                DataAccess_RegistroAgrotecnico_App(applicationContext).delete_AgroFertilizantes()
                database.use {
                    agrofertilizantes.forEach {
                        insert("AgroFertilizantes",
                                "Codigo_AF" to it.Codigo_AF,
                                "Nombre_AF" to it.Nombre_AF,
                                "Codigo_TipoAF" to it.Codigo_TipoAF,
                                "Permitido_AF" to it.Permitido_AF)
                    }
                }
                dialog.dismiss()
                uiThread { longToast("AgroFertilizantes Sincronizados") }

            }
        }

        bSincroSoc.setOnClickListener {
           val dialog = indeterminateProgressDialog(message = "Por favor espere un momento…", title = "Descargando socios")
            dialog.setCancelable(false)
            doAsync {

                val respuestasocios = URL("http://192.168.50.108/AppAgronomia/api/MaeSocios").readText()
                val gsonsocios = Gson()
                val maesocios = gsonsocios.fromJson(respuestasocios, Array<MaeSocio>::class.java)
                DataAccess_RegistroAgrotecnico_App(applicationContext).delete_MaeSocios()
                database.use {
                    maesocios.forEach {
                        insert("AA_MaeSocios",
                                "ID_Soc" to it.ID_Soc,
                                "FET_Soc" to it.FET_Soc,
                                "Nombre_Soc" to it.Nombre_Soc,
                                "Kilos_Soc" to it.Kilos_Soc,
                                "Domicilio_Soc" to it.Domicilio_Soc,
                                "Localidad_Soc" to it.Localidad_Soc,
                                "Telefono_Soc" to it.Telefono_Soc)
                    }
                }
                dialog.dismiss()
                uiThread { longToast("Socios Sincronizados. Total: " + maesocios.count().toString()) }

            }
        }

        bSincroFic.setOnClickListener {
            val dialog = indeterminateProgressDialog(message = "Por favor espere un momento…", title = "Sincronizando Fichas")
            doAsync {

                for ( item in fgralesToSincro!!){
                    val fichageneral = FichaGeneral(
                            item.ID_Ficha,
                            item.Fecha_Grales,
                            item.ID_Camp ,
                            item.ID_Soc,
                            item.Fet_Soc,
                            item.ID_Instr,
                            item.Finca_Soc,
                            item.Local_Soc,
                            item.Coord_Soc,
                            item.Zona_Soc,
                            item.ToSincro,
                            item.Grado_RiesgoAPC,
                            item.Nombre_RiesgoAPC,
                            item.Agro_Has_Propias,
                            item.Agro_Has_Arren,
                            item.Agro_Has_Tot,
                            item.Agro_Cat_DTR,
                            item.Agro_Verdeos_Has,
                            item.Agro_Rot_Has,
                            item.Agro_Dep_APC,
                            item.Agro_Cumple_Rec,
                            item.Agro_MangaRiego_Has,
                            item.Agro_Suelo_N,
                            item.Agro_Suelo_NUd,
                            item.Agro_Suelo_P,
                            item.Agro_Suelo_PUd,
                            item.Agro_Suelo_K,
                            item.Agro_Suelo_KUd,
                            item.Agro_Suelo_MO,
                            item.Agro_Suelo_MOUd,
                            item.Agro_Suelo_PH,
                            item.Agro_Agua_CE,
                            item.Agro_Agua_CEUd,
                            item.Agro_Agua_Carb,
                            item.Agro_Agua_CarbUd,
                            item.Agro_Agua_PH,
                            item.Agro_Obs,
                            item.Infra_Cumple_Rec,
                            item.Infra_Posee_Galp,
                            item.Infra_Galpon_m3,
                            item.Infra_Total_Canas,
                            item.Infra_HasEstuf,
                            item.Infra_Obs,
                            item.Infra_Est_Conv,
                            item.Infra_Conv_Gas,
                            item.Infra_Conv_Gas_CI,
                            item.Infra_Conv_Gas_SI,
                            item.Infra_Conv_Gas_Canas,
                            item.Infra_Conv_Gas_Perchas,
                            item.Infra_Conv_Lena,
                            item.Infra_Conv_Lena_Perchas,
                            item.Infra_Conv_Lena_Canas,
                            item.Infra_Bulk_Cur,
                            item.Infra_BC_Gas,
                            item.Infra_BC_Gas_CI,
                            item.Infra_BC_Gas_SI,
                            item.Infra_BC_Gas_Peines,
                            item.Infra_BC_Lena,
                            item.Infra_BC_Lena_CI,
                            item.Infra_BC_Lena_Peines,

                            item.AlmaConv_Is,
                            item.To_Sincro_AlmaConv,

                            item.AlmaFlot_Is,
                            item.To_Sincro_AlmaFlot,
                            item.AlmaBand_Is,
                            item.To_Sincro_AlmaBand,
                            item.AlmaApoya_Is,
                            item.To_Sincro_AlmaApoya,
                            item.AlmaVar_Is,
                            item.To_Sincro_AlmaVar
                    )

                    var fichaJson = Gson().toJson(fichageneral)
                    "http://192.168.50.108/AppAgronomia/api/AA_FichasGenerales"
                            .httpPost()
                            .header("Content-Type" to "application/json")
                            .body(fichaJson.toString())
                            .responseJson { request, response, result ->
                            }

                    DataAccess_RegistroAgrotecnico_App(applicationContext).delete_FGenerales(item.ID_Soc)
                    database.use {
                        insert("AA_FichasGenerales",
                                "ID_Ficha" to item.ID_Ficha,
                                "Fecha_Grales" to item.Fecha_Grales,
                                "ID_Camp" to item.ID_Camp,
                                "ID_Soc" to item.ID_Soc,
                                "Fet_Soc" to item.Fet_Soc,
                                "ID_Instr" to item.ID_Instr,
                                "Finca_Soc" to item.Finca_Soc,
                                "Local_Soc" to item.Local_Soc,
                                "Coord_Soc" to item.Coord_Soc,
                                "Zona_Soc" to item.Zona_Soc,
                                "ToSincro" to 0,
                                "Grado_RiesgoAPC" to item.Grado_RiesgoAPC,
                                "Nombre_RiesgoAPC" to item.Nombre_RiesgoAPC,
                                "Agro_Has_Propias" to item.Agro_Has_Propias,
                                "Agro_Has_Arren" to item.Agro_Has_Arren,
                                "Agro_Has_Tot" to item.Agro_Has_Tot,
                                "Agro_Cat_DTR" to item.Agro_Cat_DTR,
                                "Agro_Verdeos_Has" to item.Agro_Verdeos_Has,
                                "Agro_Rot_Has" to item.Agro_Rot_Has,
                                "Agro_Dep_APC" to item.Agro_Dep_APC,
                                "Agro_Cumple_Rec" to item.Agro_Cumple_Rec,
                                "Agro_MangaRiego_Has" to item.Agro_MangaRiego_Has,
                                "Agro_Suelo_N" to item.Agro_Suelo_N,
                                "Agro_Suelo_NUd" to item.Agro_Suelo_NUd,
                                "Agro_Suelo_P" to item.Agro_Suelo_P,
                                "Agro_Suelo_K" to item.Agro_Suelo_K,
                                "Agro_Suelo_KUd" to item.Agro_Suelo_KUd,
                                "Agro_Suelo_MO" to item.Agro_Suelo_MO,
                                "Agro_Suelo_MOUd" to item.Agro_Suelo_MOUd,
                                "Agro_Suelo_PH" to item.Agro_Suelo_PH,
                                "Agro_Agua_CE" to item.Agro_Agua_CE,
                                "Agro_Agua_CEUd" to item.Agro_Agua_CEUd,
                                "Agro_Agua_Carb" to item.Agro_Agua_Carb,
                                "Agro_Agua_CarbUd" to item.Agro_Agua_CarbUd,
                                "Agro_Agua_PH" to item.Agro_Agua_PH,
                                "Agro_Obs" to item.Agro_Obs,
                                "Infra_Cumple_Rec" to item.Infra_Cumple_Rec,
                                "Infra_Posee_Galp" to item.Infra_Posee_Galp,
                                "Infra_Galpon_m3" to item.Infra_Galpon_m3,
                                "Infra_Total_Canas" to item.Infra_Total_Canas,
                                "Infra_HasEstuf" to item.Infra_HasEstuf,
                                "Infra_Obs" to item.Infra_Obs,
                                "Infra_Est_Conv" to item.Infra_Est_Conv,
                                "Infra_Conv_Gas" to item.Infra_Conv_Gas,
                                "Infra_Conv_Gas_CI" to item.Infra_Conv_Gas_CI,
                                "Infra_Conv_Gas_SI" to item.Infra_Conv_Gas_SI,
                                "Infra_Conv_Gas_Canas" to item.Infra_Conv_Gas_Canas,
                                "Infra_Conv_Gas_Perchas" to item.Infra_Conv_Gas_Perchas,
                                "Infra_Conv_Lena" to item.Infra_Conv_Lena,
                                "Infra_Conv_Lena_Perchas" to item.Infra_Conv_Lena_Perchas,
                                "Infra_Conv_Lena_Canas" to item.Infra_Conv_Lena_Canas,
                                "Infra_Bulk_Cur" to item.Infra_Bulk_Cur,
                                "Infra_BC_Gas" to item.Infra_BC_Gas,
                                "Infra_BC_Gas_CI" to item.Infra_BC_Gas_CI,
                                "Infra_BC_Gas_SI" to item.Infra_BC_Gas_SI,
                                "Infra_BC_Gas_Peines" to item.Infra_BC_Gas_Peines,
                                "Infra_BC_Lena" to item.Infra_BC_Lena,
                                "Infra_BC_Lena_CI" to item.Infra_BC_Lena_CI,
                                "Infra_BC_Lena_Peines" to item.Infra_BC_Lena_Peines,

                                "AlmaConv_Is" to item.AlmaConv_Is,
                                "To_Sincro_AlmaConv" to item.To_Sincro_AlmaConv,

                                "AlmaFlot_Is" to item.AlmaFlot_Is,
                                "To_Sincro_AlmaFlot" to item.To_Sincro_AlmaFlot,
                                "AlmaBand_Is" to item.AlmaBand_Is,
                                "To_Sincro_AlmaBand" to item.To_Sincro_AlmaBand,
                                "AlmaApoya_Is" to item.AlmaApoya_Is,
                                "To_Sincro_AlmaApoya" to item.To_Sincro_AlmaApoya,
                                "AlmaVar_Is" to item.AlmaVar_Is,
                                "To_Sincro_AlmaVar" to item.To_Sincro_AlmaVar
                                )
                    }
                }
                dialog.dismiss()
                uiThread { longToast("Fichas Sincronizadas. Total: " + fgralesToSincro?.count().toString()) }
                act.recreate()
            }
        }
    }

    //Metodo Volley
    private fun solicitudHTPPVolley(url: String) {
        val cola = Volley.newRequestQueue(this)
        val solicitud = StringRequest(Request.Method.GET, url, Response.Listener<String> { response ->
            try {
            } catch (e: Exception) {

            }
        }, Response.ErrorListener { })
        cola.add(solicitud)
    }

    private fun descargarDatos(url: String): String {
        val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)

        var inputStream: InputStream? = null

        try {
            val url = URL(url)
            val conn = url.openConnection() as HttpsURLConnection
            conn.requestMethod = "GET"
            conn.connect()

            inputStream = conn.inputStream
            return inputStream.bufferedReader().use {
                it.readText()
            }
        } finally {
            if (inputStream != null) {
                inputStream.close()
            }
        }
    }


}