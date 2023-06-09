package org.DAO.DAOLayer.interfaces;

import java.sql.SQLException;
import java.util.List;

public interface DAO <T> {
    //DAO Layer
    //Defines standard operations to be performed on model objects
    //is an abstraction of a class, that will actually hold the persistence logic
    T get(int tId) throws SQLException;

    List<T> getAll() throws SQLException;

    int save(T t) throws SQLException;

    int insert(T t) throws SQLException;

    int update (T t) throws SQLException;

    int delete (T t) throws SQLException;
}
