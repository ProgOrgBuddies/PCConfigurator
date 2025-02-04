package de.htwsaar.servicelayer;

import java.io.Serializable;

import de.htwsaar.servicelayer.components.*;

// Klasse für die Erstellung von persönlichen Listen.

public class PersonalList {
    GPU gpu;
    CPU cpu;
    RAM ram;
    PowerUnit powerUnit;
    ComputerCase computerCase;
    Mainboard mainboard;
    int id;

    public PersonalList(int id, GPU gpu, CPU cpu, RAM ram, PowerUnit powerUnit, ComputerCase computerCase, Mainboard mainboard) {
        this.id = id;
        this.gpu = gpu;
        this.cpu = cpu;
        this.ram = ram;
        this.powerUnit = powerUnit;
        this.computerCase = computerCase;
        this.mainboard = mainboard;
    }

    public int getId() {
        return id;
    }

    public CPU getCpu() {
        return cpu;
    }
    public GPU getGpu() {
        return gpu;
    }
    public RAM getRam() {
        return ram;
    }
    public PowerUnit getPowerUnit() {
        return powerUnit;
    }
    public ComputerCase getComputerCase() {
        return computerCase;
    }
    public Mainboard getMainboard() {
        return mainboard;
    }


    @Override
    public String toString() {
        return "Liste mit der ID: " + id + '\'' +
                " GPU: " + (gpu != null ? gpu.getName() : "Keine") +
                ", CPU: " + (cpu != null ? cpu.getName() : "Keine") +
                ", RAM: " + (ram != null ? ram.getName() : "Keine") +
                ", Netzteil: " + (powerUnit != null ? powerUnit.getName() : "Keine") +
                ", Gehäuse: " + (computerCase != null ? computerCase.getName() : "Keine") +
                ", Mainboard: " + (mainboard != null ? mainboard.getName() : "Keine");
    }
}
