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
import java.util.List;

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

    @Test
    public void ListarClienteJuegoNoDevuelto() throws ParseException {
        Cliente clienteExperado = new Cliente("Nombre","Apellido");
        VideoJuego videoJuego = new VideoJuego("Juego de prueba");
        Disponibilidad disponibilidad = new Disponibilidad(videoJuego,3);
        Inventario inventario = new Inventario();
        inventario.agregarVideoJuego(videoJuego,disponibilidad);

        rentatest = new Renta("2019-08-12", videoJuego, clienteExperado);

        Cliente clienteDevuelto = rentatest.listarClienteProdutoNoDevuelto();

        Assert.assertEquals(clienteExperado, clienteDevuelto);
    }

}