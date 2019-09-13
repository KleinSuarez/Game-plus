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
public class ClienteTest {
    private  Cliente clienteTest;
    private  String nombre = "nombretest";
    private  String apellido = "apellidotest";

    @Before
    public void setUp (){
        clienteTest = new Cliente(nombre, apellido);
    }

    @Test
    public void obtenerNombreCliente(){
        String nombreEsperado = "nombretest";
        Assert.assertEquals(nombreEsperado, clienteTest.getNombre());

    }

}