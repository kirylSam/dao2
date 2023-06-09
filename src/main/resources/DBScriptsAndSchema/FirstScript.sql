SELECT * FROM mydb.specializations;

INSERT INTO mydb.specializations (specialization_name, specialization_desc)
VALUES ("SURGEON", "The guy with a scaplel");

INSERT INTO mydb.specializations (specialization_name, specialization_desc)
VALUES ("CARDIOLOGITST", "Heart issues specialist"),
("PULMONOLOGIST", "Lung issues specialist"),
("DERMATOLOGIST", "Skin issues specialist"),
("LABORANT", "Conducting laboratory examinations");

INSERT INTO mydb.departments (department_name)
VALUES ("Surgical"),
("Cardiological"),
("Therapeutical"),
("Dermatological"),
("Laboratory");

INSERT INTO mydb.departments (department_name)
VALUES ("Admin");

UPDATE mydb.departments
SET department_name = "Adminstration"
WHERE department_id = 6;

ALTER TABLE mydb.departments
ADD department_short varchar(10);

UPDATE mydb.departments
SET department_short = "SUR"
WHERE department_id = 1;

UPDATE mydb.departments
SET department_short = "CAR"
WHERE department_id = 2;

UPDATE mydb.departments
SET department_short = "THR"
WHERE department_id = 3;

UPDATE mydb.departments
SET department_short = "DRM"
WHERE department_id = 4;

UPDATE mydb.departments
SET department_short = "LAB"
WHERE department_id = 5;

UPDATE mydb.departments
SET department_short = "ADM"
WHERE department_id = 6;

INSERT INTO mydb.doctors (first_name, last_name, salary, department_id, specialization_id)
VALUES ("SurgeonName", "SurgeonSurname", 10000, 1, 1);

INSERT INTO mydb.doctors (first_name, last_name, salary, department_id, specialization_id)
VALUES ("LabGuy", "LabGuySurname", 1000, 5, 5),
("Dermatolog", "DermatologSurname", 1200, 4, 4),
("Cardio", "CardioSurname", 9000, 2, 2),
("Cardio2", "Cardio2", 10000, 2, 2),
("Therapeuta", "Internista", 10000, 3, 4),
("LabGuy2", "LabGuySurname2", 100000, 5, 5);

INSERT INTO mydb.doctors (first_name, last_name, salary, department_id, specialization_id)
VALUES ("LabGuy", "LabGuySurname", 1000, 5, 5),
("Dermatolog", "DermatologSurname", 1200, 4, 4),
("Cardio", "CardioSurname", 9000, 2, 2),
("Cardio2", "Cardio2", 10000, 2, 2),
("Therapeuta", "Internista", 10000, 3, 4),
("LabGuy2", "LabGuySurname2", 100000, 5, 5);

DELETE FROM mydb.doctors
WHERE doctor_id = 8;

DELETE FROM mydb.doctors 
WHERE doctor_id BETWEEN 9 AND 13;

INSERT INTO mydb.doctors (first_name, last_name, salary, department_id, specialization_id)
VALUES ("Cox", "Perry", 10100, 5, 5);

ALTER TABLE mydb.nurses
ADD fake_column varchar(1);

ALTER TABLE mydb.nurses
DROP fake_column;

ALTER TABLE mydb.nurses
RENAME COLUMN salary TO nurse_salary; 

INSERT INTO mydb.nurses (first_name, last_name, nurse_salary, department_id, specialization_id)
VALUES ("Nurse", "One", 1000, 5, 5),
("Nurse", "Two", 1200, 4, 4),
("Nurse", "Three", 9000, 2, 2),
("Cardio", "Nurse", 10000, 2, 2),
("Thera", "Nurs", 10000, 3, 4),
("Lab", "Nurse", 100000, 5, 5);

INSERT INTO mydb.laboratory_personel (first_name, last_name, salary, department_id, specialization_id)
VALUES ("LabWorker", "One", 1000, 5, 5),
("LabWorker", "Two", 100000, 5, 5);

INSERT INTO mydb.patients (first_name, last_name, age)
VALUES ("Patient", "One", 19),
("Patient2", "Two", 37),
("Bob", "Kelso", 78),
("Dorian", "Gray", 34),
("Mister", "Fragster", 10);

INSERT INTO mydb.diseases_list (disease_name, disease_desc)
VALUES ("HIV", "Bad disease"),
("Flu", "Just your normal seasonal flu"),
("Corona", "Not the one you wear on your head"),
("Bronchitis", "When flu gets serious");

INSERT INTO mydb.patients_visits (patient_id, doctor_id, disease_id)
VALUES (1, 6, 4);
INSERT INTO mydb.patients_visits (patient_id, doctor_id, disease_id)
VALUES (1, 6, 1);
INSERT INTO mydb.patients_visits (patient_id, doctor_id, disease_id)
VALUES (2, 3, 2);
INSERT INTO mydb.patients_visits (patient_id, doctor_id, disease_id)
VALUES (2, 3, 3);

INSERT INTO mydb.prescriptions (prescription_body, doctor_id, patient_id)
VALUES ("APAP 2x1 daily", 1, 1);
INSERT INTO mydb.prescriptions (prescription_body, doctor_id, patient_id)
VALUES ("APAP 3x1 daily", 2, 1);

INSERT INTO mydb.prescribed_during_visit (patient_visit_id, prescription_id)
VALUES (1, 2),
(1, 3);

INSERT INTO mydb.examinations (examination_name, examination_type, examination_result, laboratory_personel_id, patient_id)
VALUES ("Badanie krwi", "Blood test", "Negative",  1, 1),
("Badanie krwi - rozszerzone", "Blood test", "Positive", 1, 2),
("USG Of intestines", "USG", "Negative", 2, 2);

INSERT INTO mydb.procedures (procedure_body, nurse_id, patient_id)
VALUES ("Massage", 3, 1),
("Parafine", 2, 1),
("Bioptron", 4, 2);

INSERT INTO mydb.procedures_during_visit
VALUES (1, 1),
(2, 2),
(2, 3);

INSERT INTO mydb.examinations_during_visits
VALUES (2, 1),
(3, 2),
(3, 3);