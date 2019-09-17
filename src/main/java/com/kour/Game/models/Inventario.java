package com.kour.Game.models;

import com.kour.Game.models.businessException.ProductoNoDisponibleException;
import com.kour.Game.models.mensajes.Mensaje;

import java.util.ArrayList;
import java.util.List;

public class Inventario {
    private  Long id;
    //private  List<VideoJuego> videoJuegos = new ArrayList<>();
    private  List<CatalogoVideoJuegos> catalogoVideoJuegos = new ArrayList<>();

    public Inventario() {
    }

    public Inventario(CatalogoVideoJuegos catalogoVideoJuegos) {
        this.catalogoVideoJuegos.add(catalogoVideoJuegos);
    }

    public void agregarVideoJuego(VideoJuego videoJuego, CatalogoVideoJuegos catalogoVideoJuegos){
        //this.videoJuegos.add(videoJuego);
        this.catalogoVideoJuegos.add(catalogoVideoJuegos);
    }

    public boolean verificarDisponibilidadJuego (VideoJuego videoJuego) throws ProductoNoDisponibleException{
        boolean disponile = false;
        for (CatalogoVideoJuegos vj: catalogoVideoJuegos) {
            if(videoJuego.equals(vj.getVideoJuego()) && vj.isDisponible() == false){
                throw new ProductoNoDisponibleException(Mensaje.Inventario.PRODUCTO_NO_DISPONIBLE);
            }
            else {
                disponile = true;
            }
        }

        return disponile;
    }

}
