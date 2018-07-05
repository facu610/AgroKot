package agronomia.coprotrab.agrokot

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bCambiarInstr = findViewById<Button>(R.id.b_CambiarInstr)



        bCambiarInstr.setOnClickListener(View.OnClickListener {
            Toast.makeText(this, "Hola Perro!", Toast.LENGTH_LONG).show()
        })


        fun validaDato(et:EditText): Boolean {
            if (et.text.isNullOrEmpty()) {return false}
            return true
        }

    }
}
