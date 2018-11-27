package agronomia.coprotrab.agrokot.Actividades

import agronomia.coprotrab.agrokot.Clases.Adapters.AlmacigosFragment_Adapter
import agronomia.coprotrab.agrokot.Clases.Adapters.InfraestructuraFragment_Adapter
import agronomia.coprotrab.agrokot.R
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TabLayout
import kotlinx.android.synthetic.main.activity_falmacigos.*
import android.support.v7.widget.Toolbar


class FAlmacigosActivity : AppCompatActivity() {

    var toolbar: Toolbar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_falmacigos)


        toolbar = findViewById(R.id.tb_act_falma)
        toolbar?.title = "Almácigos"
        toolbar?.setTitleMargin(10,10,10,10)
        setSupportActionBar(toolbar)

        configFragmentLayout()
    }

    private fun configFragmentLayout() {

        tab_layout.addTab(tab_layout.newTab().setText("Convencional"))
        tab_layout.addTab(tab_layout.newTab().setText("Flotante"))
        tab_layout.addTab(tab_layout.newTab().setText("Bandeja"))
        tab_layout.addTab(tab_layout.newTab().setText("Apoyado"))
        tab_layout.addTab(tab_layout.newTab().setText("Variedades"))

        var id_socio: Int =  (intent.getStringExtra("agronomia.coprotab.agrokot.ID_SOCIO").toInt())


        val adapter = AlmacigosFragment_Adapter(supportFragmentManager,
                tab_layout.tabCount,id_socio)
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
