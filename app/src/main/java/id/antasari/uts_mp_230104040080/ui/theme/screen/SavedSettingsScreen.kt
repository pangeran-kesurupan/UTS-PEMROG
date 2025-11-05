package id.antasari.uts_mp_230104040080.ui.theme.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import id.antasari.uts_mp_230104040080.data.Prefs

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SavedSettingsScreen(
    onBackToForm: () -> Unit
) {
    val context = LocalContext.current
    val prefs = remember(context) { Prefs(context) }

    var hasData by remember { mutableStateOf(false) }
    var nama by remember { mutableStateOf("") }
    var kelas by remember { mutableStateOf("") }
    var hobi by remember { mutableStateOf("") }
    var dark by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        hasData = prefs.hasData()
        if (hasData) {
            nama = prefs.getNama().orEmpty()
            kelas = prefs.getKelas().orEmpty()
            hobi = prefs.getHobi().orEmpty()
            dark = prefs.getDarkMode()
        }
    }

    Scaffold(
        topBar = { TopAppBar(title = { Text("Pengaturan Tersimpan") }) }
    ) { padding ->
        Column(
            modifier = Modifier.padding(padding).padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            if (!hasData) {
                Text("Belum ada data, silakan isi profil dulu")
            } else {
                Text("Nama: $nama")
                Text("Kelas: $kelas")
                Text("Hobi: $hobi")
                Text("Mode Gelap: ${if (dark) "Ya" else "Tidak"}")
            }

            Button(onClick = onBackToForm, modifier = Modifier.fillMaxWidth()) {
                Text("Kembali ke Form")
            }
        }
    }
}
