package com.oocl.ir4.gipp.backend.transaction;

import com.oocl.ir4.gipp.backend.DatabaseConnection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PairingTransaction {

    private String result;

    public PairingTransaction() {
    }

    public void execute() {
        this.setResult("tests");
        DatabaseConnection db = new DatabaseConnection();
        db.startConnection();

        String insertQuery = "INSERT INTO PAIRING_MEMBERS ([MEMBER]) VALUES (?)";
        PreparedStatement st = null;
        try {
            st = db.getConnection().prepareStatement (insertQuery);
            st.setString(1, "kat");
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        db.closeConnection();
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
