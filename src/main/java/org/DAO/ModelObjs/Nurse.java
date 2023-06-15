package org.DAO.ModelObjs;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlRootElement(name = "nurse")
@XmlType(propOrder = { "nurseId", "firstName", "lastName", "nurseSalary", "departmentId", "specializationId" }, namespace = "https://www.example.org/nurse")
public class Nurse {
    //Data transfer object - only storage and retrieval (no business logic whatsoever)
    //model object
    private int nurseId;
    private String firstName;
    private String lastName;
    private int nurse_salary;
    private int departmentId;
    private int specializationId;

    public Nurse() {

    }

    public Nurse(String firstName, String lastName, int nurse_salary, int departmentId, int specializationId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nurse_salary = nurse_salary;
        this.departmentId = departmentId;
        this.specializationId = specializationId;
    }

    public Nurse(int nurseId, String firstName, String lastName, int nurse_salary, int departmentId, int specializationId) {
        this.nurseId = nurseId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.nurse_salary = nurse_salary;
        this.departmentId = departmentId;
        this.specializationId = specializationId;
    }

    @Override
    public String toString() {
        return "Nurse{" +
                "nurseId=" + nurseId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", nurse_salary=" + nurse_salary +
                ", departmentId=" + departmentId +
                ", specializationId=" + specializationId +
                '}';
    }

    @XmlAttribute(name = "nurse_id")
    public int getNurseId() {
        return nurseId;
    }

    public void setNurseId(int nurseId) {
        this.nurseId = nurseId;
    }

    @XmlElement(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @XmlElement(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @XmlElement(name = "nurse_salary")
    public int getNurseSalary() {
        return nurse_salary;
    }

    public void setNurseSalary(int nurse_salary) {
        this.nurse_salary = nurse_salary;
    }

    @XmlElement(name = "department_id")
    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    @XmlElement(name = "specialization_id")
    public int getSpecializationId() {
        return specializationId;
    }

    public void setSpecializationId(int specializationId) {
        this.specializationId = specializationId;
    }
}
