Feature: Calcular precio final de productos
  Como administrador de la librería
  Quiero calcular precios correctamente
  Para vender productos con descuentos e IVA

  Background:
    Given existe un producto llamado "Libro" con precio 100

  @positivo
  Scenario: Aplicar descuento válido
    When aplico un descuento de 20
    Then el precio con descuento debe ser 80

  @borde
  Scenario Outline: Aplicar descuentos límite
    When aplico un descuento de <descuento>
    Then el precio con descuento debe ser <resultado>

    Examples:
      | descuento | resultado |
      | 0          | 100       |
      | 40         | 60        |

  @negativo
  Scenario: Rechazar descuento inválido
    When aplico un descuento inválido de 50
    Then debe mostrarse un error de descuento

  @positivo
  Scenario: Calcular precio final con IVA
    When calculo el precio final con descuento 20
    Then el precio final debe ser 95.2

  @negativo
  Scenario: Rechazar descuento negativo
    When aplico un descuento inválido de -1
    Then debe mostrarse un error de descuento
