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
}
