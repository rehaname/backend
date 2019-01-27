package com.oocl.ir4.gipp.backend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DatabaseConnection {

    private Connection connection = null;
    private Statement statement = null;
    private ResultSet resultSet = null;

    public void startConnection() {
        // variables

        // Step 1: Loading or registering Oracle JDBC driver class
        try {

            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        } catch (ClassNotFoundException cnfex) {

            System.out.println("Problem in loading or "
                    + "registering MS Access JDBC driver");
            cnfex.printStackTrace();
        }

        // Step 2: Opening database connection
        try {

            String msAccDB = "C:/Users/Ana Katrina De Leon/Documents/Work/Repo/ITSGSP_Tools/hamster1.accdb";
            String dbURL = "jdbc:ucanaccess://" + msAccDB;

            // Step 2.A: Create and get connection using DriverManager class
            connection = DriverManager.getConnection(dbURL);

            // Step 2.B: Creating JDBC Statement
            statement = connection.createStatement();

            // Step 2.C: Executing SQL & retrieve data into ResultSet
            resultSet = statement.executeQuery("SELECT * FROM PAIRING_MEMBERS");
            System.out.println("Test CONNECTION");

            // processing returned data and printing into console
            while (resultSet.next()) {
                System.out.println(resultSet.getInt(1) + "\t" +
                        resultSet.getString(2));
            }
        } catch (SQLException sqlex) {
            sqlex.printStackTrace();
        }
    }

    public void closeConnection(){
        // Step 3: Closing database connection
        try {
            if (null != connection) {

                // cleanup resources, once after processing
                resultSet.close();
                statement.close();

                // and then finally close connection
                connection.close();
            }
        } catch (SQLException sqlex) {
            sqlex.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
