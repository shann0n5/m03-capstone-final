BEGIN TRANSACTION;
-- ROLLBACK;

DROP TABLE IF EXISTS users, manager_profiles, tenant_profiles, properties, applications, service_requests, 
rent_transactions;
--, DROP TABLE IF EXISTS property_addresses, user_profiles, user_properties, tenant_service_requests, tenant_rent_transactions
DROP SEQUENCE IF EXISTS seq_user_id, seq_manager_id, seq_tenant_id, seq_property_id, seq_application_id, 
seq_service_request_id, seq_transaction_id;--, seq_address_id;

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

CREATE SEQUENCE seq_manager_id
	INCREMENT BY 1
	START WITH 2001
	NO MAXVALUE;

CREATE TABLE manager_profiles(
	manager_id int NOT NULL DEFAULT nextval('seq_manager_id'),
	user_id int NOT NULL,
	full_name varchar(100) NOT NULL,
	email varchar(100) NOT NULL,
	CONSTRAINT PK_manager_profiles PRIMARY KEY (manager_id),
	CONSTRAINT FK_manager_profiles_users FOREIGN KEY (user_id) REFERENCES users (user_id)
);


CREATE SEQUENCE seq_property_id
	INCREMENT BY 1
	START WITH 4001
	NO MAXVALUE;

CREATE TABLE properties (
    property_id int NOT NULL DEFAULT nextval('seq_property_id'),
	manager_id int NOT NULL,
	address varchar (150) NOT NULL,
	number_of_rooms int NOT NULL,
	rent Decimal(10,2) NOT NULL,
	is_available boolean NOT NULL,
	CONSTRAINT PK_properties PRIMARY KEY (property_id),
	CONSTRAINT FK_properties_manager_profiles FOREIGN KEY (manager_id) REFERENCES manager_profiles (manager_id)
);

CREATE SEQUENCE seq_tenant_id
	INCREMENT BY 1
	START WITH 3001
	NO MAXVALUE;

CREATE TABLE tenant_profiles(
	tenant_id int NOT NULL DEFAULT nextval('seq_tenant_id'),
	property_id int NOT NULL,
	user_id int NOT NULL,
	full_name varchar(100) NOT NULL,
	email varchar(100) NOT NULL,
	suite_number varchar(5),
	has_autopay boolean DEFAULT false,
	CONSTRAINT PK_tenant_profiles PRIMARY KEY (tenant_id),
	CONSTRAINT FK_tenant_profiles_users FOREIGN KEY (user_id) REFERENCES users (user_id),
	CONSTRAINT FK_tenant_profiles_properties FOREIGN KEY (property_id) REFERENCES properties (property_id)
);

CREATE SEQUENCE seq_application_id
	INCREMENT BY 1
	START WITH 5001
	NO MAXVALUE;

CREATE TABLE applications (
	application_id int NOT NULL DEFAULT nextval('seq_application_id'),
	user_id int NOT NULL,
	property_id int NOT NULL,
	status varchar(25) NOT NULL,
	full_name varchar(100) NOT NULL,
	email varchar(100) NOT NULL,
	is_above_18 boolean NOT NULL,
	has_roomates boolean NOT NULL,
	roomate_names varchar(100),
	CONSTRAINT PK_applications PRIMARY KEY (application_id),
	CONSTRAINT FK_applications_users FOREIGN KEY (user_id) REFERENCES users (user_id),
	CONSTRAINT FK_applications_properties FOREIGN KEY (property_id) REFERENCES properties (property_id),
	CONSTRAINT CK_status CHECK (status IN ('STATUS_PENDING', 'STATUS_REJECTED', 'STATUS_APPROVED'))
);

CREATE SEQUENCE seq_service_request_id
	INCREMENT BY 1
	START WITH 6001
	NO MAXVALUE;

CREATE TABLE service_requests (
	service_request_id int NOT NULL DEFAULT nextval('seq_service_request_id'),
	tenant_id int NOT NULL,
	request_details varchar(500) NOT NULL,
	status varchar(25) NOT NULL,
	CONSTRAINT PK_service_requests PRIMARY KEY (service_request_id),
	CONSTRAINT FK_service_requests_tenant_profiles FOREIGN KEY (tenant_id) REFERENCES tenant_profiles (tenant_id),
	CONSTRAINT CK_status CHECK (status IN ('STATUS_OPEN', 'STATUS_IN_PROGRESS', 'STATUS_COMPLETE'))
);


