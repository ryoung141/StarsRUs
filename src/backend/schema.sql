SET foreign_key_checks = 0;
DROP TABLE IF EXISTS customer_profile;
DROP TABLE IF EXISTS account;
DROP TABLE IF EXISTS market_account;
DROP TABLE IF EXISTS stock_account;
DROP TABLE IF EXISTS transactions;
DROP TABLE IF EXISTS buy;
DROP TABLE IF EXISTS sell;
DROP TABLE IF EXISTS withdrawal;
DROP TABLE IF EXISTS deposit;
DROP TABLE IF EXISTS accrue_interest;
DROP TABLE IF EXISTS stock;
DROP TABLE IF EXISTS actor;
DROP TABLE IF EXISTS movie_contract;
SET foreign_key_checks = 1;

CREATE TABLE customer_profile(
	tax_id int(100) UNIQUE, 
	username varchar(255) PRIMARY KEY, 
	password varchar(255),
	firstname varchar(255),
	lastname varchar(255),
	state char(2),
	phonenumber varchar(100),
	email varchar(255)
	);

CREATE TABLE account(
	a_id int(100) AUTO_INCREMENT,
	owner varchar(255) NOT NULL,
	PRIMARY KEY(a_id, owner),
	FOREIGN KEY(owner)
		REFERENCES customer_profile(username)
		ON UPDATE CASCADE ON DELETE CASCADE
	);

CREATE TABLE market_account(
	a_id int(100) NOT NULL PRIMARY KEY,
	balance float(100, 3) NOT NULL,
	FOREIGN KEY (a_id)
		REFERENCES account(a_id)
		ON UPDATE CASCADE ON DELETE CASCADE
	);

CREATE TABLE stock_account(
	a_id int(100) NOT NULL PRIMARY KEY AUTO_INCREMENT,
	master_id int(100) NOT NULL,
	s_id int(100) NOT NULL,
	balance FLOAT(100, 3),
	FOREIGN KEY (master_id)
		REFERENCES account(a_id)
		ON UPDATE CASCADE ON DELETE CASCADE
	);

CREATE TABLE transactions(
	t_id int(100) AUTO_INCREMENT PRIMARY KEY,
	a_id int(100) NOT NULL,
	date bigint(255) NOT NULL,
	FOREIGN KEY (a_id)
		REFERENCES account(a_id)
		ON DELETE CASCADE
	);

CREATE TABLE deposit(
	t_id int(100) NOT NULL PRIMARY KEY,
	amount float(13, 3) NOT NULL,
	FOREIGN KEY(t_id)
		REFERENCES transactions(t_id)
		ON UPDATE CASCADE ON DELETE CASCADE
	);

CREATE TABLE withdrawal(
	t_id int(100) NOT NULL PRIMARY KEY,
	amount float(13,3) NOT NULL,
	FOREIGN KEY (t_id)
		REFERENCES transactions(t_id)
		ON UPDATE CASCADE ON DELETE CASCADE
	);

CREATE TABLE buy(
	t_id int(100) NOT NULL PRIMARY KEY,
  	s_id int(100) NOT NULL,
  	amount float(13, 3) NOT NULL,
  	price float(13, 3) NOT NULL,
  	FOREIGN KEY (t_id)
    	REFERENCES transactions(t_id)
    	ON UPDATE CASCADE ON DELETE CASCADE
	);

CREATE TABLE sell (
	t_id int(100) NOT NULL PRIMARY KEY,
  	s_id int(100) NOT NULL,
  	amount float(13, 3) NOT NULL,
  	price float(13, 3) NOT NULL,
  	FOREIGN KEY (t_id)
    	REFERENCES transactions(t_id)
    	ON UPDATE CASCADE ON DELETE CASCADE
	);

CREATE TABLE accrue_interest (
  	t_id int(100) NOT NULL PRIMARY KEY,
  	rate float(7, 3) NOT NULL,
  	avg_daily_balance float(100, 3) NOT NULL,
  	FOREIGN KEY (t_id)
    	REFERENCES transactions(t_id)
    	ON UPDATE CASCADE ON DELETE CASCADE
  	);
  
CREATE TABLE stock (
	s_id int(100) AUTO_INCREMENT PRIMARY KEY,
	a_id int(100) NOT NULL,
	symbol char(3) NOT NULL,
	closing_price float(13,3),
	current_price float(13,3),
	active enum('0', '1')
  );
  
CREATE TABLE actor (
	a_id int(100) AUTO_INCREMENT PRIMARY KEY,
	firstname varchar(100),
	lastname varchar(100),
	s_id int(100),
	date_of_birth bigint(255),
	FOREIGN KEY (s_id)
	    REFERENCES stock(s_id)
	    ON UPDATE CASCADE
  );
  
