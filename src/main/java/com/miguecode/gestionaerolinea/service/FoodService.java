package com.miguecode.gestionaerolinea.service;

import com.miguecode.gestionaerolinea.domain.Food;
import com.miguecode.gestionaerolinea.exception.EntityNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class FoodService {
    private List<Food> foods;
    private static final FoodService INSTANCE = new FoodService();
    private FoodService () {
        this.foods = new ArrayList<>();
    }
    public static FoodService getInstance() {
        return INSTANCE;
    }

    public void addFood(String foodName, double foodPrice) {
        Food food = new Food(foodName, foodPrice);
        this.foods.add(food);
    }

    public List<Food> getFoods() {
        return foods;
    }

    public Food getFoodById(int id) {
        for (Food food : this.foods) {
            if (food.checkId(id)) {
                return food;
            }
        }

        throw new EntityNotFoundException("Comida con el id "+id+" no encontrada");
    }
}
