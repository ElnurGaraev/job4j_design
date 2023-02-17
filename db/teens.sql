create table teens(
	id serial primary key,
	name text,
	gender text
);

insert into teens(name, gender) values ('Ivan', 'Male'), ('Maria', 'Female'),
('Kirill', 'Male');

select n1.name, n2.name from teens n1 cross join teens n2 where n1.gender != n2.gender;
