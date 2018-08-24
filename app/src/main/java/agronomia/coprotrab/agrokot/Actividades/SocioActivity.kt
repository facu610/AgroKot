package agronomia.coprotrab.agrokot.Actividades

import agronomia.coprotrab.agrokot.Clases.Adapters.MaeSocio_Adapter
import agronomia.coprotrab.agrokot.Clases.DataResources.DataAccess_RegistroAgrotecnico_App
import agronomia.coprotrab.agrokot.Clases.Entidades.MaeSocio
import agronomia.coprotrab.agrokot.Interfaces.rvMaeSoc_ClickListener
import agronomia.coprotrab.agrokot.R
import android.app.SearchManager
import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.support.v7.widget.SearchView

class SocioActivity : AppCompatActivity(){

    val TAGID = "agronomia.coprotab.agrokot.ID_SOCIO"



    var rv_socios: RecyclerView? = null
    var adapter: MaeSocio_Adapter? = null
    var layoutManager: RecyclerView.LayoutManager? = null

    var maesocios: ArrayList<MaeSocio>? = null

    var toolbar:Toolbar? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_socio)

        maesocios = DataAccess_RegistroAgrotecnico_App(this).select_MaeSocios()

        rv_socios = findViewById(R.id.rv_Socios)
        rv_socios?.setHasFixedSize(true) // Optimiza el tamaño de las celdas, para que no lo calcule en tiempo de ejec.

        layoutManager = LinearLayoutManager(this) // Define el tipo del rv, que es un linear layout
        rv_socios?.layoutManager = layoutManager // Asociamos el lmanager al Rec View

        adapter = MaeSocio_Adapter(maesocios!!, object : rvMaeSoc_ClickListener {
            override fun onClick(vista: View, index: Int) {

                var activity:String = intent.getStringExtra("agronomia.coprotab.agrokot.FICHA")

                if (activity == "FICHA"){
                    val intentficha = Intent(applicationContext, FichaActivity::class.java)
                    var maesocio: MaeSocio = adapter?.getItem(index) as MaeSocio
                    intentficha.putExtra(TAGID, maesocio.ID_Soc.toString())
                    startActivity(intentficha)
                }





            }
        }) // Definimos el adaptador y lo asociamos al Rec View
        rv_socios?.adapter = adapter!!

        toolbar = findViewById(R.id.tb_act_soc)
        toolbar?.title ="Fichas | Visitas"
        setSupportActionBar(toolbar)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_tb_soc, menu)
        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        val item_search = menu?.findItem(R.id.action_search)
        var searchView = item_search?.actionView as SearchView
        searchView.setSearchableInfo(searchManager.getSearchableInfo(componentName))
        searchView.queryHint = "Escribe un nombre..."
        searchView.setOnQueryTextFocusChangeListener { v, hasFocus ->
        }
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return true
            }
            override fun onQueryTextChange(newText: String?): Boolean {
                adapter?.filtrar(newText!!)
                return true
            }
        })
        return super.onCreateOptionsMenu(menu)
    }
    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item?.itemId){
            R.id.action_search ->{
                //hace algo
                return true
            }
            else -> {return super.onOptionsItemSelected(item)}
        }
    }






}

