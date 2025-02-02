package de.htwsaar.servicelayer.components;

import java.util.Map;

public class PowerUnit extends Components {

    public PowerUnit(String brand, String name, float price) {
        super(brand, name, price);
    }

    public static Map<Integer, PowerUnit> readPowerUnitList() {
        // Verwende die generische Methode aus Components
        return Components.readList("src/main/java/de/htwsaar/servicelayer/components/PowerUnit.txt",
                (brand, name, price) -> new PowerUnit(brand, name, price));
    }
}
