package com.kour.Game.models;

import com.kour.Game.models.businessException.ProductoNoDisponibleException;

import java.util.List;

public class CatalogoVideoJuegos {
    private VideoJuego videoJuego;
    private int cantidad;

    public CatalogoVideoJuegos(){}

    public CatalogoVideoJuegos(VideoJuego videoJuego){
        this.videoJuego = videoJuego;
    }

    public CatalogoVideoJuegos(VideoJuego videoJuego, int cantidad) {
        this.videoJuego = videoJuego;
        this.cantidad = cantidad;
    }

    public void disminuirCantidad(){
        this.cantidad --;
    }

    public void aumentarCantidad(){
        this.cantidad ++;
    }

    public boolean isDisponible() {
        if(this.cantidad > 0){
            return  true;
        }else{
            return false;
        }
    }

    public VideoJuego getVideoJuego() {
        return videoJuego;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
