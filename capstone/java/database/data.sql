BEGIN TRANSACTION;
--ROLLBACK;

INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN'); --userId 1001
INSERT INTO users (username,password_hash,role) VALUES ('admin2','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN'); --userId 1002
INSERT INTO users (username,password_hash,role) VALUES ('admin3','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN'); --userId 1003

INSERT INTO users (username,password_hash,role) VALUES ('harry','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER'); --userId 1004
INSERT INTO users (username,password_hash,role) VALUES ('neville','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER'); --userId 1005
INSERT INTO users (username,password_hash,role) VALUES ('ron','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER'); --userId 1006
INSERT INTO users (username,password_hash,role) VALUES ('hermione','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER'); --userId 1007
INSERT INTO users (username,password_hash,role) VALUES ('ginny','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER'); --userId 1008
INSERT INTO users (username,password_hash,role) VALUES ('draco','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER'); --userId 1009
INSERT INTO users (username,password_hash,role) VALUES ('fred','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER'); --userId 1010
INSERT INTO users (username,password_hash,role) VALUES ('godric','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER'); --userId 1011
INSERT INTO users (username,password_hash,role) VALUES ('salazar','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER'); --userId 1012

INSERT INTO properties(address, number_of_rooms, rent, is_available, is_owner) VALUES ('123 Test St New York, NY 10024', 3, 5000.00, true, true); --propertyId 2001
INSERT INTO properties(address, number_of_rooms, rent, is_available, is_owner) VALUES ('456 Testing Blvd Long Beach, CA 90210', 2, 3500.00, false, true); --propertyId 2002
INSERT INTO properties(address, number_of_rooms, rent, is_available, is_owner) VALUES ('789 Test Ave Philadelphia, PA 19093', 1, 1500.00, false, true); --propertyId 2003
INSERT INTO properties(address, number_of_rooms, rent, is_available, is_owner) VALUES ('24 Tech Rd Brooklyn, NY 11201', 4, 4775.00, true, true); --propertyId 2004
INSERT INTO properties(address, number_of_rooms, rent, is_available, is_owner) VALUES ('357 Elevator Dr Los Angeles, CA 90217', 1, 2250.00, false, true); --propertyId 2005
INSERT INTO properties(address, number_of_rooms, rent, is_available, is_owner) VALUES ('8 Software St Pittsburg, PA 19580', 2, 2000.00, true, true); --propertyId 2006

INSERT INTO user_profiles(user_id, full_name, suite_number, has_autopay) VALUES (1003, 'Harry Potter','3R', true);
INSERT INTO user_profiles(user_id, full_name, suite_number, has_autopay) VALUES (1004, 'Neville Longbottom', NULL, false); --applicant
INSERT INTO user_profiles(user_id, full_name, suite_number, has_autopay) VALUES (1005, 'Ron Weasley', '3R', false);
INSERT INTO user_profiles(user_id, full_name, suite_number, has_autopay) VALUES (1006, 'Hermione Granger', NULL, true); --applicant
INSERT INTO user_profiles(user_id, full_name, suite_number, has_autopay) VALUES (1007, 'Ginny Weasley', NULL, false);
INSERT INTO user_profiles(user_id, full_name, suite_number, has_autopay) VALUES (1003, 'Harry Potter','3R', true);
INSERT INTO user_profiles(user_id, full_name, suite_number, has_autopay) VALUES (1003, 'Harry Potter','3R', true);
INSERT INTO user_profiles(user_id, full_name, suite_number, has_autopay) VALUES (1003, 'Harry Potter','3R', true);
INSERT INTO user_profiles(user_id, full_name, suite_number, has_autopay) VALUES (1003, 'Harry Potter','3R', true);
INSERT INTO user_profiles(user_id, full_name, suite_number, has_autopay) VALUES (1003, 'Harry Potter','3R', true);
INSERT INTO user_profiles(user_id, full_name, suite_number, has_autopay) VALUES (1003, 'Harry Potter','3R', true);
INSERT INTO user_profiles(user_id, full_name, suite_number, has_autopay) VALUES (1003, 'Harry Potter','3R', true);

INSERT INTO user_properties(user_id, property_id) VALUES (1001, 2001); --owner
INSERT INTO user_properties(user_id, property_id) VALUES (1001, 2003); --owner
INSERT INTO user_properties(user_id, property_id) VALUES (1002, 2002); --owner
INSERT INTO user_properties(user_id, property_id) VALUES (1002, 2004); --owner
INSERT INTO user_properties(user_id, property_id) VALUES (1003, 2005); --owner
INSERT INTO user_properties(user_id, property_id) VALUES (1003, 2006); --owner
INSERT INTO user_properties(user_id, property_id) VALUES (1003, 2001); --tenant
INSERT INTO user_properties(user_id, property_id) VALUES (1005, 2001); --tenant
INSERT INTO user_properties(user_id, property_id) VALUES (1007, 2003); --tenant
INSERT INTO user_properties(user_id, property_id) VALUES (1011, 2005); --tenant
INSERT INTO user_properties(user_id, property_id) VALUES (1012, 2003); --tenant
INSERT INTO user_properties(user_id, property_id) VALUES (1004, 2002); --applicant
INSERT INTO user_properties(user_id, property_id) VALUES (1006, 2003); --applicant
INSERT INTO user_properties(user_id, property_id) VALUES (1009, 2004); --applicant
INSERT INTO user_properties(user_id, property_id) VALUES (1010, 2006); --applicant


