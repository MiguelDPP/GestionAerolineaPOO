package com.miguecode.gestionaerolinea.domain;

import java.util.ArrayList;
import java.util.List;

public class Seat {
    private static int lastId = 1;
    private int id;
    private boolean isAvailable = true;
    private String seatNumber;
    private Client client;
    List<Food> foods;

    public Seat(String seatNumber) {
        this.id = lastId++;
        this.foods = new ArrayList<>();
        this.seatNumber = seatNumber;
    }

    public boolean getIsAvailable() {
        return this.isAvailable;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    //Ocupar asiento
    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void addFood(Food food) {
        this.foods.add(food);
    }

    public boolean checkClient(Client client) {
        if (this.client == null) return false;
        return this.client.getDocumentoId() ==  client.getDocumentoId(); // Igual se puede comparar referencias
    }
}
