create table departments(
	id serial primary key,
	name text
);

create table employees(
	id serial primary key,
	name text,
	department_id int references departments(id)
);

insert into departments(name) values ('Material department'), ('IT department'),
('Procurement'), ('Construction'), ('Marketing');
															 
insert into employees(name, department_id) values ('Kirill', 1), ('Maria', 1), ('Ivan', 2),
('Kate', 3), ('Sergey', 4), ('Marina', null);
#2
select * from employees e  left join departments d
on d.id = e.department_id;
select * from employees e right join departments d
on d.id = e.department_id;
select * from departments d full join employees e
on d.id = e.department_id;
select * from employees cross join departments;
#3
select * from departments d left join employees e
on d.id = e.department_id;
#4
select d.name, e.name, e.department_id from departments d left join  employees e
on d.id = e.department_id;
select d.name, e.name, e.department_id from employees e right join departments d
on d.id = e.department_id;

