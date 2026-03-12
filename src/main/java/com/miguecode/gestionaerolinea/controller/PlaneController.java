package com.miguecode.gestionaerolinea.controller;

import com.miguecode.gestionaerolinea.service.PlaneService;
import com.miguecode.gestionaerolinea.util.Console;
import com.miguecode.gestionaerolinea.util.Validator;

public class PlaneController {
    private final PlaneService planeService = PlaneService.getInstance();

    public void addPlane() {
        System.out.println("---- Agregar un vuelo ----");
        String pilotName = Console.readValidator("Ingrese el nombre del piloto: ", String::toString, Validator::isNotEmpty);
        String pilotName = Console.readValidator("Ingrese el nombre del piloto: ", String::toString, Validator::isNotEmpty);
        double price = Console.readValidator("Ingrese el valor del vuelo: ", Double::parseDouble, Validator::positiveDecimalNumber);
        int rows = Console.readValidator("Ingrese la cantidad de filas de asientos: ", Integer::parseInt, Validator::positiveNumber);
        int columns = Console.readValidator("Ingrese la cantidad de columnas de asientos: ", Integer::parseInt, Validator::positiveNumber);

        this.planeService.addPlane(pilotName, price, );
    }

    public void sellSeat() {

    }

    public void showTotalForClient() {

    }

    public void placeFoodOrder() {
    }
}
