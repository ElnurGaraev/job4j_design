create table history_of_price(
	ID SERIAL PRIMARY KEY,
	name VARCHAR(50),
	price INTEGER,
	date TIMESTAMP
);

--point 3
CREATE OR REPLACE FUNCTION history()
	RETURNS TRIGGER AS
$$
	BEGIN
		INSERT INTO history_of_price(name, price, date)
		VALUES(NEW.name, NEW.price, now());
		RETURN NEW;
	END;
$$
LANGUAGE 'plpgsql';

CREATE TRIGGER history_pr
	AFTER INSERT
	ON products
	FOR EACH ROW
	EXECUTE PROCEDURE history();