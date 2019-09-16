package com.kour.Game.models;

import java.util.ArrayList;
import java.util.List;

public class Inventario {
    private  Long id;
    private  List<VideoJuego> videoJuegos = new ArrayList<>();
    private  List<Disponibilidad> disponibilidad = new ArrayList<>();

    public Inventario() {
    }

    public Inventario(List<VideoJuego> videoJuegos) {
        this.videoJuegos = videoJuegos;
    }

    public void agregarVideoJuego(VideoJuego videoJuego, Disponibilidad disponibilidad){
        this.videoJuegos.add(videoJuego);
        this.disponibilidad.add(disponibilidad);
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

}
