# Host: localhost  (Version 5.5.5-10.4.8-MariaDB)
# Date: 2021-05-11 22:49:58
# Generator: MySQL-Front 6.1  (Build 1.21)


#
# Structure for table "posts"
#

DROP TABLE IF EXISTS `posts`;
CREATE TABLE `posts` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fecha` date DEFAULT NULL,
  `titulo` varchar(100) DEFAULT NULL,
  `contenido` text DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

#
# Data for table "posts"
#

INSERT INTO `posts` VALUES (1,'2021-05-11','busqueda','   editando para versi funciona'),(2,'2021-05-11','pueba ','                        \r\n      contenido de prueba                  ');

#
# Structure for table "usuarios"
#

DROP TABLE IF EXISTS `usuarios`;
CREATE TABLE `usuarios` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `usuarios` varchar(20) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

#
# Data for table "usuarios"
#

INSERT INTO `usuarios` VALUES (1,'rudy','123456');
