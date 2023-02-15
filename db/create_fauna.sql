create table fauna (
	id serial primary key,
	name text,
	avr_age int,
	discovery_date date
);

insert into fauna(name, avr_age, discovery_date)
values ('cat', 13, date '950-09-01');
insert into fauna(name, avr_age, discovery_date)
values ('dog', 11, date '700-05-01');
insert into fauna(name, avr_age, discovery_date)
values ('rabbit', 7, date '1900-06-01');
insert into fauna(name, avr_age, discovery_date)
values ('elephant', 60, date '1912-05-01');
insert into fauna(name, avr_age, discovery_date)
values ('wolf', 6, date '1500-04-01');
