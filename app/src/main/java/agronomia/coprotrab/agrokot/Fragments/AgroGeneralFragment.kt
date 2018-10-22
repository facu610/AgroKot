package agronomia.coprotrab.agrokot.Fragments


import agronomia.coprotrab.agrokot.Clases.DataResources.DataAccess_RegistroAgrotecnico_App
import agronomia.coprotrab.agrokot.Clases.DataResources.database
import agronomia.coprotrab.agrokot.Clases.Entidades.FichaGeneral
import agronomia.coprotrab.agrokot.R
import android.graphics.Color
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import kotlinx.android.synthetic.main.fragment_ageneral.*
import org.jetbrains.anko.db.update
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.longToast
import org.jetbrains.anko.uiThread


class AgroGeneralFragment : Fragment(){

    var spinner: Spinner? = null
    var categoria: String? = null
    var fichaexistente: FichaGeneral? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val rootView:View = inflater.inflate(R.layout.fragment_ageneral, container, false)
        var arrayAdapter: ArrayAdapter<CharSequence> = ArrayAdapter.createFromResource(rootView.context, R.array.categoriasDTR,android.R.layout.simple_spinner_item)
        spinner = rootView.findViewById(R.id.s_FAgro_Gral_DTR)
        arrayAdapter.setDropDownViewResource(R.layout.spinner_item)
        spinner?.adapter = arrayAdapter
        //Inflate the layout for this fragment
        spinner?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(arg0: AdapterView<*>, arg1: View, position: Int, id: Long) {
                // use position to know the selected item
                (arg0.getChildAt(0) as TextView).setTextColor(Color.DKGRAY)
                //aca guardas el valor en la variable categoria
            }
            override fun onNothingSelected(parent: AdapterView<*>) {
                //do nothing
            }
        }

        var args: Bundle? = this.arguments


        var HasPropias= rootView.findViewById<EditText>(R.id.et_FAgro_Gral_HPropias)
        var HasArren= rootView.findViewById<EditText>(R.id.et_FAgro_Gral_HArren)
        var HasTotales= rootView.findViewById<TextView>(R.id.tv_FAgro_Gral_HTotal)
        var CategDTR = rootView.findViewById<Spinner>(R.id.s_FAgro_Gral_DTR)
        var Verdeos = rootView.findViewById<CheckBox>(R.id.cb_FAgro_Gral_Verdeos)
        var HasVerdeos = rootView.findViewById<EditText>(R.id.et_FAgro_Gral_HasVerdeos)
        var Rotaciones= rootView.findViewById<CheckBox>(R.id.cb_FAgro_Gral_Rotac)
        var HasRotac = rootView.findViewById<EditText>(R.id.et_FAgro_Gral_HasRotac)
        var DepAPC= rootView.findViewById<CheckBox>(R.id.cb_FAgro_Gral_DepAPC)
        var CumpleRec= rootView.findViewById<CheckBox>(R.id.cb_FAgro_Gral_CumpRec)
        var MangaRiego= rootView.findViewById<EditText>(R.id.et_FAgro_Gral_HasMangRieg)

        var haspropias:Int?
        haspropias = null
        var hasarren:Int?
        hasarren = null
        var hasmangarie:Int?
        hasmangarie= null
        var hastotales:Int?
        hastotales = null
        var hasverdeos:Int?
        hasverdeos = null
        var hasrotac:Int?
        hasrotac = null
        var chbAPC: Int = 0
        var chbRec: Int = 0
        var catdtr: Int?
        catdtr = null


        Verdeos.setOnClickListener(View.OnClickListener{
            if (Verdeos.isChecked == true){
                HasVerdeos.isEnabled = true
            }
        })
        Rotaciones.setOnClickListener(View.OnClickListener{
            if (Rotaciones.isChecked == true){
                HasRotac.isEnabled = true
            }
        })

        var id_socio = args?.getInt("id_socio")
        fichaexistente = DataAccess_RegistroAgrotecnico_App(activity!!).select_FGenerales(id_socio!!)

        if (fichaexistente!!.Agro_Has_Propias != null || fichaexistente!!.Agro_Has_Arren != null || fichaexistente!!.Agro_MangaRiego_Has != null){
            Toast.makeText(activity!!, "Cargando ficha previa...", Toast.LENGTH_LONG).show()


        }

























        val b_fagro_gral_guardar = rootView.findViewById<Button>(R.id.b_FAgro_Gral_Guardar)
        b_fagro_gral_guardar.setOnClickListener(View.OnClickListener {

            if (DepAPC.isChecked == true){
                chbAPC = 1
            }
            if (CumpleRec.isChecked == true){
                chbRec = 1
            }

            if(HasPropias.text.toString() != "" && HasArren.text.toString() != "" && MangaRiego.text.toString() != ""){
                haspropias = HasPropias.text.toString().toInt()
                hasarren = HasArren.text.toString().toInt()
                hasmangarie = MangaRiego.text.toString().toInt()
                hastotales = (haspropias!! + hasarren!!)
                if ( HasVerdeos.text.toString() != "" && HasRotac.text.toString() != "") {
                    hasverdeos = HasVerdeos.text.toString().toInt()
                    hasrotac = HasRotac.text.toString().toInt()
                }
            } else {
                Toast.makeText(activity!!, "Complete todos los campos...", Toast.LENGTH_LONG).show()
                return@OnClickListener
            }

            when (CategDTR.selectedItem.toString()){
                "Sin Riesgo" -> catdtr = 0
                "Bajo Riesgo" -> catdtr = 1
                "Medio Riesgo" -> catdtr = 2
                "Alto Riesgo" -> catdtr = 3
            }

            activity!!.database.use {
                    update("AA_FichasGenerales",
                            "Agro_Has_Propias" to haspropias,
                                    "Agro_Has_Arren" to hasarren,
                                    "Agro_Has_Tot" to hastotales,
                                    "Agro_Cat_DTR" to catdtr,
                                    "Agro_Verdeos_Has" to hasverdeos,
                                    "Agro_Rot_Has" to hasrotac,
                                    "Agro_Dep_APC" to chbAPC,
                                    "Agro_Cumple_Rec" to chbRec,
                                    "Agro_MangaRiego_Has" to hasmangarie

                    ).where("ID_Soc = {id_socio}", "id_socio" to id_socio).exec()
                }
                Toast.makeText(activity!!, "id socio " + id_socio.toString(), Toast.LENGTH_LONG).show()

            })

        return rootView
    }

}
