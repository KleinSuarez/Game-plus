package com.kour.Game.models;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class VideoJuegoTest {
    private VideoJuego videoJuego;

    @Before
    public void setUp(){
        videoJuego = new VideoJuego("JuegoDePrueba");
        videoJuego.setAniolanzamiento("2018");
        videoJuego.agregarCategoria("Lista", "Categoria");
    }

    @Test
    public void obtenerAnioLanzamiento(){
        String anioLanzamientoEsperado = "2019";
        Assert.assertEquals(anioLanzamientoEsperado,videoJuego.getAniolanzamiento());
    }

}