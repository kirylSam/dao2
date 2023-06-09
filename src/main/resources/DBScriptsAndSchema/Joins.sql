/* INNER JOIN - Returns records that have matching values in both tables */
SELECT mydb.doctors.doctor_id, mydb.doctors.first_name, mydb.doctors.last_name, mydb.specializations.specialization_name
FROM mydb.doctors
INNER JOIN mydb.specializations ON mydb.doctors.specialization_id = mydb.specializations.specialization_id;

SELECT mydb.doctors.first_name, mydb.doctors.last_name, mydb.departments.department_name
FROM mydb.doctors
INNER JOIN mydb.departments on mydb.doctors.department_id = mydb.departments.department_id;

SELECT mydb.doctors.first_name, mydb.doctors.last_name, mydb.specializations.specialization_name, mydb.departments.department_name
FROM ((mydb.doctors
INNER JOIN mydb.specializations on mydb.doctors.specialization_id = mydb.specializations.specialization_id)
INNER JOIN mydb.departments on mydb.doctors.department_id = mydb.departments.department_id);

/* LEFT JOIN - Records from left and what they might have in right (even nulls if nothing)*/
SELECT mydb.patients.first_name, mydb.patients.last_name, mydb.patients_visits.patient_visit_id
FROM mydb.patients
LEFT JOIN mydb.patients_visits ON mydb.patients.patient_id = mydb.patients_visits.patient_id;

/* RIGHT JOIN - Records from right and what they might have in right (even nulls if nothing)*/
SELECT mydb.patients.first_name, mydb.patients.last_name, mydb.prescriptions.prescription_body
FROM mydb.patients
RIGHT JOIN mydb.prescriptions ON mydb.patients.patient_id = mydb.prescriptions.patient_id;

/* UNION - unique */
SELECT mydb.patients.first_name FROM mydb.patients
UNION
SELECT mydb.nurses.first_name FROM mydb.nurses;

/* UNION ALL */
SELECT mydb.patients.first_name FROM mydb.patients
UNION ALL
SELECT mydb.nurses.first_name FROM mydb.nurses;

/* ORDER BY + WHERE*/
SELECT mydb.doctors.first_name, mydb.doctors.last_name, mydb.doctors.salary
FROM mydb.doctors
WHERE mydb.doctors.specialization_id != 5
ORDER BY mydb.doctors.salary;

/*GROUP BY */
SELECT COUNT(mydb.doctors.first_name), mydb.doctors.salary
FROM mydb.doctors
GROUP BY mydb.doctors.salary
ORDER BY mydb.doctors.salary DESC;

/*HAVING */
SELECT COUNT(mydb.doctors.first_name), mydb.doctors.salary
FROM mydb.doctors
GROUP BY mydb.doctors.salary
HAVING mydb.doctors.salary > 9000
ORDER BY mydb.doctors.salary DESC;

/* WHERE LIKE */
SELECT * FROM mydb.doctors
WHERE mydb.doctors.last_name LIKE '%name';

