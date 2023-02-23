CREATE TABLE movie(
	ID SERIAL PRIMARY KEY,
	name TEXT,
	director TEXT
);

CREATE TABLE book(
	ID SERIAL PRIMARY KEY,
	title TEXT,
	author TEXT
);

INSERT INTO movie (name, director)
VALUES ('Марсианин', 'Ридли Скотт'),
       ('Матрица', 'Братья Вачовски'),
       ('Властелин колец', 'Питер Джексон'),
       ('Гарри Поттер и узник Азкабана', 'Альфонсо Куарон'),
       ('Железный человек', 'Джон Фавро');

INSERT INTO book (title, author)
VALUES ('Гарри Поттер и узник Азкабана', 'Джоан Роулинг'),
       ('Властелин колец', 'Джон Толкин'),
       ('1984', 'Джордж Оруэлл'),
       ('Марсианин', 'Энди Уир'),
       ('Божественная комедия', 'Данте Алигьери');

SELECT name FROM movie
INTERSECT
SELECT title FROM book;

SELECT title FROM book
EXCEPT
SELECT name FROM movie;

(SELECT name FROM movie
EXCEPT
SELECT title FROM book)
UNION
(SELECT title FROM book
 EXCEPT
 SELECT name FROM movie);