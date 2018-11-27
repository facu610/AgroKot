package agronomia.coprotrab.agrokot.Fragments


import agronomia.coprotrab.agrokot.Actividades.PopAgegar
import agronomia.coprotrab.agrokot.Actividades.PopEliminar
import agronomia.coprotrab.agrokot.Clases.Adapters.FAlmacigoBandxDetalle_Adapter
import agronomia.coprotrab.agrokot.Clases.Adapters.FAlmacigoFlotxDetalle_Adapter
import agronomia.coprotrab.agrokot.Clases.DataResources.DataAccess_RegistroAgrotecnico_App
import agronomia.coprotrab.agrokot.Clases.DataResources.database
import agronomia.coprotrab.agrokot.Clases.Entidades.FichaAlmacigoBandxDetalle
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
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.Toast
import org.jetbrains.anko.db.update


class AlmaBandejaFragment : Fragment() {

    val TAGID = "agronomia.coprotab.agrokot.ID_SOCIO"
    val TAGAF ="agronomia.coprotab.agrokot.TIPO_AF"//
    val TAGDENS = "agronomia.coprotab.agrokot.DENS"
    val TAGALMA = "agronomia.coprotab.agrokot.ALMA"


    var spinnerDen: Spinner? = null
    var rv_APC_Band: RecyclerView? = null
    var rv_Fert_Band: RecyclerView? = null

    var adapter_apc: FAlmacigoBandxDetalle_Adapter? = null
    var adapter_fert: FAlmacigoBandxDetalle_Adapter? = null
    var layoutManager_APC: RecyclerView.LayoutManager? = null
    var layoutManager_Fert: RecyclerView.LayoutManager? = null

    var afs_band_apc: ArrayList<FichaAlmacigoBandxDetalle>? = null
    var afs_band_fert: ArrayList<FichaAlmacigoBandxDetalle>? = null
    var tipoAF:Int? = null


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val rootView:View = inflater.inflate(R.layout.fragment_alma_bandeja, container, false)

        val args: Bundle? = this.arguments
        val id_socio = args?.getInt("id_socio")

        rv_APC_Band = rootView.findViewById(R.id.rv_Alma_Band_APC)
        rv_APC_Band?.setHasFixedSize(true)

        layoutManager_APC = LinearLayoutManager(activity!!) // Define el tipo del rv, que es un linear layout
        layoutManager_Fert = LinearLayoutManager(activity!!) // Define el tipo del rv, que es un linear layout
        rv_APC_Band?.layoutManager = layoutManager_APC // Asociamos el lmanager al Rec View
        rv_Fert_Band?.layoutManager = layoutManager_Fert // Asociamos el lmanager al Rec View

        afs_band_apc = DataAccess_RegistroAgrotecnico_App(activity!!).select_Almacigo_BandxSocios(id_socio!!, 5)
        afs_band_fert = DataAccess_RegistroAgrotecnico_App(activity!!).select_Almacigo_BandxSocios(id_socio!!, 1)

        adapter_apc = FAlmacigoBandxDetalle_Adapter(activity!!,afs_band_apc!!, 5)
        adapter_fert = FAlmacigoBandxDetalle_Adapter(activity!!,afs_band_fert!!, 1)
        rv_APC_Band?.adapter = adapter_apc!!
        rv_Fert_Band?.adapter = adapter_fert!!


        spinnerDen = rootView.findViewById(R.id.s_FAlma_Band_Dens)
        val arrayAdapter: ArrayAdapter<CharSequence> = ArrayAdapter.createFromResource(rootView.context, R.array.densidad, android.R.layout.simple_spinner_item)
        arrayAdapter.setDropDownViewResource(R.layout.spinner_item)
        spinnerDen?.adapter = arrayAdapter



        val b_falma_band_apc_agregar = rootView.findViewById<Button>(R.id.b_FAlma_Band_APC_Agregar)
        b_falma_band_apc_agregar.setOnClickListener {


            tipoAF = 5
            val intent = Intent(activity!!, PopAgegar::class.java)
            intent.putExtra(TAGAF,tipoAF.toString())
            intent.putExtra(TAGID,id_socio.toString())
            intent.putExtra(TAGDENS, spinnerDen!!.selectedItem.toString())
            intent.putExtra(TAGALMA, "BAND")
            startActivity(intent)
        }

        val b_falma_band_apc_eliminar = rootView.findViewById<Button>(R.id.b_FAlma_Band_APC_Eliminar)
        b_falma_band_apc_eliminar.setOnClickListener {

            tipoAF = 5
            val intent = Intent(activity!!, PopEliminar::class.java)
            intent.putExtra(TAGID,id_socio.toString())
            intent.putExtra(TAGAF,tipoAF.toString())
            intent.putExtra(TAGDENS, spinnerDen!!.selectedItem.toString())
            intent.putExtra(TAGALMA, "BAND")
            startActivity(intent)
        }

        val b_falma_band_fert_agregar = rootView.findViewById<Button>(R.id.b_FAlma_Band_Fert_Agregar)
        b_falma_band_fert_agregar.setOnClickListener {
            tipoAF = 1
            val intent = Intent(activity!!,PopAgegar::class.java)
            intent.putExtra(TAGID,id_socio.toString())
            intent.putExtra(TAGAF,tipoAF.toString())
            intent.putExtra(TAGDENS, spinnerDen!!.selectedItem.toString())
            intent.putExtra(TAGALMA, "BAND")
            startActivity(intent)
        }

        val b_falma_band_fert_eliminar = rootView.findViewById<Button>(R.id.b_FAlma_Band_Fert_Eliminar)
        b_falma_band_fert_eliminar.setOnClickListener {

            tipoAF = 1
            val intent = Intent(activity!!, PopEliminar::class.java)
            intent.putExtra(TAGID,id_socio.toString())
            intent.putExtra(TAGAF,tipoAF.toString())
            intent.putExtra(TAGALMA, "BAND")
            startActivity(intent)
        }

        val b_falma_band_guardar = rootView.findViewById<Button>(R.id.b_FAlma_Band_Guardar)
        b_falma_band_guardar.setOnClickListener {
            activity!!.database.use {
                update("AA_FichasGenerales",
                        "AlmaBand_Is" to 1,
                        "To_Sincro_AlmaBand" to 1,
                        "ToSincro" to 1
                ).where("ID_Soc = {id_socio}", "id_socio" to id_socio).exec()
            }
            Toast.makeText(activity!!, "Ficha Bandeja - " + id_socio.toString() +" - Guardada", Toast.LENGTH_LONG).show()
        }
        return rootView
    }

}