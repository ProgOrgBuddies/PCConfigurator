package de.htwsaar.presentation;
import java.util.Scanner;

import de.htwsaar.servicelayer.Logic;
public class Dialog extends UserInterface {

    private Scanner scanner;
    Logic logic;


    public Dialog() {
        scanner = new Scanner(System.in);

    }

    public void start() {
        logic = new Logic(this);
        logic.startProgramm();

    }

    public int showMainMenu() {
        System.out.println("==== MAIN MENU ====");
        System.out.println("1: Datenbanken auslesen");
        System.out.println("2: Persönliche Liste");
        System.out.println("3: Programm verlassen");
        System.out.println("Bitte geben Sie eine Zahl an.");
        return readMinMaxInput(1, 3);

    }
    public int showDatabaseMenu() {
        System.out.println("==== DATABASE MENU ====");
        System.out.println("Bitte geben Sie eine Kategorie an.");
        System.out.println("1: GPU");
        System.out.println("2: CPU");
        System.out.println("3: RAM");
        System.out.println("4: Netzteil");
        System.out.println("5: Mainboard");
        System.out.println("6: Gehäuse");
        System.out.println("7: Zurück zum Hauptmenü");
        return readMinMaxInput(1, 7);

    }

    //Hilfsmethode die einen Input zwischen 0 und einem max returnt
    public int readMinMaxInput(int min, int max) {
        int result = -1;
        while (true) {
            System.out.println("Eingabe:");
            if (!scanner.hasNextInt()) {
                scanner.next();
                IllegalInput("Bitte geben Sie eine Zahl an.");
                continue;
            }
            int choice = scanner.nextInt();
            if (choice >= min && choice <= max) {
                return choice;
            } else {
                IllegalInput("Ungültige Auswahl, bitte erneut eingeben!");
            }
        }
    }

    public int showPersonalListMenu() {
        System.out.println("Bitte geben Sie eine Zahl an.");
        System.out.println("1: Persönliche Listen anzeigen");
        System.out.println("2: Persönliche Liste erstellen");
        System.out.println("3: Persönliche Liste löschen");
        System.out.println("4: Zurück zum Hauptmenü");
        return readMinMaxInput(1, 4);
    }

    public int createPersonalListMenu() {
        System.out.println("Wähle eine ID für deine Liste (ID muss zwischen 1 und 3 liegen):");
        return readMinMaxInput(1, 3);

    }

    @Override
    public void IllegalInput(String message) {
        System.out.println(message);
    }

    public void showMessage(String message) {
        System.out.println(message);
    }



}

