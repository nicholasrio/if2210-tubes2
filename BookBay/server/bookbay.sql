-- phpMyAdmin SQL Dump
-- version 4.1.12
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: May 18, 2014 at 12:58 PM
-- Server version: 5.6.16
-- PHP Version: 5.5.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `bookbay`
--
CREATE DATABASE IF NOT EXISTS `bookbay` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `bookbay`;

-- --------------------------------------------------------

--
-- Table structure for table `book`
--

DROP TABLE IF EXISTS `book`;
CREATE TABLE IF NOT EXISTS `book` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(256) NOT NULL,
  `location` text NOT NULL,
  `uploader_id` int(11) NOT NULL,
  `description` text,
  `upload_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `download_count` int(11) NOT NULL DEFAULT '0',
  `category` varchar(32) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `name` (`name`,`category`),
  KEY `uplodaer_id` (`uploader_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=18 ;

--
-- Dumping data for table `book`
--

INSERT INTO `book` (`id`, `name`, `location`, `uploader_id`, `description`, `upload_time`, `download_count`, `category`) VALUES
(15, 'HowtoReadABook.pdf', '/upload/edmundophie/c4efe4bb0e85cc99080f032a0503fb2e4a9cfc9d.pdf', 1, 'HowtoReadABook', '2014-05-17 04:01:58', 0, 'ebook'),
(16, 'Accelerated C++ 2000.pdf', '/upload/jacksparrow/1e6e2bc189b29df142e4b1e8f4b1e849e65b47ca.pdf', 2, 'hahahahahaha', '2014-05-17 12:28:52', 0, 'ebooks'),
(17, 'Capital-Volume-I.pdf', '/upload/jacksparrow/3313730920a0cdb2cf93d49614a9a478013dc988.pdf', 2, 'coba coba upload', '2014-05-17 15:52:55', 0, 'ebook');

-- --------------------------------------------------------

--
-- Table structure for table `collection`
--

DROP TABLE IF EXISTS `collection`;
CREATE TABLE IF NOT EXISTS `collection` (
  `book_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`book_id`,`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `username`, `password`) VALUES
(1, 'edmundophie', '12345'),
(2, 'jacksparrow', 'qwert');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
