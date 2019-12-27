CREATE TABLE Status(
  status_id SERIAL PRIMARY KEY,
  status VARCHAR(10)
);

CREATE TABLE Reimbursement_Type(
  type_id SERIAL PRIMARY KEY,
  type VARCHAR(10)
);

CREATE TABLE User_Roles(
  role_id SERIAL PRIMARY KEY,
  role VARCHAR(10)
);

CREATE TABLE Users(
	users_id SERIAL PRIMARY KEY,
  username VARCHAR(50),
  password INTEGER,
  first_name VARCHAR(100),
  last_name VARCHAR(100),
  email VARCHAR(100),
  role_id INT,
	FOREIGN KEY(role_id) REFERENCES User_Roles(role_id)
);

CREATE TABLE Reimbursement (
	reimbursement_id SERIAL PRIMARY KEY,
	amount DECIMAL,
	submitted TIMESTAMP,
	resolved TIMESTAMP,
	description VARCHAR(250),
	receipt BYTEA,
	author INTEGER,
	resolver INTEGER,
	status_id INTEGER,
	type_id INTEGER,
	FOREIGN KEY(author) REFERENCES Users(users_id),
	FOREIGN KEY(resolver) REFERENCES Users(users_id),
	FOREIGN KEY(status_id) REFERENCES Status(status_id),
	FOREIGN KEY(type_id) REFERENCES Reimbursement_Type(type_id)
);
