package agronomia.coprotrab.agrokot.Actividades

import agronomia.coprotrab.agrokot.Clases.Adapters.MenuItem_Adapter
import agronomia.coprotrab.agrokot.Clases.DataResources.Prefs
import agronomia.coprotrab.agrokot.Clases.DataResources.SharedApp
import agronomia.coprotrab.agrokot.Clases.MenuItem
import agronomia.coprotrab.agrokot.R
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import android.support.v7.widget.Toolbar


class MainActivity : AppCompatActivity() {


    //SHARED PREFERENCES

    val EMPTY_VALUE = ""

    //VARIABLES
    val TAGACT = "agronomia.coprotab.agrokot.FICHA"
    var tvInstr:TextView? = null
    var tvZona:TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvInstr = findViewById<TextView>(R.id.tv_Instr)
        tvZona = findViewById<TextView>(R.id.tv_Zona)


        var menuitems = ArrayList<MenuItem>()

        menuitems.add(MenuItem("Recursos", R.drawable.ic_book_red))
        menuitems.add(MenuItem("Configuración", R.drawable.ic_config_red))
        menuitems.add(MenuItem("Fichas", R.drawable.ic_fichas_red))
        menuitems.add(MenuItem("Sincronización", R.drawable.ic_sync_red))

        var grid:GridView = findViewById(R.id.gv_menuprin)
        val adaptador = MenuItem_Adapter(this, menuitems)
        grid.adapter = adaptador

        SharedApp.prefs = Prefs(applicationContext)
        configView()

        grid.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            if (menuitems.get(position).nombre == "Fichas") {
                val intentFichas = Intent(this, SocioActivity::class.java)
                intentFichas.putExtra(TAGACT, "FICHA")
                startActivity(intentFichas)
            }
            if (menuitems.get(position).nombre == "Sincronización") {
                val intentSincronizacion = Intent(this, SincronizacionActivity::class.java)
                startActivity(intentSincronizacion)
               }
            if (menuitems.get(position).nombre == "Configuración") {
                val intentConfiguracion = Intent(this, LoginActivity::class.java)
                startActivity(intentConfiguracion)
            }
            //Toast.makeText(this, menuitems.get(position).nombre, Toast.LENGTH_LONG).show()
        }

    }

    fun validaDato(et:EditText): Boolean {
        if (et.text.isNullOrEmpty()) {return false}
        return true
    }
/////////// SHARED PREFERENCES


    fun configView(){
        if(isSavedName()) {
         tvInstr?.text = "Bienvenido ${SharedApp.prefs?.user}"
        }
        else{
            tvInstr?.text = "Logueate perro"
        }
    }

    fun isSavedName():Boolean{
        val myUser = SharedApp.prefs?.user
        return myUser != EMPTY_VALUE
    }

}




