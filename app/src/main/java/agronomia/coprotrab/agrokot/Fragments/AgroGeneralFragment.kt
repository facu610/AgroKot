package agronomia.coprotrab.agrokot.Fragments


import agronomia.coprotrab.agrokot.R
import android.graphics.Color
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView


class AgroGeneralFragment : Fragment(){

    var spinner: Spinner? = null
    var categoria: String? = null

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
        return rootView

    }

}
