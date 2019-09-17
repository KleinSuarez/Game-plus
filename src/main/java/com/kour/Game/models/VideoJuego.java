package com.kour.Game.models;

import java.util.ArrayList;
import java.util.List;

public class VideoJuego {
    private  Long id;
    private  String titulo;
    private  String aniolanzamiento;
    private  String companiaDesarrollo;
    private  String descripcion;
    private List<String> categoria = new ArrayList<String>();
    private  TipoClasificacion tipoClasificacion;
    private  String categoriaClasificacion;
    private  TipoConsola tipoConsola;

    public VideoJuego (){}
    public VideoJuego (String titulo){
        this.titulo = titulo;
    }

    public void agregarCategoria(String ... categoria) {
        for (String catg: categoria) {
            this.categoria.add(catg);
        }
    }

    public void setAniolanzamiento(String aniolanzamiento) {
        this.aniolanzamiento = aniolanzamiento;
    }

    public String getAniolanzamiento() {
        return aniolanzamiento;
    }
}
