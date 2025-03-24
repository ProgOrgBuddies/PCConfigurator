package Test;

import de.htwsaar.servicelayer.Logic;
import de.htwsaar.servicelayer.PersonalList;
import de.htwsaar.servicelayer.UserInterface;
import de.htwsaar.servicelayer.components.*;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Field;
import java.util.HashMap;

import static org.junit.Assert.*;

public class LogicCreatePersonalListTest {

    private MessageRecordingUI testUI;
    private Logic logic;


    private class MessageRecordingUI implements UserInterface {


        private String lastIllegalInput;
        private String lastMessage;

        @Override
        public void illegalInput(String message) {
            lastIllegalInput = message;
        }

        @Override
        public void showMessage(String message) {
            lastMessage = message;
        }

        @Override
        public int readMinMaxInput(int min, int max) {
            return 1; 
        }

        @Override
        public int createPersonalListMenu() {

            return 1;
        }

        public String getLastIllegalInput() {
            return lastIllegalInput;
        }

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

    @Before
    public void setUp() {
        testUI = new MessageRecordingUI();
        logic = new Logic(testUI);
    }

    @Test
    public void testCreatePersonalList_TooManyLists() throws Exception {

        Field personalListsField = Logic.class.getDeclaredField("personalLists");
        personalListsField.setAccessible(true);

// Erstellt eine Test-Datenstruktur mit vier persönlichen Listen (mehr als erlaubt)
        HashMap<Integer, PersonalList> testLists = new HashMap<>();


        GPU dummyGPU = new GPU(1, "Test GPU", "NVIDIA", 150.0f);
        CPU dummyCPU = new CPU(1, "Test CPU", "Intel", 65.0f);
        RAM dummyRAM = new RAM(1, "Test RAM", "8GB", 50.0f);
        PowerUnit dummyPower = new PowerUnit(1, "Test Power", "500W", 80.0f);
        ComputerCase dummyCase = new ComputerCase(1, "Test Case", "ATX", 70.0f);
        Mainboard dummyMainboard = new Mainboard(1, "Test Mainboard", "ATX", 120.0f);


        for (int i = 0; i < 4; i++) {
            testLists.put(i, new PersonalList(i, dummyGPU, dummyCPU, dummyRAM, dummyPower, dummyCase, dummyMainboard));
        }


        personalListsField.set(logic, testLists);


        logic.createPersonalList();


        assertEquals(
                "Sie haben bereits 3 persönliche Listen erstellt. Bitte löschen Sie eine, um eine neue zu erstellen.",
                testUI.getLastIllegalInput()
        );
    }

}
