package Test;

import de.htwsaar.servicelayer.Logic;
import de.htwsaar.servicelayer.UserInterface;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LogicStartProgramTest {

    private TestUserInterface testUI;
    private TestableLogic logic;

    // Custom UserInterface implementation for testing
    private class TestUserInterface implements UserInterface {



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
    }


    private class TestableLogic extends Logic {
        private boolean showMainMenuCalled = false;

        public TestableLogic(UserInterface ui) {
            super(ui);
        }

        @Override
        public void showMainMenu() {
            showMainMenuCalled = true;
        }

        public boolean wasShowMainMenuCalled() {
            return showMainMenuCalled;
        }
    }

    @Before
    public void setUp() {
        testUI = new TestUserInterface();
        logic = new TestableLogic(testUI);
    }

    @Test
    public void testStartProgram() {

        logic.startProgram();


        assertTrue("startProgram should call showMainMenu", logic.wasShowMainMenuCalled());
    }
}
