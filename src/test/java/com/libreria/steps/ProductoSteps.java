package com.libreria.steps;

import com.librería.model.Producto;
import com.librería.service.CalculadoraPrecio;

import io.cucumber.java.en.*;

import static org.junit.jupiter.api.Assertions.*;

public class ProductoSteps {

    private Producto producto;
    private CalculadoraPrecio calculadora;
    private double resultado;
    private Exception exception;

    @Given("existe un producto llamado {string} con precio {int}")
    public void existeProducto(String nombre, int precio) {

        producto = new Producto(nombre, precio);
        calculadora = new CalculadoraPrecio();
    }

    @When("aplico un descuento de {int}")
    public void aplicarDescuento(int descuento) {

        resultado =
                calculadora.aplicarDescuento(producto, descuento);
    }

    @Then("el precio con descuento debe ser {int}")
    public void validarResultado(int esperado) {

        assertEquals(esperado, resultado);
    }

    @When("aplico un descuento inválido de {int}")
    public void descuentoInvalido(int descuento) {

        exception = assertThrows(
                IllegalArgumentException.class,
                () -> calculadora.aplicarDescuento(producto, descuento)
        );
    }

    @Then("debe mostrarse un error de descuento")
    public void validarError() {

        assertNotNull(exception);
    }

    @When("calculo el precio final con descuento {int}")
    public void calcularPrecioFinal(int descuento) {

        resultado =
                calculadora.calcularPrecioFinal(producto, descuento);
    }

    @Then("el precio final debe ser {double}")
    public void validarPrecioFinal(double esperado) {

        assertEquals(esperado, resultado);
    }
}
