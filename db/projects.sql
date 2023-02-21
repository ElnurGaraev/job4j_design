CREATE TABLE projects(
	ID SERIAL PRIMARY KEY,
	name TEXT,
	cost INT
);

INSERT INTO projects(name, cost) VALUES('project-1', 100), 
('project-2', 200), ('project-3', 150);