BEGIN TRANSACTION;

DROP TABLE IF EXISTS users, properties, applications, service_requests, bills;

DROP SEQUENCE IF EXISTS seq_user_id, seq_property_id, seq_application_id, seq_service_request_id, seq_bill_id;

CREATE SEQUENCE seq_user_id
	INCREMENT BY 1
	START WITH 1001
	NO MAXVALUE;

CREATE TABLE users (
	user_id int NOT NULL DEFAULT nextval('seq_user_id'),
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_users PRIMARY KEY (user_id),
	CONSTRAINT UQ_username UNIQUE (username),
	CONSTRAINT CK_role CHECK (role IN ('ROLE_USER', 'ROLE_TENANT', 'ROLE_ADMIN', 'ROLE_PROPERTY_OWNER'))
);

CREATE SEQUENCE seq_property_id
	INCREMENT BY 1
	START WITH 2001
	NO MAXVALUE;

CREATE TABLE properties (
    property_id int NOT NULL DEFAULT nextval('seq_property_id'),
    address varchar(75) NOT NULL UNIQUE,
    owner_id int NOT NULL,
	number_of_rooms int NOT NULL,
	rent Decimal NOT NULL,
	is_available boolean NOT NULL,
	CONSTRAINT PK_properties PRIMARY KEY (property_id),
	CONSTRAINT FK_properties_users FOREIGN KEY (owner_id) REFERENCES users (user_id),
	CONSTRAINT UQ_address UNIQUE (address) 
	
);

CREATE SEQUENCE seq_application_id
	INCREMENT BY 1
	START WITH 3001
	NO MAXVALUE;

CREATE TABLE applications (
	application_id int NOT NULL DEFAULT nextval('seq_application_id'),
	applicant_id int NOT NULL,
	property_id int NOT NULL,
	status varchar(25) NOT NULL,
	CONSTRAINT PK_applications PRIMARY KEY (application_id),
	CONSTRAINT FK_applications_users FOREIGN KEY (applicant_id) REFERENCES users (user_id),
	CONSTRAINT FK_applications_properties FOREIGN KEY (property_id) REFERENCES properties (property_id),
	CONSTRAINT CK_status CHECK (status IN ('STATUS_PENDING', 'STATUS_REJECTED', 'STATUS_WITHDRAWN'))
	
);

CREATE SEQUENCE seq_service_request_id
	INCREMENT BY 1
	START WITH 4001
	NO MAXVALUE;

CREATE TABLE service_requests (
	service_request_id int NOT NULL DEFAULT nextval('seq_service_request_id'),
	tenant_id int NOT NULL,
	property_id int NOT NULL,
	request_details varchar(500) NOT NULL,
	status varchar(25) NOT NULL,
	CONSTRAINT PK_service_requests PRIMARY KEY (service_request_id),
	CONSTRAINT FK_service_requests_users FOREIGN KEY (tenant_id) REFERENCES users (user_id),
	CONSTRAINT FK_service_requests_properties FOREIGN KEY (property_id) REFERENCES properties (property_id),
	CONSTRAINT CK_status CHECK (status IN ('STATUS_OPEN', 'STATUS_IN_PROGRESS', 'STATUS_COMPLETE'))
);

CREATE SEQUENCE seq_bill_id
	INCREMENT BY 1
	START WITH 5001
	NO MAXVALUE;

CREATE TABLE bills (
	bill_id int NOT NULL DEFAULT nextval('seq_bill_id'),
	tenant_id int  NOT NULL,
	property_id int  NOT NULL,
	amount Decimal(10,2) NOT NULL,
	is_paid boolean NOT NULL,
	CONSTRAINT PK_bills PRIMARY KEY (bill_id),
	CONSTRAINT FK_bills_users FOREIGN KEY (tenant_id) REFERENCES users (user_id),
	CONSTRAINT FK_bills_properties FOREIGN KEY (property_id) REFERENCES properties (property_id)
);

COMMIT TRANSACTION;
