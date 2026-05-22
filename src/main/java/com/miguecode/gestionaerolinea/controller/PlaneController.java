package com.miguecode.gestionaerolinea.controller;

import com.miguecode.gestionaerolinea.domain.Client;
import com.miguecode.gestionaerolinea.domain.Food;
import com.miguecode.gestionaerolinea.domain.Plane;
import com.miguecode.gestionaerolinea.domain.Seat;
import com.miguecode.gestionaerolinea.exception.EntityNotFoundException;
import com.miguecode.gestionaerolinea.service.ClientService;
import com.miguecode.gestionaerolinea.service.FoodService;
import com.miguecode.gestionaerolinea.service.PlaneService;
import com.miguecode.gestionaerolinea.ui.Printer;
import com.miguecode.gestionaerolinea.util.Console;
import com.miguecode.gestionaerolinea.util.Validator;

import java.util.List;

public class PlaneController {
    private final PlaneService planeService = PlaneService.getInstance();
    private final ClientService clientService = ClientService.getInstance();
    private final FoodService foodService = FoodService.getInstance();

    public void addPlane() {
        System.out.println("---- Agregar un vuelo ----");
        String pilotName = Console.readValidator("Ingrese el nombre del piloto: ", String::toString, Validator::isNotEmpty);
        double price = Console.readValidator("Ingrese el valor del vuelo: ", Double::parseDouble, Validator::positiveDecimalNumber);
        String planeDestination = Console.readValidator("Ingrese el lugar de destino: ", String::toString, Validator::isNotEmpty);
        int rows = Console.readValidator("Ingrese la cantidad de filas de asientos: ", Integer::parseInt, Validator::positiveNumber);
        int columns = Console.readValidator("Ingrese la cantidad de columnas de asientos: ", Integer::parseInt, Validator::positiveNumber);

        this.planeService.addPlane(pilotName, price, planeDestination, rows, columns);

        System.out.println("---- Vuelo agregado correctamente ----");
    }

    public void showPlane() {
        Printer.printPlanes(this.planeService.getPlanes());
    }

    public void sellSeat() {
        System.out.println("---- Vender Asiento ----");
        this.showPlane();
        int planeId = Console.readValidator("Ingrese el Id del vuelo: ", Integer::parseInt, Validator::positiveNumber);
        try {
            Seat[][] seats = this.planeService.getSeatsByPlaneId(planeId);
            long documentId = Console.readValidator("Ingrese su numero de documento: ", Long::parseLong, Validator::positiveNumber);
            Client client = clientService.getClient(documentId);
            if (client == null) {
                String name = Console.read("Ingrese su nombre: ", String::toString);
                short age = Console.readValidator("Ingrese su edad: ", Short::parseShort, Validator::positiveNumber);

                client = clientService.createClient(documentId, name, age);
            } else {
                // Check client
                this.planeService.checkClient(client, planeId);
            }

            Printer.printSeats(seats);
            int seat = Console.readValidator("Ingrese el numero de asiento: ", Integer::parseInt, Validator::positiveNumber);

            this.planeService.addSeat(seat, planeId, client);

            System.out.println("---- Asiento ocupado Correctamente ----");
        } catch (RuntimeException e) {
            Console.printException(e);
        }

    }

    public void showTotalForClient() {

    }

    public void placeFoodOrder() {
        Printer.printFoods(foodService.getFoods());
        int foodId = Console.readValidator("Ingrese el Id de la comida que desea: ", Integer::parseInt, Validator::positiveNumber);

        try {

            Food food = this.foodService.getFoodById(foodId);
            long documentId = Console.readValidator("Ingrese su numero de documento: ", Long::parseLong, Validator::positiveNumber);
            Client client = clientService.getClient(documentId);
            if (client == null) {
                throw new EntityNotFoundException("Cliente no encontrado");
            }
            List<Plane> planes = this.planeService.getPlanesByClient(client);
            Printer.printPlanes(planes);

            int planeId = Console.readValidator("Ingrese el Id del vuelo: ", Integer::parseInt, Validator::positiveNumber);
            Seat seat = this.planeService.getSeatByPlaneAndClient(planeId, client);
            System.out.println("--- Asiento Encontrado: "+seat.getSeatNumber()+" ----");

            char confirm = Console.read("Precione la tecla [S] si desea continuar, de lo contrario precione cualquier tecla", String::toString).toLowerCase().charAt(0);

            if (confirm == 's') {
                seat.addFood(food);
                System.out.println("---- Comida agregada correctamente ----");
            } else {
                System.out.println("---- Operación cancelada ----");
            }
        } catch (RuntimeException e) {
            Console.printException(e);
        }
    }
}
