package agronomia.coprotrab.agrokot.Fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import agronomia.coprotrab.agrokot.R
import android.graphics.Color
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView

class AgroAguaySueloFragment : Fragment() {

    var spinnerN: Spinner? = null
    var spinnerP: Spinner? = null
    var spinnerK: Spinner? = null
    var spinnerMO: Spinner? = null
    var spinnerCE: Spinner? = null
    var spinnerCarbu: Spinner? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val rootView:View = inflater.inflate(R.layout.fragment_aaguay_suelo, container, false)




        var arrayAdapter: ArrayAdapter<CharSequence> = ArrayAdapter.createFromResource(rootView.context, R.array.unidades,android.R.layout.simple_spinner_item)

        spinnerN = rootView.findViewById(R.id.s_FAgro_AyS_Nu)
        spinnerP = rootView.findViewById(R.id.s_FAgro_AyS_Pu)
        spinnerK = rootView.findViewById(R.id.s_FAgro_AyS_Ku)
        spinnerMO = rootView.findViewById(R.id.s_FAgro_AyS_MOu)
        spinnerCE = rootView.findViewById(R.id.s_FAgro_AyS_CEu)
        spinnerCarbu = rootView.findViewById(R.id.s_FAgro_AyS_Carbu)


        arrayAdapter.setDropDownViewResource(R.layout.spinner_item)

        spinnerN?.adapter = arrayAdapter
        //Inflate the layout for this fragment
        spinnerN?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onItemSelected(arg0: AdapterView<*>, arg1: View, position: Int, id: Long) {
                // use position to know the selected item
                (arg0.getChildAt(0) as TextView).setTextColor(Color.DKGRAY)
                //aca guardas el valor en la variable categoria
            }
            override fun onNothingSelected(parent: AdapterView<*>) {
                //do nothing
            }
        }

        spinnerP?.adapter = arrayAdapter
        //Inflate the layout for this fragment
        spinnerP?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onItemSelected(arg0: AdapterView<*>, arg1: View, position: Int, id: Long) {
                // use position to know the selected item
                (arg0.getChildAt(0) as TextView).setTextColor(Color.DKGRAY)
                //aca guardas el valor en la variable categoria
            }
            override fun onNothingSelected(parent: AdapterView<*>) {
                //do nothing
            }
        }

        spinnerK?.adapter = arrayAdapter
        //Inflate the layout for this fragment
        spinnerK?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onItemSelected(arg0: AdapterView<*>, arg1: View, position: Int, id: Long) {
                // use position to know the selected item
                (arg0.getChildAt(0) as TextView).setTextColor(Color.DKGRAY)
                //aca guardas el valor en la variable categoria
            }
            override fun onNothingSelected(parent: AdapterView<*>) {
                //do nothing
            }
        }


        spinnerMO?.adapter = arrayAdapter
        //Inflate the layout for this fragment
        spinnerMO?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onItemSelected(arg0: AdapterView<*>, arg1: View, position: Int, id: Long) {
                // use position to know the selected item
                (arg0.getChildAt(0) as TextView).setTextColor(Color.DKGRAY)
                //aca guardas el valor en la variable categoria
            }
            override fun onNothingSelected(parent: AdapterView<*>) {
                //do nothing
            }
        }

        spinnerCE?.adapter = arrayAdapter
        //Inflate the layout for this fragment
        spinnerCE?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onItemSelected(arg0: AdapterView<*>, arg1: View, position: Int, id: Long) {
                // use position to know the selected item
                (arg0.getChildAt(0) as TextView).setTextColor(Color.DKGRAY)
                //aca guardas el valor en la variable categoria
            }
            override fun onNothingSelected(parent: AdapterView<*>) {
                //do nothing
            }
        }

        spinnerCarbu?.adapter = arrayAdapter
        //Inflate the layout for this fragment
        spinnerCarbu?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onItemSelected(arg0: AdapterView<*>, arg1: View, position: Int, id: Long) {
                // use position to know the selected item
                (arg0.getChildAt(0) as TextView).setTextColor(Color.DKGRAY)
                //aca guardas el valor en la variable categoria
            }
            override fun onNothingSelected(parent: AdapterView<*>) {
                //do nothing
            }
        }


        return rootView
    }

}
