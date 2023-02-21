BEGIN TRANSACTION;
SET TRANSACTION ISOLATION LEVEL REPEATABLE READ;
INSERT INTO projects(name, cost)
VALUES ('project-4', 4000);
INSERT INTO projects(name, cost)
VALUES ('project-5', 5000);
SAVEPOINT first_savepoint;
DELETE FROM projects WHERE name = 'project-1';
UPDATE projects SET cost = 10000 WHERE name = 'project-2';
SAVEPOINT second_savepoint;
DELETE from projects;
DROP TABLE projects;
ROLLBACK TO second_savepoint;
SELECT * FROM projects;
COMMIT;
