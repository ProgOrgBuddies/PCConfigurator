package de.htwsaar.persistenz;

import de.htwsaar.pcconfig.generated.tables.Netzteil;
import de.htwsaar.servicelayer.components.*;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

import static de.htwsaar.pcconfig.generated.Tables.*;

public class ComponentService {
    private final DSLContext dsl;

    public ComponentService(Connection connection) {
        this.dsl = DSL.using(connection, SQLDialect.SQLITE);
    }

    public void getAllRAMComponents() {
        Result<Record> result = dsl.select().from("RAM").fetch();

        for (Record record : result) {
            Integer id = record.getValue(RAM.RAM_ID);
            String name = record.getValue(RAM.NAME);

            System.out.println("ID: " + id + " Name: " + name);
        }
    }
    public void getAllCPUComponents() {
        Result<Record> result = dsl.select().from("CPU").fetch();
        for (Record record : result) {
            Integer id = record.getValue(CPU.CPU_ID);
            String name = record.getValue(CPU.NAME);
            System.out.println("ID: " + id + " Name: " + name);
        }
    }
    public void getAllGPUComponents() {
        Result<Record> result = dsl.select().from("GPU").fetch();
        for (Record record : result) {
            Integer id = record.getValue(GPU.GPU_ID);
            String name = record.getValue(GPU.NAME);
            System.out.println("ID: " + id + " Name: " + name);
        }
    }
    public void getAllMainboardComponents() {
        Result<Record> result = dsl.select().from("Mainboard").fetch();
        for (Record record : result) {
            Integer id = record.getValue(MAINBOARD.MB_ID);
            String name = record.getValue(MAINBOARD.NAME);
            System.out.println("ID: " + id + " Name: " + name);
        }
    }
    public void getAllPowerUnitComponents() {
        Result<Record> result = dsl.select().from("Netzteil").fetch();
        for (Record record : result) {
            Integer id = record.getValue(NETZTEIL.PSU_ID);
            String name = record.getValue(NETZTEIL.NAME);
            System.out.println("ID: " + id + " Name: " + name);
        }
    }
    public void getAllCaseComponents() {
        Result<Record> result = dsl.select().from("Case").fetch();
        for (Record record : result) {
            Integer id = record.getValue(CASE.CASE_ID);
            String name = record.getValue(CASE.NAME);
            System.out.println("ID: " + id + " Name: " + name);
        }
    }

    public CPU getOneCPU(int id) {
        Record record = dsl.select().from("CPU").where(CPU.CPU_ID.eq(id)).fetchOne();
        if (record == null) {
            return null;
        } else {
            String brand = record.getValue(CPU.MARKE);
            String name = record.getValue(CPU.NAME);
            Float price = record.getValue(CPU.PREIS);
            return new CPU(brand, name, price);
        }

    }
    public GPU getOneGPU(int id) {
        Record record = dsl.select().from("GPU").where(GPU.GPU_ID.eq(id)).fetchOne();
        if (record == null) {
            return null;
        } else {
            String brand = record.getValue(GPU.MARKE);
            String name = record.getValue(GPU.NAME);
            Float price = record.getValue(GPU.PREIS);
            return new GPU(brand, name, price);
        }
    }
    public RAM getOneRAM(int id) {
        Record record = dsl.select().from("RAM").where(RAM.RAM_ID.eq(id)).fetchOne();
        if (record == null) {
            return null;
        } else {
            String brand = record.getValue(RAM.MARKE);
            String name = record.getValue(RAM.NAME);
            Float price = record.getValue(RAM.PREIS);
            return new RAM(brand, name, price);
        }
    }
    public Mainboard getOneMainboard(int id) {
        Record record = dsl.select().from("Mainboard").where(MAINBOARD.MB_ID.eq(id)).fetchOne();
        if (record == null) {
            return null;
        } else {
            String brand = record.getValue(MAINBOARD.MARKE);
            String name = record.getValue(MAINBOARD.NAME);
            Float price = record.getValue(MAINBOARD.PREIS);
            return new Mainboard(brand, name, price);
        }
    }

    public PowerUnit getOnePowerUnit(int id) {
        Record record = dsl.select().from("Netzteil").where(NETZTEIL.PSU_ID.eq(id)).fetchOne();
        if (record == null) {
            return null;
        }
        String brand = record.getValue(NETZTEIL.MARKE);
        String name = record.getValue(NETZTEIL.NAME);
        Float price = record.getValue(NETZTEIL.PREIS);
        return new PowerUnit(brand, name, price);
    }

    public ComputerCase getOneComputerCase(int id) {
        Record record = dsl.select().from("Case").where(CASE.CASE_ID.eq(id)).fetchOne();
        if (record == null) {
            return null;
        }
        String brand = "?";
        String name = record.getValue(CASE.NAME);
        Float price = record.getValue(CASE.PREIS);
        return new ComputerCase(brand, name, price);
    }



}
