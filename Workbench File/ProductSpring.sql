create table product1(
id int primary key auto_increment,
title varchar(255) NOT NULL,
price double NOT NULL,
vendor varchar(255) NOT NULL);
 
 insert into product1(title,price,vendor) values ("iphone",70000,"ABC Electronics"),("Nokia 6.1",80000,"JDC Electronics");
desc product1;

select * from product1;
