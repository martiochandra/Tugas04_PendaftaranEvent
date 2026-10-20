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
        Divider()

        // 2. Input Teks (Statis untuk saat ini)
        OutlinedTextField(
            value = "",
            onValueChange = { },
            label = { Text("Nama Lengkap") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = "",
            onValueChange = { },
            label = { Text("Alamat Email") },
            modifier = Modifier.fillMaxWidth()
        )

        // 3. Area Switch (Akses VIP) - Statis
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Daftar sebagai VIP (Akses Lounge)", style = MaterialTheme.typography.bodyLarge)
            Switch(checked = false, onCheckedChange = { })
        }

        // 4. Area Komponen Counter Tiket (Nanti akan di-hoist) - Statis
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Jumlah Tiket:", style = MaterialTheme.typography.bodyLarge)
            Row(verticalAlignment = Alignment.CenterVertically) {
                Button(onClick = { }) { Text("-") }
                Text(text = "1", modifier = Modifier.padding(horizontal = 16.dp))
                Button(onClick = { }) { Text("+") }
            }
        }

        Spacer(modifier = Modifier.weight(1f))

        // 5. Tombol Aksi
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            OutlinedButton(
                onClick = { },
                modifier = Modifier.weight(1f)
            ) {
                Text("Reset")
            }

            Button(
                onClick = { },
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