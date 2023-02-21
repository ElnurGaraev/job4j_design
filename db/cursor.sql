BEGIN TRANSACTION;
DECLARE curs_products cursor for select * from products;
MOVE FORWARD 20 FROM curs_products;
FETCH BACKWARD 5 FROM curs_products;
FETCH BACKWARD 8 FROM curs_products;
FETCH BACKWARD 5 FROM curs_products;
FETCH BACKWARD 1 FROM curs_products;
CLOSE curs_products;
COMMIT;