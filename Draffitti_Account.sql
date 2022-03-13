use draffitti;
select * from account;

use draffitti;
create table account (name varchar (255),
email varchar (255),
password varchar (255),
PhoneNumber varchar(255),
address varchar (255),
dateadded date);

ALTER TABLE `draffitti`.`account`
CHANGE COLUMN `dateadded` `dateadded` DATETIME NULL DEFAULT CURRENT_TIMESTAMP ;

ALTER TABLE `draffitti`.`account`
ADD COLUMN `id` INT NOT NULL AUTO_INCREMENT FIRST,
ADD PRIMARY KEY (`id`);
;

use draffitti;
create table Product (productID int(11), 
Productname varchar (255), 
psize varchar(255),
Pamount decimal(19,2),
customized text,
createdate timestamp);


