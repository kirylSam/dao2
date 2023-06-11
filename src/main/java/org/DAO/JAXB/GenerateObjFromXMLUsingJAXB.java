package org.DAO.JAXB;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class GenerateObjFromXMLUsingJAXB {
    static Logger logger;
    static {
        logger = LogManager.getLogger("org.DAO.JAXB.GenerateObjFromXMLUsingJAXB");
    }

    public static <T> T unmarshal(String fileName, Class<T> type) {
        /***
         * Accepts fileName (to be provided as "Doctor" or "fileName_name" (without extension)) and
         * the Class
         * Returns the object of this class created from a xml
         */
        JAXBContext context = null;
        try {
            context = JAXBContext.newInstance(type);
            return type.cast(context.createUnmarshaller().unmarshal(new FileReader("./" + fileName + ".xml")));
        } catch (JAXBException | FileNotFoundException | ClassCastException e) {
            e.printStackTrace();
        }
        return null;
    }
}
