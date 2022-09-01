-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : jeu. 01 sep. 2022 à 06:21
-- Version du serveur : 5.7.36
-- Version de PHP : 7.4.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `gestion_reservation_lit`
--

-- --------------------------------------------------------

--
-- Structure de la table `reservation_lit`
--

DROP TABLE IF EXISTS `reservation_lit`;
CREATE TABLE IF NOT EXISTS `reservation_lit` (
  `code_reseration` bigint(20) NOT NULL AUTO_INCREMENT,
  `code_hopital` bigint(20) DEFAULT NULL,
  `code_specialisation` bigint(20) DEFAULT NULL,
  `date_reservation` datetime DEFAULT NULL,
  `nom_patient` varchar(255) DEFAULT NULL,
  `prenom_patient` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`code_reseration`)
) ENGINE=MyISAM AUTO_INCREMENT=75 DEFAULT CHARSET=latin1;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