CREATE TABLE movie_contract (
	m_id int(100) NOT NULL, 
	a_id int(100) NOT NULL,
	role enum('actor', 'director', 'both'),
	year_released int(100),
	total_value int(100) NOT NULL,
	PRIMARY KEY(m_id, a_id),
  	FOREIGN KEY (a_id)
    	REFERENCES actor(a_id)
  );

ALTER TABLE stock
	ADD FOREIGN KEY (a_id) REFERENCES actor(a_id) ON UPDATE CASCADE;

ALTER TABLE buy
	ADD FOREIGN KEY (s_id) REFERENCES stock(s_id) ON DELETE CASCADE;

ALTER TABLE sell
	ADD FOREIGN KEY (s_id) REFERENCES stock(s_id) ON DELETE CASCADE;

ALTER TABLE stock_account
	ADD FOREIGN KEY (s_id) REFERENCES stock(s_id) ON UPDATE CASCADE;


INSERT INTO customer_profile(tax_id, username, password, firstname, lastname, state, phonenumber, email)
	VALUES (1000, "admin", "secret", "John", "Admin", "CA", "805-637-4632", "admin@stock.com"),
		   (1022, "alfred", "hi", "Alfred", "Hitchcock", "CA", "805-257-4499", "alfred@hotmail.com"),
		   (3045, "billy", "cl", "Billy", "Clinton", "CA", "805-562-9999", "billy@yahoo.com"),
		   (2034, "cindy", "la", "Cindy", "Laugher", "CA", "805-693-0011", "cindy@hotmail.com"),
		   (4093, "david", "co", "David", "Copperfield", "CA", "805-824-0011", "david@yahoo.com"),
		   (1234, "sailor", "sa", "Elizabeth", "Sailor", "CA", "805-123-4567", "sailor@hotmail.com"),
		   (8956, "brush", "br", "George", "Brush", "CA", "805-135-7999", "george@hotmail.com"),
		   (2341, "ivan", "st", "Ivan", "Stock", "NJ", "805-322-3243", "ivan@yahoo.com"),
		   (0456, "joe", "pe", "Joe", "Pepsi", "CA", "805-566-8213", "pepsi@pepsi.com"),
		   (3455, "magic", "jo", "Magic", "Jordon", "NJ", "805-453-5539", "jordon@jordon.org"),
		   (1123, "olive", "st", "Olive", "Stoner", "CA", "805-257-4499", "olive@yahoo.com"),
		   (3306, "frank", "ol", "Frank", "Olson", "CA", "805-345-6789", "frank@gmail.com");

INSERT INTO account(owner)
	VALUES ("admin"),
		   ("alfred"),
		   ("billy"),
		   ("cindy"),
		   ("david"),
		   ("sailor"),
		   ("brush"),
		   ("ivan"),
		   ("joe"),
		   ("magic"),
		   ("olive"),
		   ("frank");

INSERT INTO actor(firstname, lastname, s_id, date_of_birth)
	VALUES ("Kim", "Basinger", NULL, -349228800),
		   ("Michael", "Dougles", NULL, -797385600),
		   ("Tom", "Cruise", NULL, -236649600);

INSERT INTO movie_contract(m_id, a_id, role, year_released, total_value)
	VALUES (3, 1, "actor", 1997, 5000000),
		   (4, 2, "actor", 1998, 10000000),
		   (5, 3, "actor", 1996, 5000000);

INSERT INTO stock(a_id, symbol, closing_price, current_price, active)
	VALUES (1, "SKB", 40.00, 40.00, '1'),
		   (2, "SMD", 71.00, 71.00, '1'),
		   (3, "STC", 32.50, 32.50, '1');

INSERT INTO market_account(a_id, balance)
	VALUES (1, 1000),
		   (2, 10000),
		   (3, 100000),
		   (4, 50000),
		   (5, 45000),
		   (6, 200000),
		   (7, 5000),
		   (8, 2000),
		   (9, 10000),
		   (10, 130200),
		   (11, 35000),
		   (12, 30500);

INSERT INTO stock_account(master_id, s_id, balance)
	VALUES (2, 1, 100),
		   (3, 2, 500),
		   (3, 3, 100),
		   (4, 3, 250),
		   (5, 1, 100),
		   (5, 2, 500),
		   (5, 3, 50),
		   (6, 2, 1000),
		   (7, 1, 100),
		   (8, 2, 300),
		   (9, 1, 500),
		   (9, 3, 100),
		   (9, 2, 200),
		   (10, 1, 1000),
		   (11, 1, 100),
		   (11, 2, 100),
		   (11, 3, 100),
		   (12, 1, 100),
		   (12, 3, 200),
		   (12, 2, 100);

UPDATE actor SET s_id = 1 WHERE a_id = 1;
UPDATE actor SET s_id = 2 WHERE a_id = 2;
UPDATE actor SET s_id = 3 WHERE a_id = 3;