package org.DAO.Connection;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;
import java.util.concurrent.Semaphore;


public class ConnectionFactory {
    private static final String PROPERTIES_FILE = "src/main/resources/db.properties";

    //HikariCP
    private static final HikariDataSource dataSource;

    static {
        System.out.println("Static block was initialized");
        Properties properties = new Properties();
        try (FileInputStream fileInputStream = new FileInputStream(PROPERTIES_FILE)) {
            properties.load(fileInputStream);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(properties.getProperty("DATABASE_URL"));
        config.setUsername(properties.getProperty("USERNAME"));
        config.setPassword(properties.getProperty("PASSWORD"));
        config.setMaximumPoolSize(4); // maximum pool size

        dataSource = new HikariDataSource(config);
    }

    public static Connection getConnection() {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void closeConnection(Connection connection) throws SQLException {
        connection.close();
    }

    public static void closeStatement(Statement statement) throws SQLException {
        statement.close();
    }

    public static void closePreparedStatement(PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.close();
    }

    public static void closeResultSet(ResultSet resultSet) throws SQLException {
        resultSet.close();
    }
}