package agronomia.coprotrab.agrokot

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class FichaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ficha)

        val instr = intent.getStringExtra("agronomia.coprotab.agrokot.INSTRUCTOR")

        Toast.makeText(this, instr, Toast.LENGTH_LONG).show()

    }
}
