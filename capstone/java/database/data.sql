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
INSERT INTO users (username,password_hash,role) VALUES ('rowena', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER'); --1013
INSERT INTO users (username,password_hash,role) VALUES ('helga', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');--1014

INSERT INTO manager_profiles(user_id, full_name, email) VALUES (1001, 'Keena Carulla', 'kcarulla@yahoo.com'); --2001
INSERT INTO manager_profiles(user_id, full_name, email) VALUES (1002, 'Shannon Satterfield', 'ssatterfield@aol.com'); --2002
INSERT INTO manager_profiles(user_id, full_name, email) VALUES (1003, 'Tanea Quarles', 'tquarles@msn.com'); --2003

INSERT INTO properties(manager_id, address, number_of_rooms, rent, is_available) VALUES (2001, '9157 Jennings Avenue Monsey, NY 10952', 3, 5000.00, true); --propertyId 4001
INSERT INTO properties(manager_id, address, number_of_rooms, rent, is_available) VALUES (2001, '35 Highland St. Londonderry, NH 03053', 2, 3500.00, true); --propertyId 4002
INSERT INTO properties(manager_id, address, number_of_rooms, rent, is_available) VALUES (2001, '32 Courtland Ave. Royersford, PA 19468', 1, 1500.00, false); --propertyId 4003
INSERT INTO properties(manager_id, address, number_of_rooms, rent, is_available) VALUES (2001, '7784 Mayfield Drive Encino, CA 91316', 4, 4775.00, false); --propertyId 4004
INSERT INTO properties(manager_id, address, number_of_rooms, rent, is_available) VALUES (2002, '1 Lake Forest St. Fort Wayne, IN 46804', 1, 2250.00, true); --propertyId 4005
INSERT INTO properties(manager_id, address, number_of_rooms, rent, is_available) VALUES (2002, '7171 Crescent Ave. Milford, MA 01757', 3, 2000.00, true); --propertyId 4006
INSERT INTO properties(manager_id, address, number_of_rooms, rent, is_available) VALUES (2002, '11 Park Road Saint Augustine, FL 32084', 3, 5000.00, false); --propertyId 4007
INSERT INTO properties(manager_id, address, number_of_rooms, rent, is_available) VALUES (2002,'8919 Beech St. Rock Hill, SC 29730', 3, 3500.00, false); --propertyId 4008
INSERT INTO properties(manager_id, address, number_of_rooms, rent, is_available) VALUES (2003, '18 Monroe St. Philadelphia, PA 19111', 1, 1500.00, true); --propertyId 4009
INSERT INTO properties(manager_id, address, number_of_rooms, rent, is_available) VALUES (2003,'63 Greenview St. Southampton, PA 18966', 2, 4775.00,true); --propertyId 4010
INSERT INTO properties(manager_id, address, number_of_rooms, rent, is_available) VALUES (2003,'950 Essex St. Chesapeake, VA 23320', 1, 2250.00, false); --propertyId 4011
INSERT INTO properties(manager_id, address, number_of_rooms, rent, is_available) VALUES (2003, '8607 Fairway Avenue Thomasville, NC 27360', 2, 2000.00, false); --propertyId 4012

INSERT INTO tenant_profiles(property_id, user_id, full_name, email, suite_number, has_autopay) VALUES (4003, 1004, 'Harry Potter', 'hpotter@aol.com' , NULL, true); --3001
INSERT INTO tenant_profiles(property_id, user_id, full_name, email, suite_number, has_autopay) VALUES (4004, 1005, 'Neville Longbottom', 'nlongbottom@gmail.com', '2A', false); --3002
INSERT INTO tenant_profiles(property_id, user_id, full_name, email, suite_number, has_autopay) VALUES (4007, 1006, 'Ron Weasley', 'rweasley@msn.com', NULL, true); --3003
INSERT INTO tenant_profiles(property_id, user_id, full_name, email, suite_number, has_autopay) VALUES (4008, 1007, 'Hermione Granger', 'hgranger@yahoo.com', '4F', true); --3004
INSERT INTO tenant_profiles(property_id, user_id, full_name, email, suite_number, has_autopay) VALUES (4011, 1008, 'Ginny Weasley', 'ginnyw@aol.com', NULL, false); --3005
INSERT INTO tenant_profiles(property_id, user_id, full_name, email, suite_number, has_autopay) VALUES (4012, 1009, 'Draco Malfoy','dracomalfoy@gmail.com', NULL, false); --3006

INSERT INTO applications(user_id, property_id, status, full_name, email, is_above_18, has_roomates, roomate_names) VALUES (1010, 4001, 'STATUS_PENDING', 'Fred Weasley' ,'fweasley@aol.com', true, false, NULL); --applicationId 5001
INSERT INTO applications(user_id, property_id, status, full_name, email, is_above_18, has_roomates, roomate_names) VALUES (1010, 4002, 'STATUS_REJECTED', 'Fred Weasley','fweasley@aol.com', true, true, 'Luna Lovegood'); --applicationId 5002
INSERT INTO applications(user_id, property_id, status, full_name, email, is_above_18, has_roomates, roomate_names) VALUES (1011, 4005, 'STATUS_APPROVED', 'Godric Gryffindor','godric@gmail.com', true, false, NULL); --applicationId 5003
INSERT INTO applications(user_id, property_id, status, full_name, email, is_above_18, has_roomates, roomate_names) VALUES (1011, 4006, 'STATUS_REJECTED','Godric Gryffindor', 'godric@gmail.com', true, true, 'Cedric Diggory'); --applicationId 5004
INSERT INTO applications(user_id, property_id, status, full_name, email, is_above_18, has_roomates, roomate_names) VALUES (1012, 4009, 'STATUS_PENDING', 'Salazar Slytherin','salazar@yahoo.com', true, false, NULL); --applicationId 5005
INSERT INTO applications(user_id, property_id, status, full_name, email, is_above_18, has_roomates, roomate_names) VALUES (1012, 4010, 'STATUS_REJECTED','Salazar Slytherin','salazar@yahoo.com', true, true, 'Tom Riddle'); --applicationId 5006
INSERT INTO applications(user_id, property_id, status, full_name, email, is_above_18, has_roomates, roomate_names) VALUES (1013, 4001, 'STATUS_PENDING', 'Rowena Ravenclaw', 'rravenclaw@msn.com', true, true, 'Helena Ravenclaw'); --5007
INSERT INTO applications(user_id, property_id, status, full_name, email, is_above_18, has_roomates, roomate_names) VALUES (1013, 4002, 'STATUS_PENDING', 'Rowena Ravenclaw', 'rravenclaw@msn.com', true, true, 'Helena Ravenclaw'); --5008
INSERT INTO applications(user_id, property_id, status, full_name, email, is_above_18, has_roomates, roomate_names) VALUES (1013, 4001, 'STATUS_APPROVED', 'Rowena Ravenclaw', 'rravenclaw@msn.com', true, false, NULL); --5009
INSERT INTO applications(user_id, property_id, status, full_name, email, is_above_18, has_roomates, roomate_names) VALUES (1014, 4005, 'STATUS_PENDING', 'Helga Hufflepuff', 'hhufflepuff@aol.com', true, false, NULL); --5010
INSERT INTO applications(user_id, property_id, status, full_name, email, is_above_18, has_roomates, roomate_names) VALUES (1014, 4006, 'STATUS_PENDING', 'Helga Hufflepuff', 'hhufflepuff@aol.com', true, false, NULL); --5011
INSERT INTO applications(user_id, property_id, status, full_name, email, is_above_18, has_roomates, roomate_names) VALUES (1014, 4010, 'STATUS_APPROVED','Helga Hufflepuff', 'hhufflepuff@aol.com', true, false, NULL); --5012

INSERT INTO service_requests (tenant_id, request_details, status) VALUES (3001, 'Plumbing needed.', 'STATUS_COMPLETE'); --serviceResquestId 6001
INSERT INTO service_requests (tenant_id, request_details, status) VALUES (3002, 'Exterminator needed.', 'STATUS_IN_PROGRESS'); --serviceResquestId 6002
INSERT INTO service_requests (tenant_id, request_details, status) VALUES (3003, 'Stove burner needs fixing.', 'STATUS_OPEN'); --serviceResquestId 6003
INSERT INTO service_requests (tenant_id, request_details, status) VALUES (3004, 'Fix kitchen light.', 'STATUS_COMPLETE'); --serviceResquestId 6004
INSERT INTO service_requests (tenant_id, request_details, status) VALUES (3005, 'Bathroom sink broken.', 'STATUS_IN_PROGRESS'); --serviceResquestId 6005
INSERT INTO service_requests (tenant_id, request_details, status) VALUES (3006, 'Living room window broken.', 'STATUS_OPEN'); --serviceResquestId 6006
INSERT INTO service_requests (tenant_id, request_details, status) VALUES (3001, 'Paint peeling from bedroom walls', 'STATUS_OPEN');--6007
INSERT INTO service_requests (tenant_id, request_details, status) VALUES (3002, 'Leaking ac', 'STATUS_IN_PROGRESS'); --6008
INSERT INTO service_requests (tenant_id, request_details, status) VALUES (3003, 'Freezer needs to be fixed', 'STATUS_OPEN'); --6009
INSERT INTO service_requests (tenant_id, request_details, status) VALUES (3004, 'Mold in the kitchen', 'STATUS_IN_PROGRESS'); --6010
INSERT INTO service_requests (tenant_id, request_details, status) VALUES (3005, 'Cracking in bathroom ceiling', 'STATUS_OPEN'); --6011
INSERT INTO service_requests (tenant_id, request_details, status) VALUES (3006, 'Window in liivng room wont open', 'STATUS_IN_PROGRESS');--6012


INSERT INTO rent_transactions (tenant_id, amount, due_date, past_due) VALUES (3001, 1500.00, '2023-01-01', false); --rentTransactionId 7001
INSERT INTO rent_transactions (tenant_id, amount, due_date, past_due) VALUES (3002, 3500.00, '2023-01-01', false); --rentTransactionId 7002
INSERT INTO rent_transactions (tenant_id, amount, due_date, past_due) VALUES (3003, 5000.00, '2023-12-01', true); --rentTransactionId 7003
INSERT INTO rent_transactions (tenant_id, amount, due_date, past_due) VALUES (3004, 3500.00, '2023-12-01', false); --7004
INSERT INTO rent_transactions (tenant_id, amount, due_date, past_due) VALUES (3005, 2250.00, '2023-11-01', true); --7005
INSERT INTO rent_transactions (tenant_id, amount, due_date, past_due) VALUES (3006, 2000.00, '2023-11-01', true); --7006
INSERT INTO rent_transactions (tenant_id, amount, due_date, past_due) VALUES (3001, 1500.00, '2023-02-01', true); --7007
INSERT INTO rent_transactions (tenant_id, amount, due_date, past_due) VALUES (3002, 3500.00, '2023-03-01', true); --7008
INSERT INTO rent_transactions (tenant_id, amount, due_date, past_due) VALUES (3003, 5000.00, '2023-11-01', true); --7009
INSERT INTO rent_transactions (tenant_id, amount, due_date, past_due) VALUES (3004, 3500.00, '2024-01-01', true); --7010
INSERT INTO rent_transactions (tenant_id, amount, due_date, past_due) VALUES (3005, 2250.00, '2023-12-01', true); --7011
INSERT INTO rent_transactions (tenant_id, amount, due_date, past_due) VALUES (3006, 2000.00, '2023-12-01', true); --7012

-------------------------------------------------------- old tables -------------------------------------------------------
-- INSERT INTO user_profiles(user_id, full_name, suite_number, has_autopay) VALUES (1003, 'Harry Potter','3R', true);
-- INSERT INTO user_profiles(user_id, full_name, suite_number, has_autopay) VALUES (1004, 'Neville Longbottom', NULL, false); --applicant
-- INSERT INTO user_profiles(user_id, full_name, suite_number, has_autopay) VALUES (1005, 'Ron Weasley', '3R', false);
-- INSERT INTO user_profiles(user_id, full_name, suite_number, has_autopay) VALUES (1006, 'Hermione Granger', NULL, true); --applicant
-- INSERT INTO user_profiles(user_id, full_name, suite_number, has_autopay) VALUES (1007, 'Ginny Weasley', NULL, false);
-- INSERT INTO user_profiles(user_id, full_name, suite_number, has_autopay) VALUES (1003, 'Harry Potter','3R', true);
-- INSERT INTO user_profiles(user_id, full_name, suite_number, has_autopay) VALUES (1003, 'Harry Potter','3R', true);
-- INSERT INTO user_profiles(user_id, full_name, suite_number, has_autopay) VALUES (1003, 'Harry Potter','3R', true);
-- INSERT INTO user_profiles(user_id, full_name, suite_number, has_autopay) VALUES (1003, 'Harry Potter','3R', true);
-- INSERT INTO user_profiles(user_id, full_name, suite_number, has_autopay) VALUES (1003, 'Harry Potter','3R', true);
-- INSERT INTO user_profiles(user_id, full_name, suite_number, has_autopay) VALUES (1003, 'Harry Potter','3R', true);
-- INSERT INTO user_profiles(user_id, full_name, suite_number, has_autopay) VALUES (1003, 'Harry Potter','3R', true);

-- INSERT INTO tenant_service_requests (tenant_id, service_request_id) VALUES (1003, 4001);
-- INSERT INTO tenant_service_requests (tenant_id, service_request_id) VALUES (1005, 4002);
-- INSERT INTO tenant_service_requests (tenant_id, service_request_id) VALUES (1007, 4003); 

-- INSERT INTO tenant_rent_transactions (tenant_id, transaction_id) VALUES (1003, 5001);
-- INSERT INTO tenant_rent_transactions (tenant_id, transaction_id) VALUES (1005, 5002);
-- INSERT INTO tenant_rent_transactions (tenant_id, transaction_id) VALUES (1007, 5003);

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

-- INSERT INTO user_properties(user_id, property_id) VALUES (1001, 2001); --owner
-- INSERT INTO user_properties(user_id, property_id) VALUES (1001, 2003); --owner
-- INSERT INTO user_properties(user_id, property_id) VALUES (1002, 2002); --owner
-- INSERT INTO user_properties(user_id, property_id) VALUES (1002, 2004); --owner
-- INSERT INTO user_properties(user_id, property_id) VALUES (1003, 2005); --owner
-- INSERT INTO user_properties(user_id, property_id) VALUES (1003, 2006); --owner
-- INSERT INTO user_properties(user_id, property_id) VALUES (1003, 2001); --tenant
-- INSERT INTO user_properties(user_id, property_id) VALUES (1005, 2001); --tenant
-- INSERT INTO user_properties(user_id, property_id) VALUES (1007, 2003); --tenant
-- INSERT INTO user_properties(user_id, property_id) VALUES (1011, 2005); --tenant
-- INSERT INTO user_properties(user_id, property_id) VALUES (1012, 2003); --tenant
-- INSERT INTO user_properties(user_id, property_id) VALUES (1004, 2002); --applicant
-- INSERT INTO user_properties(user_id, property_id) VALUES (1006, 2003); --applicant
-- INSERT INTO user_properties(user_id, property_id) VALUES (1009, 2004); --applicant
-- INSERT INTO user_properties(user_id, property_id) VALUES (1010, 2006); --applicant
---------------------------------------------------------------------------------------------------------------------------

COMMIT TRANSACTION;

