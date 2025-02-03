package de.htwsaar.servicelayer;
import java.util.HashMap;
import java.util.Map;

import de.htwsaar.servicelayer.components.*;
import de.htwsaar.persistenz.*;

import java.sql.Connection;
import java.sql.SQLException;


public class Logic {

    Map<Integer, PersonalList> personalLists = new HashMap<>();
    private final ComponentService componentService;
    private UserInterface ui;

    public Logic (UserInterface ui) {
        componentService = new ComponentService(connectToDatabase());
        this.ui = ui;
    }

    public Connection connectToDatabase() {
        try {
            Connection connection = DatabaseManager.connect();
            System.out.println("Connected to database");
            return connection;
        } catch (SQLException e) {
            System.err.println("Fehler bei der Datenbankverbindung: " + e.getMessage());
        }
        return null;
    }

    public void startProgramm() {
        showMainMenu();

    }
    public void showMainMenu() {
        int input = ui.showMainMenu();
        switch (input) {
            case 1:
                showDatabaseMenu();
                break;
            case 2:
                showPersonalListMenu();
                break;
            case 3:
                return;
            default:
                ui.IllegalInput("Error");
        }
    }
    public void showDatabaseMenu() {
        int input = ui.showDatabaseMenu();
        switch (input) {
            case 1 -> componentService.getAllGPUComponents();
            case 2 -> componentService.getAllCPUComponents();
            case 3 -> componentService.getAllRAMComponents();
            case 4 -> componentService.getAllPowerUnitComponents();
            case 5 -> componentService.getAllMainboardComponents();
            case 6 -> componentService.getAllCaseComponents();
            default -> ui.showMessage("Ungültige Auswahl! Bitte eine Zahl zwischen 0 und 5 eingeben.");
        }
    }
    public void showPersonalListMenu() {
        int choice = ui.showPersonalListMenu();
        switch (choice) {
            case 1 -> printPersonalLists();
            case 2 -> createPersonalList();
            case 3 -> deletePersonalList();
            case 4 -> showMainMenu();
            default -> ui.IllegalInput("Ungültige Auswahl.");
        }

    }

    public void printPersonalLists() {
        personalLists.forEach((id, personalList) -> System.out.println("ID: " + id + ", List: " + personalList));
    }

    public void createPersonalList() {
        if (personalLists.size() > 3) {
            ui.IllegalInput("Sie haben bereits 3 persönliche Listen erstellt. Bitte löschen Sie eine, um eine neue zu erstellen.");
            return;
        }

        ui.showMessage("Bitte wähle eine ID für deine Liste:");
        int choiceID = ui.readMinMaxInput(1, 3);


        CPU selectedCPU = selectComponent(CPU.class, 0);
        GPU selectedGPU = selectComponent(GPU.class, 1);
        RAM selectedRAM = selectComponent(RAM.class, 2);
        Mainboard selectedMainboard = selectComponent(Mainboard.class, 3);
        PowerUnit selectedPowerUnit = selectComponent(PowerUnit.class, 4);
        ComputerCase selectedComputerCase = selectComponent(ComputerCase.class, 5);

        PersonalList newList = new PersonalList(choiceID, selectedGPU, selectedCPU, selectedRAM, selectedPowerUnit, selectedComputerCase, selectedMainboard);
        personalLists.put(choiceID, newList);
    }

    private <T extends Components> T selectComponent(Class<T> type, int choice) {
        ui.showMessage("Bitte wähle eine " + getComponentName(choice) + " aus:");

        switch (choice) {
            case 0 -> componentService.getAllCPUComponents();
            case 1 -> componentService.getAllGPUComponents();
            case 2 -> componentService.getAllRAMComponents();
            case 3 -> componentService.getAllMainboardComponents();
            case 4 -> componentService.getAllPowerUnitComponents();
            case 5 -> componentService.getAllCaseComponents();
            default -> {
                ui.IllegalInput("Ungültige Wahl.");
                return null;
            }
        }

        int id = ui.readMinMaxInput(0, 50);

        Components component = switch (choice) {
            case 0 -> componentService.getOneCPU(id);
            case 1 -> componentService.getOneGPU(id);
            case 2 -> componentService.getOneRAM(id);
            case 3 -> componentService.getOneMainboard(id);
            case 4 -> componentService.getOnePowerUnit(id);
            case 5 -> componentService.getOneComputerCase(id);
            default -> null;
        };

        return type.cast(component);
    }

    /**
     * Hilfsmethode, um den Namen der Komponente auszugeben.
     */
    private String getComponentName(int choice) {
        return switch (choice) {
            case 0 -> "CPU";
            case 1 -> "GPU";
            case 2 -> "RAM";
            case 3 -> "Mainboard";
            case 4 -> "Netzteil";
            case 5 -> "Gehäuse";
            default -> "Unbekannte Komponente";
        };
    }

    public void deletePersonalList() {
        printPersonalLists();
        int choice = ui.readMinMaxInput(1, 3);
        if (personalLists.containsKey(choice)) {
            personalLists.remove(choice);
            ui.showMessage("Liste mit ID " + choice + " wurde gelöscht.");
        } else {
            ui.IllegalInput("Keine Liste mit dieser ID gefunden.");
        }

    }

}
