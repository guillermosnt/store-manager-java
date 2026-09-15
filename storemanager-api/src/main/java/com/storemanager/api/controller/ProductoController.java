package com.storemanager.api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.storemanager.api.model.Producto;
import com.storemanager.api.service.ProductoService;

import jakarta.validation.Valid;

@RestController
public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping("/productos")
    public List<Producto> obtenerProductos() {
        return productoService.obtenerProductos();
    }

    // Con @Valid lo que consigo es que compruebe todas las reglas que tiene
    // Productos.
    @PostMapping("/productos")
    public Producto crearProducto(@Valid @RequestBody Producto producto) {
        return productoService.crearProducto(producto);
    }

    @PutMapping("/productos/{id}")
    public Producto actualizarProducto(@PathVariable Integer id, @RequestBody Producto producto) {
        return productoService.actualizarProducto(id, producto);
    }

    @GetMapping("/productos/{id}")
    public Producto obtenerProductoPorId(@PathVariable Integer id) {
        return productoService.obtenerProductoPorId(id);
    }

    @DeleteMapping("/productos/{id}")
    public void eliminarProducto(@PathVariable Integer id) {
        productoService.eliminarProducto(id);
    }

}