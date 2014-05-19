-- phpMyAdmin SQL Dump
-- version 3.4.5
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: May 19, 2014 at 03:12 PM
-- Server version: 5.5.16
-- PHP Version: 5.3.8

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `katalog_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `administrator`
--

CREATE TABLE IF NOT EXISTS `administrator` (
  `nim` int(20) NOT NULL,
  `password` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`nim`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `administrator`
--

INSERT INTO `administrator` (`nim`, `password`, `name`) VALUES
(13512081, 'admin', 'Hendro');

-- --------------------------------------------------------

--
-- Table structure for table `group_tubes`
--

CREATE TABLE IF NOT EXISTS `group_tubes` (
  `no_tubes` int(10) NOT NULL,
  `group_name` varchar(255) NOT NULL,
  `anggota_1` varchar(255) DEFAULT NULL,
  `anggota_2` varchar(255) DEFAULT NULL,
  `anggota_3` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`no_tubes`,`group_name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `group_tubes`
--

INSERT INTO `group_tubes` (`no_tubes`, `group_name`, `anggota_1`, `anggota_2`, `anggota_3`) VALUES
(1, '/* Masih dipikirkan */', 'Denny Astika Herdioso', 'Jacqueline Ibrahim', 'Kevin'),
(1, 'Belajar Kehidupan', 'Joshua Bezaleel Abednego', 'Mamat Rahmat', 'Arrya Dwisatya Widigdha'),
(1, 'Botak=Napi', 'Tirta Wening Rahman', 'Eldwin Christian', 'Ahmad Zaky'),
(1, 'Cameo', 'Daniar Heri Kurniawan', 'Stanley Santoso', 'Riska'),
(1, 'Chocolava', 'Indam Muhammad', 'Arina Listyarini Dwiastuti', 'Nisa Dian Rahmadi'),
(1, 'CI-CAK', 'Khoirunnisa Afifah', 'Kevin', 'Calvin Sadewa'),
(1, 'Forget-Us-Not', 'Jan Wira Gotama Putra', 'Christ Angga Saputra', 'Ivana Clairine Irsan'),
(1, 'GGL', 'Stephen', 'Susanti Gojali', 'Felicia Christie'),
(1, 'HFC', 'Mario Tressa Juzar', 'Khaidzir Muhammad Shahih', 'Hendro Triokta Brianto'),
(1, 'Javac', 'Danang Afnan Hudaya', 'Choirunnisa Fatima', 'Aldyaka Mushofan'),
(1, 'Judgement', 'Viktor Trimulya Buntoro', 'Michael Alexander Wangsa', 'Dariel Valdano'),
(1, 'Kel21', 'Willy', 'Jonathan', 'Fahmi Dumadi'),
(1, 'Kelompok 27', 'Aurelia', 'Rita Sarah', 'Cilvia Sianora Putri'),
(1, 'kirkgnaj', 'Muhammad Yafi', 'Ichwan Haryo Sembodo', 'Kevin Maulana'),
(1, 'Koin Aja', 'Linda Sekawati', 'Yanfa Adi Putra', 'Gilang Julian Suherik'),
(1, 'Lailatul Qoding', 'Fauzan Hilmi Ramadhian', 'Ihsan Naufal Ardanto', 'Muhammad Husain Jakfari'),
(1, 'Medan', 'Willy', 'Eric', 'Darwin Prasetio'),
(1, 'nanashi', 'Marcelinus Henry Menori', 'Mario Filino', 'Rikysamuel'),
(1, 'Pelesiran Force', 'Tegar Aji Pangestu', 'Rahmatullah Yoga Sutrisna', 'Akhmad Fathoni Listiyan Dede'),
(1, 'Rinaldio M', 'Andre Susanto', 'Tony', 'Reinaldo Michael Hasian'),
(1, 'Sekre Men', 'Riva Syafri Rachmatullah', 'Yusuf Rahmatullah', 'Lutfi Hamid Masykuri'),
(1, 'Selow', 'Kevin Yudi Utama', 'Winson Waisakurnia', 'Melvin Fonda'),
(1, 'Sembah', 'Aink', 'Luqman Faizlani Kusnadi', 'Hayyu'' Luthfi Hanifah'),
(1, 'teemager', 'Riady Sastra Kusuma', 'Teofebano Kristo', 'Andrey Simaputera'),
(1, 'Tilil 1', 'Ardi Wicaksono', 'Kanya Paramita', 'Adhika Sigit Ramanto'),
(1, 'Tilil 2', 'Ahmad', 'Windy Amelia', 'Bagaskara Pramudita'),
(1, 'Tilil 3', 'Jeffrey Lingga Binangkit', 'Vidia Anindhita', 'Mochamad Lutfi Fadlan'),
(1, 'TiroFinale', 'Tito D. Kesumo Siregar', 'Mohd. Ramdan F.', 'Sabituddin'),
(1, 'Triple A', 'Alvin Natawiguna', 'Andarias Silvanus', 'Annisa''ur Rosi Lutfiana'),
(1, 'Wacana', 'Gifari Kautsar', 'Timothy Pratama', 'William Stefan Hartono'),
(2, 'AhmadSigitAlay', 'Ahmad', 'Vidia Anindhita', 'Adhika Sigit Ramanto'),
(2, 'AZALS', 'Linda Sekawati', 'Ahmad Zaky', 'Aurel'),
(2, 'BOOKED', 'Kevin Yudi Utama', 'Willy', 'William Stefan Hartono'),
(2, 'Buka dikit joss', 'Ramandhika Pranamulia', 'Ichwan Haryo Sembodo', 'Kevin'),
(2, 'Carry me pls', 'Arrya Dwisatya Widigdha', 'Yanfa Adi Putra', 'Try Ajitono'),
(2, 'Cicir', 'Indam Muhammad', 'Khaidzir Muhammad Shahih', 'Danang Afnan Hudaya'),
(2, 'di~h', 'Gifari Kautsar', 'Cilvia Sianora Putri', 'Rikysamuel'),
(2, 'Gembool', 'Stephen', 'Ivana Clairine Irsan', 'Andrey Simaputera'),
(2, 'Giggle', 'Susanti Gojali', 'Willy', 'Melvin Fonda'),
(2, 'GoDocs Editor', 'Kevin Maulana', 'Andarias Silvanus', 'Steve Immanuel Harnadi'),
(2, 'KJeBag', 'Jeffrey Lingga Binangkit', 'Kanya Paramita', 'Bagaskara Pramudita'),
(2, 'Let''s Eat', 'Yusuf Rahmatullah', 'Muhammad Reza Irvanda', 'Arina Listyarini Dwiastuti'),
(2, 'LutfiArdiAlay', 'Ardi Wicaksono', 'Mochamad Lutfi Fadlan', 'Windy Amelia'),
(2, 'RMHolic', 'Luqman Faizlani Kusnadi', 'Hendro Triokta Brianto', 'Muhammad Yafi'),
(2, 'Sampah', 'Joshua Bezaleel Abednego', 'Alvin Natawiguna', 'Dariel Valdano'),
(2, 'SIBYL', 'Felicia Christie', 'Michael Alexander Wangsa', 'Winson Waisakurnia'),
(2, 'Team Guru Super', 'Ihsan Nauval Ardanto', 'Reinaldo Michael Hasian', 'Viktor Trimulya Buntoro'),
(2, 'Veteran STIMA', 'Aisyah Dzulqaidah', 'Reno Rasyad', 'Tito D.Kesumo Siregar'),
(2, 'Warteg Aero', 'Eric', 'Edmund Ophie', 'Daniar Heri Kurniawan'),
(2, 'Yamler', 'Mamat Rahmat', 'Rakhmatullah Yoga Sutrisna', 'Khoirunnisa Afifah'),
(2, 'Yummy', 'Jan Wira Gotama', 'Chrestella Stephanie', 'Calvin Sadewa'),
(3, 'Apaajadeh', 'Mamat Rahmat', 'Daniar Heri Kurniawan', 'Melvin Fonda'),
(3, 'bonbon studios', 'Yanfa Adi Putra', 'Teofebano Kristo', 'Ahmad Zaky'),
(3, 'Botak Brothers', 'Tirta Wening Rahman', 'Yusuf Rahmatullah', 'Andrey Simaputera'),
(3, 'byebyestima', 'Muhammad Yafi', 'Calvin Sadewa', 'Rakhmatullah Yoga Sutrisna'),
(3, 'Damri', 'Indam Muhammad', 'Marcelinus Henry Menori', 'M Husain Jakfari'),
(3, 'DimSum', 'Jan Wira Gotama Putra', 'Willy', 'Willy'),
(3, 'Final Fighter', 'Steve Immanuel Harnadi', 'Khoirunnisa Afifah', 'Akhmad Fakhoni Listiyan Dede'),
(3, 'Gaen', 'Andarias Silvanus', 'Arieza Nadya', 'Michael Alexander Wangsa'),
(3, 'HarddiskBiru', 'Jeffrey Lingga Binangkit', 'Adhika Sigit Ramanto', 'Windy Amelia'),
(3, 'IRK', 'Muntaha Ilmi', 'Khaidzir Muhammad Shahih', 'Rafi Ramadhan'),
(3, 'Konda Fans Club', 'Riska', 'Mario Tressa Juzzar', 'Reinaldo Michael Hasian'),
(3, 'Masorita', 'Rita Sarah', 'Gifari Kautsar', 'Mario Filino'),
(3, 'SID', 'Darwin Prasetio', 'Ivana Clairine Irsan', 'Susanti Gojali'),
(3, 'Triple Eights', 'Tony', 'Viktor Trimulya Buntoro', 'William Stefan Hartono'),
(3, 'tubes terakhir hore', 'Chrestella Stephanie', 'Gilang Julian Suherik', 'Try Ajitiono'),
(3, 'YAH', 'Aurelia', 'Yollanda Sekarini', 'Hendro Triokta Brianto'),
(3, 'yuuu', 'Joshua Bezaleel Abednego', 'Riva Syafri Rachmatullah', 'Aisyah Dzulqaidah'),
(3, '[A]lliance', 'Eric', 'Winson Waisakurnia', 'Kevin');

-- --------------------------------------------------------

--
-- Table structure for table `video`
--

CREATE TABLE IF NOT EXISTS `video` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  `link` text NOT NULL,
  `rating` int(10) DEFAULT NULL,
  `view` int(20) DEFAULT NULL,
  `no_tubes` int(10) NOT NULL,
  `group_nama` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_no_tubes` (`no_tubes`),
  KEY `fK_grup_nama` (`group_nama`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Dumping data for table `video`
--

INSERT INTO `video` (`id`, `title`, `link`, `rating`, `view`, `no_tubes`, `group_nama`) VALUES
(1, 'Tu', 'http://www.youtube.com/v/aLSOdCF1St8&feature=youtube_gdata_player', NULL, 0, 1, 'Tilil 3'),
(2, 'sembah', 'http://www.youtube.com/v/WIJm_eLXDP4&feature=youtube_gdata_player', NULL, NULL, 1, 'Sembah'),
(3, 'Poenya Asus', 'http://www.youtube.com/v/yovoI8GWwz0&feature=youtube_gdata_player', NULL, NULL, 2, 'Tanpa Nama');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
