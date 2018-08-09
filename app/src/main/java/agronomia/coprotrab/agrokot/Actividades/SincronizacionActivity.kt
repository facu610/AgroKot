package agronomia.coprotrab.agrokot.Actividades


import agronomia.coprotrab.agrokot.Clases.DataResources.DataAccess_RegistroAgrotecnico_App
import agronomia.coprotrab.agrokot.Clases.Instructor
import agronomia.coprotrab.agrokot.Clases.Instructores
import agronomia.coprotrab.agrokot.R
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.StrictMode
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.google.gson.JsonArray
import org.jetbrains.anko.*
import org.json.JSONObject
import java.io.InputStream
import java.net.URL
import javax.net.ssl.HttpsURLConnection

class SincronizacionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sincronizacion)

//        if (Network.validaConeccion(this)) {
//            Toast.makeText(this, "Si hay red", Toast.LENGTH_LONG).show()
//            Log.d("bSincroOnClick", descargarDatos("https://google.com"))
//            //SOLICITAR SOLICITUD HTPP
//
//        } else {
//            Toast.makeText(this, "No hay Internet", Toast.LENGTH_LONG).show()
//        }

//        val bCambiarInstr = findViewById<Button>(R.id.b_CambiarInstr)
//        bCambiarInstr.setOnClickListener(View.OnClickListener {
//            val instr: String
//            Toast.makeText(this, "Instructor cambiado con éxito, Bienvenido ", Toast.LENGTH_LONG).show()
//        })


        val bSincroInstr = findViewById<Button>(R.id.b_SincroInstr)
        bSincroInstr.setOnClickListener(View.OnClickListener{

            doAsync {

                val respuesta = URL("http://192.168.50.108/AppAgronomia/api/AA_Instructores").readText()
                //val respuesta = URL("https://api.openweathermap.org/data/2.5/forecast/daily?mode=json&units=metric&cnt=7").readText()
                //val respuesta = URL(" https://jsonplaceholder.typicode.com/posts").readText()
                val gson=Gson()
                val instr = gson.fromJson(respuesta, Array<Instructor>::class.java)

                val newinstr = Instructor(instr[1].ID_Instr.toInt(), instr[1].User_Instr, instr[1].Nombre_Instr, instr[1].Zona_Instr, instr[1].Issuper_Instr, instr[1].Idvehiculo_Instr, instr[1].Idmovil_Instr, instr[1].Pass_Instr)
                DataAccess_RegistroAgrotecnico_App(this@SincronizacionActivity).insert_Instructores(newinstr)

                //val nombre:String = instr[2].Nombre_Instr



                uiThread { longToast("Instructores Sincronizados")
                           longToast(newinstr.Nombre_Instr)}
            }









//
//
        })
    }

    //Metodo Volley
    private fun solicitudHTPPVolley(url: String) {
        val cola = Volley.newRequestQueue(this)
        val solicitud = StringRequest(Request.Method.GET, url, Response.Listener<String> { response ->
            try {
            } catch (e: Exception) {
            }
        }, Response.ErrorListener { })
        cola.add(solicitud)
    }

    private fun descargarDatos(url: String): String {
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
        } finally {
            if (inputStream != null) {
                inputStream.close()
            }
        }
    }


}