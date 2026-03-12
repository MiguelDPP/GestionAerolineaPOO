package com.miguecode.gestionaerolinea.domain;

public class Client {
    private long documentoId;
    private String name;
    private short age;

    public Client(String name, long documentoId, short age) {
        this.name = name;
        this.documentoId = documentoId;
        this.age = age;
    }

    public boolean verifyDocument(int documentoId) {
        return this.documentoId == documentoId;
    }

    public long getDocumentoId() {
        return documentoId;
    }

    public String getName() {
        return name;
    }

    public short getAge() {
        return age;
    }
}
