CREATE OR REPLACE PROCEDURE insert_data(i_name VARCHAR, prod VARCHAR, i_count INTEGER, i_price INTEGER)
LANGUAGE 'plpgsql'
AS $$
    BEGIN
    INSERT INTO products (name, producer, count, price)
    VALUES (i_name, prod, i_count, i_price);
    END
$$;

CALL insert_data('product_2', 'producer_2', 15, 32);

CREATE OR REPLACE PROCEDURE update_data(u_count INTEGER, tax FLOAT, u_id INTEGER)
LANGUAGE 'plpgsql'
AS $$
    BEGIN
        IF u_count > 0 THEN
            UPDATE products SET count = count - u_count WHERE id = u_id;
        END if;
        if tax > 0 THEN
            UPDATE products SET price = price + price * tax;
        END if;
    END;
$$;

CREATE OR REPLACE PROCEDURE delete_data(d_price FLOAT, d_id INTEGER)
LANGUAGE 'plpgsql'
AS $$
    BEGIN
        IF d_price < 2 THEN
            DELETE products WHERE id = d_id;
        END if;
    END;
$$;

delete from products;
ALTER SEQUENCE products_id_seq RESTART WITH 1;

CREATE OR REPLACE FUNCTION f_insert_data(i_name VARCHAR, prod VARCHAR, i_count INTEGER, i_price INTEGER)
RETURNS VOID
LANGUAGE 'plpgsql'
AS $$
	BEGIN
		INSERT INTO products(name, producer, count, price)
		VALUES (i_name, prod, i_count, i_price);
	END;
$$;

select f_insert_data('product-1',  'producer-1', 5, 10);

CREATE OR REPLACE FUNCTION f_update_data(u_count INTEGER, tax FLOAT, u_id INTEGER)
RETURNS INTEGER
LANGUAGE 'plpgsql'
AS $$
	DECLARE
		 result INTEGER;
	BEGIN
		IF u_count > 0 THEN
			UPDATE products SET count = count - u_count WHERE id = u_id;
			SELECT INTO result count FROM products WHERE id = u_id;
		END IF;
		IF tax > 0 THEN
			UPDATE products SET price = price + price * tax;
			SELECT INTO result sum(price) FROM products;
		END IF;
		RETURN result;
	END;
$$;

CREATE OR REPLACE FUNCTION f_delete_data(d_count INTEGER, d_id INTEGER)
RETURNS INTEGER
LANGUAGE 'plpgsql'
AS $$
		DECLARE
			result INTEGER;
			BEGIN
				IF d_count = 0 THEN
				DELETE FROM products WHERE id = d_id;
				SELECT INTO result price FROM products WHERE id = d_id;
				END IF;
				RETURN RESULT;
			END;
$$;
