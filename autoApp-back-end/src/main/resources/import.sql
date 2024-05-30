INSERT INTO ROLE (id,name) VALUES (1,'ROLE_USER');
INSERT INTO ROLE (id,name) VALUES (2,'ROLE_ADMIN');

INSERT INTO app_user(first_name, last_name, email, password, role_id, new, is_suspicious) VALUES ('Pera','Peric', 'peraperic@gmail.com', '$2a$10$nrCPz3vEZvmjlPeNbt4RQ.bSIngRXMlwMxfJJtp1Bhn.f0op9Zcui', 1, TRUE, false);
INSERT INTO app_user(first_name, last_name, email, password, role_id, new, is_suspicious) VALUES ('Admin','Admin', 'admin@gmail.com', '$2a$10$nrCPz3vEZvmjlPeNbt4RQ.bSIngRXMlwMxfJJtp1Bhn.f0op9Zcui', 2, TRUE , false);

INSERT INTO app_user (first_name, last_name, email, password, role_id, new, is_suspicious)VALUES ('Marko', 'Markovic', 'marko.markovic@gmail.com', '$2a$10$nrCPz3vEZvmjlPeNbt4RQ.bSIngRXMlwMxfJJtp1Bhn.f0op9Zcui', 1, TRUE, false);
--password for Marko is "password123"

INSERT INTO app_user (first_name, last_name, email, password, role_id, new, is_suspicious)VALUES ('Ana', 'Anic', 'ana.anic@gmail.com', '$2a$10$nrCPz3vEZvmjlPeNbt4RQ.bSIngRXMlwMxfJJtp1Bhn.f0op9Zcui', 1, TRUE, false);

INSERT INTO app_user (first_name, last_name, email, password, role_id, new, is_suspicious)VALUES ('Zoki', 'Zanic', 'zoki.anic@gmail.com', '$2a$10$nrCPz3vEZvmjlPeNbt4RQ.bSIngRXMlwMxfJJtp1Bhn.f0op9Zcui', 1, TRUE, false);
--password for Ana is "password123"

INSERT INTO app_user (first_name, last_name, email, password, role_id, new, is_suspicious)VALUES ('Zika', 'Zikic', 'zika@gmail.com', '$2a$10$nrCPz3vEZvmjlPeNbt4RQ.bSIngRXMlwMxfJJtp1Bhn.f0op9Zcui', 1, TRUE, false);

INSERT INTO app_user (first_name, last_name, email, password, role_id, new , is_suspicious)VALUES ('Mile', 'Mile', 'mile@gmail.com', '$2a$10$nrCPz3vEZvmjlPeNbt4RQ.bSIngRXMlwMxfJJtp1Bhn.f0op9Zcui', 1, TRUE, false);

-- INSERT INTO app_user (first_name, last_name, email, password, role_id, new, is_suspicious)VALUES ('Petar', 'Petrovic', 'petar@gmail.com', '$2a$10$nrCPz3vEZvmjlPeNbt4RQ.bSIngRXMlwMxfJJtp1Bhn.f0op9Zcui', 1, TRUE, false);

-- INSERT INTO app_user (first_name, last_name, email, password, role_id, new , is_suspicious)VALUES ('Nikola', 'Nikolic', 'nikola@gmail.com', '$2a$10$nrCPz3vEZvmjlPeNbt4RQ.bSIngRXMlwMxfJJtp1Bhn.f0op9Zcui', 1, TRUE, false);


--password je "password123"




INSERT INTO vehicle (model_name, current_state, price, imageurl) VALUES ('Model 1', 1, 15000.0, 'https://hips.hearstapps.com/hmg-prod/images/honda-prelude-concept-front-three-quarters-653927960f1f4.jpg?crop=1.00xw:0.920xh;0,0.0801xh&resize=980:*');
INSERT INTO vehicle (model_name, current_state, price, imageurl) VALUES ('Model 2', 2, 10000.0, 'https://upload.wikimedia.org/wikipedia/commons/thumb/a/a4/2019_Toyota_Corolla_Icon_Tech_VVT-i_Hybrid_1.8.jpg/1200px-2019_Toyota_Corolla_Icon_Tech_VVT-i_Hybrid_1.8.jpg');


