-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: May 21, 2019 at 04:42 AM
-- Server version: 8.0.13-4
-- PHP Version: 7.2.17-0ubuntu0.18.04.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `eKfdYZ2kEA`
--

-- --------------------------------------------------------

--
-- Table structure for table `spot`
--

CREATE TABLE `spot` (
  `id` int(11) NOT NULL COMMENT 'Spot Unique Identity Number',
  `tale` varchar(500) COLLATE utf8_unicode_ci NOT NULL COMMENT 'Tale of the Spot',
  `description` varchar(1000) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT 'Optional Description',
  `remark` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT 'Optional Spot Remark',
  `status` int(1) NOT NULL DEFAULT '0' COMMENT 'Spot Status',
  `latitude` float NOT NULL COMMENT 'Location Latitude',
  `longitude` float NOT NULL COMMENT 'Location Longitute',
  `create_timestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Register Timestamp'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `spot`
--

INSERT INTO `spot` (`id`, `tale`, `description`, `remark`, `status`, `latitude`, `longitude`) VALUES
(1, 'Hungry Man Came Here', 'This Place is Significantly Place of Hungry People... ', NULL, 0, 14.0492, 99.9025);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `spot`
--
ALTER TABLE `spot`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `spot`
--
ALTER TABLE `spot`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Spot Unique Identity Number', AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
