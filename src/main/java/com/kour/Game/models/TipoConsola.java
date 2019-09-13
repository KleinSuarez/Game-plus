package com.kour.Game.models;

public class TipoConsola {
    private Long id;
    private  String nombre;
    private  boolean flascheo;
    private  String tipoMemoria;
    private  String capacidadAlmacenamiento;

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isFlascheo() {
        return flascheo;
    }

    public void setFlascheo(boolean flascheo) {
        this.flascheo = flascheo;
    }

    public String getTipoMemoria() {
        return tipoMemoria;
    }

    public void setTipoMemoria(String tipoMemoria) {
        this.tipoMemoria = tipoMemoria;
    }

    public String getCapacidadAlmacenamiento() {
        return capacidadAlmacenamiento;
    }

    public void setCapacidadAlmacenamiento(String capacidadAlmacenamiento) {
        this.capacidadAlmacenamiento = capacidadAlmacenamiento;
    }
}
