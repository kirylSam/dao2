package org.DAO.Jackson;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SequenceWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ConvertModelObjToJSON {
    static Logger logger;

    static {
        logger = LogManager.getLogger("org.DAO.Jackson.ConvertModelObjToJSON");
    }

    public static <T> void convertObjToJSON(T t, String fileName) {
        ObjectMapper mapper = new ObjectMapper();

        try {
            // Java object to JSON file
            mapper.disable(SerializationFeature.WRAP_ROOT_VALUE);
            mapper.writeValue(new File(fileName), t);
            // pretty-print
            String jsonString2 = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(t);
            logger.info(jsonString2);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> void convertMultipleObjToJSON(List<T> list, String fileName) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(SerializationFeature.WRAP_ROOT_VALUE);
        File jsonFile = new File(fileName);

        try {
            FileWriter fileWriter = new FileWriter(jsonFile, true);
            SequenceWriter seqWriter = mapper.writer().writeValuesAsArray(fileWriter);
            for (Object obj : list) {
                seqWriter.write(obj);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
