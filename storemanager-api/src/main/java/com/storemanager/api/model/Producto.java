package com.storemanager.api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Producto {

    // JPA / Hibernate

    // Cuando guarde un producto, PostgreSQL genera el ID por mi y lo asignará
    // automáticamente.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // El nombre es obligatorio y no puede estar vacío
    @NotBlank
    private String nombre;

    // El precio tiene que ser positivo (mayor que cero)
    @Positive
    private double precio;

    // El stock tiene que ser positivo o cero.
    @PositiveOrZero
    private int stock;

}