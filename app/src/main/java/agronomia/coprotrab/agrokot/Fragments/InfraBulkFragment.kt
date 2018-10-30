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

class InfraBulkFragment : Fragment() {

    var fichaexistente: FichaGeneral? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val rootView:View = inflater.inflate(R.layout.fragment_infra_bulk, container, false)

        val args: Bundle? = this.arguments
        val id_socio = args?.getInt("id_socio")


        val EstufBC = rootView.findViewById<EditText>(R.id. et_FInfra_BC_EstufBC)
        val Gas = rootView.findViewById<EditText>(R.id. et_FInfra_BC_Gas)
        val Gas_CI = rootView.findViewById<EditText>(R.id. et_FInfra_BC_Gas_CI)
        val Gas_Peines = rootView.findViewById<EditText>(R.id. et_FInfra_BC_Gas_Peines)
        val Gas_SI = rootView.findViewById<EditText>(R.id. et_FInfra_BC_Gas_SI)
        val Lena = rootView.findViewById<EditText>(R.id. et_FInfra_BC_Lena)
        val Lena_CI = rootView.findViewById<EditText>(R.id. et_FInfra_BC_Lena_CI)
        val Lena_Peines = rootView.findViewById<EditText>(R.id.et_FInfra_BC_Lena_Peines)

        var estufbc:Int?
        var gas:Int?
        var gas_ci:Int?
        var gas_peines:Int?
        var gas_si:Int?
        var lena:Int?
        var lena_ci:Int?
        var lena_peines:Int?

        fichaexistente = DataAccess_RegistroAgrotecnico_App(activity!!).select_FGenerales(id_socio!!)

        if (fichaexistente!!.Infra_Bulk_Cur != null)
//                || fichaexistente!!.Infra_BC_Gas != null
//                || fichaexistente!!.Infra_BC_Gas_CI!= null
//                || fichaexistente!!.Infra_BC_Gas_SI!= null
//                || fichaexistente!!.Infra_BC_Gas_Peines!= null
//                || fichaexistente!!.Infra_BC_Lena != null
//                || fichaexistente!!.Infra_BC_Lena_CI!= null
//                || fichaexistente!!.Infra_BC_Lena_Peines != null){
        {
            Toast.makeText(activity!!, "Cargando ficha previa...", Toast.LENGTH_SHORT).show()

            EstufBC.text = Editable.Factory.getInstance().newEditable(fichaexistente!!.Infra_Bulk_Cur.toString())
            Gas.text = Editable.Factory.getInstance().newEditable(fichaexistente!!.Infra_BC_Gas.toString())
            Gas_CI.text = Editable.Factory.getInstance().newEditable(fichaexistente!!.Infra_BC_Gas_CI.toString())
            Gas_Peines.text = Editable.Factory.getInstance().newEditable(fichaexistente!!.Infra_BC_Gas_Peines.toString())
            Gas_SI.text = Editable.Factory.getInstance().newEditable(fichaexistente!!.Infra_BC_Gas_SI.toString())
            Lena.text = Editable.Factory.getInstance().newEditable(fichaexistente!!.Infra_BC_Lena.toString())
            Lena_CI.text = Editable.Factory.getInstance().newEditable(fichaexistente!!.Infra_BC_Lena_CI.toString())
            Lena_Peines.text = Editable.Factory.getInstance().newEditable(fichaexistente!!.Infra_BC_Lena_Peines.toString())
        }

        val b_finfra_bc_guardar = rootView.findViewById<Button>(R.id.b_FInfra_BC_Guardar)
        b_finfra_bc_guardar.setOnClickListener(View.OnClickListener {
            if (EstufBC.text.toString() != "" &&
                    Gas.text.toString() != "" &&
                    Gas_CI.text.toString() != "" &&
                    Gas_Peines.text.toString() != "" &&
                    Gas_SI.text.toString() != "" &&
                    Lena.text.toString() != "" &&
                    Lena_CI.text.toString() != "" &&
                    Lena_Peines.text.toString() != "") {

                estufbc = EstufBC.text.toString().toInt()
                gas = Gas.text.toString().toInt()
                gas_ci= Gas_CI.text.toString().toInt()
                gas_peines = Gas_Peines.text.toString().toInt()
                gas_si = Gas_SI.text.toString().toInt()
                lena = Lena.text.toString().toInt()
                lena_ci = Lena_CI.text.toString().toInt()
                lena_peines = Lena_Peines.text.toString().toInt()
            } else {
                Toast.makeText(activity!!, "Complete todos los campos...", Toast.LENGTH_LONG).show()
                return@OnClickListener
            }

            activity!!.database.use {
                update("AA_FichasGenerales",
                        "Infra_Bulk_Cur" to estufbc,
                        "Infra_BC_Gas" to gas,
                        "Infra_BC_Gas_CI" to gas_ci,
                        "Infra_BC_Gas_SI" to gas_si,
                        "Infra_BC_Gas_Peines" to gas_peines,
                        "Infra_BC_Lena" to lena,
                        "Infra_BC_Lena_CI" to lena_ci,
                        "Infra_BC_Lena_Peines" to lena_peines,
                        "ToSincro" to 1
                ).where("ID_Soc = {id_socio}", "id_socio" to id_socio).exec()
            }
            Toast.makeText(activity!!, "Ficha Infraestructura - " + id_socio.toString() +" - Guardada", Toast.LENGTH_LONG).show()
        })
        return rootView
    }
}
