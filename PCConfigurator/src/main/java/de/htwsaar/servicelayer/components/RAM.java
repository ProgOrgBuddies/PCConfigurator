package de.htwsaar.servicelayer.components;

import java.util.Map;

public class RAM extends Components {

    public RAM(String brand, String name, float price) {
        super(brand, name, price);
    }

    public static Map<Integer, RAM> readRAMList() {
        // Verwende die generische Methode aus Components
        return Components.readList("src/main/java/de/htwsaar/servicelayer/components/RAM.txt",
                (brand, name, price) -> new RAM(brand, name, price));
    }

}
