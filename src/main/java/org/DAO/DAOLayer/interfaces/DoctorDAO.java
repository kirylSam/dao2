package org.DAO.DAOLayer.interfaces;

import org.DAO.ModelObjs.Doctor;

import java.sql.SQLException;
import java.util.List;

public interface DoctorDAO extends MainMyBatisMapper<Doctor> {
    //DAO Layer
    //here specific operations for DAO Object can be specified
    List<Doctor> getAllWithLastName(String lastName) throws SQLException;
}
