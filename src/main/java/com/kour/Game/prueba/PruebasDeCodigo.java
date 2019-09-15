package com.kour.Game.prueba;

import java.text.SimpleDateFormat;
import java.util.Date;

public class PruebasDeCodigo {
    public static void main(String[] args) {

        String fechaActual = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
        System.out.println(fechaActual);
    }
}
