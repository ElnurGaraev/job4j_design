CREATE TABLE manufacturers(
	ID SERIAL PRIMARY KEY,
	name TEXT
);
INSERT INTO manufacturers(name) VALUES ('Konar'), ('PTPA'), ('Gusarskiy AZ');

CREATE TABLE materials(
	ID SERIAL PRIMARY KEY,
	description TEXT,
	manufacturer_id INT REFERENCES manufacturers(id)
);
INSERT INTO materials(description, manufacturer_id) 
VALUES ('Glob valve', 1), ('Ball valve', 2), ('Check valve', 3);

CREATE TABLE clients(
	ID SERIAL PRIMARY KEY,
	name VARCHAR(255)
);
INSERT INTO clients(name) VALUES ('Gazprom'), ('Lukoil'), ('ASPO');

CREATE TABLE status_delivery(
	ID SERIAL PRIMARY KEY,
	delivered BOOL,
	client_id INT REFERENCES clients(id),
	material_id INT REFERENCES materials(id)
);
INSERT INTO status_delivery(delivered, client_id, material_id)
VALUES (true, 1, 1), (true, 1, 2), (true, 1, 3),
(true, 2, 1), (true, 2, 2), (false, 2, 3),
(false, 3, 1), (false, 3, 2), (false, 3, 3);

CREATE VIEW show_cliens_and_manufacturers_and_materials_that_delivered
AS SELECT c.name AS Client, mt.description, mf.name AS Manufacturer, sd.delivered
FROM status_delivery sd
JOIN clients c ON sd.client_id = c.id
JOIN materials mt ON sd.material_id = mt.id
JOIN manufacturers mf ON mt.manufacturer_id = mf.id
WHERE delivered = true;

select * from show_cliens_and_manufacturers_and_materials_that_delivered;