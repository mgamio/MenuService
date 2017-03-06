DROP TABLE IF EXISTS food;
CREATE TABLE food (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(20) NOT NULL,
    PRIMARY KEY (id)
);
DROP TABLE IF EXISTS ingredient;
CREATE TABLE ingredient (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(20) NOT NULL,
    PRIMARY KEY (id)
);
DROP TABLE IF EXISTS food_ingredient;
CREATE TABLE food_ingredient (
    food_id INT NOT NULL,
    ingredient_id INT NOT NULL,
    PRIMARY KEY (food_id, ingredient_id)
);
