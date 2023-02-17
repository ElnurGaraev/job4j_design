create table car_bodies(
	id serial primary key,
	name text
);

create table car_engines(
	id serial primary key,
	name text
);

create table car_transmissions(
	id serial primary key,
	name text
);

create table cars(
	id serial primary key,
	name varchar(128),
	body_id int references car_bodies(id),
	engine_id int references car_engines(id),
	transmission_id int references car_transmissions(id)
);

insert into car_bodies(name) values ('седан'), ('хэтчбек'), ('пикап'), ('купе'), ('универсал');
insert into car_engines(name) values ('бензиновый'), ('дизельный'), ('электрический');
insert into car_transmissions(name) values ('механическая'), ('автоматическая'), ('полуавтоматическая');
insert into cars(name, body_id, engine_id, transmission_id) values ('mazda', 1, 1, 2),
('corolla', 1, 2, 1), ('focus', 2, 1, 2), ('opel', 4, null, 2), ('optima', 1, 1, null);

--point 2.1
select c.name, cb.name, ce.name, ct.name from cars c left join car_bodies cb on c.body_id = cb.id
left join car_engines ce on c.engine_id = ce.id
left join car_transmissions ct on c.transmission_id = ct.id;

--point 2.2
select cb.name from cars c right join car_bodies cb on c.body_id = cb.id
where c.name is null;

--point 2.3
select ce.name from cars c right join car_engines ce on c.engine_id = ce.id
where c.name is null;

--point 2.4
select ct.name from cars c right join car_transmissions ct on c.transmission_id = ct.id
where c.name is null;
