package agronomia.coprotrab.agrokot.Fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import agronomia.coprotrab.agrokot.R
import android.support.v7.widget.RecyclerView

class AlmaApoyadoFragment : Fragment() {


    var rv_alma_apoy_apc: RecyclerView? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val rootView:View = inflater.inflate(R.layout.fragment_alma_apoyado, container, false)

        return rootView
    }


}
