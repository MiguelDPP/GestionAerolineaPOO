package com.miguecode.gestionaerolinea.service;

import com.miguecode.gestionaerolinea.domain.Food;

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
}
