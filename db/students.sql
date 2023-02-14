create table students (
	id serial primary key,
	name varchar(255)
);

create table task (
	id serial primary key,
	name varchar(255)
);

create table students_task(
	student_id int references student(id),
	tasks_id int references tasks(id)
);