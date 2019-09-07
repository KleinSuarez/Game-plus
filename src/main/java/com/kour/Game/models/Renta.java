package com.kour.Game.models;

import java.util.List;

public class Renta {
    private Long id;
    private String fechaRenta;
    private List<VideoJuego> videoJuegos;
    private Cliente cliente;

    public Long getId() {
        return id;
    }

    public String getFechaRenta() {
        return fechaRenta;
    }

    public void setFechaRenta(String fechaRenta) {
        this.fechaRenta = fechaRenta;
    }

    public List<VideoJuego> getVideoJuegos() {
        return videoJuegos;
    }

    public void setVideoJuegos(List<VideoJuego> videoJuegos) {
        this.videoJuegos = videoJuegos;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
