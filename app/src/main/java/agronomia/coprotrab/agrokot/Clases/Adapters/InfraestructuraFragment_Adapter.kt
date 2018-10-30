package agronomia.coprotrab.agrokot.Clases.Adapters

import agronomia.coprotrab.agrokot.Fragments.InfraBulkFragment
import agronomia.coprotrab.agrokot.Fragments.InfraConvencionalesFragment
import agronomia.coprotrab.agrokot.Fragments.InfraGeneralFragment
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

class InfraestructuraFragment_Adapter(fm: FragmentManager, var fragcount: Int, var id_socio:Int): FragmentPagerAdapter(fm) {


    override fun getItem(position: Int): Fragment? {
        when (position) {

            0 -> {
                val infrageneralfragment =  InfraGeneralFragment()
                val args = Bundle()
                args.putInt("id_socio", id_socio)
                infrageneralfragment.arguments = args
                return infrageneralfragment
            }
            1 -> {
                val infraconvencionalesfragment =  InfraConvencionalesFragment()
                val args = Bundle()
                args.putInt("id_socio", id_socio)
                infraconvencionalesfragment.arguments = args
                return infraconvencionalesfragment
            }

            2 -> {
                val infrabulkfragment =  InfraBulkFragment()
                val args = Bundle()
                args.putInt("id_socio", id_socio)
                infrabulkfragment.arguments = args
                return infrabulkfragment
            }
            else -> return null
        }
    }

    override fun getCount(): Int {
        return fragcount
    }
}