package agronomia.coprotrab.agrokot.Fragments


import agronomia.coprotrab.agrokot.Clases.DataResources.DataAccess_RegistroAgrotecnico_App
import agronomia.coprotrab.agrokot.Clases.DataResources.database
import agronomia.coprotrab.agrokot.Clases.Entidades.FichaGeneral
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.jetbrains.anko.db.update
import agronomia.coprotrab.agrokot.R
import android.text.Editable
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import org.jetbrains.anko.db.NULL

class InfraGeneralFragment : Fragment() {

    var fichaexistente: FichaGeneral? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val rootView:View = inflater.inflate(R.layout.fragment_infra_general, container, false)
        val args: Bundle? = this.arguments

        val id_socio = args?.getInt("id_socio")
        val CumpleRec = rootView.findViewById<CheckBox>(R.id.cb_FInfra_Gral_CumpRec)
        val PoseeGalp = rootView.findViewById<CheckBox>(R.id.cb_FInfra_Gral_Galpon)
        val Galponm3 = rootView.findViewById<EditText>(R.id.et_FInfra_Gral_m3Galpon)
        val TotalCanas = rootView.findViewById<EditText>(R.id.et_FInfra_Gral_TotCañas)
        val HasEst = rootView.findViewById<EditText>(R.id.et_FInfra_Gral_HasEst)
        val InfraObs = rootView.findViewById<EditText>(R.id.et_FInfra_Gral_Obs)

        var cumplerec:Int = 0
        var poseegalp:Int = 0
        var galponm3:Int?
        var totalcanas:Int?
        var hasest:Int?
        var infraobs:String? = null

        fichaexistente = DataAccess_RegistroAgrotecnico_App(activity!!).select_FGenerales(id_socio!!)
        if (fichaexistente!!.Infra_Galpon_m3 != null){
            Toast.makeText(activity!!, "Cargando ficha previa...", Toast.LENGTH_SHORT).show()
            if(fichaexistente!!.Infra_Cumple_Rec == 1){CumpleRec.isChecked = true }
            if(fichaexistente!!.Infra_Posee_Galp == 1){PoseeGalp.isChecked = true }
            Galponm3.text = Editable.Factory.getInstance().newEditable(fichaexistente!!.Infra_Galpon_m3.toString())
            TotalCanas.text = Editable.Factory.getInstance().newEditable(fichaexistente!!.Infra_Total_Canas.toString())
            HasEst.text = Editable.Factory.getInstance().newEditable(fichaexistente!!.Infra_HasEstuf.toString())
            InfraObs.text = Editable.Factory.getInstance().newEditable(fichaexistente!!.Infra_Obs)
        }
        val b_finfra_gral_guardar = rootView.findViewById<Button>(R.id.b_FInfra_Gral_Guardar)
        b_finfra_gral_guardar.setOnClickListener (View.OnClickListener {
            if ( Galponm3.text.toString() != "" && TotalCanas.text.toString() != "" && HasEst.text.toString() != ""){
                if (CumpleRec.isChecked == true){cumplerec = 1}
                if (PoseeGalp.isChecked == true){poseegalp = 1}
                galponm3 = Galponm3.text.toString().toInt()
                totalcanas = TotalCanas.text.toString().toInt()
                hasest = HasEst.text.toString().toInt()
                }else {
                Toast.makeText(activity!!, "Complete todos los campos...", Toast.LENGTH_LONG).show()
                return@OnClickListener
            }
            if (InfraObs.text.toString() != "Escriba aquí..."){infraobs = InfraObs.text.toString()}
            activity!!.database.use {
                update("AA_FichasGenerales",
                        "Infra_Cumple_Rec" to cumplerec,
                        "Infra_Posee_Galp" to poseegalp,
                        "Infra_Galpon_m3" to galponm3,
                        "Infra_Total_Canas" to totalcanas,
                        "Infra_HasEstuf" to hasest,
                        "Infra_Obs" to infraobs,
                        "ToSincro" to 1
                ).where("ID_Soc = {id_socio}", "id_socio" to id_socio).exec()
            }
            Toast.makeText(activity!!, "Ficha Infraestructura - " + id_socio.toString() +" - Guardada", Toast.LENGTH_LONG).show()
        })
        return rootView
    }
}
