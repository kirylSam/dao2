package org.DAO.ModelObjs;


import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonRootName;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlRootElement(name = "doctor")
@XmlType(propOrder = { "adminPersonelId", "firstName", "lastName", "salary", "departmentId", "roleId" }, namespace = "https://www.example.org/adminp")
@JsonRootName(value = "adminp")
public class AdminP {
    //Data transfer object - only storage and retrieval (no business logic whatsoever)
    //model object
    private int adminPersonelId;
    private String firstName;
    private String lastName;
    private int salary;
    private int departmentId;
    private int roleId;

    public AdminP() {

    }

    public AdminP(String firstName, String lastName, int salary, int departmentId, int roleId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.departmentId = departmentId;
        this.roleId = roleId;
    }

    public AdminP(int adminPersonelId, String firstName, String lastName, int salary, int departmentId, int roleId) {
        this.adminPersonelId = adminPersonelId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.departmentId = departmentId;
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "AdminPersonnel{" +
                "adminPersonelId=" + adminPersonelId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", salary=" + salary +
                ", departmentId=" + departmentId +
                ", roleId=" + roleId +
                '}';
    }

    @XmlAttribute(name = "admin_personel_id")
    @JsonGetter
    public int getAdminPersonelId() {
        return adminPersonelId;
    }

    public void setAdminPersonelIdId(int adminPersonelId) {
        this.adminPersonelId = adminPersonelId;
    }

    @XmlElement(name = "first_name")
    @JsonGetter
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @XmlElement(name = "last_name")
    @JsonGetter
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @XmlElement(name = "salary")
    @JsonGetter
    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @XmlElement(name = "department_id")
    @JsonGetter
    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    @XmlElement(name = "role_id")
    @JsonGetter
    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }
}
