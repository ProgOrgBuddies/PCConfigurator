package de.htwsaar.servicelayer.components;

import java.util.Map;

public class CPU extends Components {

    public CPU(String brand, String name, float price) {
        super(brand, name, price);
    }

    public static Map<Integer, CPU> readCPUList() {
        // Verwende die generische Methode aus Components
        return Components.readList("src/main/java/de/htwsaar/servicelayer/components/CPU.txt",
                (brand, name, price) -> new CPU(brand, name, price));
    }

}
