CREATE TABLE customer_profile(
	tax_id int(100) UNIQUE, 
	username varchar(255) PRIMARY KEY, 
	password varchar(255),
	firstname varchar(255),
	lastname varchar(255),
	state ENUM("AL", "AK", "AR", "AZ", "CA", "CO", "CT", "DC", "DE", "FL", "GA", "HI",
			   "IA", "ID", "IL", "IN", "KS", "KY", "LA", "MA", "MD", "ME", "MI", "MN",
			   "MO", "MS", "MY", "NC", "ND", "NE", "NH", "NJ", "NM", "NV", "NY", "OK",
			   "OH", "OR", "PA", "RI", "SC", "SD", "TN", "TX", "UT", "VA", "VT", "WA",
			   "WI", "WV", "WY")
	phonenumber varchar(100),
	email varchar(255)
	);

CREATE TABLE account(
	a_id int(100) AUTOINCREMENT,
	owner varchar(255) NOT NULL,
	PRIMARY KEY(a_id, owner),
	FOREIGN KEY(owner)
		REFERENCES customer_profile(username)
		ON UPDATE CASCADE ON DELETE CASCADE
	);

CREATE TABLE market_account(
	a_id int(100) NOT NULL PRIMARY KEY,
	balance int(255) NOT NULL,
	FOREIGN KEY (a_id)
		REFERENCES account(a_id)
		ON UPDATE CASCADE ON DELETE CASCADE
	);

CREATE TABLE stock_account(
	a_id int(100) NOT NULL PRIMARY KEY,
	balance FLOAT(13, 3),
	FOREIGN KEY (a_id)
		REFERENCES account(a_id)
		ON UPDATE CASCADE ON DELETE CASCADE
	);

CREATE TABLE transactions(
	t_id int(100) AUTO_INCREMENT PRIMARY KEY,
	a_id int(100) NOT NULL,
	date int(100) NOT NULL,
	FOREIGN KEY (a_id)
		REFERENCES account(a_id)
		ON DELETE CASCADE
	);

CREATE TABLE deposit(
	t_id int(100) NOT NULL PRIMARY KEY,
	amount int(100) NOT NULL,
	FOREIGN KEY(t_id)
		REFERENCES transactions(t_id)
		ON UPDATE CASCADE ON DELETE CASCADE
	);

CREATE TABLE withdrawal(
	t_id int(100) NOT NULL PRIMARY KEY,
	amount int(100) NOT NULL,
	FOREIGN KEY (t_id)
		REFERENCES transactions(t_id)
		ON UPDATE CASCADE ON DELETE CASCADE
	);

CREATE TABLE buy(
	t_id int(100) NOT NULL PRIMARY KEY,
  	s_id int(100) NOT NULL,
  	amount float(13, 3) NOT NULL,
  	FOREIGN KEY (t_id)
    	REFERENCES transactions(t_id)
    	ON UPDATE CASCADE ON DELETE CASCADE,
  	FOREIGN KEY (s_id)
    	REFERENCES stock(s_id)
    	ON DELETE CASCADE
	);

CREATE TABLE sell (
	t_id int(100) NOT NULL PRIMARY KEY,
  	s_id int(100) NOT NULL,
  	amount float(13, 3) NOT NULL,
  	FOREIGN KEY (t_id)
    	REFERENCES transactions(t_id)
    	ON UPDATE CASCADE ON DELETE CASCADE,
  	FOREIGN KEY (s_id)
    	REFERENCES stock(s_id)
    	ON DELETE CASCADE
	);

CREATE TABLE accrue_interest (
  	t_id int(100) NOT NULL PRIMARY KEY,
  	s_id int(100) NOT NULL,
  	rate float(7, 3) NOT NULL,
  	avg_daily_balance float(13, 3) NOT NULL,
  	FOREIGN KEY (t_id)
    	REFERENCES transactions(t_id)
    	ON UPDATE CASCADE ON DELETE CASCADE,
  	FOREIGN KEY (s_id)
    	REFERENCES stock(s_id)
    	ON DELETE CASCADE
  	);
  
CREATE TABLE stock (
	s_id int(100) AUTO_INCREMENT PRIMARY KEY,
	a_id int(100) NOT NULL,
	symbol char(3) NOT NULL,
	closing_price int(100),
	current_price int(100),
	active enum('0', '1'),
	FOREIGN KEY (a_id)
	    REFERENCES actor(a_id)
	    ON DELETE CASCADE
  );
  
CREATE TABLE actor (
	a_id int(100) AUTO_INCREMENT PRIMARY KEY,
	firstname varchar(100),
	lastname varchar(100),
	s_id int(100) NOT NULL,
	date_of_birth int(10),
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
  	FOREIGN KEY a_id
    	REFERENCES actor(a_id),
  );
