create table role(
id serial primary key,
name text
);

create table users(
id serial primary key,
name text,
role_id int references role(id)
);

create table rules(
id serial primary key,
name text
);

create table role_rules(
id serial primary key,
role_id int references role(id),
rules_id int references rules(id)
);

create table category(
id serial primary key,
name text,
);

create table state(
id serial primary key,
name text,
);

create table item(
id serial primary key,
name text,
users_id int reference users(id)
category_id int reference category(id)
state_id int reference state(id)
);

create table comments(
id serial primary key,
description text,
item_id int reference item(id)
);

create table attachs(
id serial primary key,
name text,
item_id int reference item(id)
);





