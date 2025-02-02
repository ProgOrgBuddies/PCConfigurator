package de.htwsaar.servicelayer.components;

public interface ComponentFactory<T extends Components> {
    T createComponent(String brand, String name, int price);
}
