CREATE DATABASE restaurant;
SET GLOBAL time_zone="+2:0";

CREATE TABLE dishes (
	id INT NOT NULL AUTO_INCREMENT,
    title VARCHAR(100) NOT NULL,
    price DOUBLE NOT NULL,
    weigth DOUBLE,
    is_discount BOOLEAN DEFAULT FALSE,
    PRIMARY KEY(id)
);

INSERT INTO dishes(title, weigth, price, is_discount) VALUES
("Salad", 0.4, 150.0, false),
("Meat1", 0.2, 200.0, false),
("Meat2", 0.2, 150.0, true),
("Meat3", 0.25, 200.0, true),
("Fish category 1", 0.25, 300.0, false),
("Fish category 2", 0.3, 300.0, false),
("Fish category 3", 0.3, 100.0, true),
("Soup1", 0.45, 100.0, false),
("Soup2", 0.4, 100.0, false),
("Soup3", 0.45, 90.0, true),
("Tea", 0.2, 20.0, false);

SELECT
	id
FROM dishes
WHERE SUM(weigth) < 1
