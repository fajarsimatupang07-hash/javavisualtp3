# Character Manager — TP8 / Sprint #3 (Java Visual SIH-6406)

* **Nama:** Royson Fajar Simatupang
* **NIM:** 253303621268
* **Link Google Docs Analisis (Bagian D):** https://docs.google.com/document/d/1FQ3LvDHiXmk2xzdDogaZFdeujKlukCNe9eswsAc-E2I/edit

## 📋 Bagian C — Dokumentasi TP8 (GUI & MVC)
- **Implementasi GUI:** Berhasil melakukan transisi dari aplikasi berbasis *console* ke jendela grafis berbasis Java Swing (`MainWindow extends JFrame` di dalam package `com.unpri.charactermanager.view`) dengan menerapkan `SwingUtilities.invokeLater()` demi keamanan *Event Dispatch Thread* (EDT).
- **Data Dinamis & Statistik:** Menampilkan data seluruh karakter secara dinamis menggunakan *loop* (bukan komponen statis/hardcode) serta melampirkan JLabel statistik "Rata-rata Level Karakter" di panel bawah yang nilainya terhitung secara akurat.
- **Alur Data MVC:** 
  1. `Main` menginisialisasi manajer data dan objek karakter awal.
  2. `CharacterManager` (Model) menampung dan memproses koleksi data karakter.
  3. `MainWindow` (View) mengambil data dari Model secara dinamis dan merendernya ke dalam kartu antarmuka grafis Swing.
- **Daftar Karakter Baru:** Menambahkan 2 karakter baru yaitu `Shadow` (Assassin, Level 4) dan `Eirwyn` (Archer, Level 3) sehingga total menjadi 5 karakter, sekaligus menguji keakuratan perhitungan statistik rata-rata level saat data diubah.