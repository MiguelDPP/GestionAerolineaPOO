package com.miguecode.gestionaerolinea.service;

import com.miguecode.gestionaerolinea.domain.Plane;
import com.miguecode.gestionaerolinea.domain.Seat;
import com.miguecode.gestionaerolinea.exception.EntityNotFoundException;

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

    public Plane getPlaneById(int planeId) {
        for (Plane plane: planes) {
            if (plane.checkId(planeId)) {
                return plane;
            }
        }
        return null;
    }

    public Seat[][] getSeatsByPlaneId(int planeId) {
        Plane plane = getPlaneById(planeId);
        if (plane == null) {
            throw new EntityNotFoundException("El vuelo con el Id "+ planeId + "no existe");
        }
        return plane.getSeats();
    }

    public List<Plane> getPlanes() {
        return this.planes;
    }
}
