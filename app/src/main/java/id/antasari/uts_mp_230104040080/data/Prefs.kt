package id.antasari.uts_mp_230104040080.data

import android.content.Context

class Prefs(context: Context) {
    private val sp = context.getSharedPreferences("profile_prefs", Context.MODE_PRIVATE)

    fun saveProfile(nama: String, kelas: String, hobi: String, darkMode: Boolean) {
        sp.edit()
            .putString("nama", nama)
            .putString("kelas", kelas)
            .putString("hobi", hobi)
            .putBoolean("darkMode", darkMode)
            .apply()
    }

    fun getNama(): String? = sp.getString("nama", null)
    fun getKelas(): String? = sp.getString("kelas", null)
    fun getHobi(): String? = sp.getString("hobi", null)
    fun getDarkMode(): Boolean = sp.getBoolean("darkMode", false)
    fun hasData(): Boolean = getNama() != null && getKelas() != null && getHobi() != null
}