create table phonenumber (
	id serial primary key,
	number int
);

create table people (
	id serial primary key,
	name varchar(255),
	phonenumber_id int references phonenumber(id) unique
);