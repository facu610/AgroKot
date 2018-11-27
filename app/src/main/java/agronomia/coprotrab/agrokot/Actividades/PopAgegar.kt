package agronomia.coprotrab.agrokot.Actividades

import agronomia.coprotrab.agrokot.Clases.DataResources.DataAccess_RegistroAgrotecnico_App
import agronomia.coprotrab.agrokot.Clases.DataResources.database
import agronomia.coprotrab.agrokot.Fragments.AlmaConvencionalFragment
import agronomia.coprotrab.agrokot.R
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.util.DisplayMetrics
import android.view.Gravity
import android.view.View
import android.widget.*
import org.jetbrains.anko.db.MapRowParser
import org.jetbrains.anko.db.insert
import org.jetbrains.anko.db.select
import java.text.SimpleDateFormat
import java.util.*

class PopAgegar : AppCompatActivity() {


    var toolbar: Toolbar? = null
    var spin_AF: Spinner? = null
    var spin_Ud: Spinner? = null
    var listView: ListView? = null
    var et_pop_dosis: EditText? = null
    var items: ArrayList<String>? = null




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.popagregar_layout)

        val id_socio: Int =  (intent.getStringExtra("agronomia.coprotab.agrokot.ID_SOCIO").toInt())
        val tipoAF:Int = (intent.getStringExtra("agronomia.coprotab.agrokot.TIPO_AF").toInt())
        val tipoAlma:String = (intent.getStringExtra("agronomia.coprotab.agrokot.ALMA").toString())
        val densidad:String = (intent.getStringExtra("agronomia.coprotab.agrokot.DENS").toString())


        toolbar = findViewById(R.id.tb_act_pop)
        toolbar?.title ="Agregar"

        val af_fertilizantes = DataAccess_RegistroAgrotecnico_App(this).select_AF_NombreFertilizantes(tipoAF)

        val arrayAdapter_Ud: ArrayAdapter<CharSequence> = ArrayAdapter.createFromResource(this, R.array.unidades_af, android.R.layout.simple_spinner_item)
        val arrayAdapter_AF =  ArrayAdapter(this, android.R.layout.simple_spinner_item, af_fertilizantes)
        arrayAdapter_Ud.setDropDownViewResource(R.layout.spinner_item)
        arrayAdapter_AF.setDropDownViewResource(R.layout.spinner_item)

        spin_AF = findViewById(R.id.S_Pop_Fertilizantes)
        spin_AF?.adapter = arrayAdapter_AF

        spin_Ud = findViewById(R.id.S_Pop_Dosis_Ud)
        spin_Ud?.adapter = arrayAdapter_Ud

        et_pop_dosis = findViewById(R.id.et_Pop_Dosis)

        val displayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics)

        var width = displayMetrics.widthPixels
        var height = displayMetrics.heightPixels

        val date = getCurrentDateTime()
        val dateInString = date.toString("yyyy/MM/dd HH:mm:ss")

        with(window) {
            setLayout((width*.8).toInt(),(height*.4).toInt())
            setGravity(Gravity.CENTER)
            val b_pop_agregar = findViewById<Button>(R.id.b_Pop_Agregar) as Button

            b_pop_agregar.setOnClickListener {

                val nombre:String = spin_AF!!.selectedItem.toString()
                val codigo_af:Int = DataAccess_RegistroAgrotecnico_App(context).obtiene_idAF(nombre).toInt()
                var dosis:Float? = null

                if(et_pop_dosis!!.text.toString() != "") {
                     dosis = et_pop_dosis!!.text.toString().toFloat()
                } else {
                    Toast.makeText(context, "Complete todos los campos...", Toast.LENGTH_LONG).show()
                    return@setOnClickListener
                }

                when (tipoAlma){
                    "CONV" ->{
                        if (tipoAF == 5 ) {
                            database.use {
                                insert("AA_Almacigo_ConvxDetalle",
                                        "ID_Alma_Conv_Detalle" to 0,
                                        "ID_Socio" to id_socio,
                                        "Fecha" to dateInString,
                                        "ID_AF_APC_Conv" to codigo_af,
                                        "Nombre_AF_APC_Conv" to nombre,
                                        "AF_APC_Unid_Conv" to spin_Ud!!.selectedItem.toString(),
                                        "AF_APC_Dosis_Conv" to dosis,
                                        "Codigo_TipoAF" to 5,
                                        "Densidad" to densidad)}
                        } else{
                            database.use {
                                insert("AA_Almacigo_ConvxDetalle",
                                        "ID_Alma_Conv_Detalle" to 0,
                                        "ID_Socio" to id_socio,
                                        "Fecha" to dateInString,
                                        "ID_AF_Fert_Conv" to codigo_af,
                                        "Nombre_AF_Fert_Conv" to nombre,
                                        "AF_Fert_Unid_Conv" to spin_Ud!!.selectedItem.toString(),
                                        "AF_Fert_Dosis_Conv" to dosis,
                                        "Codigo_TipoAF" to 1,
                                        "Densidad" to densidad)}}
                        Toast.makeText(context, "Fertilizante Añadido", Toast.LENGTH_LONG).show()}
                    "FLOT" ->{
                        if (tipoAF == 5 ) {
                            database.use {
                                insert("AA_Almacigo_FlotxDetalle",
                                        "ID_Alma_Flot_Detalle" to 0,
                                        "ID_Socio" to id_socio,
                                        "Fecha" to dateInString,
                                        "ID_AF_APC_Flot" to codigo_af,
                                        "Nombre_AF_APC_Flot" to nombre,
                                        "AF_APC_Unid_Flot" to spin_Ud!!.selectedItem.toString(),
                                        "AF_APC_Dosis_Flot" to dosis,
                                        "Codigo_TipoAF" to 5,
                                        "Densidad" to densidad)}
                        } else{
                            database.use {
                                insert("AA_Almacigo_FlotxDetalle",
                                        "ID_Alma_Flot_Detalle" to 0,
                                        "ID_Socio" to id_socio,
                                        "Fecha" to dateInString,
                                        "ID_AF_Fert_Flot" to codigo_af,
                                        "Nombre_AF_Fert_Flot" to nombre,
                                        "AF_Fert_Unid_Flot" to spin_Ud!!.selectedItem.toString(),
                                        "AF_Fert_Dosis_Flot" to dosis,
                                        "Codigo_TipoAF" to 1,
                                        "Densidad" to densidad)}}
                        Toast.makeText(context, "Fertilizante Añadido", Toast.LENGTH_LONG).show()}
                    "BAND" ->{
                        if (tipoAF == 5 ) {
                            database.use {
                                insert("AA_Almacigo_BandxDetalle",
                                        "ID_Alma_Band_Detalle" to 0,
                                        "ID_Socio" to id_socio,
                                        "Fecha" to dateInString,
                                        "ID_AF_APC_Band" to codigo_af,
                                        "Nombre_AF_APC_Band" to nombre,
                                        "AF_APC_Unid_Band" to spin_Ud!!.selectedItem.toString(),
                                        "AF_APC_Dosis_Band" to dosis,
                                        "Codigo_TipoAF" to 5,
                                        "Densidad" to densidad)}
                        } else{
                            database.use {
                                insert("AA_Almacigo_BandxDetalle",
                                        "ID_Alma_Band_Detalle" to 0,
                                        "ID_Socio" to id_socio,
                                        "Fecha" to dateInString,
                                        "ID_AF_Fert_Band" to codigo_af,
                                        "Nombre_AF_Fert_Band" to nombre,
                                        "AF_Fert_Unid_Band" to spin_Ud!!.selectedItem.toString(),
                                        "AF_Fert_Dosis_Band" to dosis,
                                        "Codigo_TipoAF" to 1,
                                        "Densidad" to densidad)}}
                        Toast.makeText(context, "Fertilizante Añadido", Toast.LENGTH_LONG).show()}
                    "APOYA" ->{
                        if (tipoAF == 5 ) {
                            database.use {
                                insert("AA_Almacigo_ApoyaxDetalle",
                                        "ID_Alma_Apoya_Detalle" to 0,
                                        "ID_Socio" to id_socio,
                                        "Fecha" to dateInString,
                                        "ID_AF_APC_Apoya" to codigo_af,
                                        "Nombre_AF_APC_Apoya" to nombre,
                                        "AF_APC_Unid_Apoya" to spin_Ud!!.selectedItem.toString(),
                                        "AF_APC_Dosis_Apoya" to dosis,
                                        "Codigo_TipoAF" to 5,
                                        "Densidad" to densidad)}
                } else{
                    database.use {
                        insert("AA_Almacigo_ApoyaxDetalle",
                                "ID_Alma_Apoya_Detalle" to 0,
                                "ID_Socio" to id_socio,
                                "Fecha" to dateInString,
                                "ID_AF_Fert_Apoya" to codigo_af,
                                "Nombre_AF_Fert_Apoya" to nombre,
                                "AF_Fert_Unid_Apoya" to spin_Ud!!.selectedItem.toString(),
                                "AF_Fert_Dosis_Apoya" to dosis,
                                "Codigo_TipoAF" to 1,
                                "Densidad" to densidad)}}
                Toast.makeText(context, "Fertilizante Añadido", Toast.LENGTH_LONG).show()}}
            }
        }
    }

    private fun fragmentTransaction(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
                .replace(R.id.pager, fragment)
                .commit()
    }

    fun Date.toString(format: String, locale: Locale = Locale.getDefault()): String {
        val formatter = SimpleDateFormat(format, locale)
        return formatter.format(this)
    }

    fun getCurrentDateTime(): Date {
        return Calendar.getInstance().time
    }
}


