# Librería Parcial Sofia



## Parte 1 — Análisis



### Regla 1 — Particiones de equivalencia

| Partición | Tipo | Valor representativo | Resultado esperado |
|---|---|---|---|
| Precio mayor a 0 | Válida | 100 | Producto creado |
| Precio igual a 0 | Inválida | 0 | Error |
| Precio negativo | Inválida | -50 | Error |

---



### Regla 2 — Particiones de equivalencia

| Partición | Tipo | Valor representativo | Resultado esperado |
|---|---|---|---|
| Descuento entre 0 y 40 | Válida | 20 | Descuento aplicado |
| Descuento igual a 0 | Válida | 0 | Sin descuento |
| Descuento mayor a 40 | Inválida | 50 | Error |
| Descuento negativo | Inválida | -5 | Error |

---



### Regla 2 — Valores límite

| Valor | Resultado esperado |
|---|---|
| -1 | Error |
| 0 | Válido |
| 1 | Válido |
| 39 | Válido |
| 40 | Válido |
| 41 | Error |

---



### Regla 3 — Pregunta para el administrador

**¿Qué nivel de redondeo debe manejar el sistema en el precio final?**

**Justificación:** el IVA puede generar decimales y es importante saber si el sistema redondea a enteros o maneja decimales exactos.

---

## Parte 2 — Casos de prueba

| ID | Regla | Descripción | Precondición | Datos de entrada | Pasos | Resultado esperado | Tipo |
|---|---|---|---|---|---|---|---|
| CP-01 | R1 | Crear producto válido | Ninguna | Libro, 100 | Crear producto | Producto creado | Positivo |
| CP-02 | R1 | Crear producto con precio 0 | Ninguna | Libro, 0 | Crear producto | Error | Negativo |
| CP-03 | R1 | Crear producto con precio negativo | Ninguna | Libro, -50 | Crear producto | Error | Negativo |
| CP-04 | R2 | Aplicar descuento válido | Producto válido | 20% | Aplicar descuento | Descuento aplicado | Positivo |
| CP-05 | R2 | Aplicar descuento 0 | Producto válido | 0% | Aplicar descuento | Sin descuento | Borde |
| CP-06 | R2 | Aplicar descuento 40 | Producto válido | 40% | Aplicar descuento | Descuento aplicado | Borde |
| CP-07 | R2 | Aplicar descuento inválido | Producto válido | 50% | Aplicar descuento | Error | Negativo |
| CP-08 | R3 | Calcular precio final | Producto válido | 100 con 20% | Calcular precio final | 95.2 | Positivo |