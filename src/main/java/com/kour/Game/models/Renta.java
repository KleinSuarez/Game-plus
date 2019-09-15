package com.kour.Game.models;

import com.kour.Game.models.businessException.ExcedidoTiempoMaximoRentaException;
import com.kour.Game.models.mensajes.Mensaje;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Renta {
    private Long id;
    private Date fechaRenta;
    private SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
    private List<VideoJuego> videoJuegos;
    private Cliente cliente;
    private boolean devuelto;

    public Renta(){}
    public Renta(String fechaRenta, List<VideoJuego> videoJuegos, Cliente cliente) throws ParseException {
        this.fechaRenta = formatoFecha.parse(fechaRenta);
        this.videoJuegos = videoJuegos;
        this.cliente = cliente;
    }


    public int calculateDiasUso(){
        java.util.Date fechaActual = new Date();
        return  (int) ((fechaActual.getTime()-this.fechaRenta.getTime())/86400000);
    }

    public void diasUso () throws ExcedidoTiempoMaximoRentaException, ParseException {

        if (this.calculateDiasUso() > ParametroSistema.DIAS_MAXIMO_DE_RENTA){
            throw new ExcedidoTiempoMaximoRentaException(Mensaje.Renta.DIAS_EXCEDIDOS);
        }

    }

    public Renta clienteSinDevolverVideoJuego () {


        return this;
    }

}