CREATE SEQUENCE seq_transaction_id
	INCREMENT BY 1
	START WITH 7001
	NO MAXVALUE;

CREATE TABLE rent_transactions (
	transaction_id int NOT NULL DEFAULT nextval('seq_transaction_id'),
	tenant_id int NOT NULL,
	amount Decimal(10,2) NOT NULL,
	due_date DATE NOT NULL,
	past_due boolean NOT NULL,
	CONSTRAINT PK_tenant_service_requests PRIMARY KEY (transaction_id),
	CONSTRAINT FK_rent_transactions_tenant_profiles FOREIGN KEY (tenant_id) REFERENCES tenant_profiles (tenant_id)
);


------------------------------------ old tables ---------------------------------------------------------

--CREATE TABLE properties (
--    property_id int NOT NULL DEFAULT nextval('seq_property_id'),
--	number_of_rooms int NOT NULL,
--	rent Decimal(10,2) NOT NULL,
--	is_available boolean NOT NULL,
--	is_owner boolean NOT NULL,
--	CONSTRAINT PK_properties PRIMARY KEY (property_id)
--);
--CREATE TABLE properties (
--    property_id int NOT NULL DEFAULT nextval('seq_property_id'),
--	address_id int NOT NULL,
--	number_of_rooms int NOT NULL,
--	rent Decimal(10,2) NOT NULL,
--	is_available boolean NOT NULL,
--	is_owner boolean NOT NULL,
--	CONSTRAINT PK_properties PRIMARY KEY (property_id),
--	CONSTRAINT FK_properties_addresses FOREIGN KEY (address_id) REFERENCES addresses (address_id)
--);


--CREATE TABLE property_addresses (
--	address_id int NOT NULL,
--	property_id int NOT NULL,
--	CONSTRAINT FK_property_addresses_addresses FOREIGN KEY (address_id) REFERENCES addresses (address_id),
--	CONSTRAINT FK_property_addresses_properties FOREIGN KEY (property_id) REFERENCES properties (property_id)
--);

--CREATE SEQUENCE seq_address_id
--	INCREMENT BY 1
--	START WITH 1
--	NO MAXVALUE;
--
--CREATE TABLE addresses (
--	address_id int NOT NULL DEFAULT nextval('seq_address_id'),
--	address varchar (50) NOT NULL,
--	address2 varchar (50),
--	city varchar (75) NOT NULL,
--	state varchar (50) NOT NULL,
--	zipcode varchar (15) NOT NULL,
--	CONSTRAINT PK_addresses PRIMARY KEY (address_id)
--);

-- CREATE TABLE user_profiles (
-- 	user_id int NOT NULL,
-- 	full_name varchar(100) NOT NULL,
-- 	suite_number varchar(10),
-- 	has_autopay boolean DEFAULT false,
-- 	CONSTRAINT PK_user_profiles PRIMARY KEY (user_id),
-- 	CONSTRAINT FK_user_profile_users FOREIGN KEY (user_id) REFERENCES users (user_id)
-- );

-- CREATE TABLE user_properties (
-- 	user_id int NOT NULL,
-- 	property_id int NOT NULL,
-- 	CONSTRAINT FK_user_properties_users FOREIGN KEY (user_id) REFERENCES users (user_id),
-- 	CONSTRAINT FK_user_properties_properties FOREIGN KEY (property_id) REFERENCES properties (property_id)
-- );

-- CREATE TABLE tenant_service_requests (
-- 	tenant_id int NOT NULL,
-- 	service_request_id int NOT NULL,
-- 	CONSTRAINT FK_tenant_services_requests_users FOREIGN KEY (tenant_id) REFERENCES users (user_id),
-- 	CONSTRAINT FK_tenant_services_requests_service_requests FOREIGN KEY (service_request_id) REFERENCES service_requests (service_request_id)
-- );

-- CREATE TABLE tenant_rent_transactions(
-- 	tenant_id int NOT NULL,
-- 	transaction_id int NOT NULL,
-- 	CONSTRAINT FK_tenant_rent_transactions_users FOREIGN KEY (tenant_id) REFERENCES users (user_id),
-- 	CONSTRAINT FK_tenant_rent_transactions_rent_transactions FOREIGN KEY (transaction_id) REFERENCES rent_transactions (transaction_id)
-- );
----------------------------------------------------------------------------------------------------------

-- ROLLBACK;
COMMIT TRANSACTION;
