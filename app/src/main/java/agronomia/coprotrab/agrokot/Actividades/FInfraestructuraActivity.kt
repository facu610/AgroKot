package agronomia.coprotrab.agrokot.Actividades

import agronomia.coprotrab.agrokot.Clases.Adapters.AgronomicosFragment_Adapter
import agronomia.coprotrab.agrokot.Clases.Adapters.InfraestructuraFragment_Adapter
import agronomia.coprotrab.agrokot.R
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TabLayout
import kotlinx.android.synthetic.main.activity_fagronomicos.*
import android.support.v7.widget.Toolbar

class FInfraestructuraActivity : AppCompatActivity() {

    var toolbar: Toolbar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finfraestructura)


        toolbar = findViewById(R.id.tb_act_finfra)
        toolbar?.title = "Infraestructura"
        toolbar?.setTitleMargin(10,10,10,10)
        setSupportActionBar(toolbar)

        configFragmentLayout()
    }

    private fun configFragmentLayout() {

        tab_layout.addTab(tab_layout.newTab().setText("General"))
        tab_layout.addTab(tab_layout.newTab().setText("Convencionales"))
        tab_layout.addTab(tab_layout.newTab().setText("Bulk Curing"))

        var id_socio: Int =  (intent.getStringExtra("agronomia.coprotab.agrokot.ID_SOCIO").toInt())
        val adapter = InfraestructuraFragment_Adapter(supportFragmentManager,
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
