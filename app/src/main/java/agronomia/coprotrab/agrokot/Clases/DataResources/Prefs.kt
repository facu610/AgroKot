package agronomia.coprotrab.agrokot.Clases.DataResources

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager

class Prefs(context: Context){

        val PREFS_INSTRUCTOR = "com.agronomia.coprotab.agrokot.sharedpreferences"
        val SHARED_USER = "shared_user"
        val SHARED_PASS = "shared_pass"
        val prefs: SharedPreferences = context.getSharedPreferences(PREFS_INSTRUCTOR, 0)

        var user: String
            get() = prefs.getString(SHARED_USER, "")
            set(value) = prefs.edit().putString(SHARED_USER, value).apply()

        var pass: String
            get() = prefs.getString(SHARED_PASS, "")
            set(value) = prefs.edit().putString(SHARED_PASS, value).apply()

}
