# Notes — Log Perbaikan Proyek PC Booking

Catatan perubahan/perbaikan dari kondisi awal proyek. Format: **Masalah → Penyebab → Perbaikan → File**.

Tambahkan entri baru di bawah kalau kamu nemu/benerin hal lain sendiri — biar histori perubahannya kebaca runtut.

---

## [1] Aplikasi wajib import SQL manual sebelum bisa start

- **Masalah:** Aplikasi gagal start dengan `SchemaManagementException: Schema-validation: missing table [...]` kalau database belum dibuat & di-import manual dulu.
- **Penyebab:** `spring.jpa.hibernate.ddl-auto=validate` — Hibernate cuma mengecek skema yang sudah ada, tidak membuatnya.
- **Perbaikan:** Ganti jadi `ddl-auto=update` (Hibernate auto membuat/menyesuaikan tabel dari entity), tambah `createDatabaseIfNotExist=true` di JDBC URL (database otomatis dibuat kalau belum ada), dan tambah `data.sql` + `spring.sql.init.mode=always` + `spring.jpa.defer-datasource-initialization=true` supaya data referensi (laboratorium & pc) otomatis ter-seed tiap start.
- **File:** `src/main/resources/application.properties`, `src/main/resources/data.sql` (baru)
- **Status:** ✅ Selesai

## [2] JDK 19 dikunci di pom.xml, padahal bukan versi LTS

- **Masalah:** Build gagal di komputer yang cuma punya JDK 17/21 (paling umum terpasang), karena `pom.xml` mengunci versi 19.
- **Penyebab:** `<java.version>19</java.version>` — Java 19 bukan LTS, jarang ada yang instal khusus.
- **Perbaikan:** Turunkan ke `<java.version>17</java.version>` (LTS, lebih umum tersedia, tetap kompatibel dengan Spring Boot 3.5.15).
- **File:** `pom.xml`
- **Status:** ✅ Selesai

## [3] Tidak ada halaman di path `/` (404 kalau buka root URL)

- **Masalah:** Buka `http://localhost:8080/` langsung dapat Whitelabel Error Page 404.
- **Penyebab:** Tidak ada Controller yang menangani `GET /`.
- **Perbaikan:** Tambah `@GetMapping("/")` di `LoginController` yang redirect ke `/login`.
- **File:** `LoginController.java`
- **Status:** ✅ Selesai

## [4] Password disimpan plain text di database

- **Masalah:** Kolom `password` di tabel `peminjam` menyimpan teks polos (mis. `123`), tidak aman kalau database bocor.
- **Penyebab:** `LoginController` & `PeminjamService` menyimpan dan mencocokkan password apa adanya (`findByNimAndPassword`).
- **Perbaikan:** Tambah dependency `spring-security-crypto` (cuma modul hashing, bukan full Spring Security — jadi tidak ada proteksi endpoint otomatis, itu belum digarap di sini). Tambah bean `PasswordEncoder` (BCrypt). `PeminjamService.save()` sekarang hash password sebelum simpan; `PeminjamService.login()` cocokkan pakai `passwordEncoder.matches()`. Method `findByNimAndPassword` di repository dihapus karena sudah tidak relevan.
- **File:** `pom.xml`, `config/PasswordEncoderConfig.java` (baru), `service/PeminjamService.java`, `repository/PeminjamRepository.java`
- **Status:** ✅ Selesai

## [5] Maven Wrapper (`mvnw`) belum executable di Linux

- **Masalah:** `./mvnw spring-boot:run` gagal dengan `Permission denied` di Linux/Mac.
- **Penyebab:** File `mvnw` di-commit tanpa execute bit.
- **Perbaikan:** `chmod +x mvnw` sebelum di-zip ulang, jadi begitu di-extract izinnya sudah ikut kebawa (tergantung tool ekstraknya, kalau masih kena masalah tinggal `chmod +x mvnw` lagi).
- **File:** `mvnw`
- **Status:** ✅ Selesai

---

## Belum digarap / opsional buat langkah selanjutnya

Bagian ini kosong dulu — silakan diisi sendiri kalau nemu hal lain pas inspeksi/debug lanjutan. Beberapa ide yang kemarin belum disentuh (tidak wajib, tapi worth dipertimbangkan):

- [ ] Belum ada proteksi endpoint sungguhan (Spring Security filter chain) — saat ini semua URL termasuk `/dashboard`, `/booking`, dll bisa diakses langsung tanpa login kalau tahu URL-nya, karena pengecekan session cuma ada di `/history`. Coba cek `BookingController` & `DashboardController`, sepertinya belum ada guard session di sana.
- [ ] Belum ada validasi input di form register/login (NIM kosong, password terlalu pendek, dsb) — dependency `spring-boot-starter-validation` sudah ada di `pom.xml` tapi belum dipakai di entity/controller manapun.
- [ ] Belum ada halaman error kustom (404/500 masih default Whitelabel).
- [ ] `pc_booking.sql` & `pc_booking Old.sql` di root masih ikut terbawa — sekarang statusnya cuma arsip/referensi karena seeding sudah otomatis lewat `data.sql`. Boleh dihapus kalau memang tidak dipakai lagi.
