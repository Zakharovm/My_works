
// �������� ��

CREATE DATABASE restaurant
  WITH ENCODING='UTF8'
       OWNER="user"
       CONNECTION LIMIT=-1;

--------------------------------------------------	   
CREATE TABLE EMPLOYEE (
	ID		INT PRIMARY KEY NOT NULL,
	SURNAME			TEXT NOT NULL,
	NAME			TEXT NOT NULL,
	DATE_OF_BIRTH	TEXT,
	PHONE_NUMBER	TEXT,
	POSITION		TEXT NOT NULL,
	SALARY			REAL );

INSERT INTO EMPLOYEE VALUES (1, 'Petrov', 'Dima', '02-24-1994', '063-111-22-33', 'Waiter', 4000.0);	
INSERT INTO EMPLOYEE VALUES (2, 'Popov', 'Dima', '12-01-1990', '063-222-22-33', 'Waiter', 4000.0);
INSERT INTO EMPLOYEE VALUES (3, 'Harchenko', 'Lena', '24-02-1985', '063-123-32-33', 'Cook', 6000.0);
INSERT INTO EMPLOYEE VALUES (4, 'Ivanov', 'Aleksandr', '24-10-1980', '063-151-22-44', 'Cook', 8000.0);
INSERT INTO EMPLOYEE VALUES (5, 'Sidorov', 'Vlad', '15-12-1991', '063-111-22-33', 'Waiter', 4000.0);
INSERT INTO EMPLOYEE VALUES (6, 'Drozd', 'Elena', '21-05-1970', '063-333-33-33', 'Cook', 3000.0);
INSERT INTO EMPLOYEE VALUES (7, 'Zakharov', 'Maksym', '24-02-1994', '063-111-56-89', 'Administrator', 15000.0);
INSERT INTO EMPLOYEE VALUES (8, 'Petrova', 'Aleksandra', '02-02-1990', '063-555-33-33', 'Waiter', 4000.0);
INSERT INTO EMPLOYEE VALUES (9, 'Kovalenko', 'Andrew', '02-02-1985', '063-555-33-33', 'Waiter', 7000.0);

--------------------------------------------------	
CREATE TABLE DISH (
	ID			INT PRIMARY KEY NOT NULL,
	NAME		TEXT NOT NULL,
	CATEGORY    TEXT NOT NULL,
	PRICE		REAL NOT NULL,
	WEIGHT		REAL NOT NULL );
	
INSERT INTO DISH VALUES (1, 'Caesar Salad', 'Salad', 50.0, 250.0);	
INSERT INTO DISH VALUES (2, 'Greece Salad', 'Salad', 40.0, 250.0);
INSERT INTO DISH VALUES (3, 'Vegetable Salad', 'Salad', 45.0, 300.0);
INSERT INTO DISH VALUES (4, 'Fries', 'Garnish', 30.0, 250.0);
INSERT INTO DISH VALUES (5, 'Pasta', 'Garnish', 35.0, 250.0);
INSERT INTO DISH VALUES (6, 'Medallions', 'Garnish', 60.0, 300.0);
INSERT INTO DISH VALUES (7, 'Chicken', 'Garnish', 50.0, 300.0);
INSERT INTO DISH VALUES (8, 'Pork', 'Garnish', 40.0, 250.0);
INSERT INTO DISH VALUES (9, 'Chocolate ice cream', 'Dessert', 30.0, 250.0);
INSERT INTO DISH VALUES (10, 'Tiramisu', 'Dessert', 50.0, 200.0);
INSERT INTO DISH VALUES (11, 'Cake', 'Dessert', 45.0, 250.0);

--------------------------------------------------

CREATE TABLE MENU (
	ID	INT PRIMARY KEY NOT NULL,
	NAME	TEXT NOT NULL );
	
INSERT INTO MENU VALUES (1, 'Food');	
INSERT INTO MENU VALUES (2, 'Drink');
INSERT INTO MENU VALUES (3, 'Alcohol');

