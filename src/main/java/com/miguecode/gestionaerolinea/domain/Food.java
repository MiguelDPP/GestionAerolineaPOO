package com.miguecode.gestionaerolinea.domain;

public class Food {
    private static int lastId = 1;
    private int id;
    private String name;
    private double price;

    public Food(String name, double price) {
        this.id = lastId++;
        this.name = name;
        this.price = price;
    }

    public boolean checkId(int id) {
        return this.id == id;
    }

    @Override
    public String toString() {
        return String.format("%-10s %-20s %-10s", this.id, this.name, this.price);
    }

}
