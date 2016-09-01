
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
	SALARY			REAL,
	DTYPE			character varying);

INSERT INTO EMPLOYEE VALUES (1, 'Peskova', 'Lena', '25-01-1965', '053-123-42-53', 'Cook', 4000.0, 'Waiter');	
INSERT INTO EMPLOYEE VALUES (2, 'Popova', 'Vlada', '25-01-1965', '053-123-42-53', 'Waiter', 4000.0, 'Waiter');
INSERT INTO EMPLOYEE VALUES (3, 'Zakharov', 'Maksym', '24-02-1994', '063-111-56-89', 'Administrator', 15000.0, 'Administrator');


--------------------------------------------------	
CREATE TABLE DISH (
	ID			INT PRIMARY KEY NOT NULL,
	NAME		TEXT NOT NULL,
	CATEGORY    TEXT NOT NULL,
	PRICE		REAL NOT NULL,
	WEIGHT		REAL NOT NULL );
	
INSERT INTO DISH VALUES (1, 'Caesar Salad', 'Salad', 50.0, 250.0);	
INSERT INTO DISH VALUES (2, 'Greek Salad', 'Salad', 40.0, 250.0);
INSERT INTO DISH VALUES (3, 'Vegetable Salad', 'Salad', 45.0, 300.0);
INSERT INTO DISH VALUES (4, 'Fries', 'Side_Dish', 30.0, 250.0);
INSERT INTO DISH VALUES (5, 'Pasta', 'Side_Dish', 35.0, 250.0);
INSERT INTO DISH VALUES (6, 'Medallions', 'Side_Dish', 60.0, 300.0);
INSERT INTO DISH VALUES (7, 'Fried chicken', 'Side_Dish', 50.0, 300.0);
INSERT INTO DISH VALUES (8, 'Skewers of pork', 'Side_Dish', 40.0, 250.0);
INSERT INTO DISH VALUES (9, 'Chocolate ice cream', 'Dessert', 30.0, 250.0);
INSERT INTO DISH VALUES (10, 'Tiramisu', 'Dessert', 50.0, 200.0);
INSERT INTO DISH VALUES (11, 'Cake', 'Dessert', 45.0, 250.0);

--------------------------------------------------

CREATE TABLE MENU (
	ID	INT PRIMARY KEY NOT NULL,
	NAME	TEXT NOT NULL );
	
INSERT INTO MENU VALUES (1, 'Spring_morning');	
INSERT INTO MENU VALUES (2, 'Summer_morning');
INSERT INTO MENU VALUES (3, 'Spring_dinner');

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
	
CREATE TABLE COOKED_DISHES (
	ID				INT PRIMARY KEY NOT NULL,
	EMPLOYEE_ID		INT NOT NULL,
	DISH_ID			INT NOT NULL,
	ORDER_ID		INT NOT NULL,
	DATE_OF_PREP	date NOT NULL );

INSERT INTO COOKED_DISHES VALUES (1, 1, 1, 1, '2011-05-16 15:46:38');	
INSERT INTO COOKED_DISHES VALUES (2, 4, 5, 2, '2011-05-16 15:47:38');
INSERT INTO COOKED_DISHES VALUES (3, 3, 4, 1, '2011-05-16 15:49:48');
INSERT INTO COOKED_DISHES VALUES (4, 3, 3, 2, '2011-05-16 15:51:38');	
INSERT INTO COOKED_DISHES VALUES (5, 4, 10, 3, '2011-05-16 15:53:38');
INSERT INTO COOKED_DISHES VALUES (6, 3, 7, 3, '2011-05-16 15:55:48');

ALTER TABLE COOKED_DISHES ADD CONSTRAINT EMPLOYEE_ID_FK FOREIGN KEY (EMPLOYEE_ID) REFERENCES EMPLOYEE(ID);
ALTER TABLE COOKED_DISHES ADD CONSTRAINT DISH_ID_FK FOREIGN KEY (DISH_ID) REFERENCES DISH(ID);
ALTER TABLE COOKED_DISHES ADD CONSTRAINT ORDER_ID_FK FOREIGN KEY (ORDER_ID) REFERENCES ORDERS(ID);
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
INSERT INTO INGREDIENT VALUES (15, 'Rice');
	
--------------------------------------------------

CREATE TABLE STOCK (
	ID		INT PRIMARY KEY NOT NULL,
	INGREDIENT_ID	INT NOT NULL,
	QUANTITY	real NOT NULL );	

