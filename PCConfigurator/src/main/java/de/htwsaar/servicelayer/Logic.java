package de.htwsaar.servicelayer;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import de.htwsaar.servicelayer.components.*;
import de.htwsaar.persistenz.*;

import java.sql.Connection;
import java.sql.SQLException;


public class Logic {

    Map<Integer, PersonalList> personalLists = new HashMap<>();
    Map<Integer, GPU> gpuMap;
    Map<Integer, CPU> cpuMap;
    Map<Integer, RAM> ramMap;
    Map<Integer, Mainboard> mainboardMap;
    Map<Integer, PowerUnit> powerUnitMap;
    Map<Integer, ComputerCase> computerCaseMap;

    public Connection connectToDatabase() {
        try (Connection connection = DatabaseManager.connect()) {
            System.out.println("Listen werden initialisiert...");
            return connection;
        } catch (SQLException e)  {
            System.err.println("Fehler bei der Datenbankverbindung: " + e.getMessage());
        }

        return null;
    }

    public void initiateLists() {
        ComponentService service = new ComponentService(connectToDatabase());

        gpuMap = GPU.readGPUList();
        cpuMap = service.returnCPUComponentMap();
        ramMap = RAM.readRAMList();
        mainboardMap = Mainboard.readMainboardList();
        powerUnitMap = PowerUnit.readPowerUnitList();
        computerCaseMap = ComputerCase.readComputerCaseList();
    }

    public void printPersonalLists() {
        personalLists.forEach((id, personalList) -> System.out.println("ID: " + id + ", List: " + personalList));
    }

    public PersonalList createPersonalList(int choiceID, int gpuID, int cpuID, int ramID, int powerUnitID, int computerCaseID, int mainboardID) {
        if (personalLists.size() > 3) {
            System.out.println("Sie haben bereits 3 persönliche Listen erstellt. Bitte löschen Sie eine, um eine neue zu erstellen.");
            return null;
        }

        GPU selectedGPU = selectComponent(gpuID, gpuMap);
        CPU selectedCPU = selectComponent(cpuID, cpuMap);
        RAM selectedRAM = selectComponent(ramID, ramMap);
        Mainboard selectedMainboard = selectComponent(mainboardID, mainboardMap);
        ComputerCase selectedComputerCase = selectComponent(computerCaseID, computerCaseMap);
        PowerUnit selectedPowerUnit = selectComponent(powerUnitID, powerUnitMap);

        PersonalList newList = new PersonalList(choiceID, selectedGPU, selectedCPU, selectedRAM, selectedPowerUnit, selectedComputerCase, selectedMainboard);
        personalLists.put(choiceID, newList);
        return newList;

    }

    private <T extends Components> T selectComponent(int choice, Map <Integer, T> componentMap) {
        return componentMap.get(choice);

    }

    // Muss noch implementiert werden
    public void savePersonalListTOFile(String filePath) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(personalLists);
            System.out.println("Persönliche Liste erfolgreich gespeichert.");
        } catch (IOException e) {
            e.printStackTrace();

        }

    }

    @SuppressWarnings("unchecked")
    public void loadPersonalListsFromFile(String filePath) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            personalLists = (Map<Integer, PersonalList>) ois.readObject();
            System.out.println("Persönliche Listen wurden erfolgreich geladen.");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Fehler beim Laden der persönlichen Listen: " + e.getMessage());
        }
    }



    public void deletePersonalList(Scanner scanner) {
        printPersonalLists();
        int choice = scanner.nextInt();
        personalLists.remove(choice);
    }

    public void printGPUDatabase() {
        gpuMap.forEach((id, gpu) -> System.out.println(id + ": " + gpu));
    }

    public void printCPUDatabase() {
        cpuMap.forEach((id, cpu) -> System.out.println(id + ": " + cpu));
    }

    public void printRAMDatabase() {
        ramMap.forEach((id, ram) -> System.out.println(id + ": " + ram));
    }

    public void printComputerCaseDatabase() {
        computerCaseMap.forEach((id, computerCase) -> System.out.println(id + ": " + computerCase));
    }

    public void printPowerUnitDatabase() {
        powerUnitMap.forEach((id, powerUnit) -> System.out.println(id + ": " + powerUnit));
    }
    public void printMainboardDatabase() {
        mainboardMap.forEach((id, mainboard) -> System.out.println(id + ": " + mainboard));
    }

}
