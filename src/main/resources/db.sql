CREATE DATABASE  IF NOT EXISTS `manager` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `manager`;

DROP TABLE IF EXISTS user;
CREATE TABLE user
(
    id INT(10) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    login VARCHAR(255),
    password VARCHAR(255),
    role VARCHAR(255)
);

DROP TABLE IF EXISTS dashboard;
CREATE TABLE dashboard
(
    id INT(10) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255),
    description TEXT,
    status VARCHAR(255),
    date_start VARCHAR(255),
    date_end VARCHAR(255),
    author VARCHAR(255)
);

DROP TABLE IF EXISTS task;
CREATE TABLE task
(
    id INT(10) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255),
    description VARCHAR(255),
    status VARCHAR(255),
    date_start VARCHAR(255),
    date_end VARCHAR(255),
    dashboard_id INT(10),
    author VARCHAR(255),
    user VARCHAR(255)
);

DROP TABLE IF EXISTS comment;
CREATE TABLE comment
(
    id INT(10) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    login VARCHAR(255),
    date VARCHAR (255),
    task_id INT(10),
    comment text
);
