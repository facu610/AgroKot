package agronomia.coprotrab.agrokot.Actividades

import agronomia.coprotrab.agrokot.Clases.DataResources.database
import agronomia.coprotrab.agrokot.Clases.Entidades.Instructor
import agronomia.coprotrab.agrokot.Clases.Entidades.MaeSocio
import agronomia.coprotrab.agrokot.R
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.StrictMode
import android.view.View
import android.widget.Button
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import org.jetbrains.anko.*
import org.jetbrains.anko.db.insert
import java.io.InputStream
import java.net.URL
import javax.net.ssl.HttpsURLConnection

class SincronizacionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sincronizacion)

//        if (Network.validaConeccion(this)) {
//            Toast.makeText(this, "Si hay red", Toast.LENGTH_LONG).show()
//            Log.d("bSincroOnClick", descargarDatos("https://google.com"))
//            //SOLICITAR SOLICITUD HTPP
//
//        } else {
//            Toast.makeText(this, "No hay Internet", Toast.LENGTH_LONG).show()
//        }

//        val bCambiarInstr = findViewById<Button>(R.id.b_CambiarInstr)
//        bCambiarInstr.setOnClickListener(View.OnClickListener {
//            val instr: String
//            Toast.makeText(this, "Instructor cambiado con éxito, Bienvenido ", Toast.LENGTH_LONG).show()
//        })

        val bSincroInstr = findViewById<Button>(R.id.b_SincroInstr)
        val bSincroSoc: Button = findViewById<Button>(R.id.b_SincroSocios)

        bSincroInstr.setOnClickListener(View.OnClickListener{

            doAsync {

                val respuesta = URL("http://192.168.50.108/AppAgronomia/api/AA_Instructores").readText()
                //val respuesta = URL("https://api.openweathermap.org/data/2.5/forecast/daily?mode=json&units=metric&cnt=7").readText()
                //val respuesta = URL(" https://jsonplaceholder.typicode.com/posts").readText()
                val gson=Gson()
                val instructores = gson.fromJson(respuesta, Array<Instructor>::class.java)

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
                uiThread { longToast("Instructores Sincronizados")}
            }
        })

        bSincroSoc.setOnClickListener(View.OnClickListener {
            doAsync {
                val respuestasocios = URL("http://192.168.50.108/AppAgronomia/api/MaeSocios").readText()
                val gsonsocios = Gson()
                val maesocios = gsonsocios.fromJson(respuestasocios, Array<MaeSocio>::class.java)

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
                uiThread { longToast("Socios Sincronizados. Total: " + maesocios.count().toString() ) }
            }
        })
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