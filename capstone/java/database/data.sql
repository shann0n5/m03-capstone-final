BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN'); --userId 1001
INSERT INTO users (username,password_hash,role) VALUES ('admin2','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN'); --userId 1002

INSERT INTO users (username,password_hash,role) VALUES ('harry','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER'); --userId 1003
INSERT INTO users (username,password_hash,role) VALUES ('neville','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER'); --userId 1004
INSERT INTO users (username,password_hash,role) VALUES ('ron','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER'); --userId 1005
INSERT INTO users (username,password_hash,role) VALUES ('hermione','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER'); --userId 1006
INSERT INTO users (username,password_hash,role) VALUES ('ginny','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER'); --userId 1007

INSERT INTO properties(address, number_of_rooms, rent, is_available) VALUES ('123 Test St, New York, NY 10024', 3, 5000.00, true); --propertyId 2001
INSERT INTO properties(address, number_of_rooms, rent, is_available) VALUES ('456 Testing Blvd, Long Beach, CA 90210', 2, 3500.00, false); --propertyId 2002
INSERT INTO properties(address, number_of_rooms, rent, is_available) VALUES ('789 Test Ave, Philadelphia, PA 19093', 1, 1500.00, false); --propertyId 2003

INSERT INTO user_profiles(tenant_id, full_name, property_id, suite_number, has_autopay) VALUES (1003, 'Harry Potter', 2001, '3R', true);
INSERT INTO user_profiles(tenant_id, full_name, property_id, suite_number, has_autopay) VALUES (1004, 'Neville Longbottom', 2002, NULL, true);
INSERT INTO user_profiles(tenant_id, full_name, property_id, suite_number, has_autopay) VALUES (1005, 'Ron Weasley', 2001, '3R', false);
INSERT INTO user_profiles(tenant_id, full_name, property_id, suite_number, has_autopay) VALUES (1006, 'Hermione Granger', 2003, NULL, true);
INSERT INTO user_profiles(tenant_id, full_name, property_id, suite_number, has_autopay) VALUES (1007, 'Ginny Weasley', 2003, NULL, false);

INSERT INTO manager_properties(propety_manager_id, property_id) VALUES (1001, 2001);
INSERT INTO manager_properties(propety_manager_id, property_id) VALUES (1001, 2003);
INSERT INTO manager_properties(propety_manager_id, property_id) VALUES (1002, 2002);

INSERT INTO applications(applicant_id, property_id, status, has_roomates, roomate_names) VALUES (1002, 2001, 'STATUS_PENDING'); --applicationId 3001
INSERT INTO applications(applicant_id, property_id, status, has_roomates, roomate_names) VALUES (1003, 2001, 'STATUS_WITHDRAWN'); --applicationId 3002
INSERT INTO applications(applicant_id, property_id, status, has_roomates, roomate_names) VALUES (1004, 2001, 'STATUS_REJECTED'); --applicationId 3003

INSERT INTO service_requests (tenant_id, property_id, request_details, status) VALUES (1005, 2002, 'Plumbing needed.', 'STATUS_COMPLETE'); --serviceResquestId 4001
INSERT INTO service_requests (tenant_id, property_id, request_details, status) VALUES (1006, 2003, 'Exterminator needed.', 'STATUS_IN_PROGRESS'); --serviceResquestId 4002
INSERT INTO service_requests (tenant_id, property_id, request_details, status) VALUES (1007, 2004, 'Stove burner needs fixing.', 'STATUS_OPEN'); --serviceResquestId 4003

INSERT INTO bills(tenant_id, property_id, amount, is_paid) VALUES (1005, 2002, 3500.00, true); --billId 5001
INSERT INTO bills(tenant_id, property_id, amount, is_paid) VALUES (1006, 2003, 1500.00, true); --billId 5002
INSERT INTO bills(tenant_id, property_id, amount, is_paid) VALUES (1007, 2004, 3950.00, false); --billId 5003

COMMIT TRANSACTION;

