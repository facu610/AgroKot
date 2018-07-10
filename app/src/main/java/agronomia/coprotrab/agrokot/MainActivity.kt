package agronomia.coprotrab.agrokot

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val TAG = "agronomia.coprotab.agrokot.INSTRUCTOR"

    var tvInstr:TextView? = null
    var tvZona:TextView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bCambiarInstr = findViewById<Button>(R.id.b_CambiarInstr)
        val bFichas = findViewById<Button>(R.id.b_Fichas)

        tvInstr = findViewById<TextView>(R.id.tv_Instr)
        tvZona = findViewById<TextView>(R.id.tv_Zona)

        tvInstr?.text = "Facu Martinez"
        tvZona?.text = "10"

        bCambiarInstr.setOnClickListener(View.OnClickListener {
            val instr: String

            Toast.makeText(this, "Instructor cambiado con éxito, Bienvenido ", Toast.LENGTH_LONG).show()

        })

        bFichas.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, FichaActivity::class.java)
            intent.putExtra(TAG, "instructor-Facu Martinez")
            startActivity(intent)
        })




        fun validaDato(et:EditText): Boolean {
            if (et.text.isNullOrEmpty()) {return false}
            return true
        }

    }
}
