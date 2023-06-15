package org.DAO.JAXB;

import org.DAO.DAOLayer.DoctorDAOImpl;
import org.DAO.DAOLayer.interfaces.DoctorDAO;
import org.DAO.ModelObjs.Doctor;
import org.DAO.ModelObjs.Doctors;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.sql.SQLException;
import java.util.List;

public class GenerateXMLsUsingJAXB {

    static Logger logger;
    static {
        logger = LogManager.getLogger("org.DAO.JAXB.GenerateXMLsUsingJAXB");
    }

    public static void generateOneDoctorXML(int doctorId) {
        /*** Obsolete. A generic method generateOneObjectXML(t) can be used instead */

        DoctorDAO doctorDAO = new DoctorDAOImpl();

        JAXBContext context = null;
        Marshaller mar= null;

        try {
            Doctor doctor = doctorDAO.get(doctorId);
            String fileName = "./doctor_" + doctor.getFirstName() + "_" + doctor.getLastName() + ".xml";

            context = JAXBContext.newInstance(Doctor.class);
            mar = context.createMarshaller();
            mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            mar.marshal(doctor, new File(fileName));

            logger.info("[JAXB XML Generator] Added a Doctor with id: " + doctorId + " to the file: " + fileName);
        } catch (JAXBException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static void generateAllDoctorsXML() {
        DoctorDAO doctorDAO = new DoctorDAOImpl();

        List<Doctor> doctorList = null;
        Doctors doctors = new Doctors();

        try {
            doctorList = doctorDAO.getAll();
            doctors.setDoctors(doctorList);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        JAXBContext context = null;
        Marshaller mar= null;
        try {
            context = JAXBContext.newInstance(Doctors.class);
            mar = context.createMarshaller();
            mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            File file = new File("./doctors.xml");
            mar.marshal(doctors, file);

            logger.info("[JAXB XML Generator] Generated a list of all doctors.xml");
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> void generateOneObjectXML (T t) {
        JAXBContext context = null;
        Marshaller mar= null;

        try {
            String fileName =  "./generic_" + t.getClass().getSimpleName() + ".xml";

            context = JAXBContext.newInstance(t.getClass());
            mar = context.createMarshaller();
            mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            mar.marshal(t, new File(fileName));

            logger.info("[JAXB XML Generator] Added a " + t.getClass().getSimpleName() + " to the file: " + fileName);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
