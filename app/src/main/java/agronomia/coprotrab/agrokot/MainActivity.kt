package agronomia.coprotrab.agrokot

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.StrictMode
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import java.io.InputStream
import java.net.URL
import javax.net.ssl.HttpsURLConnection

class MainActivity : AppCompatActivity() {

    val TAG = "agronomia.coprotab.agrokot.INSTRUCTOR"

    var tvInstr:TextView? = null
    var tvZona:TextView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bCambiarInstr = findViewById<Button>(R.id.b_CambiarInstr)
        val bFichas = findViewById<Button>(R.id.b_Fichas)
        val bSincro = findViewById<Button>(R.id.b_Sincro)

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

        bSincro.setOnClickListener{
            if (Network.validaConeccion(this)){
                Toast.makeText(this, "Si hay red", Toast.LENGTH_LONG).show()
            }
            else{
                Toast.makeText(this, "No hay red", Toast.LENGTH_LONG).show()
            }
            if(Network.validaConeccion(this)){
                Log.d("bSincroOnClick", descargarDatos( "https://google.com"))
            }
            else{
                Toast.makeText(this,"No hay Internet", Toast.LENGTH_LONG).show()
            }
        }



        ///PARTE JSON

        var respuesta = "{ \"instructores\" : [ " +
                "{" +
                " \"nombre\" : \"Facu\" ," +
                " \"usuario\" : \"facu1\" ," +
                " \"contrasena\" : \"1234}," +

                "{" +
                " \"nombre\" : \"Juan Perez\" ," +
                " \"usuario\" : \"juanp\" ," +
                " \"contrasena\" : \"1234}" +
                "]" +
                "}"
        val gson = Gson()
        val res = gson.fromJson(respuesta, Instructores::class.java)
        Log.d("GSON", res.instructores?.count().toString())













    }
    //Codigo Para Validar RED y Descargar Datos
    private fun descargarDatos(url:String):String{
        val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)

        var inputStream: InputStream? = null

        try {
            val url = URL(url)
            val conn = url.openConnection() as HttpsURLConnection
            conn.requestMethod = "GET"
            conn.connect()

            inputStream = conn.inputStream
            return inputStream.bufferedReader().use {
                it.readText()
            }
        }
        finally {
            if(inputStream != null){
                inputStream.close()
            }
        }
    }


    //Metodo Volley
    private fun solicitudHTPPVolley(){

    }



    fun validaDato(et:EditText): Boolean {
        if (et.text.isNullOrEmpty()) {return false}
        return true
    }
}




