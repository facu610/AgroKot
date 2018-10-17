package agronomia.coprotrab.agrokot.Clases.Adapters

import agronomia.coprotrab.agrokot.Fragments.AlmaConvencionalFragment
import agronomia.coprotrab.agrokot.Fragments.AlmaFlotanteFragment
import agronomia.coprotrab.agrokot.Fragments.AlmaBandejaFragment
import agronomia.coprotrab.agrokot.Fragments.AlmaApoyadoFragment
import agronomia.coprotrab.agrokot.Fragments.AlmaVariedadesFragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentPagerAdapter

class AlmacigosFragment_Adapter(fm: FragmentManager, var fragcount: Int): FragmentPagerAdapter(fm) {


    override fun getItem(position: Int): Fragment? {
        when (position){

            0 -> return AlmaVariedadesFragment()
            1 -> return AlmaApoyadoFragment()
            2 -> return AlmaBandejaFragment()
            3 -> return AlmaFlotanteFragment()
            4 -> return AlmaConvencionalFragment()

            else -> return null
        }
    }

    override fun getCount(): Int {
        return fragcount
    }


}