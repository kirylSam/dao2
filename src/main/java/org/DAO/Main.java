package org.DAO;

import org.DAO.DAOLayer.AdminPDAOImpl;
import org.DAO.DAOLayer.NurseDAOImpl;
import org.DAO.DAOLayer.interfaces.AdminPDAO;
import org.DAO.DAOLayer.interfaces.DoctorDAO;
import org.DAO.DAOLayer.DoctorDAOImpl;
import org.DAO.DAOLayer.interfaces.NurseDAO;
import org.DAO.DOM.DOMParser;
import org.DAO.JAXB.GenerateObjFromXMLUsingJAXB;
import org.DAO.JAXB.GenerateXMLsUsingJAXB;
import org.DAO.JAXB.JAXBValidation;
import org.DAO.Jackson.ConvertJSONToModelObj;
import org.DAO.Jackson.ConvertModelObjToJSON;
import org.DAO.ModelObjs.AdminP;
import org.DAO.ModelObjs.Doctor;
import org.DAO.ModelObjs.Nurse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.util.List;

public class Main {
    static Logger logger;
    static {
        logger = LogManager.getLogger("org.DAO.Main");
    }
    public static void main(String[] args) {
        //Presentation layer

        Main main = new Main();
      // main.doctorUsage();
        //main.nursesUsage();
       // main.adminUsage();
       // main.xmlJAXBGenerationUsage();
       //main.XMLtoOBJUsage();
       // main.validateXMLAgainstXSD();
       // main.DOMParserUsage();
       main.convertOBJToJSON();
    //   main.convertJSONToObj();
    }

    public void convertOBJToJSON() {
        /*Doctor doctor = new Doctor(1,"FirstDao", "LastDao", 1, 1, 1);
        ConvertModelObjToJSON.convertObjToJSON(doctor, "jsondoctor.json");

        Nurse nurse = new Nurse(7, "JsonNurse", "JsonNurse", 1000, 2, 2);
        ConvertModelObjToJSON.convertObjToJSON(nurse, "jsonnurse.json");

        AdminP adminP = new AdminP(1, "JsonAdm", "JSONAdmp", 1000, 2, 2);
        ConvertModelObjToJSON.convertObjToJSON(adminP, "jsonadminp.json");*/
        DoctorDAO doctorDAO = new DoctorDAOImpl();
        List<Doctor> doctorList = null;
        try {
            doctorList = doctorDAO.getAll();
           /* for (Doctor doctor: doctorList) {
                //System.out.println(doctor);
                logger.info(doctor);
            }*/
            ConvertModelObjToJSON.convertMultipleObjToJSON(doctorList, "jsonmultipledoctors.json");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void convertJSONToObj(){
        Doctor doctor = (Doctor) ConvertJSONToModelObj.convertJSONFileToObj("jsondoctor.json", Doctor.class);
        logger.info(doctor);

        Nurse nurse = (Nurse) ConvertJSONToModelObj.convertJSONFileToObj("jsonnurse.json", Nurse.class);
        logger.info(nurse);

        AdminP adminP = (AdminP) ConvertJSONToModelObj.convertJSONFileToObj("jsonadminp.json", AdminP.class);
        logger.info(adminP);
    }

    public void validateXMLAgainstXSD() {
        logger.info("Is the doctor.xml correct according to doctor.xsd?");
        logger.info(new JAXBValidation().isValid("doctor.xsd", "doctor.xml"));
    }

    public void DOMParserUsage() {
        List<Doctor> doctors = DOMParser.processFile();
        for (Doctor doctor : doctors) {
            logger.info(doctor);
        }
    }

    public void xmlJAXBGenerationUsage() {
        GenerateXMLsUsingJAXB.generateOneDoctorXML(1);
        GenerateXMLsUsingJAXB.generateAllDoctorsXML();

        Nurse nurse = new Nurse(7, "GenerciNurse", "GenericNurseLast", 1000, 2, 2);
        GenerateXMLsUsingJAXB.generateOneObjectXML(nurse);

        AdminP adminP = new AdminP(1, "AdminP", "AdminP", 1000, 2, 2);
        GenerateXMLsUsingJAXB.generateOneObjectXML(adminP);
    }

    public void XMLtoOBJUsage() {
        Doctor doctor = GenerateObjFromXMLUsingJAXB.unmarshal("doctor_SurgeonName_SurgeonSurname", Doctor.class);
        logger.info(doctor);
        AdminP adminP = GenerateObjFromXMLUsingJAXB.unmarshal("generic_AdminP", AdminP.class);
        logger.info(adminP);
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

     /*   //Create - insert
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
        }*/

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

        /*//Get All with Specific Last Name
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

