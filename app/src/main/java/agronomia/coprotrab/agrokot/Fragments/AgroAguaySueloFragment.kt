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
import android.graphics.Color
import android.text.Editable
import android.widget.*
import org.jetbrains.anko.db.update
import org.jetbrains.anko.find

class AgroAguaySueloFragment : Fragment() {

    var spinnerN: Spinner? = null
    var spinnerP: Spinner? = null
    var spinnerK: Spinner? = null
    var spinnerMO: Spinner? = null
    var spinnerCE: Spinner? = null
    var spinnerCarbu: Spinner? = null
    var fichaexistente: FichaGeneral? = null


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val rootView: View = inflater.inflate(R.layout.fragment_aaguay_suelo, container, false)
        var arrayAdapter: ArrayAdapter<CharSequence> = ArrayAdapter.createFromResource(rootView.context, R.array.unidades, android.R.layout.simple_spinner_item)
        spinnerN = rootView.findViewById(R.id.s_FAgro_AyS_Nu)
        spinnerP = rootView.findViewById(R.id.s_FAgro_AyS_Pu)
        spinnerK = rootView.findViewById(R.id.s_FAgro_AyS_Ku)
        spinnerMO = rootView.findViewById(R.id.s_FAgro_AyS_MOu)
        spinnerCE = rootView.findViewById(R.id.s_FAgro_AyS_CEu)
        spinnerCarbu = rootView.findViewById(R.id.s_FAgro_AyS_Carbu)
        arrayAdapter.setDropDownViewResource(R.layout.spinner_item)
        spinnerN?.adapter = arrayAdapter
        spinnerN?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(arg0: AdapterView<*>, arg1: View, position: Int, id: Long) {
                (arg0.getChildAt(0) as TextView).setTextColor(Color.DKGRAY)
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
            }
        }
        spinnerP?.adapter = arrayAdapter
        spinnerP?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(arg0: AdapterView<*>, arg1: View, position: Int, id: Long) {
                (arg0.getChildAt(0) as TextView).setTextColor(Color.DKGRAY)
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
            }
        }
        spinnerK?.adapter = arrayAdapter
        spinnerK?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(arg0: AdapterView<*>, arg1: View, position: Int, id: Long) {
                (arg0.getChildAt(0) as TextView).setTextColor(Color.DKGRAY)
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
            }
        }
        spinnerMO?.adapter = arrayAdapter
        spinnerMO?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(arg0: AdapterView<*>, arg1: View, position: Int, id: Long) {
                (arg0.getChildAt(0) as TextView).setTextColor(Color.DKGRAY)
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
            }
        }
        spinnerCE?.adapter = arrayAdapter
        spinnerCE?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(arg0: AdapterView<*>, arg1: View, position: Int, id: Long) {
                (arg0.getChildAt(0) as TextView).setTextColor(Color.DKGRAY)
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
            }
        }
        spinnerCarbu?.adapter = arrayAdapter
        spinnerCarbu?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(arg0: AdapterView<*>, arg1: View, position: Int, id: Long) {
                (arg0.getChildAt(0) as TextView).setTextColor(Color.DKGRAY)
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
            }
        }

        val args: Bundle? = this.arguments

        val SueloN = rootView.findViewById<EditText>(R.id.et_FAgro_AyS_N)
        val SueloNUd = rootView.findViewById<Spinner>(R.id.s_FAgro_AyS_Nu)
        val SueloP = rootView.findViewById<EditText>(R.id.et_FAgro_AyS_P)
        val SueloPUd = rootView.findViewById<Spinner>(R.id.s_FAgro_AyS_Pu)
        val SueloK = rootView.findViewById<EditText>(R.id.et_FAgro_AyS_K)
        val SueloKUd = rootView.findViewById<Spinner>(R.id.s_FAgro_AyS_Ku)
        val SueloMO = rootView.findViewById<EditText>(R.id.et_FAgro_AyS_MO)
        val SueloMOUd = rootView.findViewById<Spinner>(R.id.s_FAgro_AyS_MOu)
        val SueloPH = rootView.findViewById<EditText>(R.id.et_FAgro_AyS_PHSuelo)
        val AguaCE = rootView.findViewById<EditText>(R.id.et_FAgro_AyS_CE)
        val AguaCEUd = rootView.findViewById<Spinner>(R.id.s_FAgro_AyS_CEu)
        val AguaCarb = rootView.findViewById<EditText>(R.id.et_FAgro_AyS_Carb)
        val AguaCarbUd = rootView.findViewById<Spinner>(R.id.s_FAgro_AyS_Carbu)
        val AguaPH = rootView.findViewById<EditText>(R.id.et_FAgro_AyS_PHAgua)
        val AgroObs = rootView.findViewById<EditText>(R.id.et_FAgro_AyS_Obs)

        var suelon: Float?
        var suelonud: String?
        var suelop: Float?
        var suelopud: String?
        var suelok: Float?
        var suelokud: String?
        var suelomo: Float?
        var suelomoud: String?
        var sueloph: Float?
        var aguace: Float?
        var aguaceud: String?
        var aguacarb: Float?
        var aguacarbud: String?
        var aguaph: Float?
        var agroobs: String?

        val id_socio = args?.getInt("id_socio")
        fichaexistente = DataAccess_RegistroAgrotecnico_App(activity!!).select_FGenerales(id_socio!!)

        if (fichaexistente!!.Agro_Suelo_N != null
                || fichaexistente!!.Agro_Suelo_P != null
                || fichaexistente!!.Agro_Suelo_K != null
                || fichaexistente!!.Agro_Suelo_MO != null
                || fichaexistente!!.Agro_Suelo_PH != null
                || fichaexistente!!.Agro_Agua_CE != null
                || fichaexistente!!.Agro_Agua_Carb != null
                || fichaexistente!!.Agro_Agua_PH != null) {
            Toast.makeText(activity!!, "Cargando ficha previa...", Toast.LENGTH_SHORT).show()

            SueloN.text = Editable.Factory.getInstance().newEditable(fichaexistente!!.Agro_Suelo_N.toString())
            if (fichaexistente!!.Agro_Suelo_NUd == "%") {SueloNUd.setSelection(0)} else{SueloNUd.setSelection(1)}

            SueloP.text = Editable.Factory.getInstance().newEditable(fichaexistente!!.Agro_Suelo_P.toString())
            if (fichaexistente!!.Agro_Suelo_PUd == "%") {SueloPUd.setSelection(0)} else{SueloPUd.setSelection(1)}

            SueloK.text = Editable.Factory.getInstance().newEditable(fichaexistente!!.Agro_Suelo_K.toString())
            if (fichaexistente!!.Agro_Suelo_KUd == "%") {SueloKUd.setSelection(0)} else{SueloKUd.setSelection(1)}

            SueloMO.text = Editable.Factory.getInstance().newEditable(fichaexistente!!.Agro_Suelo_MO.toString())
            if (fichaexistente!!.Agro_Suelo_MOUd == "%") {SueloMOUd.setSelection(0)} else{SueloMOUd.setSelection(1)}

            AguaCE.text = Editable.Factory.getInstance().newEditable(fichaexistente!!.Agro_Agua_CE.toString())
            if (fichaexistente!!.Agro_Agua_CEUd == "%") {AguaCEUd.setSelection(0)} else{AguaCEUd.setSelection(1)}

            AguaCarb.text = Editable.Factory.getInstance().newEditable(fichaexistente!!.Agro_Agua_Carb.toString())
            if (fichaexistente!!.Agro_Agua_CarbUd == "%") {AguaCarbUd.setSelection(0)} else{AguaCarbUd.setSelection(1)}

            AguaPH.text = Editable.Factory.getInstance().newEditable(fichaexistente!!.Agro_Agua_PH.toString())
            AgroObs.text = Editable.Factory.getInstance().newEditable(fichaexistente!!.Agro_Obs)

        }

        val b_fagro_ays_guardar = rootView.findViewById<Button>(R.id.b_FAgro_AyS_Guardar)
        b_fagro_ays_guardar.setOnClickListener (View.OnClickListener {

            if (SueloN.text.toString() != ""
                    && SueloP.text.toString() != ""
                    && SueloK.text.toString() != ""
                    && SueloMO.text.toString() != ""
                    && SueloPH.text.toString() != ""
                    && AguaCE.text.toString() != ""
                    && AguaCarb.text.toString() != ""
                    && AguaPH.text.toString() != "") {
                suelon = SueloN.text.toString().toFloat()
                suelop = SueloP.text.toString().toFloat()
                suelok = SueloK.text.toString().toFloat()
                suelomo = SueloMO.text.toString().toFloat()
                sueloph = SueloPH.text.toString().toFloat()
                aguace = AguaCE.text.toString().toFloat()
                aguacarb = AguaCarb.text.toString().toFloat()
                aguaph = AguaPH.text.toString().toFloat()

            } else {
                Toast.makeText(activity!!, "Complete todos los campos...", Toast.LENGTH_LONG).show()
                return@OnClickListener
            }
            if (SueloNUd.selectedItem.toString() == "ppm.") {suelonud = "ppm."} else {suelonud = "%"}
            if (SueloPUd.selectedItem.toString() == "ppm.") {suelopud = "ppm."} else {suelopud = "%"}
            if (SueloKUd.selectedItem.toString() == "ppm.") {suelokud = "ppm."} else {suelokud = "%"}
            if (SueloMOUd.selectedItem.toString() == "ppm.") {suelomoud = "ppm."} else{suelomoud = "%"}
            if (AguaCEUd.selectedItem.toString() == "ppm.") {aguaceud = "ppm."} else {aguaceud = "%"}
            if (AguaCarbUd.selectedItem.toString() == "ppm.") {aguacarbud= "ppm."} else{aguacarbud ="%"}

            if(AgroObs.text.toString() != "Escriba aquí..."){agroobs = AgroObs.text.toString()} else {agroobs = null}

            activity!!.database.use {
                update("AA_FichasGenerales",
                        "Agro_Suelo_N" to suelon,
                        "Agro_Suelo_NUd" to suelonud,
                        "Agro_Suelo_P" to suelop,
                        "Agro_Suelo_PUd" to suelopud,
                        "Agro_Suelo_K" to suelok,
                        "Agro_Suelo_KUd" to suelokud,
                        "Agro_Suelo_MO" to suelomo,
                        "Agro_Suelo_MOUd" to suelomoud,
                        "Agro_Suelo_PH" to sueloph,
                        "Agro_Agua_CE" to aguace,
                        "Agro_Agua_CEUd" to aguaceud,
                        "Agro_Agua_Carb" to aguacarb,
                        "Agro_Agua_CarbUd" to aguacarbud,
                        "Agro_Agua_PH" to aguaph,
                        "Agro_Obs" to agroobs,
                        "ToSincro" to 1

                ).where("ID_Soc = {id_socio}", "id_socio" to id_socio).exec()
            }
            Toast.makeText(activity!!, "Ficha Agronómicos - " + id_socio.toString() +" - Guardada", Toast.LENGTH_LONG).show()
        })

        return rootView
    }

}



