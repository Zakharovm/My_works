--
-- PostgreSQL database dump
--

-- Dumped from database version 9.5.3
-- Dumped by pg_dump version 9.5.3

-- Started on 2016-09-21 01:05:31

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 1 (class 3079 OID 12355)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2182 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 185 (class 1259 OID 24814)
-- Name: cooked_dishes; Type: TABLE; Schema: public; Owner: user
--

CREATE TABLE cooked_dishes (
    id integer NOT NULL,
    employee_id integer NOT NULL,
    dish_id integer NOT NULL,
    order_id integer NOT NULL,
    date_of_prep date NOT NULL
);


ALTER TABLE cooked_dishes OWNER TO "user";

--
-- TOC entry 182 (class 1259 OID 24790)
-- Name: dish; Type: TABLE; Schema: public; Owner: user
--

CREATE TABLE dish (
    id integer NOT NULL,
    name text NOT NULL,
    category text NOT NULL,
    price real NOT NULL,
    weight real NOT NULL
);


ALTER TABLE dish OWNER TO "user";

--
-- TOC entry 189 (class 1259 OID 32995)
-- Name: dish_composition; Type: TABLE; Schema: public; Owner: user
--

CREATE TABLE dish_composition (
    dish_id integer NOT NULL,
    ingredient_id integer NOT NULL,
    amount real
);


ALTER TABLE dish_composition OWNER TO "user";

--
-- TOC entry 181 (class 1259 OID 24782)
-- Name: employee; Type: TABLE; Schema: public; Owner: user
--

CREATE TABLE employee (
    id integer NOT NULL,
    surname text NOT NULL,
    name text NOT NULL,
    phone_number text,
    "position" text NOT NULL,
    salary real,
    dtype character varying,
    date_of_birth text
);


ALTER TABLE employee OWNER TO "user";

--
-- TOC entry 186 (class 1259 OID 24819)
-- Name: ingredient; Type: TABLE; Schema: public; Owner: user
--

CREATE TABLE ingredient (
    id integer NOT NULL,
    name text NOT NULL
);


ALTER TABLE ingredient OWNER TO "user";

--
-- TOC entry 183 (class 1259 OID 24798)
-- Name: menu; Type: TABLE; Schema: public; Owner: user
--

CREATE TABLE menu (
    id integer NOT NULL,
    name text NOT NULL
);


ALTER TABLE menu OWNER TO "user";

--
-- TOC entry 188 (class 1259 OID 32980)
-- Name: menu_to_dish; Type: TABLE; Schema: public; Owner: user
--

CREATE TABLE menu_to_dish (
    menu_id integer NOT NULL,
    dish_id integer NOT NULL
);


ALTER TABLE menu_to_dish OWNER TO "user";

--
-- TOC entry 190 (class 1259 OID 41172)
-- Name: order_to_dish; Type: TABLE; Schema: public; Owner: user
--

CREATE TABLE order_to_dish (
    order_id integer NOT NULL,
    dish_id integer NOT NULL
);


ALTER TABLE order_to_dish OWNER TO "user";

--
-- TOC entry 184 (class 1259 OID 24806)
-- Name: orders; Type: TABLE; Schema: public; Owner: user
--

CREATE TABLE orders (
    id integer NOT NULL,
    employee_id integer NOT NULL,
    table_number integer NOT NULL,
    date_of_order timestamp with time zone NOT NULL,
    current_status text NOT NULL
);


ALTER TABLE orders OWNER TO "user";

--
-- TOC entry 187 (class 1259 OID 24827)
-- Name: stock; Type: TABLE; Schema: public; Owner: user
--

CREATE TABLE stock (
    id integer NOT NULL,
    ingredient_id integer NOT NULL,
    quantity real NOT NULL
);


ALTER TABLE stock OWNER TO "user";

--
-- TOC entry 2169 (class 0 OID 24814)
-- Dependencies: 185
-- Data for Name: cooked_dishes; Type: TABLE DATA; Schema: public; Owner: user
--

INSERT INTO cooked_dishes VALUES (1, 1, 1, 1, '2011-05-16');


--
-- TOC entry 2166 (class 0 OID 24790)
-- Dependencies: 182
-- Data for Name: dish; Type: TABLE DATA; Schema: public; Owner: user
--

