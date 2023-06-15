package org.DAO.JAXB;

import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class JAXBValidation {
    private Validator initValidator(String xsdFilePath) {
        SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Source schemaFile = new StreamSource(getFile(xsdFilePath));
        Schema schema = null;
        try {
            schema = factory.newSchema(schemaFile);
        } catch (SAXException e) {
            e.printStackTrace();
        }
        return schema.newValidator();
    }

    private File getFile(String location) {
        return new File(getClass().getClassLoader().getResource(location).getFile());
    }

    public boolean isValid(String xsdFilePath, String xmlFilePath) {
        Validator validator = initValidator(xsdFilePath);
        try {
            validator.validate(new StreamSource(getFile(xmlFilePath)));
        } catch (IOException | SAXException e) {
            e.printStackTrace();
        }
        return true;
    }
}
