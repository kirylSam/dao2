package org.DAO.DOM;

import org.DAO.ModelObjs.Doctor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class DOMParser {

    static Logger logger;
    static {
        logger = LogManager.getLogger("org.DAO.JAXB.GenerateXMLsUsingJAXB");
    }

    private static final String FILENAME = "src/main/resources/doctors.xml";

    public static List<Doctor> processFile() {

        // Instantiate the Factory
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        List<Doctor> doctors = new ArrayList<>();

        try {
            dbf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);

            // parse XML file
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(new File(FILENAME));
            doc.getDocumentElement().normalize();

            // get <doctor>
            NodeList list = doc.getElementsByTagName("doctor");

            for (int temp = 0; temp < list.getLength(); temp++) {
                Node node = list.item(temp);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    // get doctor's attribute
                    int id = Integer.parseInt(element.getAttribute("doctor_id"));

                    // get text
                    String firstname = element.getElementsByTagName("first_name").item(0).getTextContent();
                    String lastname = element.getElementsByTagName("last_name").item(0).getTextContent();
                    int salary = Integer.parseInt(element.getElementsByTagName("salary").item(0).getTextContent());
                    int departmentId = Integer.parseInt(element.getElementsByTagName("department_id").item(0).getTextContent());
                    int specializationId = Integer.parseInt(element.getElementsByTagName("specialization_id").item(0).getTextContent());

                    doctors.add(new Doctor(id, firstname, lastname, salary, departmentId, specializationId));
                }
            }

        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
        return doctors;
    }
}