package id.antasari.uts_mp_230104040080

import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import androidx.navigation.NavType
import androidx.navigation.compose.*
import androidx.navigation.navArgument
import id.antasari.uts_mp_230104040080.data.Prefs
import id.antasari.uts_mp_230104040080.data.Profile
import id.antasari.uts_mp_230104040080.nav.Routes
import id.antasari.uts_mp_230104040080.ui.theme.PAKET_ATheme
import id.antasari.uts_mp_230104040080.ui.theme.screen.ProfileFormScreen
import id.antasari.uts_mp_230104040080.ui.theme.screen.ProfileSummaryScreen
import id.antasari.uts_mp_230104040080.ui.theme.screen.SavedSettingsScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val prefs = remember { Prefs(this) }
            var isDark by remember { mutableStateOf(false) }

            // baca preferensi saat start
            LaunchedEffect(Unit) { isDark = prefs.getDarkMode() }

            // terapkan tema berdasar state (berubah real-time)
            PAKET_ATheme(darkTheme = isDark) {
                val nav = rememberNavController()

                NavHost(nav, startDestination = Routes.PROFILE_FORM) {

                    composable(Routes.PROFILE_FORM) {
                        ProfileFormScreen { nama, kelas, hobi ->
                            val n = Uri.encode(nama); val k = Uri.encode(kelas); val h = Uri.encode(hobi)
                            nav.navigate("${Routes.PROFILE_SUMMARY}?nama=$n&kelas=$k&hobi=$h")
                        }
                    }

                    composable(
                        "${Routes.PROFILE_SUMMARY}?nama={nama}&kelas={kelas}&hobi={hobi}",
                        arguments = listOf(
                            navArgument("nama"){ type = NavType.StringType; defaultValue = "" },
                            navArgument("kelas"){ type = NavType.StringType; defaultValue = "" },
                            navArgument("hobi"){ type = NavType.StringType; defaultValue = "" },
                        )
                    ) { backStack ->
                        val profile = Profile(
                            backStack.arguments?.getString("nama").orEmpty(),
                            backStack.arguments?.getString("kelas").orEmpty(),
                            backStack.arguments?.getString("hobi").orEmpty(),
                        )

                        ProfileSummaryScreen(
                            profile = profile,
                            // kirim status saat ini agar switch sinkron
                            darkMode = isDark,
                            // toggle switch → update tema SEGERA
                            onDarkModeChange = { isDark = it },
                            // tombol "Simpan" → persist ke SharedPreferences (dan lanjut)
                            onSaveAndGo = { dark ->
                                prefs.saveProfile(profile.nama, profile.kelas, profile.hobi, dark)
                                nav.navigate(Routes.SAVED_SETTINGS)
                            },
                            onBack = { nav.popBackStack() }
                        )
                    }

                    composable(Routes.SAVED_SETTINGS) {
                        SavedSettingsScreen {
                            nav.navigate(Routes.PROFILE_FORM) {
                                popUpTo(Routes.PROFILE_FORM) { inclusive = true }
                            }
                        }
                    }
                }
            }
        }
    }
}
