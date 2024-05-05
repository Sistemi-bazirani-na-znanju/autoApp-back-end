INSERT INTO ROLE (id,name) VALUES (1,'ROLE_USER');
INSERT INTO ROLE (id,name) VALUES (2,'ROLE_ADMIN');

INSERT INTO app_user(first_name, last_name, email, password, role_id) VALUES ('Pera','Peric', 'peraperic@gmail.com', '$2a$10$nrCPz3vEZvmjlPeNbt4RQ.bSIngRXMlwMxfJJtp1Bhn.f0op9Zcui', 1);
INSERT INTO app_user(first_name, last_name, email, password, role_id) VALUES ('Admin','Admin', 'admin@gmail.com', '$2a$10$nrCPz3vEZvmjlPeNbt4RQ.bSIngRXMlwMxfJJtp1Bhn.f0op9Zcui', 2);
--password je "password123"

INSERT INTO vehicle (model_name, current_state, price, imageurl) VALUES ('Model 1', 1, 15000.0, 'https://hips.hearstapps.com/hmg-prod/images/honda-prelude-concept-front-three-quarters-653927960f1f4.jpg?crop=1.00xw:0.920xh;0,0.0801xh&resize=980:*');
INSERT INTO vehicle (model_name, current_state, price, imageurl) VALUES ('Model 2', 2, 10000.0, 'https://upload.wikimedia.org/wikipedia/commons/thumb/a/a4/2019_Toyota_Corolla_Icon_Tech_VVT-i_Hybrid_1.8.jpg/1200px-2019_Toyota_Corolla_Icon_Tech_VVT-i_Hybrid_1.8.jpg');
