package org.DAO.DAOLayer.interfaces;

import java.sql.SQLException;
import java.util.List;

public interface MainMyBatisMapper <T> {
    //DAO Layer
    //Defines standard operations to be performed on model objects
    //is an abstraction of a class, that will actually hold the persistence logic
    T get(int tId) throws SQLException;

    List<T> getAll() throws SQLException;

    void insert(T t) throws SQLException;

    void update (T t) throws SQLException;

    int delete (T t) throws SQLException;
}
