create table status_delivery (
    id serial primary key,
    Description varchar(255),
    Quantity bigint,
    Delivered boolean
);
insert into status_delivery(Description, Quantity, Delivered)
values ('Valves', '5', true);
update status_delivery set quantity = '4';
delete from status_delivery;