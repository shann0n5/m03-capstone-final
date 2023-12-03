BEGIN TRANSACTION;

DROP TABLE IF EXISTS users, properties, applications, service_requests, bills;

CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

CREATE TABLE properties (
    property_id serial PRIMARY KEY,
    address varchar(75) NOT NULL UNIQUE,
    owner_id int REFERENCES users(user_id),
	number_of_rooms int NOT NULL,
	rent Decimal NOT NULL,
	is_available boolean NOT NULL
);

CREATE TABLE applications (
	application_id serial PRIMARY KEY,
	applicant_id int REFERENCES users(user_id),
	property_id int REFERENCES properties(property_id),
	status varchar(25) NOT NULL
);

CREATE TABLE service_requests (
	service_request_id serial PRIMARY KEY,
	tenant_id int REFERENCES users(user_id),
	property_id int REFERENCES properties(property_id),
	request_details varchar(500) NOT NULL,
	status varchar(25) NOT NULL
);

CREATE TABLE bills (
	bill_id serial PRIMARY KEY,
	tenant_id int REFERENCES users(user_id),
	property_id int REFERENCES properties(property_id),
	amount Decimal(10,2) NOT NULL,
	is_paid boolean NOT NULL
);


COMMIT TRANSACTION;
