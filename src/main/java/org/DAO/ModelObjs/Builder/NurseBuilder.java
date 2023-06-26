package org.DAO.ModelObjs.Builder;

import org.DAO.ModelObjs.Nurse;

public class NurseBuilder {
    private Nurse nurse;

    public NurseBuilder() {
        this.nurse = new Nurse();
    }

    public NurseBuilder buildNurseId(int nurseId) {
        nurse.setNurseId(nurseId);
        return this;
    }

    public NurseBuilder buildFirstName(String firstName) {
        nurse.setFirstName(firstName);
        return this;
    }

    public NurseBuilder buildLastName(String lastName) {
        nurse.setLastName(lastName);
        return this;
    }

    public NurseBuilder buildSalary(int salary) {
        nurse.setNurseSalary(salary);
        return this;
    }

    public NurseBuilder buildDepartmentId(int deptId) {
        nurse.setDepartmentId(deptId);
        return this;
    }

    public NurseBuilder buildSpecId(int specId) {
        nurse.setSpecializationId(specId);
        return this;
    }

    public Nurse getNurse() {
        return nurse;
    }
}
