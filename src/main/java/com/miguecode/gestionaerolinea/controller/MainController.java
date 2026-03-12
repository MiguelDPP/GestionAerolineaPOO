package com.miguecode.gestionaerolinea.controller;

import com.miguecode.gestionaerolinea.ui.MenuView;
import com.miguecode.gestionaerolinea.util.Console;
import com.miguecode.gestionaerolinea.util.Validator;

public class MainController {
    private PlaneController planeController;
    private FoodController foodController;

    public MainController(PlaneController planeController, FoodController foodController) {
        this.planeController = planeController;
        this.foodController = foodController;
    }

    public void run () {
        short op = 0;

        System.out.println("---- Bienvenido a su Aerolinea WFLYS (World Fly Solution) ----");
        do {
            MenuView.showInitialMenu();
            op = Console.readValidator("Seleccione una opción: ", Short::parseShort, Validator::positiveNumber);

            switch (op) {
                case 1:
                    this.planeController.addPlane();
                    break;
                case 2:
                    this.planeController.sellSeat();
                    break;
                case 3:
                    this.foodController.addFoodToMenu();
                    break;
                case 4:
                    this.planeController.placeFoodOrder();
                    break;
                case 5:
                    this.planeController.showTotalForClient();
                    break;
                case 6:
                    System.out.println("--- Ha salido del sistema ---");
                    break;
                default:
                    System.out.println("--- Opción incorrecta ---");
            }
        } while (op != 8);
    }
}