INSERT INTO dish VALUES (1, 'Caesar Salad', 'Salad', 50, 250);
INSERT INTO dish VALUES (3, 'Vegetable Salad', 'Salad', 45, 300);
INSERT INTO dish VALUES (9, 'Chocolate ice cream', 'Dessert', 30, 250);
INSERT INTO dish VALUES (10, 'Tiramisu', 'Dessert', 50, 200);
INSERT INTO dish VALUES (11, 'Cake', 'Dessert', 45, 250);
INSERT INTO dish VALUES (12, 'Napoleon', 'Dessert', 50, 300);
INSERT INTO dish VALUES (4, 'Fries', 'Side_Dish', 30, 250);
INSERT INTO dish VALUES (5, 'Pasta', 'Side_Dish', 35, 250);
INSERT INTO dish VALUES (6, 'Medallions', 'Side_Dish', 60, 300);
INSERT INTO dish VALUES (7, 'Fried chicken', 'Side_Dish', 50, 300);
INSERT INTO dish VALUES (8, 'Skewers of pork', 'Side_Dish', 40, 250);
INSERT INTO dish VALUES (2, 'Greek Salad', 'Salad', 40, 250);
INSERT INTO dish VALUES (13, 'Plov', 'Side_Dish', 30, 250);


--
-- TOC entry 2173 (class 0 OID 32995)
-- Dependencies: 189
-- Data for Name: dish_composition; Type: TABLE DATA; Schema: public; Owner: user
--

INSERT INTO dish_composition VALUES (3, 3, 75);
INSERT INTO dish_composition VALUES (3, 4, 75);
INSERT INTO dish_composition VALUES (4, 10, 250);
INSERT INTO dish_composition VALUES (5, 11, 250);
INSERT INTO dish_composition VALUES (6, 6, 300);
INSERT INTO dish_composition VALUES (7, 4, 300);
INSERT INTO dish_composition VALUES (8, 5, 250);
INSERT INTO dish_composition VALUES (9, 8, 150);
INSERT INTO dish_composition VALUES (9, 9, 100);
INSERT INTO dish_composition VALUES (10, 9, 50);
INSERT INTO dish_composition VALUES (10, 8, 50);
INSERT INTO dish_composition VALUES (10, 13, 15);
INSERT INTO dish_composition VALUES (10, 12, 4);
INSERT INTO dish_composition VALUES (11, 7, 250);
INSERT INTO dish_composition VALUES (12, 7, 250);
INSERT INTO dish_composition VALUES (12, 8, 50);
INSERT INTO dish_composition VALUES (1, 1, 75);
INSERT INTO dish_composition VALUES (1, 2, 100);
INSERT INTO dish_composition VALUES (1, 3, 75);
INSERT INTO dish_composition VALUES (2, 1, 75);
INSERT INTO dish_composition VALUES (2, 2, 100);
INSERT INTO dish_composition VALUES (2, 3, 75);
INSERT INTO dish_composition VALUES (3, 1, 50);
INSERT INTO dish_composition VALUES (3, 2, 100);
INSERT INTO dish_composition VALUES (13, 15, 200);
INSERT INTO dish_composition VALUES (13, 14, 50);


--
-- TOC entry 2165 (class 0 OID 24782)
-- Dependencies: 181
-- Data for Name: employee; Type: TABLE DATA; Schema: public; Owner: user
--

INSERT INTO employee VALUES (7, 'Vlasova', 'Katya', '067-543-34-12', 'Waiter', 10000, 'Waiter', '23-12-1994');
INSERT INTO employee VALUES (5, 'Ivanov', 'Anton', '067-222-11-33', 'Waiter', 5000, 'Waiter', '01-01-1994');
INSERT INTO employee VALUES (6, 'Sidorov', 'Alex', '050-222-54-23', 'Waiter', 6000, 'Waiter', '25-04-1992');
INSERT INTO employee VALUES (4, 'Rubtsov', 'Andrew', '063-111-56-90', 'Waiter', 5000, 'Waiter', '12-10-1985');
INSERT INTO employee VALUES (3, 'Zakharov', 'Maksym', '063-111-56-89', 'Administrator', 15000, 'Employee', '1987-09-10');
INSERT INTO employee VALUES (1, 'Peskova', 'Lena', '053-123-42-53', 'Cook', 4000, 'Cook', '10-10-1990');
INSERT INTO employee VALUES (2, 'Popova', 'Vlada', '053-123-42-53', 'Waiter', 4000, 'Waiter', '15-11-1985');


