package Test;

import de.htwsaar.presentation.Dialog;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.util.Scanner;

import static org.junit.Assert.*;

public class DialogTest {

    private Dialog dialog;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUp() {
        dialog = new Dialog();
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setIn(System.in);
    }

    @Test
    public void testShowMessage() {
        String message = "Test message";
        dialog.showMessage(message);

        assertTrue("Dialog should display the message",
                outContent.toString().contains(message));
    }

    @Test
    public void testIllegalInput() {
        String message = "Illegal input test";

        dialog.showIllegalInput(message);

        String capturedOutput = outContent.toString();
        System.err.println("Captured output: " + capturedOutput);

        assertTrue("Dialog should display the illegal input message",
                capturedOutput.contains(message));
    }

    @Test
    public void testReadMinMaxInput_ValidInput() throws Exception {
        // Simulierte Benutzereingabe (z.B. der Benutzer gibt "2" ein)
        String input = "2\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);


        Field scannerField = Dialog.class.getDeclaredField("scanner");
        scannerField.setAccessible(true);
        scannerField.set(dialog, new Scanner(System.in));

        int result = dialog.readMinMaxInput(1, 3);
        assertEquals("Should return 2 for input '2'", 2, result);
    }

    @Test
    public void testShowMainMenu() throws Exception {
        // Testet, ob das Hauptmenü korrekt angezeigt wird
        provideInput("1");


        dialog.showMainMenu();
        String output = outContent.toString();

        assertTrue("Should display MAIN MENU", output.contains("MAIN MENU"));
        assertTrue("Should display option 1", output.contains("1: Datenbanken auslesen"));
        assertTrue("Should display option 2", output.contains("2: Persönliche Liste"));
        assertTrue("Should display option 3", output.contains("3: Programm verlassen"));
    }


    private void provideInput(String data) throws Exception {
        ByteArrayInputStream testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);

        Field scannerField = Dialog.class.getDeclaredField("scanner");
        scannerField.setAccessible(true);
        scannerField.set(dialog, new Scanner(System.in));
    }
}
