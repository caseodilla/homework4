-- Copyright © JZ Greenwell & Casey Hayes
-- Elon University
-- December 3rd, 2016

-- Deletes database if it already exists
DROP DATABASE IF EXISTS vzo5k;

-- Creates a database entitled vzo5k
CREATE SCHEMA vzo5k DEFAULT CHARACTER SET utf8 ;

USE vzo5k;

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