package com.storemanager.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter 
public class ProductoDTO {

    /*
     * DATA TRANSFER OBJECT
     * ----------------------------
     * Un DTO es un objeto que utilizamos para transportar los datos
     * que entran o salen de nuestra API.
     * 
     * ¿Para qué sirve?
     * 
     * - Separar los datos de la API de la entidad de la base de datos.
     * - Controlar qué datos puede recibir o devolver la API.
     * - Colocar validaciones específicas para los datos recibidos.
     * - Evitar exponer directamente la entidad JPA.
     * 
     * 
     * Así podemos validar los datos que llegan a la API sin depender directamente
     * de la entidad Producto.
     */

    @NotBlank
    private String nombre;

    @Positive
    private double precio;

    @PositiveOrZero
    private int stock;

}