package org.DAO.DAOLayer.interfaces;

import org.DAO.ModelObjs.AdminP;

import java.sql.SQLException;
import java.util.List;

public interface AdminPMyBatisMapper extends MainMyBatisMapper<AdminP> {
    AdminP get(int adminPID) throws SQLException;

    List<AdminP> getAll() throws SQLException;

    void insert(AdminP adminPID) throws SQLException;

    void update (AdminP adminPID) throws SQLException;

    void delete (AdminP adminPID) throws SQLException;
}
