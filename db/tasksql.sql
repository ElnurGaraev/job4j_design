CREATE TABLE company(
	id integer NOT NULL,
	name CHARACTER VARYING,
	CONSTRAINT company_pkey PRIMARY KEY(id)
);

CREATE TABLE person(
	id INTEGER  NOT NULL,
	name CHARACTER VARYING,
	company_id INTEGER REFERENCES company(id),
	CONSTRAINT person_pkey PRIMARY KEY (id)
);

INSERT INTO company(id, name) VALUES(1, 'Company-A'),
(2, 'Company-B'), (3, 'Company-C'), (4, 'Company-D'),
(5, 'Company-E');

INSERT INTO person(id, name, company_id) VALUES(1, 'Kirill', 1),
(2, 'Maria', 2), (3, 'Kate', 3), (4, 'Ivan', 4),
(5, 'Valentin', 5), (6, 'Natali', 2), (7, 'Alex', 3);

--point 1
SELECT p.name, c.id FROM person p
JOIN company c ON p.company_id = c.id and c.id != 5;

--point 2
SELECT p.name, c.name FROM person p
JOIN company c ON p.company_id = c.id;

SELECT c.name, COUNT(p.name) FROM company c
JOIN person p ON p.company_id = c.id
GROUP BY c.name
HAVING COUNT(p.name) =
(SELECT MAX(m.num) FROM (SELECT c.name, COUNT(p.name) as num FROM company c
JOIN person p ON p.company_id = c.id
GROUP BY c.name) AS m);