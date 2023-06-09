package org.DAO.ModelObjs;

public class Doctor {
    //Data transfer object - only storage and retrieval (no business logic whatsoever)
    //model object
    private int doctorId;
    private String firstName;
    private String lastName;
    private int salary;
    private int departmentId;
    private int specializationId;

    public Doctor() {

    }

    public Doctor(String firstName, String lastName, int salary, int departmentId, int specializationId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.departmentId = departmentId;
        this.specializationId = specializationId;
    }

    public Doctor(int doctorId, String firstName, String lastName, int salary, int departmentId, int specializationId) {
        this.doctorId = doctorId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.departmentId = departmentId;
        this.specializationId = specializationId;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "doctorId=" + doctorId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", salary=" + salary +
                ", departmentId=" + departmentId +
                ", specializationId=" + specializationId +
                '}';
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public int getSpecializationId() {
        return specializationId;
    }

    public void setSpecializationId(int specializationId) {
        this.specializationId = specializationId;
    }
}
