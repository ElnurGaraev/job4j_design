create table car (
	id serial primary key,
	name varchar(255)
);

create table owner (
	id serial primary key,
	name varchar(255),
	car_id int references car (id)
);

insert into car(name) values('Toyota');
insert into owner(name, car_id) VALUES ('Ivan', 1);
