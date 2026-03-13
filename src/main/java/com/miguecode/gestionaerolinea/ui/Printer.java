package com.miguecode.gestionaerolinea.ui;

import com.miguecode.gestionaerolinea.domain.Plane;

import java.util.List;

public class Printer {
    public static void printPlanes(List<Plane> planes) {
        System.out.printf("%-24sListado De Aviones\n","");
        System.out.println("-----------------------------------------------------------------------");
        System.out.printf("%-10s %-20s %-20s %-10s\n", "Id", "Destino", "Piloto", "Precio");
        System.out.println("-----------------------------------------------------------------------");
        if (planes.isEmpty()) {
            System.out.println("No hay vuelos disponibles");
            return;
        }
        for (Plane plane : planes) {
            System.out.println(plane);
        }
        System.out.println();
    }
}
