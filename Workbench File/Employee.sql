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

show tables;

desc students;
select * from students;
desc department;
select * from department;

desc products;
desc vendor;
desc review;
select * from vendor;
select * from products;
select * from review;

desc employee_records;
select * from employee_records;

desc dept;
select * from dept;