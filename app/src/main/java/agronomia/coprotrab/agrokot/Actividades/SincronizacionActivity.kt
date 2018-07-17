package agronomia.coprotrab.agrokot.Actividades

import agronomia.coprotrab.agrokot.Clases.Instructores
import agronomia.coprotrab.agrokot.Clases.Network
import agronomia.coprotrab.agrokot.R
import android.app.VoiceInteractor
import android.content.Intent
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
import java.io.InputStream
import java.net.ResponseCache
import java.net.URL
import javax.net.ssl.HttpsURLConnection

class SincronizacionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sincronizacion)

        if (Network.validaConeccion(this)) {
            Toast.makeText(this, "Si hay red", Toast.LENGTH_LONG).show()
            Log.d("bSincroOnClick", descargarDatos("https://google.com"))
            //SOLICITAR SOLICITUD HTPP




        } else {
            Toast.makeText(this, "No hay Internet", Toast.LENGTH_LONG).show()
        }

        val bCambiarInstr = findViewById<Button>(R.id.b_CambiarInstr)
        bCambiarInstr.setOnClickListener(View.OnClickListener {
            val instr: String

            Toast.makeText(this, "Instructor cambiado con éxito, Bienvenido ", Toast.LENGTH_LONG).show()

        })

        var respuesta = "{ \"instructores\" : [ " +
                "{" +
                " \"nombre\" : \"Facu\" ," +
                " \"usuario\" : \"facu1\" ," +
                " \"contrasena\" : \"1234\"}," +

                "{" +
                " \"nombre\" : \"Juan Perez\" ," +
                " \"usuario\" : \"juanp\" ," +
                " \"contrasena\" : \"1234\"}" +
                "]" +
                "}"
        val gson = Gson()
        val res = gson.fromJson(respuesta, Instructores::class.java)
        Log.d("GSON", res.instructores?.count().toString())

    }

    //Metodo Volley
    private fun solicitudHTPPVolley(url: String) {
        val cola = Volley.newRequestQueue(this)
        val solicitud = StringRequest(Request.Method.GET, url, Response.Listener<String> { response ->
            try {
                Log.d("solicitudHttp", response)
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