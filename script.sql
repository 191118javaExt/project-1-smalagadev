CREATE TABLE Status(
  status_id SERIAL PRIMARY KEY,
  status VARCHAR(25)
);

INSERT INTO Status(status_id, status) VALUES(0, 'Pending');
INSERT INTO Status(status_id, status) VALUES(1, 'Approved');
INSERT INTO Status(status_id, status) VALUES(2, 'Denied');

CREATE TABLE Reimbursement_Type(
  type_id SERIAL PRIMARY KEY,
  type VARCHAR(25)
);

INSERT INTO Reimbursement_Type(type_id, type) VALUES(0, 'Lodging');
INSERT INTO Reimbursement_Type(type_id, type) VALUES(1, 'Travel');
INSERT INTO Reimbursement_Type(type_id, type) VALUES(2, 'Food');
INSERT INTO Reimbursement_Type(type_id, type) VALUES(3, 'Other');

CREATE TABLE User_Roles(
  role_id SERIAL PRIMARY KEY,
  role VARCHAR(25)
);

INSERT INTO User_Roles(role_id, role) VALUES(0, 'Finance Manager');
INSERT INTO User_Roles(role_id, role) VALUES(1, 'Employee');
INSERT INTO User_Roles(role_id, role) VALUES(2, 'Recruiter');
INSERT INTO User_Roles(role_id, role) VALUES(3, 'Accountant');

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

INSERT INTO USERS (username, password, first_name, last_name, email, role_id) VALUES('jberrymore', 368540387, 'Jerry', 'Berrymore', 'jerry.berrymore@ers.com', 1);
-- password - berrytime
INSERT INTO USERS (username, password, first_name, last_name, email, role_id) VALUES('mbolton', 197113697, 'Michael', 'Bolton', 'michael.bolton@ers.com', 1);
-- password - notthatmichaelbolton
INSERT INTO USERS (username, password, first_name, last_name, email, role_id) VALUES('amahoney', 1216985755, 'Alton', 'Mahoney', 'alton.mahoney@ers.com', 1);
-- password - password
INSERT INTO USERS (username, password, first_name, last_name, email, role_id) VALUES('chill', 1659762602, 'Carmen', 'Hill', 'carmen.hill@ers.com', 0);
-- password - chillout
INSERT INTO USERS (username, password, first_name, last_name, email, role_id) VALUES('tcrewes', 1438651681, 'Thomas', 'Crewes', 'thomas.crewes@ers.com', 2);
-- password - missionimpossible
INSERT INTO USERS (username, password, first_name, last_name, email, role_id) VALUES('achocula', -1022649593, 'Aaron', 'Chocula', 'aaron.chocula@ers.com', 3);
-- password - countmeout

CREATE TABLE Reimbursement (
	reimbursement_id SERIAL PRIMARY KEY,
	amount DECIMAL,
	submitted TIMESTAMP DEFAULT GETDATE(),
	resolved TIMESTAMP,
	description VARCHAR(250),
	receipt BYTEA,
	author INTEGER,
	resolver INTEGER,
	status_id INTEGER DEFAULT 0,
	type_id INTEGER,
	FOREIGN KEY(author) REFERENCES Users(users_id),
	FOREIGN KEY(resolver) REFERENCES Users(users_id),
	FOREIGN KEY(status_id) REFERENCES Status(status_id),
	FOREIGN KEY(type_id) REFERENCES Reimbursement_Type(type_id)
);
