package org.DAO.ModelObjs.Builder;

import org.DAO.ModelObjs.Doctor;

public class DoctorBuilder {
    private Doctor doctor;

    public DoctorBuilder() {
        this.doctor = new Doctor();
    }

    public DoctorBuilder buildDoctorId(int doctorId) {
        doctor.setDoctorId(doctorId);
        return this;
    }

    public DoctorBuilder buildFirstName(String firstName) {
        doctor.setFirstName(firstName);
        return this;
    }

    public DoctorBuilder buildLastName(String lastName) {
        doctor.setLastName(lastName);
        return this;
    }

    public DoctorBuilder buildSalary(int salary) {
        doctor.setSalary(salary);
        return this;
    }

    public DoctorBuilder buildDepartmentId(int deptId) {
        doctor.setDepartmentId(deptId);
        return this;
    }

    public DoctorBuilder buildSpecId(int specId) {
        doctor.setSpecializationId(specId);
        return this;
    }

    public Doctor getDoctor() {
        return doctor;
    }
}
