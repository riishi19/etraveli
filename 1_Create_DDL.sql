create database weather;

use weather;

CREATE TABLE User (userid int(11) NOT NULL AUTO_INCREMENT,  name varchar(45) NOT NULL,  email varchar(45) NOT NULL, password varchar(100) NOT NULL,  address varchar(45) NOT NULL, age varchar(2) NOT NULL, city varchar(25) NOT NULL, mobile varchar(13) NOT NULL, temp_range double(6,2) ,  alert_type varchar(3),notification_channel varchar(20), PRIMARY KEY (userid)) ENGINE=InnoDB DEFAULT CHARSET=utf8;

create table Location (locationid int(10), locationname varchar(100) , PRIMARY KEY (locationid));


create table Weather (weatherid int(10), APIName varchar(100),   PRIMARY KEY (weatherid));


create table LocWeather (id int(6), weatherid int(10), locationid int(10), min_temp double(6,2), max_temp double(6,2),   PRIMARY KEY (id), FOREIGN KEY (locationid) REFERENCES Location(locationid), FOREIGN KEY (weatherid) REFERENCES Temparature(weatherid));


Create table UserPreference (id int(11) NOT NULL AUTO_INCREMENT,userid int(11) NOT NULL ,email varchar(45) NOT NULL, locationid int(10),last_update TIMESTAMP,notification_channel varchar(20),PRIMARY KEY (id), FOREIGN KEY (userid) REFERENCES user(userid), FOREIGN KEY (locationid) REFERENCES Location(locationid));
