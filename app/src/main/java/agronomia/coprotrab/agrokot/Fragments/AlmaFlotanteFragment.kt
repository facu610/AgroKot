package agronomia.coprotrab.agrokot.Fragments

import agronomia.coprotrab.agrokot.Actividades.PopAgegar
import agronomia.coprotrab.agrokot.Actividades.PopEliminar
import agronomia.coprotrab.agrokot.Clases.Adapters.FAlmacigoFlotxDetalle_Adapter
import agronomia.coprotrab.agrokot.Clases.DataResources.DataAccess_RegistroAgrotecnico_App
import agronomia.coprotrab.agrokot.Clases.Entidades.FichaAlmacigoFlotxDetalle
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import agronomia.coprotrab.agrokot.R
import android.content.Intent
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Button
import android.widget.Spinner
import agronomia.coprotrab.agrokot.Clases.Adapters.FAlmacigoConvxDetalle_Adapter
import agronomia.coprotrab.agrokot.Clases.DataResources.database
import agronomia.coprotrab.agrokot.Clases.Entidades.FichaAlmacigoConvxDetalle
import android.widget.ArrayAdapter
import android.widget.Toast
import org.jetbrains.anko.db.update

class AlmaFlotanteFragment : Fragment() {

    val TAGID = "agronomia.coprotab.agrokot.ID_SOCIO"
    val TAGAF ="agronomia.coprotab.agrokot.TIPO_AF"//
    val TAGDENS = "agronomia.coprotab.agrokot.DENS"
    val TAGALMA = "agronomia.coprotab.agrokot.ALMA"


    var spinnerDen: Spinner? = null
    var rv_APC_Flot: RecyclerView? = null
    var rv_Fert_Flot: RecyclerView? = null

    var adapter_apc: FAlmacigoFlotxDetalle_Adapter? = null
    var adapter_fert: FAlmacigoFlotxDetalle_Adapter? = null
    var layoutManager_APC: RecyclerView.LayoutManager? = null
    var layoutManager_Fert: RecyclerView.LayoutManager? = null

    var afs_flot_apc: ArrayList<FichaAlmacigoFlotxDetalle>? = null
    var afs_flot_fert: ArrayList<FichaAlmacigoFlotxDetalle>? = null
    var tipoAF:Int? = null


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val rootView:View = inflater.inflate(R.layout.fragment_alma_flotante, container, false)

        val args: Bundle? = this.arguments
        val id_socio = args?.getInt("id_socio")

        rv_APC_Flot = rootView.findViewById(R.id.rv_Alma_Flot_APC)
        rv_APC_Flot?.setHasFixedSize(true)

        rv_Fert_Flot = rootView.findViewById(R.id.rv_Alma_Flot_Fert)
        rv_Fert_Flot?.setHasFixedSize(true)



        layoutManager_APC = LinearLayoutManager(activity!!) // Define el tipo del rv, que es un linear layout
        layoutManager_Fert = LinearLayoutManager(activity!!) // Define el tipo del rv, que es un linear layout
        rv_APC_Flot?.layoutManager = layoutManager_APC // Asociamos el lmanager al Rec View
        rv_Fert_Flot?.layoutManager = layoutManager_Fert // Asociamos el lmanager al Rec View



        afs_flot_apc = DataAccess_RegistroAgrotecnico_App(activity!!).select_Almacigo_FlotxSocios(id_socio!!, 5)
        afs_flot_fert = DataAccess_RegistroAgrotecnico_App(activity!!).select_Almacigo_FlotxSocios(id_socio!!, 1)

        adapter_apc = FAlmacigoFlotxDetalle_Adapter(activity!!,afs_flot_apc!!, 5)
        adapter_fert = FAlmacigoFlotxDetalle_Adapter(activity!!,afs_flot_fert!!, 1)
        rv_APC_Flot?.adapter = adapter_apc!!
        rv_Fert_Flot?.adapter = adapter_fert!!


        spinnerDen = rootView.findViewById(R.id.s_FAlma_Flot_Dens)
        val arrayAdapter: ArrayAdapter<CharSequence> = ArrayAdapter.createFromResource(rootView.context, R.array.densidad, android.R.layout.simple_spinner_item)
        arrayAdapter.setDropDownViewResource(R.layout.spinner_item)
        spinnerDen?.adapter = arrayAdapter

        val b_falma_flot_apc_agregar = rootView.findViewById<Button>(R.id.b_FAlma_Flot_APC_Agregar)
        b_falma_flot_apc_agregar.setOnClickListener {

            tipoAF = 5
            val intent = Intent(activity!!, PopAgegar::class.java)
            intent.putExtra(TAGAF,tipoAF.toString())
            intent.putExtra(TAGID,id_socio.toString() )
            intent.putExtra(TAGDENS, spinnerDen!!.selectedItem.toString())
            intent.putExtra(TAGALMA, "FLOT")
            startActivity(intent)

        }

        val b_falma_flot_apc_eliminar = rootView.findViewById<Button>(R.id.b_FAlma_Flot_APC_Eliminar)
        b_falma_flot_apc_eliminar.setOnClickListener {

            tipoAF = 5
            val intent = Intent(activity!!, PopEliminar::class.java)
            intent.putExtra(TAGID,id_socio.toString())
            intent.putExtra(TAGAF,tipoAF.toString())
            intent.putExtra(TAGDENS, spinnerDen!!.selectedItem.toString())
            intent.putExtra(TAGALMA, "FLOT")

            startActivity(intent)
        }

        val b_falma_flot_fert_agregar = rootView.findViewById<Button>(R.id.b_FAlma_Flot_Fert_Agregar)
        b_falma_flot_fert_agregar.setOnClickListener {
            tipoAF = 1
            val intent = Intent(activity!!, PopAgegar::class.java)
            intent.putExtra(TAGID,id_socio.toString())
          intent.putExtra(TAGAF,tipoAF.toString())
            intent.putExtra(TAGDENS, spinnerDen!!.selectedItem.toString())
            intent.putExtra(TAGALMA, "FLOT")
            startActivity(intent)
       }

        val b_falma_flot_fert_eliminar = rootView.findViewById<Button>(R.id.b_FAlma_Flot_Fert_Eliminar)
        b_falma_flot_fert_eliminar.setOnClickListener {

            tipoAF = 1
            val intent = Intent(activity!!, PopEliminar::class.java)
            intent.putExtra(TAGID,id_socio.toString())
            intent.putExtra(TAGAF,tipoAF.toString())
            intent.putExtra(TAGDENS, spinnerDen!!.selectedItem.toString())
            intent.putExtra(TAGALMA, "FLOT")
            startActivity(intent)
        }

        val b_falma_flot_guardar = rootView.findViewById<Button>(R.id.b_FAlma_Flot_Guardar)
        b_falma_flot_guardar.setOnClickListener {
            activity!!.database.use {
                update("AA_FichasGenerales",
                        "AlmaFlot_Is" to 1,
                        "To_Sincro_AlmaFlot" to 1,
                        "ToSincro" to 1
                ).where("ID_Soc = {id_socio}", "id_socio" to id_socio).exec()
            }
            Toast.makeText(activity!!, "Ficha Flotante - " + id_socio.toString() +" - Guardada", Toast.LENGTH_LONG).show()
        }
       return rootView
   }
}