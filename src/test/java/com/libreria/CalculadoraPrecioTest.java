package com.libreria;

import com.librería.model.Producto;
import com.librería.service.CalculadoraPrecio;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculadoraPrecioTest {

    private final CalculadoraPrecio calculadora =
            new CalculadoraPrecio();

    @Test
    void deberiaAplicarDescuentoValido() {

        Producto producto = new Producto("Libro", 100);

        double resultado =
                calculadora.aplicarDescuento(producto, 20);

        assertEquals(80, resultado);
    }

    @Test
    void deberiaAceptarDescuentoCero() {

        Producto producto = new Producto("Libro", 100);

        double resultado =
                calculadora.aplicarDescuento(producto, 0);

        assertEquals(100, resultado);
    }

    @Test
    void deberiaAceptarDescuentoCuarenta() {

        Producto producto = new Producto("Libro", 100);

        double resultado =
                calculadora.aplicarDescuento(producto, 40);

        assertEquals(60, resultado);
    }

    @Test
    void deberiaRechazarDescuentoMayorACuarenta() {

        Producto producto = new Producto("Libro", 100);

        assertThrows(
                IllegalArgumentException.class,
                () -> calculadora.aplicarDescuento(producto, 50)
        );
    }

    @Test
    void deberiaCalcularPrecioFinal() {

        Producto producto = new Producto("Libro", 100);

        double resultado =
                calculadora.calcularPrecioFinal(producto, 20);

        assertEquals(95.2, resultado, 0.001);
    }

}
