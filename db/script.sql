create table status_delivery (
    id serial primary key,
    description varchar(255),
    quantity bigint,
    delivered boolean
);
insert into status_delivery(description, quantity, delivered)
values ('valves', 5, true);
update status_delivery set quantity = 4;
delete from status_delivery;