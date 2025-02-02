package de.htwsaar.persistenz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {
    private static final String URL = "jdbc:sqlite:src/main/resources/PC_ComponentsDB.db";

    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(URL);
    }
}
