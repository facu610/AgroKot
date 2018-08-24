package agronomia.coprotrab.agrokot.Actividades

import agronomia.coprotrab.agrokot.Clases.DataResources.DataAccess_RegistroAgrotecnico_App
import agronomia.coprotrab.agrokot.Clases.DataResources.database
import agronomia.coprotrab.agrokot.Clases.Entidades.MaeSocio
import agronomia.coprotrab.agrokot.R
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import org.jetbrains.anko.db.select

class FichaActivity : AppCompatActivity() {

    var maesocio:MaeSocio? = null
    var tv_actfich_id_soc: TextView? = null
    var tv_actfich_nombre_soc: TextView? = null
    var tv_actfich_dom_soc: TextView? = null
    var tv_actfich_loc_soc: TextView? = null
    var tv_actfich_tel_soc: TextView? = null
    var tv_actfich_compro_soc: TextView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ficha)
        val id_soc = intent.getStringExtra("agronomia.coprotab.agrokot.ID_SOCIO")

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


        val bGenerales = findViewById<Button>(R.id.b_Act_Fic_Generales)


        bGenerales.setOnClickListener {
            val intentGrales = Intent(this, FGeneralesActivity::class.java)
            startActivity(intentGrales)
            Toast.makeText(this,"",Toast.LENGTH_SHORT)
        }



        //Toast.makeText(this, maesocio!!.Nombre_Soc, Toast.LENGTH_LONG).show()

    }
}
