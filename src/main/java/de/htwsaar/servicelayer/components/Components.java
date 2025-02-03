package de.htwsaar.servicelayer.components;

import java.io.Serializable;


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

    @Override
    public String toString() {
        return "Brand: " + brand + ", Name: " + name + ", Price: " + price;
    }
}
