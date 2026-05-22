package com.miguecode.gestionaerolinea.service;

import com.miguecode.gestionaerolinea.domain.Client;
import com.miguecode.gestionaerolinea.exception.DuplicateEntityException;

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

    public Client getClient(long documentId) {
        for (Client client : clients) {
            if (client.getDocumentoId() == documentId) {
                return client;
            }
        }
        return null;
    }

    public Client createClient(long documentId, String name, short age) {
        if (this.getClient(documentId) != null) {
            throw new DuplicateEntityException("Cliente existente");
        }

        Client client = new Client(name, documentId, age);
        this.clients.add(client);

        return client;
    }
}
