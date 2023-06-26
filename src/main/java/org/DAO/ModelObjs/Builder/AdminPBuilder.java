package org.DAO.ModelObjs.Builder;

import org.DAO.ModelObjs.AdminP;

public class AdminPBuilder {
    private AdminP adminP;

    public AdminPBuilder() {
        this.adminP = new AdminP();
    }

    public AdminPBuilder buildAdminPId(int adminPId) {
        adminP.setAdminPersonelIdId(adminPId);
        return this;
    }

    public AdminPBuilder buildFirstName(String firstName) {
        adminP.setFirstName(firstName);
        return this;
    }

    public AdminPBuilder buildLastName(String lastName) {
        adminP.setLastName(lastName);
        return this;
    }

    public AdminPBuilder buildSalary(int salary) {
        adminP.setSalary(salary);
        return this;
    }

    public AdminPBuilder buildDepartmentId(int deptId) {
        adminP.setDepartmentId(deptId);
        return this;
    }

    public AdminPBuilder buildRoleId(int roleId) {
        adminP.setRoleId(roleId);
        return this;
    }

    public AdminP getAdminP() {
        return adminP;
    }
}
