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
  username VARCHAR(50) NOT NULL,
  password INTEGER NOT NULL,
  first_name VARCHAR(100) NOT NULL,
  last_name VARCHAR(100) NOT NULL,
  email VARCHAR(100) NOT NULL,
  role_id INT NOT NULL,
	FOREIGN KEY(role_id) REFERENCES User_Roles(role_id)
);

INSERT INTO Users (username, password, first_name, last_name, email, role_id) VALUES('jberrymore', 368540387, 'Jerry', 'Berrymore', 'jerry.berrymore@ers.com', 1);
-- password - berrytime
INSERT INTO Users (username, password, first_name, last_name, email, role_id) VALUES('mbolton', 197113697, 'Michael', 'Bolton', 'michael.bolton@ers.com', 1);
-- password - notthatmichaelbolton
INSERT INTO Users (username, password, first_name, last_name, email, role_id) VALUES('amahoney', 1216985755, 'Alton', 'Mahoney', 'alton.mahoney@ers.com', 1);
-- password - password
INSERT INTO Users (username, password, first_name, last_name, email, role_id) VALUES('chill', 1659762602, 'Carmen', 'Hill', 'carmen.hill@ers.com', 0);
-- password - chillout
INSERT INTO Users (username, password, first_name, last_name, email, role_id) VALUES('tcrewes', 1438651681, 'Thomas', 'Crewes', 'thomas.crewes@ers.com', 2);
-- password - missionimpossible
INSERT INTO Users (username, password, first_name, last_name, email, role_id) VALUES('achocula', -1022649593, 'Aaron', 'Chocula', 'aaron.chocula@ers.com', 3);
-- password - countmeout

CREATE TABLE Reimbursements (
	reimbursement_id SERIAL PRIMARY KEY,
	amount DECIMAL CHECK (amount > 0),
	submitted TIMESTAMP DEFAULT current_date,
	resolved TIMESTAMP,
	description VARCHAR(250),
	receipt BYTEA,
	author INTEGER NOT NULL,
	resolver INTEGER,
	status_id INTEGER DEFAULT 0,
	type_id INTEGER NOT NULL,
	FOREIGN KEY(author) REFERENCES Users(users_id),
	FOREIGN KEY(resolver) REFERENCES Users(users_id),
	FOREIGN KEY(status_id) REFERENCES Status(status_id),
	FOREIGN KEY(type_id) REFERENCES Reimbursement_Type(type_id)
);

INSERT INTO Reimbursements (amount, description, submitted, author, status_id, type_id) VALUES (300, 'Relocation', '2019-12-12 00:00:00', 2, 1, 1);
INSERT INTO Reimbursements (amount, description, submitted, author, status_id, type_id) VALUES (300, 'Relocation', '2019-11-27 00:00:00', 3, 1, 1);
INSERT INTO Reimbursements (amount, description, submitted, author, status_id, type_id) VALUES (300, 'Relocation', '2019-01-02 00:00:00', 1, 1, 1);
INSERT INTO Reimbursements (amount, description, submitted, author, status_id, type_id) VALUES (300, 'Relocation', '2019-12-25 00:00:00', 4, 1, 1);
INSERT INTO Reimbursements (amount, description, resolved, author, status_id, type_id) VALUES (12500000, 'Ferrari', '2019-01-13 00:00:00', 3, 1, 3);
INSERT INTO Reimbursements (amount, description, author, type_id) VALUES (1000, 'The Tampa Inn', 2, 0);
INSERT INTO Reimbursements (amount, description, author, type_id) VALUES (1000, 'The Austin Inn', 3, 0);
INSERT INTO Reimbursements (amount, description, author, type_id) VALUES (1000, 'The Houstin Inn', 1, 0);
INSERT INTO Reimbursements (amount, description, author, type_id) VALUES (1000, 'The Tampa Inn', 4, 0);
INSERT INTO Reimbursements (amount, description, author, type_id) VALUES (15.24, 'Hotel lunch', 2, 2);
INSERT INTO Reimbursements (amount, description, author, type_id) VALUES (11.65, 'Hotel lunch', 3, 2);
INSERT INTO Reimbursements (amount, description, author, type_id) VALUES (13.02, 'Hotel lunch', 1, 2);
INSERT INTO Reimbursements (amount, description, author, type_id) VALUES (23.85, 'Hotel lunch', 4, 2);
INSERT INTO Reimbursements (amount, description, author, type_id) VALUES (27.31, 'Hotel dinner', 3, 2);
INSERT INTO Reimbursements (amount, description, author, type_id) VALUES (29.43, 'Fill up gas tank', 3, 1);
