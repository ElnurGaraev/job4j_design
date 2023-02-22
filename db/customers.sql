CREATE TABLE customers(
	ID SERIAL PRIMARY KEY,
	first_name TEXT,
	last_name TEXT,
	age INT,
	country TEXT
);

INSERT INTO customers(first_name, last_name, age, country)
VALUES ('Ivan', 'Ivanov', 18, 'Russia'), ('Kirill', 'Petrov', 21, 'Russia'),
('Maria', 'Sidorova', 20, 'Russia');

CREATE TABLE orders(
	ID SERIAL PRIMARY KEY,
	amount INT,
	customer_id INT REFERENCES customers(id)
);

INSERT INTO orders(amount, customer_id) VALUES(5, 1), (10, 3);

SELECT * FROM customers WHERE customers.id NOT IN(SELECT customer_id FROM orders);
