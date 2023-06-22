package org.DAO.DAOLayer.interfaces;

import org.DAO.ModelObjs.Nurse;
import org.DAO.ModelObjs.Nurse;

import java.sql.SQLException;
import java.util.List;

public interface NurseMyBatisMapper extends MainMyBatisMapper<Nurse> {
    Nurse get(int nurseID) throws SQLException;

    List<Nurse> getAll() throws SQLException;

    void insert(Nurse nurseID) throws SQLException;

    void update (Nurse nurseID) throws SQLException;

    void delete (Nurse nurseID) throws SQLException;
}
