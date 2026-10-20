package com.example.tugas04_pendaftaranevent // Sesuaikan dengan package Anda!

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.example.tugas04_pendaftaranevent.ui.theme.Tugas04_PendaftaranEventTheme // Sesuaikan tema

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Tugas04_PendaftaranEventTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    EventRegistrationScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

// ==============================================================
// LAYAR UTAMA (Owner dari State nantinya)
// ==============================================================
@Composable
fun EventRegistrationScreen(modifier: Modifier = Modifier) {
    // --- DEKLARASI STATE (HARI 3) ---
    // Menyimpan nilai yang diketik/dipilih oleh user
    var namaPeserta by remember { mutableStateOf("") }
    var emailPeserta by remember { mutableStateOf("") }
    var aksesVIP by remember { mutableStateOf(false) }
    var jumlahTiket by remember { mutableIntStateOf(1) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // 1. Header
        Text(
            text = "Pendaftaran Event Tech 2026",
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary
        )
        HorizontalDivider()

        // 2. Input Teks (Sekarang Interaktif membaca & mengubah State)
        OutlinedTextField(
            value = namaPeserta,
            onValueChange = { namaPeserta = it },
            label = { Text("Nama Lengkap") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = emailPeserta,
            onValueChange = { emailPeserta = it },
            label = { Text("Alamat Email") },
            modifier = Modifier.fillMaxWidth()
        )

        // 3. Area Switch VIP (Interaktif)
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Daftar sebagai VIP (Akses Lounge)", style = MaterialTheme.typography.bodyLarge)
            Switch(
                checked = aksesVIP,
                onCheckedChange = { aksesVIP = it }
            )
        }

        // 4. Area Komponen Counter Tiket (Interaktif dengan batas minimal 1)
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Jumlah Tiket:", style = MaterialTheme.typography.bodyLarge)
            Row(verticalAlignment = Alignment.CenterVertically) {
                // Tombol minus tidak bisa mengurangi di bawah 1
                Button(onClick = { if (jumlahTiket > 1) jumlahTiket-- }) { Text("-") }

                Text(text = jumlahTiket.toString(), modifier = Modifier.padding(horizontal = 16.dp))

                // Tombol plus
                Button(onClick = { jumlahTiket++ }) { Text("+") }
            }
        }

        Spacer(modifier = Modifier.weight(1f))

        // 5. Tombol Aksi (Logika menyusul di Hari 4)
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            OutlinedButton(
                onClick = { /* TODO Hari 4 */ },
                modifier = Modifier.weight(1f)
            ) {
                Text("Reset")
            }

            Button(
                onClick = { /* TODO Hari 4 */ },
                modifier = Modifier.weight(1f)
            ) {
                Text("Daftar")
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun EventRegistrationPreview() {
    Tugas04_PendaftaranEventTheme {
        EventRegistrationScreen()
    }
}