package com.kour.Game.models;
import com.kour.Game.models.ParametroSistema;

import com.kour.Game.models.businessException.ExcedidoTiempoMaximoRentaException;
import com.kour.Game.models.mensajes.Mensaje;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RentaTest {

    private Renta rentatest;
    private Date fechaRenta;
    private Date fechaActual;

    @Rule
    public final ExpectedException exception = ExpectedException.none();


    @Before
    public void setUp() throws ParseException {
        rentatest = new Renta();
        rentatest.setFechaRenta("2019-08-12");
    }

    @Test
    public void calcularDiasUso() throws  ParseException {
        String fechaActual = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        String nuevaFechaRenta = String.valueOf(fechaActual);
        rentatest.setFechaRenta(nuevaFechaRenta);

        int diasEsperados = 0;
        int diasSalida = rentatest.calculateDiasUso();

        Assert.assertEquals(diasEsperados, diasSalida,0.5);
    }

    @Test
    public void seExcedioTiempoRenta() throws ExcedidoTiempoMaximoRentaException, ParseException {
        exception.expect(ExcedidoTiempoMaximoRentaException.class);
        exception.expectMessage(Mensaje.Renta.DIAS_EXCEDIDOS);
        rentatest.calcularSiExcedioTiempo();
    }



}