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

    public void diasUso () throws ExcedidoTiempoMaximoRentaException, ParseException {
        java.util.Date fechaActual = new Date();
        int diasUso =(int) ((fechaActual.getTime()-this.fechaRenta.getTime())/86400000);

        if (diasUso > ParametroSistema.DIAS_MAXIMO_DE_RENTA){
            throw new ExcedidoTiempoMaximoRentaException(Mensaje.Renta.DIAS_EXCEDIDOS);
        }

    }



    public void setFechaRenta(String fechaRenta) throws ParseException {
        this.fechaRenta = formatoFecha.parse(fechaRenta);
    }

    public Date getFechaRenta() {
        return fechaRenta;
    }

    public boolean isDevuelto() {
        return devuelto;
    }

    public void setDevuelto(boolean devuelto) {
        this.devuelto = devuelto;
    }
}
