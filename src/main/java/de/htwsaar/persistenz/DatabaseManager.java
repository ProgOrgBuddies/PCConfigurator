package de.htwsaar.persistenz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {
    private static final String COMPONENTS_DB_URL = "jdbc:sqlite:src/main/resources/PC_ComponentsDB.db";
    private static final String PERSONAL_LIST_DB_URL = "jdbc:sqlite:src/main/resources/PersonalList.db";

    public static Connection connectComponentsDB() throws SQLException {
        System.out.println("Gebe Komponenten-Connection zurück.");
        return DriverManager.getConnection(COMPONENTS_DB_URL);
    }

    public static Connection connectPersonalListDB() throws SQLException {
        System.out.println("Gebe PersonalList-Connection zurück.");
        return DriverManager.getConnection(PERSONAL_LIST_DB_URL);
    }
}
