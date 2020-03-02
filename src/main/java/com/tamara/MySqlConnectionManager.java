package com.tamara;

import org.w3c.dom.ls.LSOutput;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MySqlConnectionManager {

    private Connection conn;

    public MySqlConnectionManager() {
        try {
            this.conn = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "root");
        } catch (SQLException e) {
            System.out.println("ERROR: could not create connection to db");
            e.printStackTrace();
        }
    }

    public ResultSet executeSqlQuery(String sqlQuery) {
        try {
            return conn.createStatement().executeQuery(sqlQuery);
        } catch (SQLException e) {
            System.out.println("ERROR, unable to query db");

            return null;
        }

    }

    public void close(){
        try {
            this.conn.close();
        } catch (SQLException e) {
            System.out.println("ERROR: could not close connection");
            e.printStackTrace();
        }
    }


}
