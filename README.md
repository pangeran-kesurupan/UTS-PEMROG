# Profile & Preference App

Aplikasi Android berbasis **Jetpack Compose** untuk tugas **UTS Mobile Programming – Paket A**  
Menampilkan form profil, ringkasan dengan toggle **mode gelap**, dan halaman **riwayat data tersimpan**.

---

## Fitur Utama

### 1. Form Profil
- Input **Nama Lengkap**, **Kelas**, dan **Hobi**
- Tombol **Simpan & Lanjut** untuk navigasi ke Ringkasan Profil  
- Validasi otomatis agar semua field terisi sebelum lanjut

### 2. Ringkasan Profil
- Menampilkan data yang dikirim dari form
- Switch untuk **mengaktifkan Mode Gelap / Terang (real-time)**
- Tombol **Simpan ke Perangkat** untuk menyimpan data ke SharedPreferences
- Data yang disimpan juga otomatis masuk ke **riwayat**

### 3. Pengaturan Tersimpan
- Menampilkan **profil terakhir** dan **daftar riwayat profil**
- Setiap item riwayat bisa:
  - **Edit** (ubah nama, kelas, hobi, atau status mode gelap)
  - **Hapus**
- Tombol **Kembali ke Form** untuk membuat entri baru

---

## ⚙️ Teknologi yang Digunakan

| Komponen | Keterangan |
|-----------|------------|
| **Jetpack Compose** | UI deklaratif modern Android |
| **Material 3** | Tampilan modern (TopAppBar, ElevatedCard, Button, Switch, dsb) |
| **Navigation Compose** | Navigasi antar 3 screen |
| **SharedPreferences (JSON)** | Penyimpanan lokal data profil & riwayat |
| **Kotlin** | Bahasa utama pengembangan aplikasi |

---

## Struktur Navigasi
ProfileFormScreen → ProfileSummaryScreen → SavedSettingsScreen
↑ ↓
└────────────── Back to Form ───────┘


---

## Struktur Folder
~~~
app/
├── data/
│ ├── Prefs.kt # Penyimpanan & riwayat (SharedPreferences)
│ ├── Profile.kt # Data profil sederhana
│ └── ProfileEntry.kt # Model riwayat profil
│
├── nav/
│ └── Routes.kt # Rute navigasi antar screen
│
├── ui/theme/
│ ├── Color.kt # Palet warna utama
│ ├── Theme.kt # Dark/Light theme controller
│ ├── Type.kt # Typography
│ └── screen/
│ ├── ProfileFormScreen.kt
│ ├── ProfileSummaryScreen.kt
│ └── SavedSettingsScreen.kt
│
├── MainActivity.kt # Root dengan NavHost dan tema
└── AndroidManifest.xml
~~~
---

## Tampilan Aplikasi

| Screen | Preview |
|:-------|:---------|
| **Form Profil** | Input nama, kelas, hobi |
| **Ringkasan Profil** | Toggle mode gelap / terang |
| **Pengaturan Tersimpan** | Riwayat profil (edit & hapus) |

---

##  Fitur Mode Gelap Real-Time

- Saat switch diaktifkan, UI **langsung berubah** ke dark mode tanpa perlu simpan.
- Status dark mode disimpan di `SharedPreferences` agar tetap sama saat app dibuka lagi.

---

## Cara Menjalankan

1. Clone repo:
   ```bash
   git clone https://github.com/<username>/<repo>.git

2. Buka di Android Studio.

3. Jalankan di emulator / perangkat nyata (minSdk 24+).

4. Isi form → simpan → nikmati fitur mode gelap & riwayat data.

Pengembang

Nama: Muhammad Riduwan
NIM: 230104040080
Kelas: Informatika – Universitas Antasari
Tugas: UTS Mobile Programming – Paket A

Lisensi

Aplikasi ini dibuat untuk keperluan akademik.
Dilarang memperjualbelikan atau mendistribusikan ulang tanpa izin pembuat.

“Build once, run smart — your profile, your preferences.”

---

Kamu mau saya bantu tambahkan **preview screenshot** otomatis di README (pakai tag `<img>`), misalnya dari hasil emulator yang kamu kirim?  
Kalau iya, kirim 2–3 screenshot (Form, Ringkasan, SavedSettings), nanti saya tambahkan bagian *Screenshots* di README-mu biar makin keren.


