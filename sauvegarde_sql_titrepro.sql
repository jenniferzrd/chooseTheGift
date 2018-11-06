DROP DATABASE IF EXISTS `sql_script_titrepro`;
CREATE DATABASE sql_script_titrepro;
USE sql_script_titrepro;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;

CREATE TABLE `roles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `roles_rolecode` varchar(45) NOT NULL,
  `roles_rolename` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;
 
--
-- INSERT VALUES FOR `roles`
--

INSERT INTO `roles` VALUES
(1,'SUPERADMIN', 'Super Admin'),
(2,'ADMIN', 'Administrator');

--
-- Table structure for table `idea`
--

DROP TABLE IF EXISTS `idea`;

CREATE TABLE `idea` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(45) DEFAULT NULL,
  `img` varchar(2000) DEFAULT NULL,
  `comment` varchar(45) DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  `jaime` tinyint(1) DEFAULT NULL,
  `quantity` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

--
-- INSERT VALUES FOR `idea`
--

INSERT INTO `idea` VALUES 
(1,'test','https://cdn-images-1.medium.com/max/1600/1*WgROsTKa6diRYTG5K0R5mw.jpeg','test1',10,0,1),
(2,'test2','https://cdn-images-1.medium.com/max/1600/1*WgROsTKa6diRYTG5K0R5mw.jpeg','test2',0,0,1),
(3,'test3','https://cdn-images-1.medium.com/max/1600/1*WgROsTKa6diRYTG5K0R5mw.jpeg','test3',4,0,1),
(9,'','a','a',10,0,1),
(19,'','eee','',33,0,1);

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `firstname` varchar(45) DEFAULT NULL,
  `lastname` varchar(45) DEFAULT NULL,
  `money` int(11) DEFAULT NULL,
  `roles_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_roles_id` FOREIGN KEY (`roles_id`) REFERENCES `roles` (`id`)
  ) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

--
-- INSERT VALUES FOR `user`
--

INSERT INTO `user` VALUES 

(1,'arthur','martin',10, 1),
(15,'hello','world',10, 2),
(16,'Au','u',5, 1),
(20,'Jeanne','Jule',20, 1),
(22,'a','b',10, 1);

--
-- Table structure for table `project`
--

DROP TABLE IF EXISTS `project`;

CREATE TABLE `project` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(45) DEFAULT NULL,
  `totalmoney` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

--
-- INSERT VALUES FOR `project`
--

INSERT INTO `project` VALUES 
(1,'pot de depart',0,1),
(2,'testfk',0,15),
(3,'test3',1,22),
(4,'test4',1,NULL);

--
-- Table structure for table `projects_ideas`
--

DROP TABLE IF EXISTS `projects_ideas`;

CREATE TABLE `projects_ideas` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_ideas` int(11) NOT NULL,
  `id_projects` int(11) NOT NULL,
  PRIMARY KEY (`id`,`id_ideas`,`id_projects`),
  CONSTRAINT `fk_ideas` FOREIGN KEY (`id_ideas`) REFERENCES `idea` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_projects` FOREIGN KEY (`id_projects`) REFERENCES `project` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- INSERT VALUES FOR `projects_ideas`
--

INSERT INTO `projects_ideas` VALUES (1,1,1),(1,2,2);

--
-- Table structure for table `projects_users`
--

DROP TABLE IF EXISTS `projects_users`;

CREATE TABLE `projects_users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_users` int(11) NOT NULL,
  `id_plan` int(11) NOT NULL,
  PRIMARY KEY (`id`,`id_users`,`id_plan`),
  CONSTRAINT `fk_users` FOREIGN KEY (`id_users`) REFERENCES `user` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_plan` FOREIGN KEY (`id_plan`) REFERENCES `project` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

--
-- INSERT VALUES FOR `projects_users`
--

INSERT INTO `projects_users` VALUES (1,1,1),(2,1,2);

