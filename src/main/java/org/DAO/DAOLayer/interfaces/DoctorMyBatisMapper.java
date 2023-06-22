package org.DAO.DAOLayer.interfaces;

import org.DAO.ModelObjs.Doctor;
import org.DAO.ModelObjs.Doctor;

import java.sql.SQLException;
import java.util.List;

public interface DoctorMyBatisMapper extends MainMyBatisMapper<Doctor> {
    Doctor get(int doctorID) throws SQLException;

    List<Doctor> getAll() throws SQLException;

    void insert(Doctor doctorID) throws SQLException;

    void update (Doctor doctorID) throws SQLException;

    void delete (Doctor doctorID) throws SQLException;
}
