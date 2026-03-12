package com.miguecode.gestionaerolinea.domain;

public class Plane {
    private static int lastId = 1;
    private int id;
    private String pilotName;
    private double price;
    private Seat[][] seats;
    private String destination;

    public Plane(String pilotName, double price, String destination, int rows, int columns) {
        this.id = lastId++;
        this.pilotName = pilotName;
        this.price = price;
        this.destination = destination;
        this.seats = new Seat[rows][columns];
        this.fillSeats();
    }

    private void fillSeats() {
        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[i].length; j++) {
                seats[i][j] = new Seat();
            }
        }
    }
}
