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
    public void excedidoTiempoRenta() throws ExcedidoTiempoMaximoRentaException, ParseException {
        exception.expect(ExcedidoTiempoMaximoRentaException.class);
        exception.expectMessage(Mensaje.Renta.DIAS_EXCEDIDOS);
        rentatest.diasUso();

    }



}