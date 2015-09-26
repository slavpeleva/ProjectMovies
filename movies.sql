-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jul 16, 2015 at 07:50 PM
-- Server version: 5.6.21
-- PHP Version: 5.6.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `movies`
--

-- --------------------------------------------------------

--
-- Table structure for table `movies`
--

CREATE TABLE IF NOT EXISTS `movies` (
  `MOVIE_TITLE` varchar(250) NOT NULL,
  `DIRECTOR_NAME` varchar(250) NOT NULL,
  `actor` varchar(250) NOT NULL,
  `MOVIE_GENRE` varchar(250) NOT NULL,
  `RATING` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `movies`
--

INSERT INTO `movies` (`MOVIE_TITLE`, `DIRECTOR_NAME`, `actor`, `MOVIE_GENRE`, `RATING`) VALUES
('Insurgent', 'Robert Schwentke', 'Shailene Woodley, Ansel Elgort, Theo James', 'Action,Sci-Fi', 'C'),
('Lord of the rings', 'Peter Jackson', ' Elijah Wood, Olrando Bloom', 'Fantasy,Adventure', 'B'),
('Shrek', ' Andrew Adamson, Vicky Jenson', ' Mike Myers, Eddie Murphy, Cameron Diaz', 'Animation', 'B'),
('Ted', 'Seth MacFarlane', 'Mark Walhberg', 'Comedy', 'C'),
('Terminator Genisys', 'Alan Taylor', ' Arnold Schwarzenegger, Jason Clarke, Emilia Clarke', 'Adventure,Sci-Fi', 'C'),
('The Fault in Our Stars ', 'Josh Boone', 'Shailene Woodley', 'Drama,Romance', 'C'),
('The Matrix ', 'Andy Wachowski', ' Keanu Reeves, Laurence Fishburne, Carrie-Anne ', 'Action,Sci-Fi', 'C');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `movies`
--
ALTER TABLE `movies`
 ADD PRIMARY KEY (`MOVIE_TITLE`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
