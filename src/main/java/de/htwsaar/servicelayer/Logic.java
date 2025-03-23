package de.htwsaar.servicelayer;
import java.util.HashMap;
import java.util.Map;

import de.htwsaar.servicelayer.components.*;
import de.htwsaar.persistenz.*;

import java.sql.Connection;
import java.sql.SQLException;

/* Die Klasse die den eigentlichen Ablauf des Programmes kontrolliert. Wird ein Logic Objekt erstellt, werden die Services
 * der Datenbanken initialisiert, sowie muss ein Objekt übergeben welches das servicelayer-UserInterface implementiert, übergeben wird.
 * Dadurch wird sichergestellt, dass bei einem Austausch des UserInterfaces die Logic weiterhin ohne Veränderungen weiterlaufen kann.
 */


public class Logic {

    // Map die persönliche Listen speichert. Dient als eine Art Cache.
    Map<Integer, PersonalList> personalLists = new HashMap<>();
    private final ComponentServiceInterface componentService;
    private final PersonalListServiceInterface personalListService;
    private UserInterface ui;

    public Logic (UserInterface ui) {
        this.ui = ui;
        Connection componentConnection = connectToComponentDatabase();
        this.componentService = componentConnection != null ? new ComponentService(componentConnection) : null;
        Connection personalListConnection = connectToPersonalListDatabase();
        this.personalListService = personalListConnection != null ? new PersonalListService(personalListConnection, componentService) : null;
    }

    // Ruft die statischen Methoden aus DatabaseManager aus um eine Verbindung zur Components DB herzustellen und catcht mögliche SQLExceptions die vom DatabaseManager geworfen werden können

    public Connection connectToComponentDatabase() {
        try {
            Connection connection = DatabaseManager.connectComponentsDB();
            System.out.println("Connected to database");
            return connection;
        } catch (SQLException e) {
            System.err.println("Fehler bei der Datenbankverbindung: " + e.getMessage());
        }
        return null;
    }

    // Ruft die statischen Methoden aus DatabaseManager aus um eine Verbindung zur PersonalList DB herzustellen und catcht mögliche SQLExceptions die vom DatabaseManager geworfen werden können

    public Connection connectToPersonalListDatabase() {
        try {
            Connection connection = DatabaseManager.connectPersonalListDB();
            System.out.println("Connected to database");
            return connection;
        } catch (SQLException e) {
            System.err.println("Fehler bei der Datenbankverbindung: " + e.getMessage());
        }
        return null;
    }

    // Startet das Programm bzw. startet das MainMenu. Bevor werden noch die gespeicherten Listen initialisiert. 

    public void startProgram() {
        if (personalListService != null) {
            personalLists.clear();
            personalLists = personalListService.loadPersonalList();
        } else {
            System.err.println("Fehler: personalListService ist nicht initialisiert.");
        }

        showMainMenu();

    }

    // Zeigt das MainMenu

    public void showMainMenu() {
        while (true) {
            int input = ui.showMainMenu();
            switch (input) {
                case 1 -> showDatabaseMenu();
                case 2 -> showPersonalListMenu();
                case 3 -> {
                    ui.showMessage("Programm wird beendet.");
                    return;
                }
                default -> ui.illegalInput("Ungültige Eingabe");
            }
        }

    }

    // Zeigt das DatabaseMenu

    public void showDatabaseMenu() {
        while (true) {
            int input = ui.showDatabaseMenu();
            switch (input) {
                case 1 -> componentService.printAllGPUComponents();
                case 2 -> componentService.printAllCPUComponents();
                case 3 -> componentService.printAllRAMComponents();
                case 4 -> componentService.printAllPowerUnitComponents();
                case 5 -> componentService.printAllMainboardComponents();
                case 6 -> componentService.printAllCaseComponents();
                case 7 -> {
                    return;
                }
                default -> ui.showMessage("Ungültige Auswahl! Bitte eine Zahl zwischen 0 und 7 eingeben.");
            }
        }
    }

    // Zeigt das PersonalListMenu

    public void showPersonalListMenu() {
        while (true) {
            int choice = ui.showPersonalListMenu();
            switch (choice) {
                case 1 -> printPersonalLists();
                case 2 -> createPersonalList();
                case 3 -> deletePersonalList();
                case 4 -> {
                    return;
                }
                default -> ui.illegalInput("Ungültige Auswahl.");
            }
        }

    }

    // Printet alle Persönlichen Listen 

