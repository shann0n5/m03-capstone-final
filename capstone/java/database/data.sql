BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');
INSERT INTO users ()

INSERT INTO properties(address, owner_id, number_of_rooms, rent, is_available) VALUES ('123 Test St, New York, NY 10024'),
INSERT INTO properties(address, owner_id, number_of_rooms, rent, is_available) VALUES (),
INSERT INTO properties(address, owner_id, number_of_rooms, rent, is_available) VALUES (),

INSERT INTO applications(applicant_id, property_id, status) VALUES (),
INSERT INTO applications(applicant_id, property_id, status) VALUES (),
INSERT INTO applications(applicant_id, property_id, status) VALUES (),

INSERT INTO service_requests (tenant_id, property_id, request_details, status) VALUES ();
INSERT INTO service_requests (tenant_id, property_id, request_details, status) VALUES ();
INSERT INTO service_requests (tenant_id, property_id, request_details, status) VALUES ();

INSERT INTO bills(bill_id, tenant_id, property_id, amount, is_paid) VALUES (),

COMMIT TRANSACTION;
