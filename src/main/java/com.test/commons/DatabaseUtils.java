package com.test.commons;


import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtils {

     static final String insertSQL="insert into employee (name, surname, date_of_receipt) values (?,?,?);";
     static final String selectSQL="select * from employee";
     static final String deleteSQL="delete from employee where id=?";
     static final String updateSQL="update employee set name=?, surname=?, date_of_birth=? where id=?";

     static final String URL="jdbc:mysql://localhost:3306/demo?autoReconnect=true&useSSL=false&useLegacyDatetimeCode=false&serverTimezone=UTC";
     static final String USERNAME="root";
     static final String PASSWORD="root";

    private static Driver driver;
    static {
        try {
            driver = new com.mysql.cj.jdbc.Driver();
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
