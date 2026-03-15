package com.miguecode.gestionaerolinea.domain;

import com.miguecode.gestionaerolinea.util.StringOperations;

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
        int counter = 1;
        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[i].length; j++) {
                seats[i][j] = new Seat(StringOperations.getNumberFormatted(counter, this.getSeatQuantity()));
                counter++;
            }
        }
    }


    public int getSeatQuantity() {
        return seats.length * seats[0].length;
    }

    public int checkAvailableSeat() {
        int availableSeats = 0;
        for (Seat[] rowSeats: this.seats) {
            for (Seat seat: rowSeats) {
                if (seat.getIsAvailable()) {
                    availableSeats++;
                }
            }
        }

        return availableSeats;
    }

    public boolean checkId(int planeId) {
        return this.id == planeId;
    }

    public Seat[][] getSeats() {
        return seats;
    }

    @Override
    public String toString() {
        return String.format("%-10s %-20s %-20s %-10s %-10s", this.id, this.destination, this.pilotName, this.price, this.checkAvailableSeat());
    }
}
