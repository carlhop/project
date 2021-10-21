--Created by Carl R. Hopkins
CREATE table bankAccount (
customer_id serial primary key,
FirstName varchar(50),
account_type varchar(25),
	balance numeric
)

drop table bankAccount;
insert into bankAccount (FirstName, account_type, balance) values ('Tom', 'savings', 25000.00);

delete from 
 where  

create table contactInfo(
	customer_id serial primary key,
	LastName varchar(20),
	phone_number varchar(15),
	address varchar(75),
	city_state varchar(75),
	email_address varchar(50)
)
drop table contactInfo;
insert into contactInfo (LastName, phone_number,address, city_state, email_address) values ('Brady','334-546-9980' ,'500 Bright Street','Montgomery, AL', 'tommyt@yahoo.com');


select*
from bank_account;

select*
from contact_info;