package org.DAO.ModelObjs.MVC;

public class DoctorController {
    private DoctorView doctorView;
    private DoctorModel doctorModel;

    public DoctorController(DoctorView doctorView, DoctorModel doctorModel) {
        this.doctorView = doctorView;
        this.doctorModel = doctorModel;
    }

    public void setDoctorFirstLastName(String firstName, String lastName) {
        doctorModel.setFirstName(firstName);
        doctorModel.setLastName(lastName);
    }

    public void setDoctorSalarySpecAndDept(int salary, int deptId, int specId) {
        doctorModel.setSalary(salary);
        doctorModel.setDepartmentId(deptId);
        doctorModel.setSpecializationId(specId);
    }

    public String getDoctorFirstName() {
        return doctorModel.getFirstName();
    }

    public String getDoctorLastName() {
        return doctorModel.getLastName();
    }

    public int getDoctorSalary() {
        return doctorModel.getSalary();
    }

    public int getDeptId() {
        return doctorModel.getDepartmentId();
    }

    public int getSpecId() {
        return doctorModel.getSpecializationId();
    }

    public void updateView() {
        doctorView.printDoctorSalary(doctorModel.getFirstName(), doctorModel.getLastName(), doctorModel.getSalary());
    }
}
