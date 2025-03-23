package Test;

import de.htwsaar.servicelayer.Logic;
import de.htwsaar.servicelayer.UserInterface;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;

import static org.junit.Assert.*;

public class LogicDatabaseConnectionTest {

    private UserInterface mockUI;
    private Logic logic;

    @Before
    public void setUp() {

        mockUI = new UserInterface() {


            @Override
            public void illegalInput(String message) {}

            @Override
            public void showMessage(String message) {}

            @Override
            public int readMinMaxInput(int min, int max) {
                return min;
            }

            @Override
            public int createPersonalListMenu() {

                return 1;
            }

            @Override
            public int showMainMenu() {
                return 0;
            }

            @Override
            public int showDatabaseMenu() {
                return 0;
            }

            @Override
            public int showPersonalListMenu() {

                return 0;
            }
        };

        logic = new Logic(mockUI);
    }

    @Test
    public void testConnectToComponentDatabase() {
        Connection connection = logic.connectToComponentDatabase();

        assertNotNull("Verbindung zur Komponenten Datenbank ist null" , connection);
    }

    @Test
    public void testConnectToPersonalListDatabase() {
        Connection connection = logic.connectToPersonalListDatabase();

        assertNotNull("Verbindung zur PersonalList Datenbank ist null", connection);
    }
}
