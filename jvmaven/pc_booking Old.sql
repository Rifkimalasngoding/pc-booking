-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Jul 03, 2026 at 04:19 PM
-- Server version: 8.0.30
-- PHP Version: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `pc_booking`
--

-- --------------------------------------------------------

--
-- Table structure for table `laboratorium`
--

CREATE TABLE `laboratorium` (
  `id_lab` int NOT NULL,
  `nama_lab` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `laboratorium`
--

INSERT INTO `laboratorium` (`id_lab`, `nama_lab`) VALUES
(1, 'Game dan Multimedia'),
(2, 'Rekayasa Perangkat Lunak');

-- --------------------------------------------------------

--
-- Table structure for table `pc`
--

CREATE TABLE `pc` (
  `id_pc` int NOT NULL,
  `kode_pc` varchar(10) NOT NULL,
  `nama_pc` varchar(50) NOT NULL,
  `status` enum('TERSEDIA','DIPINJAM','MAINTENANCE') NOT NULL DEFAULT 'TERSEDIA',
  `id_lab` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `pc`
--

INSERT INTO `pc` (`id_pc`, `kode_pc`, `nama_pc`, `status`, `id_lab`) VALUES
(1, 'GM1', 'PC GAMED 1', 'DIPINJAM', 1),
(2, 'RPL1', 'PC RPL 1', 'TERSEDIA', 2),
(3, 'GM2', 'PC GAMED 2', 'TERSEDIA', 1),
(4, 'RPL2', 'PC RPL 2', 'MAINTENANCE', 2);

-- --------------------------------------------------------

--
-- Table structure for table `peminjam`
--

CREATE TABLE `peminjam` (
  `id_peminjam` int NOT NULL,
  `nim` varchar(15) NOT NULL,
  `nama` varchar(100) NOT NULL,
  `password` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `peminjam`
--

INSERT INTO `peminjam` (`id_peminjam`, `nim`, `nama`, `password`) VALUES
(1, '241080200104', 'indra', '241080200104'),
(6, '241080200999', 'Geraldo', '123'),
(7, '241080200998', 'Jamal', '123'),
(8, '241080200990', 'Hutagalung', '123');

-- --------------------------------------------------------

--
-- Table structure for table `transaksi_peminjaman`
--

CREATE TABLE `transaksi_peminjaman` (
  `id_transaksi` int NOT NULL,
  `id_peminjam` int NOT NULL,
  `id_pc` int NOT NULL,
  `waktu_mulai` datetime NOT NULL,
  `durasi_jam` int NOT NULL,
  `keperluan` varchar(255) NOT NULL,
  `waktu_selesai` datetime DEFAULT NULL,
  `status` enum('AKTIF','SELESAI') NOT NULL DEFAULT 'AKTIF'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `transaksi_peminjaman`
--

INSERT INTO `transaksi_peminjaman` (`id_transaksi`, `id_peminjam`, `id_pc`, `waktu_mulai`, `durasi_jam`, `keperluan`, `waktu_selesai`, `status`) VALUES
(1, 1, 1, '2026-07-03 13:54:54', 3, 'tuagas', '2026-07-03 14:03:16', 'SELESAI'),
(2, 1, 1, '2026-07-03 14:03:36', 6, 'tgas', '2026-07-03 14:08:24', 'SELESAI'),
(3, 1, 2, '2026-07-03 14:15:51', 1, 'tgs', '2026-07-03 14:17:55', 'SELESAI'),
(4, 1, 1, '2026-07-03 14:18:17', 1, 'w', '2026-07-03 14:18:27', 'SELESAI'),
(5, 1, 1, '2026-07-03 17:47:00', 2, 'tgs', '2026-07-03 17:47:14', 'SELESAI'),
(6, 1, 4, '2026-07-03 19:52:33', 1, 'tgs', '2026-07-03 20:22:57', 'SELESAI'),
(7, 1, 2, '2026-07-03 20:24:34', 1, 'tgs', '2026-07-03 20:25:17', 'SELESAI'),
(8, 7, 1, '2026-07-03 22:16:21', 1, 'tgs', '2026-07-03 22:16:39', 'SELESAI'),
(9, 7, 2, '2026-07-03 22:16:35', 1, 'tgs', '2026-07-03 22:16:37', 'SELESAI'),
(10, 7, 1, '2026-07-03 22:34:08', 1, 'tgs', '2026-07-03 22:34:11', 'SELESAI'),
(11, 6, 1, '2026-07-03 22:37:28', 1, 'tugas', '2026-07-03 22:42:04', 'SELESAI'),
(12, 1, 1, '2026-07-03 22:47:35', 1, 'tugas', '2026-07-03 22:50:44', 'SELESAI'),
(13, 1, 1, '2026-07-03 22:59:04', 3, 'tugas', '2026-07-03 22:59:45', 'SELESAI'),
(14, 1, 2, '2026-07-03 22:59:55', 1, 't', '2026-07-03 23:16:27', 'SELESAI'),
(15, 1, 1, '2026-07-03 23:17:22', 1, 'w', NULL, 'AKTIF');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `laboratorium`
--
ALTER TABLE `laboratorium`
  ADD PRIMARY KEY (`id_lab`),
  ADD UNIQUE KEY `nama_lab` (`nama_lab`);

--
-- Indexes for table `pc`
--
ALTER TABLE `pc`
  ADD PRIMARY KEY (`id_pc`),
  ADD UNIQUE KEY `kode_pc` (`kode_pc`),
  ADD KEY `fk_lab` (`id_lab`);

--
-- Indexes for table `peminjam`
--
ALTER TABLE `peminjam`
  ADD PRIMARY KEY (`id_peminjam`),
  ADD UNIQUE KEY `nim` (`nim`);

--
-- Indexes for table `transaksi_peminjaman`
--
ALTER TABLE `transaksi_peminjaman`
  ADD PRIMARY KEY (`id_transaksi`),
  ADD KEY `fk_peminjam` (`id_peminjam`),
  ADD KEY `fk_pc` (`id_pc`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `laboratorium`
--
ALTER TABLE `laboratorium`
  MODIFY `id_lab` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `pc`
--
ALTER TABLE `pc`
  MODIFY `id_pc` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `peminjam`
--
ALTER TABLE `peminjam`
  MODIFY `id_peminjam` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `transaksi_peminjaman`
--
ALTER TABLE `transaksi_peminjaman`
  MODIFY `id_transaksi` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `pc`
--
ALTER TABLE `pc`
  ADD CONSTRAINT `fk_lab` FOREIGN KEY (`id_lab`) REFERENCES `laboratorium` (`id_lab`) ON DELETE RESTRICT ON UPDATE CASCADE;

--
-- Constraints for table `transaksi_peminjaman`
--
ALTER TABLE `transaksi_peminjaman`
  ADD CONSTRAINT `fk_pc` FOREIGN KEY (`id_pc`) REFERENCES `pc` (`id_pc`) ON DELETE RESTRICT ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_peminjam` FOREIGN KEY (`id_peminjam`) REFERENCES `peminjam` (`id_peminjam`) ON DELETE RESTRICT ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
