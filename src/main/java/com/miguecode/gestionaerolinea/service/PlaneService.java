package com.miguecode.gestionaerolinea.service;

import com.miguecode.gestionaerolinea.domain.Plane;

import java.util.ArrayList;
import java.util.List;

public class PlaneService {
    private List<Plane> planes;
    private static final PlaneService INSTANCE = new  PlaneService();

    private PlaneService(){
        this.planes = new ArrayList<>();
    }

    public static PlaneService getInstance(){
        return INSTANCE;
    }

    public void addPlane(String pilotName, double price, String destination, int rows, int columns) {
        this.planes.add(new Plane(pilotName, price, destination, rows, columns));
    }

    public List<Plane> getPlanes() {
        return this.planes;
    }
}
