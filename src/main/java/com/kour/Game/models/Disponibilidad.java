package com.kour.Game.models;

import java.util.List;

public class Disponibilidad {
    private VideoJuego videoJuego;
    private int cantidad;

    public Disponibilidad(VideoJuego videoJuego, int cantidad) {
        this.videoJuego = videoJuego;
        this.cantidad = cantidad;
    }

    public boolean isDisponible(){
        if(this.cantidad > 0){
            return  true;
        }else{
            return false;
        }
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