INSERT INTO vehicle_reservation (actual_return_time, scheduled_pickup_time, scheduled_return_time, vehicle_state, cancellation_reason, cancellation_time, reservation_time, status, user_id, vehicle_id) VALUES (null, '2024-05-29T00:00:00', '2024-05-31T00:00:00', 8, null, null, '2024-05-27T00:00:00', 0, 6, 1);
INSERT INTO vehicle_reservation (actual_return_time, scheduled_pickup_time, scheduled_return_time, vehicle_state, cancellation_reason, cancellation_time, reservation_time, status, user_id, vehicle_id) VALUES (null, '2024-06-01T00:00:00', '2024-06-05T00:00:00', 8, null, null, '2024-05-27T00:00:00', 0, 6, 2);
INSERT INTO vehicle_reservation (actual_return_time, scheduled_pickup_time, scheduled_return_time, vehicle_state, cancellation_reason, cancellation_time, reservation_time, status, user_id, vehicle_id) VALUES (null, '2024-06-01T00:00:00', '2024-06-05T00:00:00', 8, 'aa', '2024-05-27T01:00:00', '2024-05-27T00:00:00', 1, 6, 2);
INSERT INTO vehicle_reservation (actual_return_time, scheduled_pickup_time, scheduled_return_time, vehicle_state, cancellation_reason, cancellation_time, reservation_time, status, user_id, vehicle_id) VALUES (null, '2024-06-01T00:00:00', '2024-06-05T00:00:00', 8, 'aa', '2024-05-27T01:00:00', '2024-05-27T00:00:00', 1, 6, 2);
INSERT INTO vehicle_reservation (actual_return_time, scheduled_pickup_time, scheduled_return_time, vehicle_state, cancellation_reason, cancellation_time, reservation_time, status, user_id, vehicle_id) VALUES (null, '2024-06-01T00:00:00', '2024-06-05T00:00:00', 8, 'aa', '2024-05-27T01:00:00', '2024-05-27T00:00:00', 1, 6, 2);
INSERT INTO vehicle_reservation (actual_return_time, scheduled_pickup_time, scheduled_return_time, vehicle_state, cancellation_reason, cancellation_time, reservation_time, status, user_id, vehicle_id) VALUES (null, '2024-06-01T00:00:00', '2024-06-05T00:00:00', 8, 'aa', '2024-05-27T01:00:00', '2024-05-27T00:00:00', 1, 6, 2);


-- INSERT INTO vehicle_reservation (actual_return_time, scheduled_pickup_time, scheduled_return_time, vehicle_state, cancellation_reason, cancellation_time, reservation_time, status, user_id, vehicle_id) VALUES ('2023-05-31T00:00:00', '2023-05-29T00:00:00', '2023-05-31T00:00:00', 2, null, '2024-05-20T00:00:00', '2024-05-27T00:00:00', 3, 6, 1);
-- INSERT INTO vehicle_reservation (actual_return_time, scheduled_pickup_time, scheduled_return_time, vehicle_state, cancellation_reason, cancellation_time, reservation_time, status, user_id, vehicle_id) VALUES ('2023-06-05T00:00:00', '2023-06-01T00:00:00', '2023-06-05T00:00:00', 2, null, '2024-05-20T00:00:00', '2024-05-27T00:00:00', 3, 6, 2);
-- INSERT INTO vehicle_reservation (actual_return_time, scheduled_pickup_time, scheduled_return_time, vehicle_state, cancellation_reason, cancellation_time, reservation_time, status, user_id, vehicle_id) VALUES ('2023-08-05T00:00:00', '2023-08-01T00:00:00', '2023-08-05T00:00:00', 2, null, '2024-07-20T00:00:00', '2024-07-27T00:00:00', 3, 6, 2);
--
-- INSERT INTO vehicle_reservation (actual_return_time, scheduled_pickup_time, scheduled_return_time, vehicle_state, cancellation_reason, cancellation_time, reservation_time, status, user_id, vehicle_id) VALUES ('2023-06-01T00:00:00', '2023-05-29T00:00:00', '2023-05-31T00:00:00', 1, null, '2023-05-20T00:00:00', '2024-05-27T00:00:00', 3, 6, 1);
-- INSERT INTO vehicle_reservation (actual_return_time, scheduled_pickup_time, scheduled_return_time, vehicle_state, cancellation_reason, cancellation_time, reservation_time, status, user_id, vehicle_id) VALUES ('2023-06-07T00:00:00', '2023-06-01T00:00:00', '2023-06-05T00:00:00', 1, null, '2023-05-20T00:00:00', '2024-05-27T00:00:00', 3, 6, 2);
-- INSERT INTO vehicle_reservation (actual_return_time, scheduled_pickup_time, scheduled_return_time, vehicle_state, cancellation_reason, cancellation_time, reservation_time, status, user_id, vehicle_id) VALUES ('2023-08-07T00:00:00', '2023-08-01T00:00:00', '2023-08-05T00:00:00', 1, null, '2023-07-20T00:00:00', '2024-07-27T00:00:00', 3, 6, 2);