create table product(
id int primary key auto_increment,
name varchar(255) NOT NULL,
price double NOT NULL,
description varchar(255) NOT NULL);

desc product;

insert into product(name,price,description) values
("Nokia 6.1",16000,"4 gb Ram"),
("Dell vostro",96000,"256GB SSD"),
("Redmi 9 Pro",25000,"64 MP Camera");


select * from product;
