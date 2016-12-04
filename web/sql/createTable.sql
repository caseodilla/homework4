-- Copyright © JZ Greenwell & Casey Hayes
-- Elon University
-- December 3rd, 2016

-- Deletes database if it already exists
DROP DATABASE IF EXISTS homework4;

-- Creates a database entitled homework4
CREATE SCHEMA homework4 DEFAULT CHARACTER SET utf8 ;

USE homework4;

CREATE TABLE User (
Email VARCHAR(45) UNIQUE NOT NULL,
FirstName VARCHAR(45) NULL,
LastName VARCHAR(45) NULL,
PRIMARY KEY(Email));

CREATE TABLE Book (
BookName VARCHAR(45) NOT NULL,
DueDate DATETIME NOT NULL,
Email VARCHAR(45) NOT NULL,
PRIMARY KEY(Email,BookName),
FOREIGN KEY(Email) REFERENCES User(Email));