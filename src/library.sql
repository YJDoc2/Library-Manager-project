-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Oct 28, 2019 at 06:31 AM
-- Server version: 5.7.26
-- PHP Version: 7.2.18

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `library`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
CREATE TABLE IF NOT EXISTS `admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(100) NOT NULL,
  `password` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`id`, `username`, `password`) VALUES
(1, 'Admin', '1234');

-- --------------------------------------------------------

--
-- Table structure for table `books`
--

DROP TABLE IF EXISTS `books`;
CREATE TABLE IF NOT EXISTS `books` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `BOOK_ID` varchar(50) NOT NULL,
  `NAME` varchar(100) NOT NULL,
  `TYPE` varchar(20) NOT NULL,
  `PUBLISHER` varchar(100) NOT NULL,
  `PRICE` int(50) DEFAULT NULL,
  `AVAILIBILITY` varchar(20) NOT NULL DEFAULT 'AVAILABLE',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `books`
--

-- --------------------------------------------------------

--
-- Table structure for table `issue`
--

DROP TABLE IF EXISTS `issue`;
CREATE TABLE IF NOT EXISTS `issue` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `BOOK_ID` varchar(50) NOT NULL,
  `BOOK_NAME` varchar(100) NOT NULL,
  `TYPE` varchar(20) NOT NULL,
  `PUBLISHER` varchar(100) NOT NULL,
  `PRICE` int(50) NOT NULL,
  `STUDENT_ID` bigint(11) NOT NULL,
  `STUDENT_NAME` varchar(50) NOT NULL,
  `COURSE` varchar(50) NOT NULL,
  `YEAR` varchar(25) NOT NULL,
  `SEMESTER` varchar(50) NOT NULL,
  `DATEOFISSUE` date NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=42 DEFAULT CHARSET=latin1;


-- --------------------------------------------------------

--
-- Table structure for table `students`
--

DROP TABLE IF EXISTS `students`;
CREATE TABLE IF NOT EXISTS `students` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `STUDENT_ID` bigint(11) NOT NULL,
  `NAME` varchar(50) NOT NULL,
  `COURSE` varchar(50) NOT NULL,
  `YEAR` varchar(25) NOT NULL,
  `SEMESTER` varchar(20) NOT NULL,
  `BOOKSISSUED` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `students`
--


COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
