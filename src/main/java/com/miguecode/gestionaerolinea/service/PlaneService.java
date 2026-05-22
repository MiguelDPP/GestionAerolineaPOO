package com.miguecode.gestionaerolinea.service;

import com.miguecode.gestionaerolinea.domain.Client;
import com.miguecode.gestionaerolinea.domain.Plane;
import com.miguecode.gestionaerolinea.domain.Seat;
import com.miguecode.gestionaerolinea.exception.DuplicateEntityException;
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

    public List<Plane> getPlanesByClient (Client client) {
        List<Plane> clientPlanes = new ArrayList<>();
        for (Plane plane: this.planes) {
            if (plane.checkClient(client)) {
                clientPlanes.add(plane);
            }
        }

        return  clientPlanes;
    }

    public Seat[][] getSeatsByPlaneId(int planeId) {
        Plane plane = getPlaneById(planeId);
        if (plane == null) {
            throw new EntityNotFoundException("El vuelo con el Id "+ planeId + "no existe");
        }
        return plane.getSeats();
    }

    public Seat getSeatByPlaneAndClient(int planeId, Client client) {
        for (Plane plane: planes) {
            if (plane.checkId(planeId) && plane.checkClient(client)) {
                return plane.getSeatByClient(client);
            }
        }

        throw new EntityNotFoundException("No se encuentran registros del vuelo o el documento del cliente ingresado");
    }

    public List<Plane> getPlanes() {
        return this.planes;
    }

    public Seat getSeat(int seatNumber, Plane plane) {
        Seat seat = plane.getSeat(seatNumber);
        if (seat == null) {
            throw new EntityNotFoundException("El asiento #"+seatNumber+" no existe");
        }
        if (!seat.getIsAvailable()) {
            throw new DuplicateEntityException("El asiento #"+seatNumber+" se encuentra ocupado");
        }

        return seat;
    }

    public void checkClient(Client client, int planeId) {
        Plane plane = this.getPlaneById(planeId);
        if (plane == null) {
            throw new EntityNotFoundException("El avion #"+planeId+" no existe");
        }
        if (plane.checkClient( client)) {
            throw new DuplicateEntityException("Cliente con el documento "+client.getDocumentoId()+" ya tiene apartado un asiento en este vuelo");
        }
    }

    public void addSeat(int seatNumber, int planeId, Client client) {
        Plane plane = this.getPlaneById(planeId);
        Seat seat = this.getSeat(seatNumber, plane);
        seat.setIsAvailable(false);
        seat.setClient(client);
    }
}
