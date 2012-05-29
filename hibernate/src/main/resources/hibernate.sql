-- create database experiments - create if it does not exist.

drop table test_table;
drop table student;
drop table address;
drop table person,
drop table person_details;

CREATE TABLE test_table (
id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
name VARCHAR(100));

create table user (
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


create table person (
id int primary key not null,
name varchar(255)
);

create table person_detail (
id int not null auto_increment primary key,
ssn varchar(255),
constraint FOREIGN key (id) references person (id)
);

