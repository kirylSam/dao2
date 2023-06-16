package org.DAO.Jackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;

public class ConvertJSONToModelObj {
    static Logger logger;
    static {
        logger = LogManager.getLogger("org.DAO.Jackson.ConvertJSONToModelObj");
    }

    public static <T> Object convertJSONFileToObj(String fileName, Class<T> type){
        ObjectMapper mapper = new ObjectMapper();

        try {
            // JSON file to Java object
            Object obj = mapper.readValue(new File(fileName), type);
            return obj;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static <T> Object convertJSONStringToObj(String jsonString, Class<T> type){
        ObjectMapper mapper = new ObjectMapper();

        try {
            // JSON string to Java object
            Object obj = mapper.readValue(jsonString, type);
            return obj;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