--
-- TOC entry 2170 (class 0 OID 24819)
-- Dependencies: 186
-- Data for Name: ingredient; Type: TABLE DATA; Schema: public; Owner: user
--

INSERT INTO ingredient VALUES (1, 'Tomato');
INSERT INTO ingredient VALUES (2, 'Cabbage');
INSERT INTO ingredient VALUES (4, 'Chicken leg');
INSERT INTO ingredient VALUES (5, 'Minced pork');
INSERT INTO ingredient VALUES (6, 'Neck of pork');
INSERT INTO ingredient VALUES (7, 'Cake');
INSERT INTO ingredient VALUES (8, 'Milk');
INSERT INTO ingredient VALUES (9, 'Chocolate');
INSERT INTO ingredient VALUES (10, 'Potato');
INSERT INTO ingredient VALUES (11, 'Pasta "Italy"');
INSERT INTO ingredient VALUES (12, 'Chicken egg');
INSERT INTO ingredient VALUES (13, 'Sugar');
INSERT INTO ingredient VALUES (14, 'Espresso');
INSERT INTO ingredient VALUES (3, 'Cucumber');
INSERT INTO ingredient VALUES (15, 'Rice');
INSERT INTO ingredient VALUES (16, 'Mulado');
INSERT INTO ingredient VALUES (17, 'Mortira');
INSERT INTO ingredient VALUES (18, 'Tomat');
INSERT INTO ingredient VALUES (19, 'Kolbasa');


--
-- TOC entry 2167 (class 0 OID 24798)
-- Dependencies: 183
-- Data for Name: menu; Type: TABLE DATA; Schema: public; Owner: user
--

INSERT INTO menu VALUES (2, 'Lunch');
INSERT INTO menu VALUES (3, 'Dinner');
INSERT INTO menu VALUES (1, 'Morning');


--
-- TOC entry 2172 (class 0 OID 32980)
-- Dependencies: 188
-- Data for Name: menu_to_dish; Type: TABLE DATA; Schema: public; Owner: user
--

INSERT INTO menu_to_dish VALUES (3, 1);
INSERT INTO menu_to_dish VALUES (3, 5);
INSERT INTO menu_to_dish VALUES (3, 6);
INSERT INTO menu_to_dish VALUES (3, 11);
INSERT INTO menu_to_dish VALUES (3, 12);
INSERT INTO menu_to_dish VALUES (3, 13);
INSERT INTO menu_to_dish VALUES (1, 1);
INSERT INTO menu_to_dish VALUES (1, 2);
INSERT INTO menu_to_dish VALUES (1, 3);
INSERT INTO menu_to_dish VALUES (1, 4);
INSERT INTO menu_to_dish VALUES (1, 5);
INSERT INTO menu_to_dish VALUES (1, 6);
INSERT INTO menu_to_dish VALUES (1, 7);
INSERT INTO menu_to_dish VALUES (1, 8);
INSERT INTO menu_to_dish VALUES (1, 9);
INSERT INTO menu_to_dish VALUES (1, 10);
INSERT INTO menu_to_dish VALUES (1, 11);
INSERT INTO menu_to_dish VALUES (1, 12);
INSERT INTO menu_to_dish VALUES (1, 13);
INSERT INTO menu_to_dish VALUES (2, 2);
INSERT INTO menu_to_dish VALUES (2, 3);
INSERT INTO menu_to_dish VALUES (2, 4);
INSERT INTO menu_to_dish VALUES (2, 7);
INSERT INTO menu_to_dish VALUES (2, 8);
INSERT INTO menu_to_dish VALUES (2, 9);


--
-- TOC entry 2174 (class 0 OID 41172)
-- Dependencies: 190
-- Data for Name: order_to_dish; Type: TABLE DATA; Schema: public; Owner: user
--

INSERT INTO order_to_dish VALUES (2, 12);
INSERT INTO order_to_dish VALUES (2, 4);
INSERT INTO order_to_dish VALUES (2, 5);
INSERT INTO order_to_dish VALUES (3, 12);
INSERT INTO order_to_dish VALUES (3, 4);
INSERT INTO order_to_dish VALUES (3, 5);


