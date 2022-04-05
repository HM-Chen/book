SHOW DATABASES;
SELECT MONTH(NOW()) 月;
SELECT CURDATE() 时间;
SELECT DATE_FORMAT(NOW(),"%y年%m月%d日") AS output;

CREATE TABLE employees(
	id INT(10),
	first_name VARCHAR(10),
	last_name VARCHAR(10),
	userid VARCHAR(10),
	salary DOUBLE(10,2)
);
DESC employees;
SELECT * FROM employees;

INSERT INTO employees
VALUE(1,'Tom','cat',1001,12000);

DELETE FROM employees;

UPDATE employees SET salary=15000
WHERE employees.id=1;

SHOW TABLES;


create table copy like employees;

create table copy2 
select * from employees;
insert into copy2
value(2,'cat','dog',1002,13000);

drop table copy;

truncate copy2;
SELECT * FROM copy2;


delete from copy2;
rollback;

create view my_v
as 
select * from copy2;

desc my_v;
select * from my_v;

rollback;



delimiter $
create procedure p1()
begin 
	insert into copy2
	VALUE(2,'cat','dog',1002,13000);

end $ 

call p1()$
select * from copy2;


create function f1() returns int
begin
#	declare c int default 0;
	select count(*) into @c
	from copy2;
	returns @c;

end $

select f1()$

declare c int default 0;
SELECT COUNT(*) into @c FROM copy2;
select @c 个数;





























