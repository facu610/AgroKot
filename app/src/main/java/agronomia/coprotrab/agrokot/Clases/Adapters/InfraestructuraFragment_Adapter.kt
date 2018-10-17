package agronomia.coprotrab.agrokot.Clases.Adapters

import agronomia.coprotrab.agrokot.Fragments.InfraBulkFragment
import agronomia.coprotrab.agrokot.Fragments.InfraConvencionalesFragment
import agronomia.coprotrab.agrokot.Fragments.InfraGeneralFragment
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

class InfraestructuraFragment_Adapter(fm: FragmentManager, var fragcount: Int): FragmentPagerAdapter(fm) {


    override fun getItem(position: Int): Fragment? {
        when (position) {

            0 -> return InfraGeneralFragment()
            1 -> return InfraConvencionalesFragment()
            2 -> return InfraBulkFragment()
            else -> return null
        }
    }

    override fun getCount(): Int {
        return fragcount
    }
}