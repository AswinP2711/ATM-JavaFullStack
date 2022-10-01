create database mydb_2000078293;
use mydb_2000078293;

create table employee(
id int primary key auto_increment,
name varchar(255) NOT NULL,
salary double NOT NULL,
branch varchar(255) NOT NULL);

desc employee;

insert into employee(name,salary,branch) values
("Aswin",95000,"Mumbai"),
("Manu",96000,"Chennai"),
("Kailas",25000,"Bangalore"); 

select * from employee;



