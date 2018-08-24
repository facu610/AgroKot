package agronomia.coprotrab.agrokot.Actividades

import agronomia.coprotrab.agrokot.Clases.DataResources.Ubicacion
import agronomia.coprotrab.agrokot.Interfaces.UbicacionListener
import agronomia.coprotrab.agrokot.R
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationResult

class FGeneralesActivity : AppCompatActivity() {

    private val permisoFineLocation = android.Manifest.permission.ACCESS_FINE_LOCATION
    private val permisoCoarseLocation = android.Manifest.permission.ACCESS_COARSE_LOCATION
    private val CODIGO_SOLICITUD_PERMISO = 100

    var ubicacion:Ubicacion? = null
    var tv_lat:TextView? = null
    var tv_lon:TextView? = null







    var toolbar: Toolbar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fgenerales)

        tv_lat = findViewById(R.id.tv_Fgrales_Lat)
        tv_lon = findViewById(R.id.tv_Fgrales_Long)



        ubicacion = Ubicacion(this, object : UbicacionListener {
            override fun ubicacionResponse(locationResult: LocationResult) {
                tv_lat?.text = locationResult.lastLocation.latitude.toString()
                tv_lon?.text = locationResult.lastLocation.longitude.toString()
            }
        })
        toolbar = findViewById(R.id.tb_act_fgrales)
        toolbar?.title ="Generales"


    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        ubicacion?.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }

    override fun onStart() {
        super.onStart()

        ubicacion?.inicializarUbicacion()
    }

    override fun onPause() {
        super.onPause()

        ubicacion?.detenerActualizacionUbicacion()
    }
}
