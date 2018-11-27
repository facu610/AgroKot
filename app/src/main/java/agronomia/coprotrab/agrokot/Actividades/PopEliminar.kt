package agronomia.coprotrab.agrokot.Actividades

import agronomia.coprotrab.agrokot.Clases.Adapters.FAlmacigoConvxDetalle_Adapter
import agronomia.coprotrab.agrokot.Clases.DataResources.DataAccess_RegistroAgrotecnico_App
import agronomia.coprotrab.agrokot.Clases.DataResources.database
import agronomia.coprotrab.agrokot.Clases.Entidades.FichaAlmacigoConvxDetalle
import agronomia.coprotrab.agrokot.R
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.util.DisplayMetrics
import android.view.Gravity
import android.view.View
import android.widget.*
import org.jetbrains.anko.db.MapRowParser
import org.jetbrains.anko.db.delete
import org.jetbrains.anko.db.insert
import org.jetbrains.anko.db.select
import org.jetbrains.anko.doAsync


class PopEliminar : AppCompatActivity() {

    var toolbar: Toolbar? = null
    var spin_AF: Spinner? = null

    var adapter: FAlmacigoConvxDetalle_Adapter? = null
    var layoutManager: RecyclerView.LayoutManager? = null

    var afs_conv_apc: ArrayList<String>? = null
    var afs_flot_apc: ArrayList<String>? = null
    var afs_band_apc: ArrayList<String>? = null
    var afs_apoya_apc: ArrayList<String>? = null


    var afs: ArrayList<String>? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.popeliminar_layout)

        val id_socio: Int =  (intent.getStringExtra("agronomia.coprotab.agrokot.ID_SOCIO").toInt())
        val tipoAF:Int = (intent.getStringExtra("agronomia.coprotab.agrokot.TIPO_AF").toInt())
        val tipoAlma:String = (intent.getStringExtra("agronomia.coprotab.agrokot.ALMA").toString())

        toolbar = findViewById(R.id.tb_act_pop)
        toolbar?.title ="Eliminar"


        when (tipoAlma){
            "CONV" ->{
                if (tipoAF == 5){
                    afs_conv_apc = DataAccess_RegistroAgrotecnico_App(this).select_AF_APC_Conv(id_socio,5)
                }else{
                    afs_conv_apc = DataAccess_RegistroAgrotecnico_App(this).select_AF_APC_Conv(id_socio,1)
                }
                val arrayAdapter_AF =  ArrayAdapter(this, android.R.layout.simple_spinner_item, afs_conv_apc)
                arrayAdapter_AF.setDropDownViewResource(R.layout.spinner_item)
                spin_AF = findViewById(R.id.S_Pop_ElimiarFertilizantes)
                spin_AF?.adapter = arrayAdapter_AF
            }
            "FLOT" ->{
                if (tipoAF == 5){
                    afs_flot_apc = DataAccess_RegistroAgrotecnico_App(this).select_AF_APC_Flot(id_socio,5)
                }else{
                    afs_flot_apc = DataAccess_RegistroAgrotecnico_App(this).select_AF_APC_Flot(id_socio,1)
                }
                val arrayAdapter_AF =  ArrayAdapter(this, android.R.layout.simple_spinner_item, afs_flot_apc)
                arrayAdapter_AF.setDropDownViewResource(R.layout.spinner_item)
                spin_AF = findViewById(R.id.S_Pop_ElimiarFertilizantes)
                spin_AF?.adapter = arrayAdapter_AF
            }
            "BAND" ->{
                if (tipoAF == 5){
                    afs_band_apc = DataAccess_RegistroAgrotecnico_App(this).select_AF_APC_Band(id_socio,5)
                }else{
                    afs_band_apc = DataAccess_RegistroAgrotecnico_App(this).select_AF_APC_Band(id_socio,1)
                }
                val arrayAdapter_AF =  ArrayAdapter(this, android.R.layout.simple_spinner_item, afs_band_apc)
                arrayAdapter_AF.setDropDownViewResource(R.layout.spinner_item)
                spin_AF = findViewById(R.id.S_Pop_ElimiarFertilizantes)
                spin_AF?.adapter = arrayAdapter_AF
            }
            "APOYA" ->{
                if (tipoAF == 5){
                    afs_apoya_apc = DataAccess_RegistroAgrotecnico_App(this).select_AF_APC_Apoya(id_socio,5)
                }else{
                    afs_apoya_apc = DataAccess_RegistroAgrotecnico_App(this).select_AF_APC_Apoya(id_socio,1)
                }
                val arrayAdapter_AF =  ArrayAdapter(this, android.R.layout.simple_spinner_item, afs_apoya_apc)
                arrayAdapter_AF.setDropDownViewResource(R.layout.spinner_item)
                spin_AF = findViewById(R.id.S_Pop_ElimiarFertilizantes)
                spin_AF?.adapter = arrayAdapter_AF
            }
        }

        val displayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics)

        var width = displayMetrics.widthPixels
        var height = displayMetrics.heightPixels


        with(window) {
            setLayout((width*.8).toInt(),(height*.4).toInt())
            setGravity(Gravity.CENTER)


            val b_pop_eliminar = findViewById<Button>(R.id.b_Pop_Eliminar) as Button
            b_pop_eliminar.setOnClickListener {

                when(tipoAlma){
                    "CONV" -> {database.use{delete("AA_Almacigo_ConvxDetalle", "(Nombre_AF_APC_Conv = {nombre}) or (Nombre_AF_Fert_Conv = {nombre})","nombre" to spin_AF!!.selectedItem.toString())}}
                    "FLOT" -> {database.use{delete("AA_Almacigo_FlotxDetalle", "(Nombre_AF_APC_Flot = {nombre}) or (Nombre_AF_Fert_Flot = {nombre})","nombre" to spin_AF!!.selectedItem.toString())}}
                    "BAND" -> {database.use{delete("AA_Almacigo_BandxDetalle", "(Nombre_AF_APC_Band = {nombre}) or (Nombre_AF_Fert_Band = {nombre})","nombre" to spin_AF!!.selectedItem.toString())}}
                    "APOYA" -> {database.use{delete("AA_Almacigo_ApoyaxDetalle", "(Nombre_AF_APC_Apoya = {nombre}) or (Nombre_AF_Fert_Apoya = {nombre})","nombre" to spin_AF!!.selectedItem.toString())}}
                }

                Toast.makeText(context, "Fertilizante Eliminado", Toast.LENGTH_SHORT).show()
            }


        }





        }








    }

