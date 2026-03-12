package com.miguecode.gestionaerolinea;

import com.miguecode.gestionaerolinea.controller.FoodController;
import com.miguecode.gestionaerolinea.controller.MainController;
import com.miguecode.gestionaerolinea.controller.PlaneController;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        new MainController(new PlaneController(), new FoodController()).run();
    }
}
