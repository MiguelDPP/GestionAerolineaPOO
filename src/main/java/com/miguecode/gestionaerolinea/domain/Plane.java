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

    public String getDestination() {
        return destination;
    }

    public boolean checkClient (Client client) {
        for (Seat[] rowSeat: this.seats) {
            for (Seat seat: rowSeat) {
                if (seat.checkClient(client)) {
                    return true;
                }
            }
        }

        return false;
    }

    public double getPrice() {
        return this.price;
    }

    public Seat getSeatByClient (Client client) {
        for (Seat[] rowSeat: this.seats) {
            for (Seat seat: rowSeat) {
                if (seat.checkClient(client)) {
                    return seat;
                }
            }
        }
        return null;
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

    public Seat getSeat(int seatNumber) {
        int columns = this.seats[0].length;
        int row = (seatNumber/columns);
        int column = (seatNumber%columns) - 1;
        if (column < 0) {
            column = columns - 1;
            row--;
        }
        return seats[row][column];
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
