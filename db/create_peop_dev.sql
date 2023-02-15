create table devices(
	id serial primary key,
	name varchar(255),
	price float
);

create table people(
	id serial primary key,
	name varchar(255)
);

create table devices_people(
	id serial primary key,
	device_id int references devices(id),
	people_id int references people(id)
);

insert into devices(name, price) values ('phone', 20000), ('laptop', 70000), ('playstation', 100000);
insert into people(name) values ('Ivan'), ('Kirill'), ('Roman');
insert into devices_people(people_id, device_id) values (1, 1), (1, 2), (1, 3);
insert into devices_people(people_id, device_id) values (2, 1), (2, 2);
insert into devices_people(people_id, device_id) values (3, 3);

select avg(price) from devices;

select avg(d.price), p.name
from devices_people dp join devices d on dp.device_id = d.id
join people p on dp.people_id = p.id
group by p.name;

select avg(d.price), p.name
from devices_people dp join devices d on dp.device_id = d.id
join people p on dp.people_id = p.id
group by p.name having avg(d.price) > 5000;