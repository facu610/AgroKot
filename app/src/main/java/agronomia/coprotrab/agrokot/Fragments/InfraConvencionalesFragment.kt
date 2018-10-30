package agronomia.coprotrab.agrokot.Fragments


import agronomia.coprotrab.agrokot.Clases.DataResources.DataAccess_RegistroAgrotecnico_App
import agronomia.coprotrab.agrokot.Clases.DataResources.database
import agronomia.coprotrab.agrokot.Clases.Entidades.FichaGeneral
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import agronomia.coprotrab.agrokot.R
import android.text.Editable
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_infra_convencionales.*
import org.jetbrains.anko.db.update

class InfraConvencionalesFragment : Fragment() {

    var fichaexistente: FichaGeneral? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val rootView:View = inflater.inflate(R.layout.fragment_infra_convencionales, container, false)

        val args: Bundle? = this.arguments
        val id_socio = args?.getInt("id_socio")

        val EstufConv = rootView.findViewById<EditText>(R.id.et_FInfra_Conv_EstConv)
        val Gas  = rootView.findViewById<EditText>(R.id.et_FInfra_Conv_Gas)
        val Gas_CI = rootView.findViewById<EditText>(R.id.et_FInfra_Conv_Gas_CI)
        val Gas_NCanas = rootView.findViewById<EditText>(R.id.et_FInfra_Conv_Gas_NCanas)
        val Gas_SI = rootView.findViewById<EditText>(R.id.et_FInfra_Conv_Gas_SI)
        val Gas_NPerchas = rootView.findViewById<EditText>(R.id.et_FInfra_Conv_Gas_NPerchas)
        val Lena = rootView.findViewById<EditText>(R.id.et_FInfra_Conv_Lena)
        val Lena_NPerchas = rootView.findViewById<EditText>(R.id.et_FInfra_Conv_Lena_NPerchas)
        val Lena_NCanas = rootView.findViewById<EditText>(R.id. et_FInfra_Conv_Lena_NCanas)

        var estufconv:Int?
        var gas:Int?
        var gas_ci:Int?
        var gas_ncanas:Int?
        var gas_si:Int?
        var gas_nperchas:Int?
        var lena:Int?
        var lena_nperchas:Int?
        var lena_ncanas:Int?

        fichaexistente = DataAccess_RegistroAgrotecnico_App(activity!!).select_FGenerales(id_socio!!)
        if (fichaexistente!!.Infra_Est_Conv != null){
            Toast.makeText(activity!!, "Cargando ficha previa...", Toast.LENGTH_SHORT).show()

            EstufConv.text = Editable.Factory.getInstance().newEditable(fichaexistente!!.Infra_Est_Conv.toString())
            Gas.text = Editable.Factory.getInstance().newEditable(fichaexistente!!.Infra_Conv_Gas.toString())
            Gas_CI.text = Editable.Factory.getInstance().newEditable(fichaexistente!!.Infra_Conv_Gas_CI.toString())
            Gas_NCanas.text = Editable.Factory.getInstance().newEditable(fichaexistente!!.Infra_Conv_Gas_Canas.toString())
            Gas_SI.text = Editable.Factory.getInstance().newEditable(fichaexistente!!.Infra_Conv_Gas_SI.toString())
            Gas_NPerchas.text = Editable.Factory.getInstance().newEditable(fichaexistente!!.Infra_Conv_Gas_Perchas.toString())
            Lena.text = Editable.Factory.getInstance().newEditable(fichaexistente!!.Infra_Conv_Lena.toString())
            Lena_NPerchas.text = Editable.Factory.getInstance().newEditable(fichaexistente!!.Infra_Conv_Lena_Perchas.toString())
            Lena_NCanas.text = Editable.Factory.getInstance().newEditable(fichaexistente!!.Infra_Conv_Lena_Canas.toString())
        }

        val b_finfra_conv_guardar = rootView.findViewById<Button>(R.id.b_FInfra_Conv_Guardar)
        b_finfra_conv_guardar.setOnClickListener(View.OnClickListener {
            if (EstufConv.text.toString() != "" &&
                    Gas.text.toString() != "" &&
                    Gas_CI.text.toString() != "" &&
                    Gas_NCanas.text.toString() != "" &&
                    Gas_SI.text.toString() != "" &&
                    Gas_NPerchas.text.toString() != "" &&
                    Lena.text.toString() != "" &&
                    Lena_NPerchas.text.toString() != "" &&
                    Lena_NCanas.text.toString() != "") {

                estufconv = EstufConv.text.toString().toInt()
                gas = Gas.text.toString().toInt()
                gas_ci= Gas_CI.text.toString().toInt()
                gas_ncanas = Gas_NCanas.text.toString().toInt()
                gas_si = Gas_SI.text.toString().toInt()
                gas_nperchas = Gas_NPerchas.text.toString().toInt()
                lena = Lena.text.toString().toInt()
                lena_nperchas = Lena_NPerchas.text.toString().toInt()
                lena_ncanas = Lena_NCanas.text.toString().toInt()
            } else {
                Toast.makeText(activity!!, "Complete todos los campos...", Toast.LENGTH_LONG).show()
                return@OnClickListener
            }

            activity!!.database.use {
                update("AA_FichasGenerales",
                        "Infra_Est_Conv" to estufconv,
                        "Infra_Conv_Gas" to gas,
                        "Infra_Conv_Gas_CI" to gas_ci,
                        "Infra_Conv_Gas_SI" to gas_si,
                        "Infra_Conv_Gas_Canas" to gas_ncanas,
                        "Infra_Conv_Gas_Perchas" to gas_nperchas,
                        "Infra_Conv_Lena" to lena,
                        "Infra_Conv_Lena_Perchas" to lena_nperchas,
                        "Infra_Conv_Lena_Canas" to lena_ncanas,
                        "ToSincro" to 1
                ).where("ID_Soc = {id_socio}", "id_socio" to id_socio).exec()
            }
            Toast.makeText(activity!!, "Ficha Infraestructura - " + id_socio.toString() +" - Guardada", Toast.LENGTH_LONG).show()
        })
        return rootView
    }
}
