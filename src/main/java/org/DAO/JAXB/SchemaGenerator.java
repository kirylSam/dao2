package org.DAO.JAXB;

import org.DAO.ModelObjs.Doctor;

import javax.xml.bind.*;
import javax.xml.transform.Result;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;

public class SchemaGenerator {
    public static <T> void generateSchema(Class<T> type, String filename) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(type);

            SchemaOutputResolver outputResolver = new MySchemaOutputResolver(filename);
            jaxbContext.generateSchema(outputResolver);
        } catch (IOException | JAXBException e) {
            e.printStackTrace();
        }
    }

    private static class MySchemaOutputResolver extends SchemaOutputResolver {
        private final String suggestedFileName;
        private static final String NAMESPACE_URI = "https://www.example.org/doctor";

        public MySchemaOutputResolver(String suggestedFileName) {
            this.suggestedFileName = suggestedFileName;
        }

        @Override
        public Result createOutput(String namespaceURI, String suggestedFileName) throws IOException {
            File file = new File(this.suggestedFileName);
            StreamResult result = new StreamResult(file);
            result.setSystemId(file.toURI().toURL().toString());

            // Set the namespace URI for the XSD file
            result.setSystemId(NAMESPACE_URI);

            return result;
        }
    }
}