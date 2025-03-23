package de.htwsaar.persistenz;

import de.htwsaar.servicelayer.components.*;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import java.sql.Connection;
import java.sql.SQLException;

import static de.htwsaar.pcconfig.generated.components.Tables.*;

// Klasse die PC-Komponenten aus der Datenbank PC_ComponentsDB verwaltet (read-only)

public class ComponentService implements ComponentServiceInterface {
    private final DSLContext dsl;

    public ComponentService(Connection connection) {
        if (connection != null) {
            this.dsl = DSL.using(connection, SQLDialect.SQLITE);
        } else {
            throw new IllegalArgumentException("Connection is null");
        }

        try {
            System.out.println("Verbindung zur Datenbank: " + connection.getMetaData().getURL());
        } catch (SQLException e) {
            System.err.println("Fehler beim Abrufen der Verbindungs-URL: " + e.getMessage());
        }
    }

    /* 
     * Methoden um alle Komponenten die in der entsprechenden Datenbank ausliest.
     */

    public void printAllRAMComponents() {
        Result<Record> result = dsl.select().from("RAM").fetch();

        for (Record record : result) {
            Integer id = record.getValue(RAM.RAM_ID);
            String name = record.getValue(RAM.NAME);

            System.out.println("ID: " + id + " Name: " + name);
        }
    }
    public void printAllCPUComponents() {
        Result<Record> result = dsl.select().from("CPU").fetch();
        for (Record record : result) {
            Integer id = record.getValue(CPU.CPU_ID);
            String name = record.getValue(CPU.NAME);
            System.out.println("ID: " + id + " Name: " + name);
        }
    }
    public void printAllGPUComponents() {
        Result<Record> result = dsl.select().from("GPU").fetch();
        for (Record record : result) {
            Integer id = record.getValue(GPU.GPU_ID);
            String name = record.getValue(GPU.NAME);
            System.out.println("ID: " + id + " Name: " + name);
        }
    }
    public void printAllMainboardComponents() {
        Result<Record> result = dsl.select().from("Mainboard").fetch();
        for (Record record : result) {
            Integer id = record.getValue(MAINBOARD.MB_ID);
            String name = record.getValue(MAINBOARD.NAME);
            System.out.println("ID: " + id + " Name: " + name);
        }
    }
    public void printAllPowerUnitComponents() {
        Result<Record> result = dsl.select().from("PSU").fetch();
        for (Record record : result) {
            Integer id = record.getValue(PSU.PSU_ID);
            String name = record.getValue(PSU.NAME);
            System.out.println("ID: " + id + " Name: " + name);
        }
    }
    public void printAllCaseComponents() {
        Result<Record> result = dsl.select().from("ComputerCase").fetch();
        for (Record record : result) {
            Integer id = record.getValue(COMPUTERCASE.CASE_ID);
            String name = record.getValue(COMPUTERCASE.NAME);
            System.out.println("ID: " + id + " Name: " + name);
        }
    }

    /* 
     * Methoden um eine einzelne Komponente anhand ihrer ID zu returnen
     */

    public CPU getOneCPU(int id) {
        Record record = dsl.select().from("CPU").where(CPU.CPU_ID.eq(id)).fetchOne();
        if (record == null) {
            return null;
        } else {
            int idC = record.getValue(CPU.CPU_ID);
            String brand = record.getValue(CPU.BRAND);
            String name = record.getValue(CPU.NAME);
            Float price = record.getValue(CPU.PRICE);
            return new CPU(idC, brand, name, price);
        }

    }
    public GPU getOneGPU(int id) {
        Record record = dsl.select().from("GPU").where(GPU.GPU_ID.eq(id)).fetchOne();
        if (record == null) {
            return null;
        } else {
            int idG = record.getValue(GPU.GPU_ID);
            String brand = record.getValue(GPU.BRAND);
            String name = record.getValue(GPU.NAME);
            Float price = record.getValue(GPU.PRICE);
            return new GPU(idG, brand, name, price);
        }
    }
    public RAM getOneRAM(int id) {
        Record record = dsl.select().from("RAM").where(RAM.RAM_ID.eq(id)).fetchOne();
        if (record == null) {
            return null;
        } else {
            int idR = record.getValue(RAM.RAM_ID);
            String brand = record.getValue(RAM.BRAND);
            String name = record.getValue(RAM.NAME);
            Float price = record.getValue(RAM.PRICE);
            return new RAM(idR, brand, name, price);
        }
    }
    public Mainboard getOneMainboard(int id) {
        Record record = dsl.select().from("Mainboard").where(MAINBOARD.MB_ID.eq(id)).fetchOne();
        if (record == null) {
            return null;
        } else {
            int idM = record.getValue(MAINBOARD.MB_ID);
            String brand = record.getValue(MAINBOARD.BRAND);
            String name = record.getValue(MAINBOARD.NAME);
            Float price = record.getValue(MAINBOARD.PRICE);
            return new Mainboard(idM, brand, name, price);
        }
    }

    public PowerUnit getOnePowerUnit(int id) {
        Record record = dsl.select().from("PSU").where(PSU.PSU_ID.eq(id)).fetchOne();
        if (record == null) {
            return null;
        }
        int idP = record.getValue(PSU.PSU_ID);
        String brand = record.getValue(PSU.BRAND);
        String name = record.getValue(PSU.NAME);
        Float price = record.getValue(PSU.PRICE);
        return new PowerUnit(idP, brand, name, price);
    }
    
    public ComputerCase getOneComputerCase(int id) {
        Record record = dsl.select().from("ComputerCase").where(COMPUTERCASE.CASE_ID.eq(id)).fetchOne();
        if (record == null) {
            return null;
        }
        int idC = record.getValue(COMPUTERCASE.CASE_ID);
        String brand = record.getValue(COMPUTERCASE.BRAND);
        String name = record.getValue(COMPUTERCASE.NAME);
        Float price = record.getValue(COMPUTERCASE.PRICE);
        return new ComputerCase(idC, brand, name, price);
    }



}
