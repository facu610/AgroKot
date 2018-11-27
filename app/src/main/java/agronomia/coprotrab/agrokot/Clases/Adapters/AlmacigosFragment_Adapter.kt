package agronomia.coprotrab.agrokot.Clases.Adapters

import agronomia.coprotrab.agrokot.Fragments.*
import android.os.Bundle
import android.support.v4.app.FragmentManager
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentPagerAdapter

class AlmacigosFragment_Adapter(fm: FragmentManager, var fragcount: Int, var id_socio:Int): FragmentPagerAdapter(fm) {


    override fun getItem(position: Int): Fragment? {
        when (position){

            0 -> {
                val almaconvencionalfragment =  AlmaConvencionalFragment()
                val args = Bundle()
                args.putInt("id_socio", id_socio)
                almaconvencionalfragment.arguments = args
                return almaconvencionalfragment
            }
            1 -> {
                val almaflotantefragment =  AlmaFlotanteFragment()
                val args = Bundle()
                args.putInt("id_socio", id_socio)
                almaflotantefragment.arguments = args
                return almaflotantefragment
            }
            2 -> {
                val almabandejafragment =  AlmaBandejaFragment()
                val args = Bundle()
                args.putInt("id_socio", id_socio)
                almabandejafragment.arguments = args
                return almabandejafragment
            }
            3 -> return AlmaApoyadoFragment()
            4 -> return AlmaVariedadesFragment()

            else -> return null
        }
    }

    override fun getCount(): Int {
        return fragcount
    }


}