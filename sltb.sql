-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 26, 2021 at 08:13 AM
-- Server version: 10.4.18-MariaDB
-- PHP Version: 8.0.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `sltb`
--

-- --------------------------------------------------------

--
-- Table structure for table `bus`
--

CREATE TABLE `bus` (
  `ticketPrice` float NOT NULL,
  `seatAval` int(255) NOT NULL,
  `rout` varchar(255) NOT NULL,
  `timeAval` varchar(255) NOT NULL,
  `type` varchar(255) NOT NULL,
  `id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `bus`
--

INSERT INTO `bus` (`ticketPrice`, `seatAval`, `rout`, `timeAval`, `type`, `id`) VALUES
(2525, 55, 'sfdf', 'sdfsf', 'A/C', 4),
(2525, 55, 'sfdf', 'sdfsf', 'A/C', 5),
(2525, 55, 'sfdf', 'sdfsf', 'A/C', 6),
(2525, 55, 'sfdf', 'sdfsf', 'A/C', 7),
(45000, 65, 'Digana to kandy', '1 p . m to 4 p.m', 'Non-A/C', 8),
(422, 14, 'sfdf', 'sdfsf', 'A/C', 9),
(422, 14, 'sfdf', 'sdfsf', 'A/C', 10),
(422, 14, 'sfdf', 'sdfsf', 'A/C', 11),
(422, 14, 'sfdf', 'sdfsf', 'A/C', 12),
(422, 14, 'sfdf', 'sdfsf', 'A/C', 13),
(422, 14, 'sfdf', 'sdfsf', 'A/C', 14),
(422, 14, 'sfdf', 'sdfsf', 'A/C', 15),
(422, 14, 'sfdf', 'sdfsf', 'A/C', 16),
(422, 14, 'sfdf', 'sdfsf', 'A/C', 17),
(422, 14, 'sfdf', 'sdfsf', 'A/C', 18),
(422, 14, 'sfdf', 'sdfsf', 'A/C', 19),
(422, 14, 'sfdf', 'sdfsf', 'A/C', 20),
(422, 14, 'sfdf', 'sdfsf', 'A/C', 21),
(422, 14, 'sfdf', 'sdfsf', 'A/C', 22),
(422, 14, 'sfdf', 'sdfsf', 'A/C', 23),
(422, 14, 'sfdf', 'sdfsf', 'A/C', 24),
(422, 14, 'sfdf', 'sdfsf', 'A/C', 25),
(422, 14, 'sfdf', 'sdfsf', 'A/C', 26),
(422, 14, 'sfdf', 'sdfsf', 'A/C', 27),
(422, 14, 'sfdf', 'sdfsf', 'A/C', 28);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `userType` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`email`, `password`, `userType`) VALUES
('admin@admin.com', '123456789', 'admin'),
('user@user.com', '123456789', 'user');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `bus`
--
ALTER TABLE `bus`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`email`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `bus`
--
ALTER TABLE `bus`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
