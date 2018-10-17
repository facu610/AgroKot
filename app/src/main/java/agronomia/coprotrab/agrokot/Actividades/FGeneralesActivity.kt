package agronomia.coprotrab.agrokot.Actividades

import agronomia.coprotrab.agrokot.Clases.DataResources.DataAccess_RegistroAgrotecnico_App
import agronomia.coprotrab.agrokot.Clases.DataResources.Ubicacion
import agronomia.coprotrab.agrokot.Clases.DataResources.database
import agronomia.coprotrab.agrokot.Clases.Entidades.FichaGeneral
import agronomia.coprotrab.agrokot.Interfaces.UbicacionListener
import agronomia.coprotrab.agrokot.R
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.text.Editable
import android.view.View
import android.widget.*
import com.google.android.gms.location.LocationResult
import kotlinx.android.synthetic.main.activity_fgenerales.*
import org.jetbrains.anko.db.insert
import org.jetbrains.anko.db.update
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.longToast
import org.jetbrains.anko.uiThread
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

class FGeneralesActivity : AppCompatActivity() {

    //obtener de la actividad anterior el codigo de ficha(si es que tiene una ficha precvia)mas el codigo del socio.

    private val permisoFineLocation = android.Manifest.permission.ACCESS_FINE_LOCATION
    private val permisoCoarseLocation = android.Manifest.permission.ACCESS_COARSE_LOCATION
    private val CODIGO_SOLICITUD_PERMISO = 100
    var ubicacion:Ubicacion? = null
    var tv_lat:TextView? = null
    var tv_lon:TextView? = null
    var toolbar: Toolbar? = null

    var fichaexistente:FichaGeneral? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fgenerales)
        tv_lat = findViewById(R.id.tv_Fgrales_Lat)
        tv_lon = findViewById(R.id.tv_Fgrales_Long)
        toolbar = findViewById(R.id.tb_act_fgrales)
        toolbar?.title ="Generales"

        var id_socio: Int =  (intent.getStringExtra("agronomia.coprotab.agrokot.ID_SOCIO").toInt())

        fichaexistente = DataAccess_RegistroAgrotecnico_App(this).select_FGenerales(id_socio)
        val date = getCurrentDateTime()
        val dateInString = date.toString("yyyy/MM/dd HH:mm:ss")
        val socio = DataAccess_RegistroAgrotecnico_App(this).select_MaeSocio(id_socio)

        if (fichaexistente == null) { // NO EXISTE FICHA PREVIA

            ubicacion = Ubicacion(this, object : UbicacionListener {
                override fun ubicacionResponse(locationResult: LocationResult) {
                    tv_lat?.text = locationResult.lastLocation.latitude.toString()
                    tv_lon?.text = locationResult.lastLocation.longitude.toString()
                    }
            })
        }
        else{
            Toast.makeText(this,"Cargando ficha previa...",Toast.LENGTH_SHORT).show()

            et_Fgrales_Finca.setText(fichaexistente!!.Finca_Soc).toString()
            et_Fgrales_Local.setText(fichaexistente!!.Local_Soc).toString()

            //OJO  Unable to start activity ComponentInfo{agronomia.coprotrab.agrokot/agronomia.coprotrab.agrokot.Actividades.FGeneralesActivity}:
            //java.lang.StringIndexOutOfBoundsException: length=1; index=10
            tv_lat?.text = fichaexistente!!.Coord_Soc.subSequence(0,10).toString()
            tv_lon?.text = fichaexistente!!.Coord_Soc.subSequence(11,20).toString()

            }
8
        val b_fgrales_guardar = findViewById<Button>(R.id.b_Fgrales_Guardar)
        b_fgrales_guardar.setOnClickListener(View.OnClickListener {


            if (fichaexistente != null) { //LA FICHA EXISTE Y HAY QUE ACTUALIZARLA. PARA ESO, BORRAMOS LA ANTERIOR PORQUE CON EL UPDATE NO ANDA, NO SE POR QUE!
                 DataAccess_RegistroAgrotecnico_App(this).delete_FGenerales(id_socio)
            }

            doAsync {

                    database.use {
                        insert("AA_FichasGenerales",
                                "ID_Ficha" to 0,
                                "Fecha_Grales" to dateInString,
                                "ID_Camp" to 0,
                                "ID_Soc" to id_socio,
                                "Fet_Soc" to socio.FET_Soc,
                                "ID_Instr" to 1,
                                "Finca_Soc" to et_Fgrales_Finca.text.toString(),
                                "Local_Soc" to et_Fgrales_Local.text.toString(),
                                "Coord_Soc" to tv_Fgrales_Lat.text.toString() + " " + tv_Fgrales_Long.text.toString(),
                                "Zona_Soc" to 1,
                                "ToSincro" to 1)
                    }
                    uiThread { longToast("Ficha Guardada ") }
                }
            })
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

    fun Date.toString(format: String, locale: Locale = Locale.getDefault()): String {
        val formatter = SimpleDateFormat(format, locale)
        return formatter.format(this)
    }

    fun getCurrentDateTime(): Date {
        return Calendar.getInstance().time
    }
}