--------------------------------------------------

CREATE TABLE ORDERS (
	ID				INT PRIMARY KEY NOT NULL,
	EMPLOYEE_ID		INT NOT NULL,
	TABLE_NUMBER	INT NOT NULL,
	DATE_OF_ORDER	date NOT NULL, 
	CURRENT_STATUS 	TEXT NOT NULL);
	
INSERT INTO ORDERS VALUES (1, 2, 1, '2011-05-16 15:36:38', 'Open');	
INSERT INTO ORDERS VALUES (2, 5, 5, '2011-05-16 15:38:38', 'Open');
INSERT INTO ORDERS VALUES (3, 8, 4, '2011-05-16 15:39:48', 'Closed');	
INSERT INTO ORDERS VALUES (4, 8, 2, '2011-05-16 15:59:48','Open');	


ALTER TABLE ORDERS ADD CONSTRAINT EMPLOYEE_ID_FK FOREIGN KEY (EMPLOYEE_ID) REFERENCES EMPLOYEE(ID);

--------------------------------------------------	
	
CREATE TABLE PREPARED_DISHES (
	ID				INT PRIMARY KEY NOT NULL,
	EMPLOYEE_ID		INT NOT NULL,
	DISH_ID			INT NOT NULL,
	ORDER_ID		INT NOT NULL,
	DATE_OF_PREP	date NOT NULL );

INSERT INTO PREPARED_DISHES VALUES (1, 3, 1, 1, '2011-05-16 15:46:38');	
INSERT INTO PREPARED_DISHES VALUES (2, 4, 5, 2, '2011-05-16 15:47:38');
INSERT INTO PREPARED_DISHES VALUES (3, 3, 4, 1, '2011-05-16 15:49:48');
INSERT INTO PREPARED_DISHES VALUES (4, 3, 3, 2, '2011-05-16 15:51:38');	
INSERT INTO PREPARED_DISHES VALUES (5, 4, 10, 3, '2011-05-16 15:53:38');
INSERT INTO PREPARED_DISHES VALUES (6, 3, 7, 3, '2011-05-16 15:55:48');

ALTER TABLE PREPARED_DISHES ADD CONSTRAINT EMPLOYEE_ID_FK FOREIGN KEY (EMPLOYEE_ID) REFERENCES EMPLOYEE(ID);
ALTER TABLE PREPARED_DISHES ADD CONSTRAINT DISH_ID_FK FOREIGN KEY (DISH_ID) REFERENCES DISH(ID);
ALTER TABLE PREPARED_DISHES ADD CONSTRAINT ORDER_ID_FK FOREIGN KEY (ORDER_ID) REFERENCES ORDERS(ID);
--------------------------------------------------

	
CREATE TABLE INGREDIENT (
	ID	INT PRIMARY KEY NOT NULL,
	NAME	TEXT NOT NULL);
	
INSERT INTO INGREDIENT VALUES (1, 'Tomato');
INSERT INTO INGREDIENT VALUES (2, 'Cabbage');
INSERT INTO INGREDIENT VALUES (3, 'Cucumber');
INSERT INTO INGREDIENT VALUES (4, 'Chicken leg');
INSERT INTO INGREDIENT VALUES (5, 'Minced pork');
INSERT INTO INGREDIENT VALUES (6, 'Neck of pork');
INSERT INTO INGREDIENT VALUES (7, 'Cake');
INSERT INTO INGREDIENT VALUES (8, 'Milk');
INSERT INTO INGREDIENT VALUES (9, 'Chocolate');
INSERT INTO INGREDIENT VALUES (10, 'Potato');
INSERT INTO INGREDIENT VALUES (11, 'Pasta "Italy"');
INSERT INTO INGREDIENT VALUES (12, 'Chicken egg');
INSERT INTO INGREDIENT VALUES (13, 'Sugar');
INSERT INTO INGREDIENT VALUES (14, 'Espresso');
	
