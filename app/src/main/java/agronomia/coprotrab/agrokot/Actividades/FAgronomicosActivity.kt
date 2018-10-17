package agronomia.coprotrab.agrokot.Actividades

import agronomia.coprotrab.agrokot.Clases.Adapters.AgronomicosFragment_Adapter
import agronomia.coprotrab.agrokot.R
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TabLayout
import kotlinx.android.synthetic.main.activity_fagronomicos.*
import android.support.v7.widget.Toolbar
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.fragment_ageneral.*

class FAgronomicosActivity : AppCompatActivity(){

    var toolbar: Toolbar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fagronomicos)

        toolbar = findViewById(R.id.tb_act_fagro)
        toolbar?.title = "Agronómicos"
        toolbar?.setTitleMargin(10,10,10,10)
        setSupportActionBar(toolbar)

        configFragmentLayout()
    }



    private fun configFragmentLayout() {
        tab_layout.addTab(tab_layout.newTab().setText("Generales"))
        tab_layout.addTab(tab_layout.newTab().setText("Agua y Suelo"))

        var id_socio: Int =  (intent.getStringExtra("agronomia.coprotab.agrokot.ID_SOCIO").toInt())
        val adapter = AgronomicosFragment_Adapter(supportFragmentManager,
                tab_layout.tabCount, id_socio)
        pager.adapter = adapter

        pager.addOnPageChangeListener(
                TabLayout.TabLayoutOnPageChangeListener(tab_layout))
        tab_layout.addOnTabSelectedListener(object :
                TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                pager.currentItem = tab.position
            }
            override fun onTabUnselected(tab: TabLayout.Tab) {
                pager.currentItem = tab.position
            }
            override fun onTabReselected(tab: TabLayout.Tab) {
            }
        })
    }
}
