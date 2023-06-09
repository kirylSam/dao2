package org.DAO.DAOLayer.interfaces;

import org.DAO.ModelObjs.Nurse;

import java.sql.SQLException;
import java.util.List;

public interface NurseDAO extends DAO<Nurse> {
    //DAO Layer
    //here specific operations for DAO Object can be specified
    List<Nurse> getAllWithSalaryHigherThan(int salary) throws SQLException;
}