    public void printPersonalLists() {
        if (!personalLists.isEmpty()) {
            personalLists.forEach((id, personalList) -> ui.showMessage("ID: " + id + ", List: " + personalList));
        } else {
            ui.showMessage("Es sind keine Listen vorhanden.");
        }
    }

    // Erstellt eine persönliche Liste. Zuerst wird abgefragt ob die ID im passenden Bereich liegt oder ob bereits eine Liste mit dieser ID vorhanden ist.

    public void createPersonalList() {
        if (personalLists.size() > 3) {
            ui.illegalInput("Sie haben bereits 3 persönliche Listen erstellt. Bitte löschen Sie eine, um eine neue zu erstellen.");
            return;
        }

        ui.showMessage("Bitte wähle eine ID für deine Liste. ID muss eine Zahl zwischen 1-3 sein.:");
        int choiceID = ui.readMinMaxInput(1, 3);

        if (choiceID < 1 || choiceID > 3) {
            ui.showMessage("Ungültige Auswahl.");
            return;
        }
        if (personalLists.containsKey(choiceID) && isValidPersonalList(personalLists.get(choiceID))) {
            ui.showMessage("Diese ID ist bereits belegt!");
            return;
        }
        personalListService.deletePersonalList(choiceID);

        CPU selectedCPU = selectComponent(CPU.class, 0);
        GPU selectedGPU = selectComponent(GPU.class, 1);
        RAM selectedRAM = selectComponent(RAM.class, 2);
        Mainboard selectedMainboard = selectComponent(Mainboard.class, 3);
        PowerUnit selectedPowerUnit = selectComponent(PowerUnit.class, 4);
        ComputerCase selectedComputerCase = selectComponent(ComputerCase.class, 5);

        PersonalList newList = new PersonalList(choiceID, selectedGPU, selectedCPU, selectedRAM, selectedPowerUnit, selectedComputerCase, selectedMainboard);
        personalListService.savePersonalList(newList);
        ui.showMessage("Liste wurde erfolgreich erstellt und gespeichert.!");
        personalLists.put(choiceID, newList);
    }

   /* Generische Methode die eine Komponente auswählt und zurückgibt. choice gibt an, welche Komponente man ausgeben möchte. Es muss ein Class type
    * übergeben werden damit die Komponente zu dem passenden Typen gecastet werden kann und zurückgegeben werden kann. Dies sorgt dafür
    * dass nur eine Methode geschrieben werden muss statt 6 und garantiert leichtere Erweiterbarkeit in der Zukunft.
   */ 

    private <T extends Components> T selectComponent(Class<T> type, int choice) {
        ui.showMessage("Bitte wähle eine " + getComponentName(choice) + " aus:");

        switch (choice) {
            case 0 -> componentService.printAllCPUComponents();
            case 1 -> componentService.printAllGPUComponents();
            case 2 -> componentService.printAllRAMComponents();
            case 3 -> componentService.printAllMainboardComponents();
            case 4 -> componentService.printAllPowerUnitComponents();
            case 5 -> componentService.printAllCaseComponents();
            default -> {
                ui.illegalInput("Ungültige Wahl.");
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
     * Hilfsmethode, um den Namen der Komponente auszugeben. Wird in selectComponent() aufgerufen.
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

    // Löscht persönliche Liste

    public void deletePersonalList() {
        printPersonalLists();
        int choice = ui.readMinMaxInput(1, 3);
        if (personalLists.containsKey(choice)) {
            personalLists.remove(choice);
            personalListService.deletePersonalList(choice);
            PersonalList personalList = new PersonalList(choice, null, null, null, null, null, null);
            personalListService.savePersonalList(personalList);
            personalLists.put(choice, personalList);
            ui.showMessage("Liste mit ID " + choice + " wurde gelöscht.");
        } else {
            ui.illegalInput("Keine Liste mit dieser ID gefunden.");
        }

    }


    /* Da wir wenn eine Liste null ist in der PersonalListDB trotzdem eine "leere" Liste erstellen, die aus null Objekten besteht, müssen wir beim Erstellen einer neuen Liste
     * sicherstellen dass diese leere Liste gelöscht wird und ersetzt werden kann. Diese Methode checkt ob alle Komponenten null sind und returnt false wenn sie aus
     * null Objekten besteht, true wenn sie eine "wirkliche" Liste ist. Methode wird in createPersonalList() aufgerufen.
     */

    private boolean isValidPersonalList(PersonalList list) {
        if (list == null) return false;
        return list.getCpu() != null || list.getGpu() != null || list.getRam() != null ||
                list.getMainboard() != null || list.getPowerUnit() != null || list.getComputerCase() != null;
    }


}
