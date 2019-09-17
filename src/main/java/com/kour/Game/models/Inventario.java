package com.kour.Game.models;

import java.util.ArrayList;
import java.util.List;

public class Inventario {
    private  Long id;
    private  List<VideoJuego> videoJuegos = new ArrayList<>();
    private  List<CatalogoVideoJuegos> catalogoVideoJuegos = new ArrayList<>();

    public Inventario() {
    }

    public Inventario(List<VideoJuego> videoJuegos) {
        this.videoJuegos = videoJuegos;
    }

    public void agregarVideoJuego(VideoJuego videoJuego, CatalogoVideoJuegos catalogoVideoJuegos){
        this.videoJuegos.add(videoJuego);
        this.catalogoVideoJuegos.add(catalogoVideoJuegos);
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
