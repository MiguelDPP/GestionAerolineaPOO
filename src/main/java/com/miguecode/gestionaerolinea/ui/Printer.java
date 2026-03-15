package com.miguecode.gestionaerolinea.ui;

import com.miguecode.gestionaerolinea.domain.Plane;
import com.miguecode.gestionaerolinea.domain.Seat;

import java.util.List;

public class Printer {
    public static void printPlanes(List<Plane> planes) {
        System.out.printf("%-24sListado De Aviones\n","");
        System.out.println("----------------------------------------------------------------------------------------");
        System.out.printf("%-10s %-20s %-20s %-10s %-10s\n", "Id", "Destino", "Piloto", "Precio","Asientos Disponibles");
        System.out.println("----------------------------------------------------------------------------------------");
        if (planes.isEmpty()) {
            System.out.println("No hay vuelos disponibles");
            return;
        }
        for (Plane plane : planes) {
            System.out.println(plane);
        }
        System.out.println();
    }

    public static void printSeats(Seat[][] seats) {
        System.out.printf("%-24sListado De Asientos\n","");
        System.out.println("Asientos marcados con XX se encuentran ocupados");

        int seatQuantity = seats.length*seats[0].length;
        int length = String.valueOf(seatQuantity).length();
        System.out.print("\t");
        for(int j=0; j<seats[0].length; j++) {
            System.out.printf("%-"+(length+4)+"s", "C"+(j+1));
        }
        for(int i=0; i<seats.length; i++) {
            System.out.printf("\nF%d\t", (i+1));
            for(int j=0; j<seats[i].length; j++) {
                System.out.printf("%-"+(length+4)+"s", "["+(!seats[i][j].getIsAvailable()?"x".repeat(length):seats[i][j].getSeatNumber())+"]");
            }
        }

        System.out.println();
    }
}