--
-- TOC entry 2168 (class 0 OID 24806)
-- Dependencies: 184
-- Data for Name: orders; Type: TABLE DATA; Schema: public; Owner: user
--

INSERT INTO orders VALUES (11, 2, 8, '2016-07-28 13:07:00+03', 'Open');
INSERT INTO orders VALUES (1, 7, 1, '2016-05-16 12:00:00+03', 'Closed');
INSERT INTO orders VALUES (8, 5, 1, '2016-07-28 13:06:00+03', 'Open');
INSERT INTO orders VALUES (9, 6, 1, '2016-07-28 13:07:00+03', 'Open');
INSERT INTO orders VALUES (10, 6, 8, '2016-07-28 13:07:00+03', 'Open');
INSERT INTO orders VALUES (5, 4, 6, '2016-07-28 13:03:00+03', 'Open');
INSERT INTO orders VALUES (4, 4, 5, '2016-07-28 13:02:00+03', 'Open');
INSERT INTO orders VALUES (2, 6, 2, '2016-07-28 13:00:00+03', 'Open');
INSERT INTO orders VALUES (7, 7, 2, '2016-07-28 13:05:00+03', 'Open');
INSERT INTO orders VALUES (3, 2, 3, '2016-07-28 13:01:00+03', 'Closed');
INSERT INTO orders VALUES (6, 2, 3, '2016-07-28 13:04:00+03', 'Open');


--
-- TOC entry 2171 (class 0 OID 24827)
-- Dependencies: 187
-- Data for Name: stock; Type: TABLE DATA; Schema: public; Owner: user
--

INSERT INTO stock VALUES (7, 7, 200);
INSERT INTO stock VALUES (1, 1, 50000);
INSERT INTO stock VALUES (3, 3, 50000);
INSERT INTO stock VALUES (4, 4, 30000);
INSERT INTO stock VALUES (5, 5, 30000);
INSERT INTO stock VALUES (6, 6, 30000);
INSERT INTO stock VALUES (9, 9, 10000);
INSERT INTO stock VALUES (11, 11, 30000);
INSERT INTO stock VALUES (13, 13, 50000);
INSERT INTO stock VALUES (14, 14, 10000);
INSERT INTO stock VALUES (8, 8, 19850);
INSERT INTO stock VALUES (2, 2, 50);
INSERT INTO stock VALUES (12, 12, 400);
INSERT INTO stock VALUES (15, 15, 20000);
INSERT INTO stock VALUES (16, 17, 20000);
INSERT INTO stock VALUES (17, 16, 5000);


--
-- TOC entry 2023 (class 2606 OID 24797)
-- Name: dish_pkey; Type: CONSTRAINT; Schema: public; Owner: user
--

ALTER TABLE ONLY dish
    ADD CONSTRAINT dish_pkey PRIMARY KEY (id);


--
-- TOC entry 2037 (class 2606 OID 32999)
-- Name: dish_to_ingredient_pkey; Type: CONSTRAINT; Schema: public; Owner: user
--

ALTER TABLE ONLY dish_composition
    ADD CONSTRAINT dish_to_ingredient_pkey PRIMARY KEY (dish_id, ingredient_id);


--
-- TOC entry 2021 (class 2606 OID 24789)
-- Name: employee_pkey; Type: CONSTRAINT; Schema: public; Owner: user
--

ALTER TABLE ONLY employee
    ADD CONSTRAINT employee_pkey PRIMARY KEY (id);


--
-- TOC entry 2031 (class 2606 OID 24826)
-- Name: ingredient_pkey; Type: CONSTRAINT; Schema: public; Owner: user
--

ALTER TABLE ONLY ingredient
    ADD CONSTRAINT ingredient_pkey PRIMARY KEY (id);


--
-- TOC entry 2025 (class 2606 OID 24805)
-- Name: menu_pkey; Type: CONSTRAINT; Schema: public; Owner: user
--

ALTER TABLE ONLY menu
    ADD CONSTRAINT menu_pkey PRIMARY KEY (id);


--
-- TOC entry 2035 (class 2606 OID 32984)
-- Name: menu_to_dish_pkey; Type: CONSTRAINT; Schema: public; Owner: user
--

ALTER TABLE ONLY menu_to_dish
    ADD CONSTRAINT menu_to_dish_pkey PRIMARY KEY (menu_id, dish_id);


