CREATE TABLE products(
	ID SERIAL PRIMARY KEY,
	name VARCHAR(50),
	PRODUCER varchar(50),
	count INTEGER DEFAULT 0,
	price INTEGER
);

--point 2.1
CREATE OR REPLACE FUNCTION tax()
RETURNS TRIGGER AS
$$
BEGIN
	UPDATE products
	SET price = price + price * 0.2;
	RETURN NEW;
END;
$$
LANGUAGE 'plpgsql';

CREATE TRIGGER tax_trigger
AFTER INSERT ON products
REFERENCING NEW TABLE AS inserted
FOR EACH STATEMENT
EXECUTE PROCEDURE tax();

----point 2.2
CREATE OR REPLACE FUNCTION tax_before_insert()
	RETURNS TRIGGER AS
$$
	BEGIN
	 NEW.price = NEW.price + NEW.price*0.2;
		RETURN NEW;
	END;
$$
LANGUAGE 'plpgsql'

CREATE TRIGGER tax_trigger_b
BEFORE INSERT
ON products
FOR EACH ROW
EXECUTE PROCEDURE tax_before_insert();

