package de.htwsaar.persistenz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/* Klasse die die Verbindungen zu den 2 Datenbanken verwaltet. Diese Klasse verfügt über die Connection Strings der Datenbanken
 * und gibt eine Connection zu der entsprechenden Datenbank zurück. Diese wird in der Logic dann benutzt um die jeweiligen Services der Datenbanken
 * zu initialisieren und damit zu arbeiten.
 */
 

public class DatabaseManager {
    private static final String COMPONENTS_DB_URL = "jdbc:sqlite:src/main/resources/PC_ComponentsDB.db";
    private static final String PERSONAL_LIST_DB_URL = "jdbc:sqlite:src/main/resources/PersonalList.db";

    // Gibt Connection zur Components Datenbank zurück

    public static Connection connectComponentsDB() throws SQLException {
        System.out.println("Gebe Komponenten-Connection zurück.");
        return DriverManager.getConnection(COMPONENTS_DB_URL);
    }

    // Gibt Connection zur PersonalList Datenbank zurück

    public static Connection connectPersonalListDB() throws SQLException {
        System.out.println("Gebe PersonalList-Connection zurück.");
        return DriverManager.getConnection(PERSONAL_LIST_DB_URL);
    }
}
