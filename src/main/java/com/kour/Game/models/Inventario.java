package com.kour.Game.models;

import com.kour.Game.models.businessException.ProductoExistenteException;
import com.kour.Game.models.businessException.ProductoNoDisponibleException;
import com.kour.Game.models.mensajes.Mensaje;

import java.util.ArrayList;
import java.util.List;

public class Inventario {
    private  Long id;
    private  List<CatalogoVideoJuegos> catalogoVideoJuegos = new ArrayList<>();

    public Inventario() {}

    public Inventario(CatalogoVideoJuegos catalogoVideoJuegos) {
        this.catalogoVideoJuegos.add(catalogoVideoJuegos);
    }

    public void agregarVideoJuego(VideoJuego videoJuego, CatalogoVideoJuegos catalogoVideoJuegos){

        this.catalogoVideoJuegos.add(catalogoVideoJuegos);
    }

    public void agregarVideoJuegoCatalogoInventario(VideoJuego videoJuego) throws ProductoExistenteException{
        boolean encontrado = this.buscarJuego(videoJuego);
        if(!encontrado){
            CatalogoVideoJuegos nuevoVideoJuego = new CatalogoVideoJuegos(videoJuego);
        }else{
            throw new ProductoExistenteException(Mensaje.Inventario.PRODUCTO_EN_INVENTARIO);
        }

    }

    public void agregarVideoJuegoCatalogoInventario(CatalogoVideoJuegos catalogoVideoJuego) throws ProductoExistenteException{
        boolean encontrado = this.buscarJuego(catalogoVideoJuego.getVideoJuego());
        if(!encontrado){
            this.catalogoVideoJuegos.add(catalogoVideoJuego);
        }else{
            throw new ProductoExistenteException(Mensaje.Inventario.PRODUCTO_EN_INVENTARIO);
        }

    }

    public boolean buscarJuego(VideoJuego videoJuego){
        boolean encontrado = false;
        for (CatalogoVideoJuegos vj:catalogoVideoJuegos) {
            if(videoJuego.equals(vj.getVideoJuego())){
                encontrado = true;
            }
        }
        return encontrado;
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

    public int obtenerCantidadJuego(VideoJuego videoJuego){
        int catidadVideoJuego = 0;
        for (CatalogoVideoJuegos vj: catalogoVideoJuegos) {
            if (videoJuego.equals(vj.getVideoJuego())){
                catidadVideoJuego = vj.getCantidad();
            }
        }
        return catidadVideoJuego;
    }

    public List<CatalogoVideoJuegos> getCatalogoVideoJuegos() {
        return catalogoVideoJuegos;
    }
}
