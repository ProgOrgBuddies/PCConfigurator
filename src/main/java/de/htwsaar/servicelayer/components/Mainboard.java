package de.htwsaar.servicelayer.components;

import java.util.Map;

public class Mainboard extends Components {

    public Mainboard(String brand, String name, float price) {
        super(brand, name, price);
    }

    public static Map<Integer, Mainboard> readMainboardList() {
        // Verwende die generische Methode aus Components
        return Components.readList("src/main/java/de/htwsaar/servicelayer/components/Mainboard.txt",
                (brand, name, price) -> new Mainboard(brand, name, price));
    }

}
