package org.DAO;

import org.DAO.DAOLayer.AdminPDAOImpl;
import org.DAO.DAOLayer.NurseDAOImpl;
import org.DAO.DAOLayer.interfaces.AdminPDAO;
import org.DAO.DAOLayer.interfaces.DoctorDAO;
import org.DAO.DAOLayer.DoctorDAOImpl;
import org.DAO.DAOLayer.interfaces.NurseDAO;
import org.DAO.ModelObjs.AdminP;
import org.DAO.ModelObjs.Doctor;
import org.DAO.ModelObjs.Nurse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.util.List;

public class Main {
    static Logger logger;
    public static void main(String[] args) {
        //Presentation layer
        logger = LogManager.getLogger("org.DAO.Main");
        Main main = new Main();
        main.doctorUsage();
        main.nursesUsage();
        main.adminUsage();
    }

    public void doctorUsage() {
        logger = LogManager.getLogger("org.DAO.Main");

        DoctorDAO doctorDAO = new DoctorDAOImpl();
        //Retrieve - get
        try {
            Doctor doctor = doctorDAO.get(14);
            logger.info(doctor);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

       /* //Create - insert
         Doctor doctor = new Doctor("FirstDao", "LastDao", 1, 1, 1);
        try {
            int result = doctorDAO.insert(doctor);
            System.out.println(result);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        //update
        Doctor doctor = new Doctor(16, "ChangedFirst", "ChangedLast", 100000, 2, 2);
        try {
            int result = doctorDAO.update(doctor);
            System.out.println(result);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        //Delete
        try {
            Doctor doctor = doctorDAO.get(16);
            System.out.println(doctor);
            int result = doctorDAO.delete(doctor);
            System.out.println(result);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        //Get all
        try {
           List<Doctor> doctorList = doctorDAO.getAll();
            for (Doctor doctor: doctorList) {
                //System.out.println(doctor);
                logger.info(doctor);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        //Get All with Specific Last Name
        try {
            List<Doctor> doctorList = doctorDAO.getAllWithLastName("LabGuySurname");
            for (Doctor doctor: doctorList) {
                logger.info(doctor);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }*/
    }


    public void nursesUsage() {
        logger = LogManager.getLogger("org.DAO.Main");
        NurseDAO nurseDAO = new NurseDAOImpl();

        //Get All with salary higher than
        try {
            List<Nurse> nurseList = nurseDAO.getAllWithSalaryHigherThan(9000);
            for (Nurse nurse: nurseList) {
                logger.info(nurse);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void adminUsage() {
        logger = LogManager.getLogger("org.DAO.Main");
        AdminPDAO adminPDAO = new AdminPDAOImpl();

        //Get All
        try {
            List<AdminP> adminPList = adminPDAO.getAll();
            for (AdminP adminP: adminPList) {
                logger.info(adminP);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}

