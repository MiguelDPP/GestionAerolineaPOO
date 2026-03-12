package com.miguecode.gestionaerolinea.service;

import com.miguecode.gestionaerolinea.domain.Client;

import java.util.ArrayList;
import java.util.List;

public class ClientService {
    private List<Client> clients;

    private static final ClientService INSTANCE =  new ClientService();

    private ClientService () {
        clients = new ArrayList<>();
    }

    public static ClientService getInstance() {
        return INSTANCE;
    }

    public List<Client> getClients() {
        return clients;
    }
}
