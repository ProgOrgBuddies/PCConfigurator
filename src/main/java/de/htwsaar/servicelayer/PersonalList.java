package de.htwsaar.servicelayer;

import java.io.Serializable;

import de.htwsaar.servicelayer.components.*;

// Klasse für die Erstellung von persönlichen Listen.

public class PersonalList implements Serializable
{
    private static final long serialVersionUID = 1L;
    GPU gpu;
    CPU cpu;
    RAM ram;
    PowerUnit netzteil;
    ComputerCase computerCase;
    Mainboard mainboard;
    int id;

    public PersonalList(int id, GPU gpu, CPU cpu, RAM ram, PowerUnit netzteil, ComputerCase computerCase, Mainboard mainboard) {
        this.id = id;
        this.gpu = gpu;
        this.cpu = cpu;
        this.ram = ram;
        this.netzteil = netzteil;
        this.computerCase = computerCase;
        this.mainboard = mainboard;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Liste mit der ID: " + id + '\'' +
                " GPU: " + (gpu != null ? gpu.name : "Keine") +
                ", CPU: " + (cpu != null ? cpu.name : "Keine") +
                ", RAM: " + (ram != null ? ram.name : "Keine") +
                ", Netzteil: " + (netzteil != null ? netzteil.name : "Keine") +
                ", Gehäuse: " + (computerCase != null ? computerCase.name : "Keine") +
                ", Mainboard: " + (mainboard != null ? mainboard.name : "Keine");
    }
}
