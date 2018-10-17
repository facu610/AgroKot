package agronomia.coprotrab.agrokot.Clases.Adapters


import agronomia.coprotrab.agrokot.Fragments.AgroAguaySueloFragment
import agronomia.coprotrab.agrokot.Fragments.AgroGeneralFragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentPagerAdapter

class AgronomicosFragment_Adapter(fm: FragmentManager, var fragcount: Int): FragmentPagerAdapter(fm) {


    override fun getItem(position: Int): Fragment? {
        when (position){

            0 -> return AgroGeneralFragment()
            1 -> return AgroAguaySueloFragment()
            else -> return null
        }
    }

    override fun getCount(): Int {
        return fragcount
    }


}