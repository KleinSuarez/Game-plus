package com.kour.Game.models;

import java.util.List;

public class Inventario {
    private  Long id;
    private  List<VideoJuego> videoJuegos;
    private  boolean disponibilidad;

    public Inventario() {
    }

    public Long getId() {
        return id;
    }

    public List<VideoJuego> getVideoJuegos() {
        return videoJuegos;
    }

    public void setVideoJuegos(List<VideoJuego> videoJuegos) {
        this.videoJuegos = videoJuegos;
    }

    public boolean isDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }
}
