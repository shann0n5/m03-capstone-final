BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN'); --userId 1001

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER'); --userId 1002
INSERT INTO users (username,password_hash,role) VALUES ('user1','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER'); --userId 1003
INSERT INTO users (username,password_hash,role) VALUES ('user2','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER'); --userId 1004

INSERT INTO users (username,password_hash,role) VALUES ('tenant','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_TENANT'); --userId 1005
INSERT INTO users (username,password_hash,role) VALUES ('tenant1','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_TENANT'); --userId 1006
INSERT INTO users (username,password_hash,role) VALUES ('tenant2','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_TENANT'); --userId 1007

INSERT INTO users (username,password_hash,role) VALUES ('owner','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_PROPERTY_OWNER'); --userId 1008
INSERT INTO users (username,password_hash,role) VALUES ('owner1','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_PROPERTY_OWNER'); --userId 1009
INSERT INTO users (username,password_hash,role) VALUES ('owner2','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_PROPERTY_OWNER'); --userId 1010


INSERT INTO properties(address, owner_id, number_of_rooms, rent, is_available) VALUES ('123 Test St, New York, NY 10024', 1008, 3, 5000.00, true); --propertyId 2001
INSERT INTO properties(address, owner_id, number_of_rooms, rent, is_available) VALUES ('456 Testing Blvd, Long Beach, CA 90210', 1009, 2, 3500.00, false); --propertyId 2002
INSERT INTO properties(address, owner_id, number_of_rooms, rent, is_available) VALUES ('789 Test Ave, Philadelphia, PA 19093', 1010, 1, 1500.00, false); --propertyId 2003
INSERT INTO properties(address, owner_id, number_of_rooms, rent, is_available) VALUES ('101 Tester Rd, Queens, NY 10095', 1010, 4, 3950.00, false);--propertyId 2004

INSERT INTO applications(applicant_id, property_id, status) VALUES (1002, 2001, 'STATUS_PENDING'); --applicationId 3001
INSERT INTO applications(applicant_id, property_id, status) VALUES (1003, 2001, 'STATUS_WITHDRAWN'); --applicationId 3002
INSERT INTO applications(applicant_id, property_id, status) VALUES (1004, 2001, 'STATUS_REJECTED'); --applicationId 3003

INSERT INTO service_requests (tenant_id, property_id, request_details, status) VALUES (1005, 2002, 'Plumbing needed.', 'STATUS_COMPLETE'); --serviceResquestId 4001
INSERT INTO service_requests (tenant_id, property_id, request_details, status) VALUES (1006, 2003, 'Exterminator needed.', 'STATUS_IN_PROGRESS'); --serviceResquestId 4002
INSERT INTO service_requests (tenant_id, property_id, request_details, status) VALUES (1007, 2004, 'Stove burner needs fixing.', 'STATUS_OPEN'); --serviceResquestId 4003

INSERT INTO bills(tenant_id, property_id, amount, is_paid) VALUES (1005, 2002, 3500.00, true); --billId 5001
INSERT INTO bills(tenant_id, property_id, amount, is_paid) VALUES (1006, 2003, 1500.00, true); --billId 5002
INSERT INTO bills(tenant_id, property_id, amount, is_paid) VALUES (1007, 2004, 3950.00, false); --billId 5003

COMMIT TRANSACTION;

