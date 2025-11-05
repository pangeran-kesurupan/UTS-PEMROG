package id.antasari.uts_mp_230104040080.ui.theme.screen

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import id.antasari.uts_mp_230104040080.data.Profile

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileSummaryScreen(
    profile: Profile,
    darkMode: Boolean,                        // ← status datang dari MainActivity
    onDarkModeChange: (Boolean) -> Unit,      // ← toggle langsung ubah tema di MainActivity
    onSaveAndGo: (Boolean) -> Unit,           // ← persist + navigate
    onBack: () -> Unit
) {
    val ctx = LocalContext.current

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Ringkasan Profil") },
                navigationIcon = { TextButton(onClick = onBack) { Text("Kembali") } }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier.padding(padding).padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text("Nama: ${profile.nama}")
            Text("Kelas: ${profile.kelas}")
            Text("Hobi: ${profile.hobi}")

            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Text("Aktifkan Mode Gelap (Ya/Tidak)")
                Switch(
                    checked = darkMode,                          // ← ikuti prop
                    onCheckedChange = { onDarkModeChange(it) }   // ← langsung efek real-time
                )
            }

            Button(
                onClick = {
                    onSaveAndGo(darkMode)                        // ← simpan (pakai nilai terbaru)
                    Toast.makeText(ctx, "Tersimpan ke perangkat", Toast.LENGTH_SHORT).show()
                },
                modifier = Modifier.fillMaxWidth()
            ) { Text("Simpan ke Perangkat") }
        }
    }
}
