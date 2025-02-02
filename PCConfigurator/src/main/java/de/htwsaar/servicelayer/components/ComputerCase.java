package de.htwsaar.servicelayer.components;

import java.util.Map;

public class ComputerCase extends Components {

    public ComputerCase(String brand, String name, float price) {
        super(brand, name, price);
    }

    public static Map<Integer, ComputerCase> readComputerCaseList() {
        return Components.readList("src/main/java/de/htwsaar/servicelayer/components/ComputerCase.txt",
                (brand, name, price) -> new ComputerCase(brand, name, price));
    }
}
