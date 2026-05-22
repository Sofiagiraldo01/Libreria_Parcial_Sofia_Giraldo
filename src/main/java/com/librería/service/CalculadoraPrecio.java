package com.librería.service;

import com.librería.model.Producto;

public class CalculadoraPrecio {

    private static final double IVA = 0.19;

    public double aplicarDescuento(Producto producto, double descuento) {

        if (descuento < 0 || descuento > 40) {
            throw new IllegalArgumentException(
                    "El descuento debe estar entre 0 y 40"
            );
        }

        return producto.getPrecioBase() * (1 - descuento / 100);
    }

    public double calcularPrecioFinal(Producto producto, double descuento) {

        double precioConDescuento =
                aplicarDescuento(producto, descuento);

        double precioFinal =
                precioConDescuento * (1 + IVA);

        if (precioFinal < 0) {
            throw new IllegalStateException(
                    "El precio final no puede ser negativo"
            );
        }

        return precioFinal;
    }
}


