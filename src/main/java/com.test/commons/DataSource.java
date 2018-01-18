package com.test.commons;


import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSource {

     private static final String URL="jdbc:mysql://localhost:3306/demo?autoReconnect=true&useSSL=false&useLegacyDatetimeCode=false&serverTimezone=UTC";
     private static final String USERNAME="root";
     private static final String PASSWORD="root";

    static {
        try {
            Driver driver = new com.mysql.cj.jdbc.Driver();
            DriverManager.registerDriver(driver);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){
        Connection connection=null;
        try {
            connection=DriverManager.getConnection(URL,USERNAME,PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

}
