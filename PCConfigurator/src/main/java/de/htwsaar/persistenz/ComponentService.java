package de.htwsaar.persistenz;

import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import java.sql.Connection;

import java.util.HashMap;
import java.util.Map;
import de.htwsaar.servicelayer.components.*;

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
        }    }
    public void printAllCPUComponents() {
        Result<Record> result = dsl.select().from("CPU").fetch();

        for (Record record : result) {
            Integer id = record.getValue(CPU.CPU_ID);
            String name = record.getValue(CPU.NAME);

            System.out.println("ID: " + id + " Name: " + name);
        }
    }
    public Map<Integer, CPU> returnCPUComponentMap() {
        Result<Record> result = dsl.select().from("CPU").fetch();

        Map<Integer, CPU> map = new HashMap<>();

        for (Record record : result) {
            Integer id = record.getValue(CPU.CPU_ID);
            String name = record.getValue(CPU.NAME);
            String brand = record.getValue(CPU.MARKE);
            Float price = record.getValue(CPU.PREIS);

            CPU cpu = new CPU(name, brand, price);
            map.put(id, cpu);

        }

        return map;
    }
}
