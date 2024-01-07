-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 07, 2024 at 03:49 PM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `kios`
--

-- --------------------------------------------------------

--
-- Table structure for table `tagihanpelanggan`
--

CREATE TABLE `tagihanpelanggan` (
  `nama` varchar(255) NOT NULL,
  `no_antrian` int(11) NOT NULL,
  `no_jenis_pupuk` int(11) NOT NULL,
  `jenis_pupuk` varchar(255) NOT NULL,
  `no_jenis_pelanggan` int(11) NOT NULL,
  `jenis_pelanggan` varchar(255) NOT NULL,
  `biaya` int(11) NOT NULL,
  `tagihan` double NOT NULL,
  `bayar` int(11) NOT NULL,
  `kembalian` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tagihanpelanggan`
--

INSERT INTO `tagihanpelanggan` (`nama`, `no_antrian`, `no_jenis_pupuk`, `jenis_pupuk`, `no_jenis_pelanggan`, `jenis_pelanggan`, `biaya`, `tagihan`, `bayar`, `kembalian`) VALUES
('vina', 12, 2, 'Pupuk Takesa', 1, 'Umum', 50000, 35000, 35000, 0),
('aurel', 1, 2, 'Pupuk Takesa', 2, 'Member', 50000, 35000, 40000, 5000),
('ghina', 2, 1, 'Pupuk Petroganik', 1, 'Umum', 30000, 30000, 30000, 0),
('dede', 5, 3, 'Pupuk Pronik', 1, 'Umum', 45000, 0, 50000, 50000),
('adi', 9, 3, 'Pupuk Pronik', 2, 'Member', 45000, 0, 45000, 45000),
('sofi', 1, 1, 'Pupuk Petroganik', 2, 'Member', 30000, 30000, 30000, 0),
('ara', 10, 1, 'Pupuk Petroganik', 2, 'Member', 30000, 30000, 30000, 0),
('jake', 20, 1, 'Pupuk Petroganik', 2, 'Member', 30000, 21000, 25000, 4000),
('sofia', 23, 3, 'Pupuk Pronik', 1, 'Umum', 45000, 45000, 45000, 0),
('andi', 5, 1, 'Pupuk Petroganik', 1, 'Umum', 30000, 30000, 30000, 0),
('sisi', 12, 1, 'Pupuk Petroganik', 1, 'Umum', 30000, 30000, 30000, 0),
('dodo', 33, 2, 'Pupuk Takesa', 2, 'Member', 50000, 35000, 35000, 0),
('azizah', 19, 1, 'Pupuk Petroganik', 1, 'Umum', 30000, 30000, 30000, 0),
('aldi', 2, 2, 'Pupuk Takesa', 1, 'Umum', 50000, 50000, 600000, 550000);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
