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

}
