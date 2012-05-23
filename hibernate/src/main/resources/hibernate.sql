-- create database experiments - create if it does not exist.

drop table test_table;
drop table student;
drop table address;
drop table professional;
drop table skills;
drop table person,
drop table person_details;

CREATE TABLE test_table (
id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
name VARCHAR(100));

create table student (
id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
name VARCHAR(100), 
date_of_birth timestamp , 
address_id int not null);

create table address (
id int not null auto_increment primary key,
line1 varchar(100) not null,
line2 varchar(100),
city varchar(50) not null, 
state varchar(50) not null, 
country varchar(50) not null, 
postal_code varchar(20) not null,
student_id int);

create table professional(
id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(100),
date_of_birth timestamp ,
skill_id int not null);

create table skill (
id int not null auto_increment primary key,
programming_language varchar(50),
years_of_experience int,
operating_system varchar(30),
certification varchar(100),
domain_expertise varchar(255),
professional_id int);

create table body (
  id int not null auto_increment primary key
);

create table heart (
id int NOT NULL auto_increment PRIMARY key );

create table person (
id int primary key not null,
first_name varchar(255),
last_name varchar(255)
);

create table person_details (
id int not null auto_increment primary key,
hair_color varchar(255),
eye_color varchar(255),
constraint FOREIGN key (id) references person (id)
);