package com.kour.Game.models;

import com.kour.Game.models.businessException.ExcedidoTiempoMaximoRentaException;
import com.kour.Game.models.businessException.ProductoExistenteException;
import com.kour.Game.models.businessException.ProductoNoDisponibleException;
import com.kour.Game.models.businessException.ProductoNoExistenteException;
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

@RunWith(SpringRunner.class)
@SpringBootTest
public class RentaTest {

    private Renta rentatest;
    private String fechaActual;
    private VideoJuego videoJuego;
    private Inventario inventario;
    private CatalogoVideoJuegos catalogoVideoJuegos;

    @Rule
    public final ExpectedException exception = ExpectedException.none();


    @Before
    public void setUp() throws ParseException {
        fechaActual = new SimpleDateFormat("yyyy-MM-dd").format(new Date());

        rentatest = new Renta();
        rentatest.setFechaRenta("2019-08-12");

        videoJuego = new VideoJuego("Juego de prueba");
        catalogoVideoJuegos = new CatalogoVideoJuegos(videoJuego,3);
        inventario = new Inventario();
        inventario.agregarVideoJuego(videoJuego, catalogoVideoJuegos);
    }

    @Test
    public void calcularDiasUso() throws  ParseException {
        int diasEsperados = 0;
        String nuevaFechaRenta = String.valueOf(fechaActual);
        rentatest.setFechaRenta(nuevaFechaRenta);
        int diasSalida = rentatest.calculateDiasUso();

        Assert.assertEquals(diasEsperados, diasSalida,0.5);
    }

    @Test
    public void tiempoRentaExcedido() throws ExcedidoTiempoMaximoRentaException, ParseException {
        exception.expect(ExcedidoTiempoMaximoRentaException.class);
        exception.expectMessage(Mensaje.Renta.DIAS_EXCEDIDOS);
        rentatest.calcularSiExcedioTiempo();
    }

    @Test
    public void ListarClienteJuegoNoDevuelto() throws ParseException {
        Cliente clienteExperado = new Cliente("Cliente","Test");
        rentatest = new Renta("2019-08-12", videoJuego, clienteExperado);
        Cliente clienteDevuelto = rentatest.listarClienteProdutoNoDevuelto();

        Assert.assertEquals(clienteExperado, clienteDevuelto);
    }

    @Test
    public void rentarJuegoNoExistente() throws ProductoNoExistenteException{
        VideoJuego nuevoVideoJuego = new VideoJuego("Nuevo Juego");
        exception.expect(ProductoNoExistenteException.class);
        exception.expectMessage(Mensaje.Inventario.PRODUCTO_NO_EXISTENTE);
        rentatest.rentarVideoJuego(inventario, nuevoVideoJuego);
    }

    @Test
    public void devolverJuegoNoExixtente() throws  ProductoNoExistenteException{
        VideoJuego nuevoJuego = new VideoJuego("Nuevo Juego");
        exception.expect(ProductoNoExistenteException.class);
        exception.expectMessage(Mensaje.Inventario.PRODUCTO_NO_EXISTENTE);

        rentatest.devolverVideoJuego(inventario, nuevoJuego);
    }

    @Test
    public void ProductoNoDisponible() throws ProductoNoDisponibleException, ProductoExistenteException {
        VideoJuego nuevoVideoJuego = new VideoJuego("Nuevo Juego2");
        CatalogoVideoJuegos nCatalogoVideoJuegos = new CatalogoVideoJuegos(nuevoVideoJuego, 0);
        inventario.agregarVideoJuegoCatalogoInventario(nCatalogoVideoJuegos);

        exception.expect(ProductoNoDisponibleException.class);
        exception.expectMessage(Mensaje.Inventario.PRODUCTO_NO_DISPONIBLE);
        inventario.verificarDisponibilidadJuego(nuevoVideoJuego);
    }
    
}