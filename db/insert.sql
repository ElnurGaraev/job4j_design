insert into role(name) values ('supervisor');

insert into users(name, role_id) values ('Ivan', 1);

insert into rules(name) values ('inspection');

insert into role_rules(role_id, rules_id) values (1, 1);

insert into category(name) values ('important');

insert into state(name) values ('open');

insert into item(name, users_id, category_id, state_id) values ('inspect', 1, 1, 1);

insert into comments(description, item_id) values ('piping', 1);

insert into attachs(name, item_id) values ('act', 1);