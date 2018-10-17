package agronomia.coprotrab.agrokot.Actividades

import agronomia.coprotrab.agrokot.Clases.Adapters.MenuItem_Adapter
import agronomia.coprotrab.agrokot.Clases.DataResources.DataAccess_RegistroAgrotecnico_App
import agronomia.coprotrab.agrokot.Clases.Entidades.MaeSocio
import agronomia.coprotrab.agrokot.R
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.view.Menu
import agronomia.coprotrab.agrokot.Clases.MenuItem
import android.content.Intent
import android.widget.AdapterView
import android.widget.GridView
import android.widget.TextView


class FichaActivity : AppCompatActivity() {

    val TAGID = "agronomia.coprotab.agrokot.ID_SOCIO"

    var maesocio:MaeSocio? = null
    var tv_actfich_id_soc: TextView? = null
    var tv_actfich_nombre_soc: TextView? = null
    var tv_actfich_dom_soc: TextView? = null
    var tv_actfich_loc_soc: TextView? = null
    var tv_actfich_tel_soc: TextView? = null
    var tv_actfich_compro_soc: TextView? = null
    var toolbar: Toolbar? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ficha)
        val id_soc = intent.getStringExtra("agronomia.coprotab.agrokot.ID_SOCIO")

        toolbar = findViewById(R.id.tb_act_ficha)
        toolbar?.title = "Ficha"
        toolbar?.setTitleMargin(10,10,10,10)
        setSupportActionBar(toolbar)

        maesocio = DataAccess_RegistroAgrotecnico_App(this).select_MaeSocio(id_soc.toInt())

        tv_actfich_id_soc = findViewById(R.id.tv_ActFich_ID_Soc)
        tv_actfich_nombre_soc = findViewById(R.id.tv_ActFich_Nombre_Soc)
        tv_actfich_dom_soc = findViewById(R.id.tv_ActFich_Dom_Soc)
        tv_actfich_loc_soc = findViewById(R.id.tv_ActFich_Loc_Soc)
        tv_actfich_tel_soc = findViewById(R.id.tv_ActFich_Tel_Soc)
        tv_actfich_compro_soc = findViewById(R.id.tv_ActFich_Compro_Soc)

        tv_actfich_id_soc?.text = maesocio?.ID_Soc.toString()
        tv_actfich_nombre_soc?.text = maesocio?.Nombre_Soc.toString()
        tv_actfich_dom_soc?.text = maesocio?.Domicilio_Soc.toString()
        tv_actfich_loc_soc?.text = maesocio?.Localidad_Soc.toString()
        tv_actfich_tel_soc?.text =  maesocio?.Telefono_Soc.toString()
        tv_actfich_compro_soc?.text = maesocio?.Kilos_Soc.toString()

        var menuitems = ArrayList<MenuItem>()

        menuitems.add(agronomia.coprotrab.agrokot.Clases.MenuItem("Generales", R.drawable.ic_gral_30dp))
        menuitems.add(agronomia.coprotrab.agrokot.Clases.MenuItem("Agronómicos", R.drawable.ic_agro_30dp))
        menuitems.add(agronomia.coprotrab.agrokot.Clases.MenuItem("Infraestructura", R.drawable.ic_infra_30dp))
        menuitems.add(agronomia.coprotrab.agrokot.Clases.MenuItem("Almácigos", R.drawable.ic_alma_30dp))
        menuitems.add(agronomia.coprotrab.agrokot.Clases.MenuItem("Plantación", R.drawable.ic_plan_30dp))
        menuitems.add(agronomia.coprotrab.agrokot.Clases.MenuItem("Cosecha", R.drawable.ic_cos_30dp))
        menuitems.add(agronomia.coprotrab.agrokot.Clases.MenuItem("Emisiones GEI", R.drawable.ic_emis_30dp))

        var grid: GridView = findViewById(R.id.gv_menuficha)
        val adaptador = MenuItem_Adapter(this, menuitems)
        grid.adapter = adaptador

        grid.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            if (menuitems.get(position).nombre == "Generales") {
                val intentGrales = Intent(this, FGeneralesActivity::class.java)
                intentGrales.putExtra(TAGID,maesocio?.ID_Soc.toString() )
                startActivity(intentGrales)
            }
            if (menuitems.get(position).nombre == "Agronómicos") {
                val intentAgro = Intent(this, FAgronomicosActivity::class.java)
                intentAgro.putExtra(TAGID,maesocio?.ID_Soc.toString() )
                startActivity(intentAgro)

            }
            if (menuitems.get(position).nombre == "Infraestructura") {
                val intentInfra = Intent(this, FInfraestructuraActivity::class.java)
                //intentAgro.putExtra(TAGID,maesocio?.ID_Soc.toString() )
                startActivity(intentInfra)
            }
            if (menuitems.get(position).nombre == "Almácigos") {
                val intentInfra = Intent(this, FAlmacigosActivity::class.java)
                //intentAgro.putExtra(TAGID,maesocio?.ID_Soc.toString() )
                startActivity(intentInfra)
            }
            //Toast.makeText(this, menuitems.get(position).nombre, Toast.LENGTH_LONG).show()
        }


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_gral, menu)
        return super.onCreateOptionsMenu(menu)
    }
}
