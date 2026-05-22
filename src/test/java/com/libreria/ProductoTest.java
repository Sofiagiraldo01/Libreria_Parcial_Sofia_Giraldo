package com.libreria;

import com.libreria.model.Producto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProductoTest {

    @Test
    void deberiaCrearProductoValido() {

        Producto producto = new Producto("Libro", 100);

        assertEquals(100, producto.getPrecioBase());
    }

    @Test
    void deberiaLanzarErrorSiPrecioEsCero() {

        Exception exception = assertThrows(
                IllegalArgumentException.class,
                () -> new Producto("Libro", 0)
        );

        assertEquals(
                "El precio base debe ser mayor que cero",
                exception.getMessage()
        );
    }

    @Test
    void deberiaLanzarErrorSiPrecioEsNegativo() {

        assertThrows(
                IllegalArgumentException.class,
                () -> new Producto("Libro", -10)
        );
    }
}