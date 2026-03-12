package com.miguecode.gestionaerolinea.domain;

import java.util.ArrayList;
import java.util.List;

public class Seat {
    private static int lastId = 1;
    private int id;
    private boolean isBusy;
    private Client client;
    List<Food> foods;

    public Seat() {
        this.id = lastId++;
        this.foods = new ArrayList<>();
    }
}