INSERT INTO applications(user_id, property_id, status, has_roomates, roomate_names) VALUES (1004, 2001, 'STATUS_PENDING', false, NULL); --applicationId 3001
INSERT INTO applications(user_id, property_id, status, has_roomates, roomate_names) VALUES (1005, 2003, 'STATUS_WITHDRAWN', true, 'Luna Lovegood'); --applicationId 3002
INSERT INTO applications(user_id, property_id, status, has_roomates, roomate_names) VALUES (1005, 2003, 'STATUS_WITHDRAWN', true, 'Draco Malfoy'); --applicationId 3003
INSERT INTO applications(user_id, property_id, status, has_roomates, roomate_names) VALUES (1005, 2002, 'STATUS_PENDING', true, 'Cedric Diggory'); --applicationId 3004

INSERT INTO applications(user_id, property_id, status, has_roomates, roomate_names) VALUES (1005, 2003, 'STATUS_WITHDRAWN', false, 'NULL'); --applicationId 3005
INSERT INTO applications(user_id, property_id, status, has_roomates, roomate_names) VALUES (1005, 2003, 'STATUS_WITHDRAWN', true, 'Draco Malfoy'); --applicationId 3006
INSERT INTO applications(user_id, property_id, status, has_roomates, roomate_names) VALUES (1005, 2002, 'STATUS_PENDING', true, 'Cedric Diggory'); --applicationId 3007
INSERT INTO applications(user_id, property_id, status, has_roomates, roomate_names) VALUES (1005, 2003, 'STATUS_WITHDRAWN', false, 'NULL'); --applicationId 3008

INSERT INTO service_requests (request_details, status) VALUES ('Plumbing needed.', 'STATUS_COMPLETE'); --serviceResquestId 4001
INSERT INTO service_requests (request_details, status) VALUES ('Exterminator needed.', 'STATUS_IN_PROGRESS'); --serviceResquestId 4002
INSERT INTO service_requests (request_details, status) VALUES ('Stove burner needs fixing.', 'STATUS_OPEN'); --serviceResquestId 4003

INSERT INTO tenant_service_requests (tenant_id, service_request_id) VALUES (1003, 4001);
INSERT INTO tenant_service_requests (tenant_id, service_request_id) VALUES (1005, 4002);
INSERT INTO tenant_service_requests (tenant_id, service_request_id) VALUES (1007, 4003);

INSERT INTO rent_transactions (amount, due_date, past_due) VALUES (2500.00, '2023-01-01', false); --rentTransactionId 5001
INSERT INTO rent_transactions (amount, due_date, past_due) VALUES (2500.00, '2023-01-01', false); --rentTransactionId 5002
INSERT INTO rent_transactions (amount, due_date, past_due) VALUES (1500.00, '2023-12-01', true); --rentTransactionId 5003

INSERT INTO tenant_rent_transactions (tenant_id, transaction_id) VALUES (1003, 5001);
INSERT INTO tenant_rent_transactions (tenant_id, transaction_id) VALUES (1005, 5002);
INSERT INTO tenant_rent_transactions (tenant_id, transaction_id) VALUES (1007, 5003);


-------------------------------------------------------- old tables -------------------------------------------------------

--INSERT INTO properties(number_of_rooms, rent, is_available, is_owner) VALUES (3, 5000.00, true, true); --propertyId 2001
--INSERT INTO properties(number_of_rooms, rent, is_available, is_owner) VALUES (2, 3500.00, false, true); --propertyId 2002
--INSERT INTO properties(number_of_rooms, rent, is_available, is_owner) VALUES (1, 1500.00, false, true); --propertyId 2003

--INSERT INTO property_addresses (address_id, property_id) VALUES (1,2001);
--INSERT INTO property_addresses (address_id, property_id) VALUES (2,2002);
--INSERT INTO property_addresses (address_id, property_id) VALUES (3,2003);

--INSERT INTO properties(address_id, number_of_rooms, rent, is_available, is_owner) VALUES (1, 3, 5000.00, true, true); --propertyId 2001
--INSERT INTO properties(address_id, number_of_rooms, rent, is_available, is_owner) VALUES (2, 2, 3500.00, false, true); --propertyId 2002
--INSERT INTO properties(address_id, number_of_rooms, rent, is_available, is_owner) VALUES (3, 1, 1500.00, false, true); --propertyId 2003

--INSERT INTO addresses (address, address2, city, state, zipcode) VALUES ('123 Test St', '', 'New York', 'NY', '10024'); --addressId 1 ?
--INSERT INTO addresses (address, address2, city, state, zipcode) VALUES ('456 Testing Blvd', '', 'Long Beach', 'CA', '90210'); --addressId 2 ?
--INSERT INTO addresses (address, address2, city, state, zipcode) VALUES('789 Test Ave', '', 'Philadelphia', 'PA', '19093'); --addressId 3 ?
---------------------------------------------------------------------------------------------------------------------------

COMMIT TRANSACTION;

