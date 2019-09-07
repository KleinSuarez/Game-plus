package com.kour.Game.models;

public class TipoClasificacion {
    private  Long id;
    private  String clasificacion;
    private  String sigla;

    // La clasificación puede ser PEGI o ESRB dependiendo del país donse se encuentre
    public Long getId() {
        return id;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }
}
