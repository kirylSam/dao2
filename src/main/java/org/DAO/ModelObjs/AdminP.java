package org.DAO.ModelObjs;

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

    public int getAdminPersonelIdId() {
        return adminPersonelId;
    }

    public void setAdminPersonelIdId(int adminPersonelId) {
        this.adminPersonelId = adminPersonelId;
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

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }
}
