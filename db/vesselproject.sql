create table project(
	id serial primary key,
	number int
);

create table status(
	id serial primary key,
	name text,
	readiness bool,
	project_id int references project(id) unique
);

insert into project(number) values (210);
insert into project(number) values (100256);
insert into project(number) values (22500);

insert into status(name, readiness, project_id) 
values ('Tugboat', true, 1);
insert into status(name, readiness, project_id) 
values ('Craneboat', true, 2);
insert into status(name, readiness, project_id) 
values ('Icebreaker', false, 3);

select * from project join status on status.project_id = project.id;
select p.number, s.name, s.readiness
from project as p join status as s on s.project_id = p.id;
select p.number as Номер, s.name as Имя, s.readiness as Готовность
from project as p join status as s on s.project_id = p.id;
select p.number as "Номер проекта", s.name Имя, s.readiness Готовность
from project p join status s on s.project_id = p.id;

