package com.juegos.backend.dto;

public class Mensaje {
    private String  message;

    public Mensaje(String mensaje) {
        this.message = mensaje;
    }

    public String getMensaje() {
        return message;
    }

    public void setMensaje(String mensaje) {
        this.message = mensaje;
    }
}
