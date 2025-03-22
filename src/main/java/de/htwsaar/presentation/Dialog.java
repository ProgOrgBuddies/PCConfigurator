package de.htwsaar.presentation;
import java.util.Scanner;

import de.htwsaar.servicelayer.Logic;
public class Dialog extends UserInterface {

    private Scanner scanner;
    Logic logic;


    public Dialog() {
        scanner = new Scanner(System.in);

    }

    // Startet das Programm

    public void start() {
        logic = new Logic(this);
        logic.startProgram();

    }

    // Zeigt das MainMenu an und gibt einen passenden int zurück, der in der Logic benutzt wird um weiteren Ablauf zu regulieren

    public int showMainMenu() {
        System.out.println("==== MAIN MENU ====");
        System.out.println("1: Datenbanken auslesen");
        System.out.println("2: Persönliche Liste");
        System.out.println("3: Programm verlassen");
        System.out.println("Bitte geben Sie eine Zahl an.");
        return readMinMaxInput(1, 3);

    }

    // Zeigt das DatabaseMenu an und gibt einen passenden int zurück, der in der Logic benutzt wird um weiteren Ablauf zu regulieren

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

    // Zeigt das PersonalListMenu an und gibt einen passenden int zurück, der in der Logic benutzt wird um weiteren Ablauf zu regulieren

    public int showPersonalListMenu() {
        System.out.println("==== PERSONAL LIST MENU ====");
        System.out.println("Bitte geben Sie eine Kategorie an.");
        System.out.println("1: Bestehende Listen auslesen.");
        System.out.println("2: Neue Liste erstellen.");
        System.out.println("3: Bestehende Liste löschen.");
        System.out.println("4: Zurück zum Hauptmenü.");
        return readMinMaxInput(1, 4);

    }

    //Hilfsmethode die einen Input zwischen min und einem max returnt

    public int readMinMaxInput(int min, int max) {
        while (true) {
            System.out.println("Eingabe:");
            if (!scanner.hasNextInt()) {
                scanner.next();
                illegalInput("Bitte geben Sie eine Zahl an.");
                continue;
            }
            int choice = scanner.nextInt();
            if (choice >= min && choice <= max) {
                return choice;
            } else {
                illegalInput("Ungültige Auswahl, bitte erneut eingeben!");
            }
        }
    }

    // Frägt den Benutzer nach einer ID für eine Liste und gibt diese zurück

    public int createPersonalListMenu() {
        System.out.println("Wähle eine ID für deine Liste (ID muss zwischen 1 und 3 liegen):");
        return readMinMaxInput(1, 3);

    }

    // Methode um Missinput von Benutzern auszudrücken 

    public void illegalInput(String message) {
        System.out.println(message);
    }

    // Methode um eine Nachricht auf dem CLI zu zeigen

    public void showMessage(String message) {
        System.out.println(message);
    }

    public void showIllegalInput(String message) {
        System.out.println(message);
    }
    public void showError(String message){

    }
}

