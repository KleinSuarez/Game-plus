package com.kour.Game.models;

import com.kour.Game.models.businessException.ProductoNoDisponibleException;
import com.kour.Game.models.mensajes.Mensaje;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InventarioTest {
    private Inventario inventario;
    private CatalogoVideoJuegos catalogoVideoJuegos;
    private VideoJuego videoJuego;

    @Rule
    public final ExpectedException expectedException = ExpectedException.none();

    @Before
    public void setUp(){
        videoJuego = new VideoJuego("JuegoPrueba");
        catalogoVideoJuegos = new CatalogoVideoJuegos(videoJuego, 0);
        inventario = new Inventario(catalogoVideoJuegos);
    }

    @Test
    public void isDisponible() throws ProductoNoDisponibleException {
        expectedException.expect(ProductoNoDisponibleException.class);
        expectedException.expectMessage(Mensaje.Inventario.PRODUCTO_NO_DISPONIBLE);
        inventario.verificarDisponibilidadJuego(videoJuego);
    }


}

