--------------------------------------------------

CREATE TABLE STOCK (
	ID		INT PRIMARY KEY NOT NULL,
	INGREDIENT_ID	INT NOT NULL,
	QUANTITY	INT NOT NULL );	

INSERT INTO STOCK VALUES (1, 1, 5);
INSERT INTO STOCK VALUES (2, 2, 10);
INSERT INTO STOCK VALUES (3, 3, 10);
INSERT INTO STOCK VALUES (4, 4, 15);
INSERT INTO STOCK VALUES (5, 5, 5);
INSERT INTO STOCK VALUES (6, 6, 7);
INSERT INTO STOCK VALUES (7, 7, 6);
INSERT INTO STOCK VALUES (8, 8, 15);
INSERT INTO STOCK VALUES (9, 9, 5);

ALTER TABLE STOCK ADD CONSTRAINT INGREDIENT_ID_FK FOREIGN KEY (INGREDIENT_ID) REFERENCES INGREDIENT(ID);

--------------------------------------------------	
	
CREATE TABLE DISH_TO_ORDER (
    DISH_ID integer,
    ORDER_ID integer,
    PRIMARY KEY (DISH_ID, ORDER_ID)
);	

INSERT INTO DISH_TO_ORDER VALUES (1, 2);
INSERT INTO DISH_TO_ORDER VALUES (3, 2);
INSERT INTO DISH_TO_ORDER VALUES (4, 4);
	
ALTER TABLE DISH_TO_ORDER ADD CONSTRAINT DISH_ID_FK FOREIGN KEY (DISH_ID) REFERENCES DISH(ID);
ALTER TABLE DISH_TO_ORDER ADD CONSTRAINT ORDER_ID_FK FOREIGN KEY (ORDER_ID) REFERENCES ORDERS(ID);
	
--------------------------------------------------	

CREATE TABLE DISH_TO_MENU (
    DISH_ID integer,
    MENU_ID integer,
    PRIMARY KEY (DISH_ID, MENU_ID)
);	
	
INSERT INTO DISH_TO_MENU VALUES (1, 1);
INSERT INTO DISH_TO_MENU VALUES (5, 1);
INSERT INTO DISH_TO_MENU VALUES (6, 1);

ALTER TABLE DISH_TO_MENU ADD CONSTRAINT DISH_ID_FK FOREIGN KEY (DISH_ID) REFERENCES DISH(ID);
ALTER TABLE DISH_TO_MENU ADD CONSTRAINT MENU_ID_FK FOREIGN KEY (MENU_ID) REFERENCES MENU(ID);	
--------------------------------------------------	

CREATE TABLE DISH_TO_INGREDIENT (
    DISH_ID integer,
    INGREDIENT_ID integer,
    PRIMARY KEY (DISH_ID, INGREDIENT_ID)
);	
	
INSERT INTO DISH_TO_INGREDIENT VALUES (1, 1);
INSERT INTO DISH_TO_INGREDIENT VALUES (2, 1);
INSERT INTO DISH_TO_INGREDIENT VALUES (3, 1);
INSERT INTO DISH_TO_INGREDIENT VALUES (1, 2);
INSERT INTO DISH_TO_INGREDIENT VALUES (2, 2);
INSERT INTO DISH_TO_INGREDIENT VALUES (3, 2);
INSERT INTO DISH_TO_INGREDIENT VALUES (1, 3);
INSERT INTO DISH_TO_INGREDIENT VALUES (2, 3);
INSERT INTO DISH_TO_INGREDIENT VALUES (3, 3);
	
ALTER TABLE DISH_TO_INGREDIENT ADD CONSTRAINT DISH_ID_FK FOREIGN KEY (DISH_ID) REFERENCES DISH(ID);
ALTER TABLE DISH_TO_INGREDIENT ADD CONSTRAINT INGREDIENT_ID_FK FOREIGN KEY (INGREDIENT_ID) REFERENCES INGREDIENT(ID);