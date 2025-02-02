package de.htwsaar.presentation;
import java.util.Scanner;

import de.htwsaar.servicelayer.Logic;
public class Dialog {

    private Scanner scanner;
    Logic logic;


    public Dialog() {
        scanner = new Scanner(System.in);
        logic = null;


    }

    public void start() {
        logic = new Logic();
        System.out.println("Initiere Datenbanken...");
        logic.initiateLists();
        System.out.println("Lade bestehende Listen...");
        logic.loadPersonalListsFromFile("Projektarbeit\\src\\ServiceLayer\\PersonalListsSave.txt");
        System.out.println("Datenbanken erfolgreich initialisiert.");
        System.out.println("=====================================================");
        System.out.println("Willkommen beim PC-Konfigurator!");
        System.out.println("Wie kann ich Ihnen helfen?");
        showMainMenu(scanner);
        scanner.close();

    }

    public void showMainMenu(Scanner scanner) {
        System.out.println("1: Datenbanken ");
        System.out.println("2: Persönliche Liste");
        System.out.println("3: Programm verlassen");
        System.out.println("Bitte geben Sie eine Zahl an.");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                showDatabaseMenu(scanner);
                break;
            case 2:
                showPersonalListMenu(scanner);
                break;
            case 3:
                logic.savePersonalListTOFile("Projektarbeit\\src\\ServiceLayer\\PersonalListsSave.txt");
                break;
            default:
                System.out.println("Ungültige Eingabe. Bitte versuchen Sie es erneut.");
                showMainMenu(scanner);

        }

    }
    public void showDatabaseMenu(Scanner scanner) {
        System.out.println("Bitte geben Sie eine Kategorie an.");
        System.out.println("1: GPU");
        System.out.println("2: CPU");
        System.out.println("3: RAM");
        System.out.println("4: Netzteil");
        System.out.println("5: Mainboard");
        System.out.println("6: Gehäuse");
        System.out.println("7: Zurück zum Hauptmenü");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                logic.printGPUDatabase();
                break;
            case 2:
                logic.printCPUDatabase();
                break;
            case 3:
                logic.printRAMDatabase();
                break;
            case 4:
                logic.printPowerUnitDatabase();
                break;
            case 5:
                logic.printMainboardDatabase();
                break;
            case 6:
                logic.printComputerCaseDatabase();
                break;
            case 7:
                showMainMenu(scanner);
                break;
            default:
                System.out.println("Ungültige Eingabe. Bitte versuchen Sie es erneut.");
        }
        showDatabaseMenu(scanner);
    }

    public void showPersonalListMenu(Scanner scanner) {
        System.out.println("Bitte geben Sie eine Zahl an.");
        System.out.println("1: Persönliche Listen anzeigen");
        System.out.println("2: Persönliche Liste erstellen");
        System.out.println("3: Persönliche Liste löschen");
        System.out.println("4: Zurück zum Hauptmenü");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                System.out.println("Alle Listen:");
                logic.printPersonalLists();
                break;
            case 2:
                createPersonalListMenu();
                break;
            case 3:
                System.out.println("Welche Liste möchten Sie löschen?");
                logic.deletePersonalList(scanner);
                break;
            case 4:
                break;
            default:
                System.out.println("Ungültige Eingabe. Bitte versuchen Sie es erneut.");
        }

        showMainMenu(scanner);
    }

    public void createPersonalListMenu() {
        System.out.println("Wähle eine ID für deine Liste (ID muss zwischen 1 und 3 liegen):");
        int choiceID = scanner.nextInt();
        if (choiceID > 3) {
            System.out.println("Die ID darf maximal 3 sein.");
            createPersonalListMenu();
        }

        System.out.println("Wähle eine GPU:");
        logic.printGPUDatabase();
        int choiceGPU = scanner.nextInt();
        System.out.println("Wähle eine CPU:");
        logic.printCPUDatabase();
        int choiceCPU = scanner.nextInt();
        System.out.println("Wähle eine RAM:");
        logic.printRAMDatabase();
        int choiceRAM = scanner.nextInt();
        System.out.println("Wähle ein Mainboard:");
        logic.printMainboardDatabase();
        int choiceMainboard = scanner.nextInt();
        System.out.println("Wähle ein Gehäuse:");
        logic.printComputerCaseDatabase();
        int choiceComputerCase = scanner.nextInt();
        System.out.println("Wähle ein Netzteil:");
        logic.printPowerUnitDatabase();
        int choicePowerUnit = scanner.nextInt();

        logic.createPersonalList(choiceID, choiceGPU, choiceCPU, choiceRAM, choicePowerUnit, choiceComputerCase, choiceMainboard);

        System.out.println("Liste erfolgreich erstellt.");

    }



}

