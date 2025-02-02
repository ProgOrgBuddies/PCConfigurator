package de.htwsaar.servicelayer.components;

import java.util.Map;

public class GPU extends Components {

    public GPU(String brand, String name, float price) {
        super(brand, name, price);
    }

    public static Map<Integer, GPU> readGPUList() {
        // Verwende die generische Methode aus Components
        return Components.readList("src/main/java/de/htwsaar/servicelayer/components/GPU.txt",
                (brand, name, price) -> new GPU(brand, name, price));
    }

}