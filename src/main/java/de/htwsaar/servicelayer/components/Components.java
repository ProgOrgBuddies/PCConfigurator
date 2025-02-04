package de.htwsaar.servicelayer.components;

public abstract class Components  {

    private String brand;
    private String name;
    private float price;
    private int id;

    public Components(int id, String brand, String name, float price) {
        this.brand = brand;
        this.name = name;
        this.price = price;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Brand: " + brand + ", Name: " + name + ", Price: " + price;
    }
    public int getId() {
        return id;
    }
    public String getBrand() {
        return brand;
    }
    public String getName() {
        return name;
    }
}
