# Form Pendaftaran Event (Tugas 4 Compose State)

**Nama:** Martio Chandra  
**NIM:** 0102524723  
**Program Studi:** Informatika, Universitas Al Azhar Indonesia  

## Deskripsi Aplikasi
Aplikasi ini adalah implementasi antarmuka interaktif menggunakan Jetpack Compose dan Material 3 berbasis *State Management*. Aplikasi ini memfasilitasi pendaftaran event dengan validasi input secara *real-time*, interaksi *toggle switch*, serta perhitungan jumlah tiket yang aman dari rotasi layar.

## Daftar State yang Digunakan
| Nama State | Tipe Data | Owner | Dipakai Oleh | Keterangan |
| :--- | :--- | :--- | :--- | :--- |
| `namaPeserta` | String | `EventRegistrationScreen` | `OutlinedTextField` | Input nama lengkap (dipertahankan via `rememberSaveable`) |
| `emailPeserta` | String | `EventRegistrationScreen` | `OutlinedTextField` | Input email dengan validasi karakter `@` |
| `aksesVIP` | Boolean | `EventRegistrationScreen` | `Switch` | Menentukan status pendaftaran VIP |
| `jumlahTiket` | Int | `EventRegistrationScreen` | `TicketCounter` (Hoisted) | Dikelola via komponen stateless `TicketCounter` |
| `pesanFeedback` | String | `EventRegistrationScreen` | `Text` | Menampilkan respons setelah tombol diklik |

## Fitur Utama
1. **Validasi Input Real-time:** Tombol "Daftar" otomatis aktif hanya jika nama terisi dan email mengandung karakter `@`.
2. **State Hoisting:** Komponen `TicketCounter` bersifat *stateless* dan menerima *value* serta *event callback* dari komponen induk.
3. **Penyimpanan State saat Rotasi:** Menggunakan `rememberSaveable` agar data pendaftaran tidak hilang ketika layar diputar.
4. **Tombol Reset:** Mengembalikan seluruh *state* ke nilai awal dalam satu klik.

## Cara Menjalankan
1. *Clone* repositori ini atau ekstraksi berkas ZIP proyek.
2. Buka proyek di Android Studio.
3. Jalankan aplikasi pada emulator (misal: Pixel 6a API 34) atau perangkat fisik.
