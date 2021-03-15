# Create DATABASE
CREATE DATABASE `spam-application`;

# Create `authorities` table and insert data
CREATE TABLE `authorities` (
                               `username` varchar(50) NOT NULL,
                               `authority` varchar(50) NOT NULL,
                               UNIQUE KEY `authorities_idx_1` (`username`,`authority`),
                               CONSTRAINT `authorities_ibfk_1` FOREIGN KEY (`username`) REFERENCES `users` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
INSERT INTO `authorities` VALUES ('avgona2017@yandex.com','ROLE_ADMIN');

# Create `users` table and insert data
CREATE TABLE `users` (
                         `username` varchar(50) NOT NULL,
                         `password` char(68) NOT NULL,
                         `enabled` tinyint(1) NOT NULL,
                         PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
INSERT INTO `users` VALUES ('avgona2017@yandex.com','{bcrypt}$2a$04$eFytJDGtjbThXa80FyOOBuFdK2IwjyWefYkMpiBEFlpBwDH.5PM0K',1);


# Create `spam` table and insert data
CREATE TABLE `spam` (
                        `id` int NOT NULL AUTO_INCREMENT,
                        `email` varchar(50) NOT NULL,
                        `text` varchar(200) DEFAULT NULL,
                        `time` time NOT NULL,
                        PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
INSERT INTO `spam` VALUES (1,'avgona2017@yandex.com','qweqwe','13:09:30'),(18,'xti@mail.ru','qwe34','18:12:00');
