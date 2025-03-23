package de.htwsaar.persistenz;


import de.htwsaar.servicelayer.PersonalList;
import de.htwsaar.servicelayer.components.*;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import static org.jooq.impl.DSL.*;


// Klasse die die Datenbank PersonalList verwaltet (read+write)

public class PersonalListService implements PersonalListServiceInterface {
    private final DSLContext dsl;
    private final ComponentServiceInterface componentService;

    public PersonalListService(Connection connection, ComponentServiceInterface componentService) {
        this.dsl = DSL.using(connection, SQLDialect.SQLITE);
        this.componentService = componentService;

        try {
            System.out.println("Verbindung zur Datenbank: " + connection.getMetaData().getURL());
        } catch (SQLException e) {
            System.err.println("Fehler beim Abrufen der Verbindungs-URL: " + e.getMessage());
        }
    }

    // Speichert eine Persönliche Liste in der Datenbank

    public void savePersonalList(PersonalList personalList) {
        dsl.insertInto(table("PersonalList"),
                        field("PL_ID"), field("CPU_ID"), field("GPU_ID"), field("RAM_ID"),
                        field("MB_ID"), field("SSD_ID"), field("Case_ID"))
                .values(personalList.getId(),
                        personalList.getCpu() != null ? personalList.getCpu().getId() : null,
                        personalList.getGpu() != null ? personalList.getGpu().getId() : null,
                        personalList.getRam() != null ? personalList.getRam().getId() : null,
                        personalList.getMainboard() != null ? personalList.getMainboard().getId() : null,
                        personalList.getPowerUnit() != null ? personalList.getPowerUnit().getId() : null,
                        personalList.getComputerCase() != null ? personalList.getComputerCase().getId() : null)
                .execute();
    }

    // Lädt persönliche Liste aus der Datenbank. Sollten die IDs der entsprechenden nicht vorhanden sein bzw. NULL entsprechen werden Null Objekte erstellt.

    public Map<Integer, PersonalList> loadPersonalList() {
        Result<Record> records = dsl.select().from("PersonalList").fetch();
        Map<Integer, PersonalList> personalLists = new HashMap<>();

        for (Record record : records) {
            try {
                int id = record.getValue("PL_ID", int.class);
                Integer cpuId = record.get("CPU_ID", Integer.class);
                Integer gpuId = record.get("GPU_ID", Integer.class);
                Integer ramId = record.get("RAM_ID", Integer.class);
                Integer mainboardId = record.get("MB_ID", Integer.class);
                Integer powerUnitId = record.get("SSD_ID", Integer.class);
                Integer computerCaseId = record.get("Case_ID", Integer.class);


                CPU cpu = (cpuId != null) ? componentService.getOneCPU(cpuId) : null;
                GPU gpu = (gpuId != null) ? componentService.getOneGPU(gpuId) : null;
                RAM ram = (ramId != null) ? componentService.getOneRAM(ramId) : null;
                Mainboard mainboard = (mainboardId != null) ? componentService.getOneMainboard(mainboardId) : null;
                PowerUnit powerUnit = (powerUnitId != null) ? componentService.getOnePowerUnit(powerUnitId) : null;
                ComputerCase computerCase = (computerCaseId != null) ? componentService.getOneComputerCase(computerCaseId) : null;

                PersonalList personalList = new PersonalList(id, gpu, cpu, ram, powerUnit, computerCase, mainboard);
                personalLists.put(id, personalList);
            } catch (Exception e) {
                System.err.println("Fehler beim Laden einer PersonalList (PL_ID: " + record.getValue("PL_ID") + "): " + e.getMessage());
            }
        }

        return personalLists;
    }

    // Löscht eine persönliche Liste anhand seiner ID

    public void deletePersonalList(int id) {
        dsl.deleteFrom(table("PersonalList"))
                .where(field("PL_ID").eq(id))
                .execute();
    }

}

