package agronomia.coprotrab.agrokot.Clases

import android.content.Context
import android.net.ConnectivityManager
import android.support.v7.app.AppCompatActivity
import java.io.IOException


class Network {

    companion object {
        fun validaConeccion(activity: AppCompatActivity):Boolean{
            val connectivityManager = activity.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val networkInfo = connectivityManager.activeNetworkInfo
            return networkInfo != null && networkInfo.isConnected

        }
        fun isConecctedToCoop(): Boolean {

            val runtime = Runtime.getRuntime()
            try {
                val ipProcess = runtime.exec("/system/bin/ping -c 1 192.168.50.108")
                val exitValue = ipProcess.waitFor()
                return exitValue == 0
            } catch (e: IOException) {
                e.printStackTrace()
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }

            return false
        }

    }




}