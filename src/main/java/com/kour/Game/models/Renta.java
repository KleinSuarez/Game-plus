package com.kour.Game.models;

import com.kour.Game.models.businessException.ExcedidoTiempoMaximoRentaException;
import com.kour.Game.models.mensajes.Mensaje;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Renta {
    private Long id;
    private Date fechaRenta;
    private SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
    private List<VideoJuego> videoJuegos = new ArrayList<>();
    private Cliente cliente;
    private  boolean devuelto = false;

    public Renta(){}
    public Renta(String fechaRenta, List<VideoJuego> videoJuegos, Cliente cliente) throws ParseException {
        this.fechaRenta = formatoFecha.parse(fechaRenta);
        this.videoJuegos = videoJuegos;
        this.cliente = cliente;
    }
    public Renta(String fechaRenta, VideoJuego videoJuego, Cliente cliente) throws ParseException {
        this.fechaRenta = formatoFecha.parse(fechaRenta);
        this.videoJuegos.add(videoJuego);
        this.cliente = cliente;

    }


    public Renta(VideoJuego videoJuego, Cliente cliente) {
        this.videoJuegos.add(videoJuego);
        this.cliente = cliente;
    }


    public int calculateDiasUso(){
        java.util.Date fechaActual = new Date();
        return  (int) ((fechaActual.getTime()-this.fechaRenta.getTime())/86400000);
    }

    public boolean calcularSiExcedioTiempo () throws ExcedidoTiempoMaximoRentaException, ParseException {
        if (this.calculateDiasUso() > ParametroSistema.DIAS_MAXIMO_DE_RENTA){
            throw new ExcedidoTiempoMaximoRentaException(Mensaje.Renta.DIAS_EXCEDIDOS);
        }
        return false;
    }

    public Cliente listarClienteProdutoNoDevuelto (){
        if(!devuelto){
            return this.cliente;
        }
        return null;
    }

    // Getter and Setter

    public void setFechaRenta(String fechaRenta) throws ParseException {
        this.fechaRenta = formatoFecha.parse(fechaRenta);
    }
}
