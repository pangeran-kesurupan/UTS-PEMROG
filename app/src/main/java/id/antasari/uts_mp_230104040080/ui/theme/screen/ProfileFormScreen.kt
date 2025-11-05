package id.antasari.uts_mp_230104040080.ui.theme.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileFormScreen(
    onSubmit: (nama: String, kelas: String, hobi: String) -> Unit
) {
    var nama by remember { mutableStateOf(TextFieldValue("")) }
    var kelas by remember { mutableStateOf(TextFieldValue("")) }
    var hobi by remember { mutableStateOf(TextFieldValue("")) }

    Scaffold(
        topBar = { TopAppBar(title = { Text("Form Profil") }) }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            OutlinedTextField(
                value = nama, onValueChange = { nama = it },
                label = { Text("Nama lengkap") }, modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = kelas, onValueChange = { kelas = it },
                label = { Text("Kelas") }, modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = hobi, onValueChange = { hobi = it },
                label = { Text("Hobi") }, modifier = Modifier.fillMaxWidth()
            )

            Button(
                onClick = { onSubmit(nama.text.trim(), kelas.text.trim(), hobi.text.trim()) },
                enabled = nama.text.isNotBlank() && kelas.text.isNotBlank() && hobi.text.isNotBlank(),
                modifier = Modifier.fillMaxWidth()
            ) { Text("Simpan & Lanjut") }
        }
    }
}
