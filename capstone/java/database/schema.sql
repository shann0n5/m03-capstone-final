BEGIN TRANSACTION;

DROP TABLE IF EXISTS users, user_profiles, user_properties, properties, applications, service_requests, tenant_service_requests, rent_transactions, tenant_rent_transactions;

DROP SEQUENCE IF EXISTS seq_user_id, seq_property_id, seq_application_id, seq_service_request_id, seq_transaction_id;

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
	CONSTRAINT CK_role CHECK (role IN ('ROLE_USER','ROLE_ADMIN'))
);

CREATE SEQUENCE seq_property_id
	INCREMENT BY 1
	START WITH 2001
	NO MAXVALUE;

CREATE TABLE properties (
    property_id int NOT NULL DEFAULT nextval('seq_property_id'),
    address varchar(75) NOT NULL UNIQUE,
	number_of_rooms int NOT NULL,
	rent Decimal(10,2) NOT NULL,
	is_available boolean NOT NULL,
	CONSTRAINT PK_properties PRIMARY KEY (property_id),
	CONSTRAINT UQ_address UNIQUE (address) 
);

CREATE TABLE user_profiles (
	user_id int NOT NULL,
	full_name varchar(100) NOT NULL,
	suite_number varchar(10),
	has_autopay boolean DEFAULT false,
	CONSTRAINT PK_user_profiles PRIMARY KEY (user_id),
	CONSTRAINT FK_user_profile_users FOREIGN KEY (user_id) REFERENCES users (user_id)
);

CREATE TABLE user_properties (
	user_id int NOT NULL,
	property_id int NOT NULL,
	CONSTRAINT FK_user_properties_users FOREIGN KEY (user_id) REFERENCES users (user_id),
	CONSTRAINT FK_user_properties_properties FOREIGN KEY (property_id) REFERENCES properties (property_id)
);

CREATE SEQUENCE seq_application_id
	INCREMENT BY 1
	START WITH 3001
	NO MAXVALUE;

CREATE TABLE applications (
	application_id int NOT NULL DEFAULT nextval('seq_application_id'),
	user_id int NOT NULL,
	property_id int NOT NULL,
	status varchar(25) NOT NULL,
	has_roomates boolean NOT NULL,
	roomate_names varchar(100),
	CONSTRAINT PK_applications PRIMARY KEY (user_id),
	CONSTRAINT FK_applications_users FOREIGN KEY (user_id) REFERENCES users (user_id),
	CONSTRAINT FK_applications_properties FOREIGN KEY (property_id) REFERENCES properties (property_id),
	CONSTRAINT CK_status CHECK (status IN ('STATUS_PENDING', 'STATUS_REJECTED', 'STATUS_WITHDRAWN'))
);

CREATE SEQUENCE seq_service_request_id
	INCREMENT BY 1
	START WITH 4001
	NO MAXVALUE;

CREATE TABLE service_requests (
	service_request_id int NOT NULL DEFAULT nextval('seq_service_request_id'),
	request_details varchar(500) NOT NULL,
	status varchar(25) NOT NULL,
	CONSTRAINT PK_service_requests PRIMARY KEY (service_request_id),
	CONSTRAINT CK_status CHECK (status IN ('STATUS_OPEN', 'STATUS_IN_PROGRESS', 'STATUS_COMPLETE'))
);

CREATE TABLE tenant_service_requests (
	tenant_id int NOT NULL,
	service_request_id int NOT NULL,
	CONSTRAINT FK_tenant_services_requests_users FOREIGN KEY (tenant_id) REFERENCES users (user_id),
	CONSTRAINT FK_tenant_services_requests_service_requests FOREIGN KEY (service_request_id) REFERENCES service_requests (service_request_id)
);

CREATE SEQUENCE seq_transaction_id
	INCREMENT BY 1
	START WITH 5001
	NO MAXVALUE;

CREATE TABLE rent_transactions (
	transaction_id int NOT NULL DEFAULT nextval('seq_transaction_id'),
	amount Decimal(10,2) NOT NULL,
	due_date DATE NOT NULL,
	past_due boolean NOT NULL,
	CONSTRAINT PK_tenant_service_requests PRIMARY KEY (transaction_id)
);

CREATE TABLE tenant_rent_transactions(
	tenant_id int NOT NULL,
	transaction_id int NOT NULL,
	CONSTRAINT FK_tenant_rent_transactions_users FOREIGN KEY (tenant_id) REFERENCES users (user_id),
	CONSTRAINT FK_tenant_rent_transactions_rent_transactions FOREIGN KEY (transaction_id) REFERENCES rent_transactions (transaction_id)
);

-- ROLLBACK;
COMMIT TRANSACTION;