INSERT INTO STOCK VALUES (1, 1, 50000.0);
INSERT INTO STOCK VALUES (2, 2, 40000.0);
INSERT INTO STOCK VALUES (3, 3, 50000.0);
INSERT INTO STOCK VALUES (4, 4, 30000.0);
INSERT INTO STOCK VALUES (5, 5, 30000.0);
INSERT INTO STOCK VALUES (6, 6, 30000.0);
INSERT INTO STOCK VALUES (7, 7, 15000.0);
INSERT INTO STOCK VALUES (8, 8, 20000.0);
INSERT INTO STOCK VALUES (9, 9, 10000.0);
INSERT INTO STOCK VALUES (10, 10, 100000.0);
INSERT INTO STOCK VALUES (11, 11, 30000.0);
INSERT INTO STOCK VALUES (12, 12, 500.0);
INSERT INTO STOCK VALUES (13, 13, 50000.0);
INSERT INTO STOCK VALUES (14, 14, 10000.0);
INSERT INTO STOCK VALUES (15, 15, 25000.0);


ALTER TABLE STOCK ADD CONSTRAINT INGREDIENT_ID_FK FOREIGN KEY (INGREDIENT_ID) REFERENCES INGREDIENT(ID);

--------------------------------------------------	
	
CREATE TABLE ORDER_TO_DISH (
    ORDER_ID integer,
	DISH_ID integer,
    PRIMARY KEY (ORDER_ID, DISH_ID)
);	

INSERT INTO ORDER_TO_DISH VALUES (2, 1);
INSERT INTO ORDER_TO_DISH VALUES (2, 3);
INSERT INTO ORDER_TO_DISH VALUES (4, 4);
	
ALTER TABLE ORDER_TO_DISH ADD CONSTRAINT DISH_ID_FK FOREIGN KEY (DISH_ID) REFERENCES DISH(ID);
ALTER TABLE ORDER_TO_DISH ADD CONSTRAINT ORDER_ID_FK FOREIGN KEY (ORDER_ID) REFERENCES ORDERS(ID);
	
--------------------------------------------------	

CREATE TABLE MENU_TO_DISH (
    MENU_ID integer,
	DISH_ID integer,
    PRIMARY KEY (MENU_ID, DISH_ID)
);	
	
INSERT INTO MENU_TO_DISH VALUES (1, 1);
INSERT INTO MENU_TO_DISH VALUES (1, 5);
INSERT INTO MENU_TO_DISH VALUES (1, 6);

ALTER TABLE MENU_TO_DISH ADD CONSTRAINT DISH_ID_FK FOREIGN KEY (DISH_ID) REFERENCES DISH(ID);
ALTER TABLE MENU_TO_DISH ADD CONSTRAINT MENU_ID_FK FOREIGN KEY (MENU_ID) REFERENCES MENU(ID);	
--------------------------------------------------	

CREATE TABLE DISH_COMPOSITION(
	DISH_ID integer,
	INGREDIENT_ID integer,
	AMOUNT real,
    PRIMARY KEY (DISH_ID, INGREDIENT_ID)
);	
	
INSERT INTO DISH_COMPOSITION VALUES (1, 1, 75);
INSERT INTO DISH_COMPOSITION VALUES (2, 1, 100);
INSERT INTO DISH_COMPOSITION VALUES (3, 1, 75);
INSERT INTO DISH_COMPOSITION VALUES (1, 2, 75);
INSERT INTO DISH_COMPOSITION VALUES (2, 2, 100);
INSERT INTO DISH_COMPOSITION VALUES (3, 2, 75);
INSERT INTO DISH_COMPOSITION VALUES (1, 3, 50);
INSERT INTO DISH_COMPOSITION VALUES (2, 3, 100);
INSERT INTO DISH_COMPOSITION VALUES (3, 3, 75);
INSERT INTO DISH_COMPOSITION VALUES (3, 4, 75);
INSERT INTO DISH_COMPOSITION VALUES (4, 10, 250);
INSERT INTO DISH_COMPOSITION VALUES (5, 11, 250);
INSERT INTO DISH_COMPOSITION VALUES (6, 6, 300);
INSERT INTO DISH_COMPOSITION VALUES (7, 4, 300);
INSERT INTO DISH_COMPOSITION VALUES (8, 5, 250);
INSERT INTO DISH_COMPOSITION VALUES (9, 8, 150);
INSERT INTO DISH_COMPOSITION VALUES (9, 9, 100);
INSERT INTO DISH_COMPOSITION VALUES (10, 9, 50);
INSERT INTO DISH_COMPOSITION VALUES (10, 8, 50);
INSERT INTO DISH_COMPOSITION VALUES (10, 13, 15);
INSERT INTO DISH_COMPOSITION VALUES (10, 12, 4);
INSERT INTO DISH_COMPOSITION VALUES (11, 7, 250);
INSERT INTO DISH_COMPOSITION VALUES (12, 7, 250);
INSERT INTO DISH_COMPOSITION VALUES (12, 8, 50);
INSERT INTO DISH_COMPOSITION VALUES (13, 15, 200);
	
ALTER TABLE DISH_COMPOSITION ADD CONSTRAINT DISH_ID_FK FOREIGN KEY (DISH_ID) REFERENCES DISH(ID);
ALTER TABLE DISH_COMPOSITION ADD CONSTRAINT INGREDIENT_ID_FK FOREIGN KEY (INGREDIENT_ID) REFERENCES INGREDIENT(ID);