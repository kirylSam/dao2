package org.DAO.ModelObjs.MVC;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DoctorView {
    static Logger logger;

    static {
        logger = LogManager.getLogger("org.DAO.Main");
    }

    public void printDoctorSalary(String firstName, String lastName, int salary) {
        logger.info("[View]: Doctor: " + firstName + " " + lastName + " has a salary of: " + salary);
    }
}
