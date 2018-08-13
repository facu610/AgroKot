package agronomia.coprotrab.agrokot.Actividades

import agronomia.coprotrab.agrokot.Clases.Adapters.MenuItem_Adapter
import agronomia.coprotrab.agrokot.Clases.DataResources.DataAccess_RegistroAgrotecnico_App
import agronomia.coprotrab.agrokot.Clases.Entidades.Instructor
import agronomia.coprotrab.agrokot.Clases.MenuItem
import agronomia.coprotrab.agrokot.R
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.*


class MainActivity : AppCompatActivity() {

    //VARIABLES FIJAS HASTA
    val TAG = "agronomia.coprotab.agrokot.INSTRUCTOR"
    var tvInstr:TextView? = null
    var tvZona:TextView? = null

    val InstState = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        DataAccess_RegistroAgrotecnico_App(this).insert_Instructores(Instructor(9, "Sincronico", "nombresincro", 9, 9, 9, 9, "as"))

        tvInstr = findViewById<TextView>(R.id.tv_Instr)
        tvZona = findViewById<TextView>(R.id.tv_Zona)

        tvInstr?.text = "Facu Martinez"
        tvZona?.text = "10"


        var menuitems = ArrayList<MenuItem>()

        menuitems.add(MenuItem("Recursos", R.drawable.ic_bookweb))
        menuitems.add(MenuItem("Configuración", R.drawable.ic_configweb))
        menuitems.add(MenuItem("Fichas", R.drawable.ic_fichasweb))
        menuitems.add(MenuItem("Sincronización", R.drawable.ic_syncweb))

        var grid:GridView = findViewById(R.id.gv_menuprin)
        val adaptador = MenuItem_Adapter(this, menuitems)
        grid.adapter = adaptador

        grid.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            if (menuitems.get(position).nombre == "Fichas") {
                val intent = Intent(this, FichaActivity::class.java)
                intent.putExtra(TAG, "instructor-Facu Martinez")
                startActivity(intent) }
            if (menuitems.get(position).nombre == "Sincronización") {
                val intentSincronizacion = Intent(this, SincronizacionActivity::class.java)
                startActivity(intentSincronizacion)
               }
            //Toast.makeText(this, menuitems.get(position).nombre, Toast.LENGTH_LONG).show()
        }
    }

    fun validaDato(et:EditText): Boolean {
        if (et.text.isNullOrEmpty()) {return false}
        return true
    }
}