--
-- TOC entry 2039 (class 2606 OID 41176)
-- Name: order_to_dish_pkey; Type: CONSTRAINT; Schema: public; Owner: user
--

ALTER TABLE ONLY order_to_dish
    ADD CONSTRAINT order_to_dish_pkey PRIMARY KEY (order_id, dish_id);


--
-- TOC entry 2027 (class 2606 OID 24813)
-- Name: orders_pkey; Type: CONSTRAINT; Schema: public; Owner: user
--

ALTER TABLE ONLY orders
    ADD CONSTRAINT orders_pkey PRIMARY KEY (id);


--
-- TOC entry 2029 (class 2606 OID 24818)
-- Name: prepared_dishes_pkey; Type: CONSTRAINT; Schema: public; Owner: user
--

ALTER TABLE ONLY cooked_dishes
    ADD CONSTRAINT prepared_dishes_pkey PRIMARY KEY (id);


--
-- TOC entry 2033 (class 2606 OID 24831)
-- Name: stock_pkey; Type: CONSTRAINT; Schema: public; Owner: user
--

ALTER TABLE ONLY stock
    ADD CONSTRAINT stock_pkey PRIMARY KEY (id);


--
-- TOC entry 2042 (class 2606 OID 24872)
-- Name: dish_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: user
--

ALTER TABLE ONLY cooked_dishes
    ADD CONSTRAINT dish_id_fk FOREIGN KEY (dish_id) REFERENCES dish(id);


--
-- TOC entry 2045 (class 2606 OID 32985)
-- Name: dish_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: user
--

ALTER TABLE ONLY menu_to_dish
    ADD CONSTRAINT dish_id_fk FOREIGN KEY (dish_id) REFERENCES dish(id);


--
-- TOC entry 2047 (class 2606 OID 33000)
-- Name: dish_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: user
--

ALTER TABLE ONLY dish_composition
    ADD CONSTRAINT dish_id_fk FOREIGN KEY (dish_id) REFERENCES dish(id);


--
-- TOC entry 2049 (class 2606 OID 41177)
-- Name: dish_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: user
--

ALTER TABLE ONLY order_to_dish
    ADD CONSTRAINT dish_id_fk FOREIGN KEY (dish_id) REFERENCES dish(id);


--
-- TOC entry 2040 (class 2606 OID 24862)
-- Name: employee_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: user
--

ALTER TABLE ONLY orders
    ADD CONSTRAINT employee_id_fk FOREIGN KEY (employee_id) REFERENCES employee(id);


--
-- TOC entry 2041 (class 2606 OID 24867)
-- Name: employee_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: user
--

ALTER TABLE ONLY cooked_dishes
    ADD CONSTRAINT employee_id_fk FOREIGN KEY (employee_id) REFERENCES employee(id);


--
-- TOC entry 2044 (class 2606 OID 24882)
-- Name: ingredient_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: user
--

ALTER TABLE ONLY stock
    ADD CONSTRAINT ingredient_id_fk FOREIGN KEY (ingredient_id) REFERENCES ingredient(id);


--
-- TOC entry 2048 (class 2606 OID 33005)
-- Name: ingredient_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: user
--

ALTER TABLE ONLY dish_composition
    ADD CONSTRAINT ingredient_id_fk FOREIGN KEY (ingredient_id) REFERENCES ingredient(id);


--
-- TOC entry 2046 (class 2606 OID 32990)
-- Name: menu_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: user
--

ALTER TABLE ONLY menu_to_dish
    ADD CONSTRAINT menu_id_fk FOREIGN KEY (menu_id) REFERENCES menu(id);


--
-- TOC entry 2043 (class 2606 OID 24877)
-- Name: order_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: user
--

ALTER TABLE ONLY cooked_dishes
    ADD CONSTRAINT order_id_fk FOREIGN KEY (order_id) REFERENCES orders(id);


--
-- TOC entry 2050 (class 2606 OID 41182)
-- Name: order_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: user
--

ALTER TABLE ONLY order_to_dish
    ADD CONSTRAINT order_id_fk FOREIGN KEY (order_id) REFERENCES orders(id);


--
-- TOC entry 2181 (class 0 OID 0)
-- Dependencies: 6
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2016-09-21 01:05:36

--
-- PostgreSQL database dump complete
--

