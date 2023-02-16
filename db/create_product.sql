create table type(
	id serial primary key,
	name text
);

create table product(
	id serial primary key,
	name text,
	type_id int references type(id),
	expired_date date,
	price int
);

insert into type(name) values ('СЫР'), ('МОЛОКО'), ('МОРОЖЕНОЕ'),
('КОЛБАСА'), ('ШОКОЛАД');

insert into product(name, type_id, expired_date, price)
values ('Сыр плавленный', 1, '2023-04-01', 200), ('Сыр моцарелла', 1, '2023-03-01', 250),
('Сыр голландский', 1, '2023-01-01', 240), ('Сыр плавленный', 1, '2023-04-01', 300),
('Молоко буренка', 2, '2023-03-05', 60), ('Молоко деревенское', 2, '2023-03-03', 62), ('Молоко ставропольское', 2, '2023-02-01', 65),
('Мороженное коровка', 3, '2023-03-10', 45), ('Мороженное максим', 3, '2023-05-10', 75), ('Мороженное золотой стандарт', 3, '2023-04-20', 84), 
('Мороженное пломбир', 3, '2023-05-01', 50), ('Мороженное шоколадное', 3, '2023-01-25', 50),
('Колбаса докторская', 4, '2023-06-01', 250), ('Колбаса зернистая', 4, '2023-05-25', 300), ('Колбаса салями', 4, '2023-06-15', 130),
('Колбаса охотничья', 4, '2023-06-05', 270), ('Колбаса фаворит', 4, '2023-06-07', 265), ('Колбаса графская', 4, '2023-06-03', 225),
('Колбаса праздничная', 4, '2023-07-05', 280), ('Колбаса юбилейная', 4, '2023-07-05', 290), ('Колбаса столичная', 4, '2023-07-03', 235),
('Колбаса классическая', 4, '2023-05-25', 215), ('Колбаса сырная', 4, '2023-06-17', 295), ('Колбаса куриная', 4, '2023-07-05', 210),
('Шоколад молочный', 5, '2023-09-01', 80), ('Шоколад темный', 5, '2023-09-10', 60), ('Шоколад с карамелью', 5, '2023-08-10', 75),
('Шоколад с орехом', 5, '2023-09-20', 60);

select * from product p join type t on p.type_id = t.id
where t.name = 'СЫР';

select * from product p join type t on p.type_id = t.id
where p.name like 'Мороженное%' or p.name like '%мороженное';

select * from product p join type t
on p.type_id = t.id where expired_date<current_date;

select * from product where price = (select max(price) from product);

select t.name, count(p.type_id)
from product p join type t on p.type_id = t.id
group by t.name;

select * from product p join type t on p.type_id = t.id
where t.name = 'СЫР' or t.name = 'МОЛОКО';

select t.name, count(p.type_id)
from product p join type t on p.type_id = t.id
group by t.name having count(p.type_id) < 10;

select p.name as "Наименование продукта", t.name "Тип продукта"
from product p join type t on p.type_id = t.id;


