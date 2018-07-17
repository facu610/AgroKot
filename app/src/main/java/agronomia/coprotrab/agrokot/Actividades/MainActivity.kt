package agronomia.coprotrab.agrokot.Actividades

import agronomia.coprotrab.agrokot.Clases.Instructores
import agronomia.coprotrab.agrokot.Clases.Network
import agronomia.coprotrab.agrokot.R
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.gson.Gson


class MainActivity : AppCompatActivity() {

    val TAG = "agronomia.coprotab.agrokot.INSTRUCTOR"

    var tvInstr:TextView? = null
    var tvZona:TextView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val bFichas = findViewById<Button>(R.id.b_Fichas)
        val bSincro = findViewById<Button>(R.id.b_Sincronizacion)

        tvInstr = findViewById<TextView>(R.id.tv_Instr)
        tvZona = findViewById<TextView>(R.id.tv_Zona)

        tvInstr?.text = "Facu Martinez"
        tvZona?.text = "10"

        bSincro.setOnClickListener{

            val intentSincronizacion = Intent(this, SincronizacionActivity::class.java)
            startActivity(intentSincronizacion)
        }
        bFichas.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, FichaActivity::class.java)
            intent.putExtra(TAG, "instructor-Facu Martinez")
            startActivity(intent)
        })
    }

    fun validaDato(et:EditText): Boolean {
        if (et.text.isNullOrEmpty()) {return false}
        return true
    }
}




