package de.htwsaar.servicelayer.components;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

// Superklasse für alle Komponenten, enthält generische Methode zum Einlesen von Komponentenlisten sowie zum Abgeben von Komponenten aus diesen Listen.

public abstract class Components implements Serializable {

    private static final long serialVersionUID = 1L;

    public String brand;
    public String name;
    public float price;

    public Components(String brand, String name, float price) {
        this.brand = brand;
        this.name = name;
        this.price = price;
    }

    public void printInformation() {
        System.out.println(brand + " " + name + " " + price);
    }

    public static <T extends Components> Map<Integer, T> readList(String filePath, ComponentFactory<T> factory) {
        Map<Integer, T> componentsMap = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean firstLine = true;

            while ((line = br.readLine()) != null) {
                if (firstLine) {
                    firstLine = false;
                    continue;
                }

                String[] parts = line.split(";");
                int id = Integer.parseInt(parts[0].trim());
                String brand = parts[1];
                String name = parts[2];
                int price = Integer.parseInt(parts[3].trim());


                T component = factory.createComponent(brand, name, price);
                componentsMap.put(id, component);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return componentsMap;
    }


    public static <T extends Components> T returnFromList(int id, Map<Integer, T> componentsMap) {
        T component = componentsMap.get(id);
        if (component != null) {
            return component;
        }

        throw new IllegalArgumentException("Kein Element mit der angegebenen ID (" + id + ") gefunden.");
    }

    @Override
    public String toString() {
        return "Brand: " + brand + ", Name: " + name + ", Price: " + price;
    }
}
