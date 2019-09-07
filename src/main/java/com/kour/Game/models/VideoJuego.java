package com.kour.Game.models;

public class VideoJuego {
    private  Long id;
    private  String titulo;
    private  String aniolanzamiento;
    private  String companiaDesarrollo;
    private  String descripcion;
    private  String [] categoria;
    private  TipoClasificacion tipoClasificacion;
    private  String categoriaClasificacion;
    private  TipoConsola tipoConsola;

    public VideoJuego (){}

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAniolanzamiento() {
        return aniolanzamiento;
    }

    public void setAniolanzamiento(String aniolanzamiento) {
        this.aniolanzamiento = aniolanzamiento;
    }

    public String getCompaniaDesarrollo() {
        return companiaDesarrollo;
    }

    public void setCompaniaDesarrollo(String companiaDesarrollo) {
        this.companiaDesarrollo = companiaDesarrollo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String[] getCategoria() {
        return categoria;
    }

    public void setCategoria(String[] categoria) {
        this.categoria = categoria;
    }

    public TipoClasificacion getTipoClasificacion() {
        return tipoClasificacion;
    }

    public void setTipoClasificacion(TipoClasificacion tipoClasificacion) {
        this.tipoClasificacion = tipoClasificacion;
    }

    public String getCategoriaClasificacion() {
        return categoriaClasificacion;
    }

    public void setCategoriaClasificacion(String categoriaClasificacion) {
        this.categoriaClasificacion = categoriaClasificacion;
    }

    public TipoConsola getTipoConsola() {
        return tipoConsola;
    }

    public void setTipoConsola(TipoConsola tipoConsola) {
        this.tipoConsola = tipoConsola;
    }
}
