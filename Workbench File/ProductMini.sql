create table productmini(
id int primary key auto_increment,
title varchar(255) NOT NULL,
price double NOT NULL,
vendor varchar(255) NOT NULL);
 
desc product;

insert into productmini(title,price,vendor) values
("Nokia 6.1",16000,"MyG"),
("Dell vostro",96000,"JioMart"),
("Redmi 9 Pro",25000,"MyG");


select * from productmini;
