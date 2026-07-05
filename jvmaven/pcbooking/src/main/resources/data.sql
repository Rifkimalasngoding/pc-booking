-- Data referensi (laboratorium & pc) di-seed otomatis setiap aplikasi start.
-- Pakai INSERT IGNORE supaya aman dijalankan berkali-kali (tidak duplikat),
-- berkat UNIQUE KEY di kolom nama_lab dan kode_pc.
--
-- Data akun peminjam & riwayat transaksi TIDAK di-seed di sini secara sengaja:
-- akun dibuat sendiri lewat halaman /register, dan transaksi dibuat lewat /booking.

INSERT IGNORE INTO laboratorium (id_lab, nama_lab) VALUES
(1, 'Game dan Multimedia'),
(2, 'Rekayasa Perangkat Lunak'),
(3, 'Jaringan Komputer');

INSERT IGNORE INTO pc (id_pc, kode_pc, nama_pc, status, id_lab) VALUES
(1, 'GM1', 'PC GAMED 1', 'TERSEDIA', 1),
(2, 'RPL1', 'PC RPL 1', 'TERSEDIA', 2),
(3, 'GM2', 'PC GAMED 2', 'TERSEDIA', 1),
(4, 'RPL2', 'PC RPL 2', 'MAINTENANCE', 2),
(5, 'JK1', 'PC JARKOM 1', 'TERSEDIA', 3),
(6, 'JK2', 'PC JARKOM 2', 'TERSEDIA', 3),
(7, 'JK3', 'PC JARKOM 3', 'MAINTENANCE', 3),
(8, 'GM3', 'PC GAMED 3', 'TERSEDIA', 1);
