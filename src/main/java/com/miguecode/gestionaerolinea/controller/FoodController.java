package com.miguecode.gestionaerolinea.controller;

import com.miguecode.gestionaerolinea.service.FoodService;
import com.miguecode.gestionaerolinea.util.Console;
import com.miguecode.gestionaerolinea.util.Validator;

public class FoodController {
    private final FoodService foodService = FoodService.getInstance();
    public void addFoodToMenu() {
        System.out.println("---- Añadir Comida Al Menú ----");
        String foodName = Console.readValidator("Ingrese el nombre de la comida: ", String::toString, Validator::isNotEmpty);
        double foodPrice = Console.readValidator("Precio de la comida: ", Double::parseDouble, Validator::positiveDecimalNumber);

        this.foodService.addFood(foodName, foodPrice);

        System.out.println("---- Comida agregada correctamente ----");

    }
}
