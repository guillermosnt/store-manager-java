package com.storemanager.api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.storemanager.api.model.Producto;
import com.storemanager.api.repository.ProductoRepository;
import com.storemanager.api.exception.ProductoNoEncontradoException;

@Service
public class ProductoService {

    //Hibernate

    private final ProductoRepository productoRepository;

    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    public List<Producto> obtenerProductos() {
        return productoRepository.findAll();
    }

    public Producto crearProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    public Producto obtenerProductoPorId(Integer id) {
        return productoRepository.findById(id)
                // Si no existe, lanza una excepción (orElseThrow())
                .orElseThrow(() -> new ProductoNoEncontradoException("ERROR - Producto no encontrado..."));
    }

    public Producto actualizarProducto(Integer id, Producto producto) {

        Producto productoExistente = productoRepository.findById(id).orElse(null);

        if (productoExistente == null) {
            return null;
        }

        productoExistente.setNombre(producto.getNombre());
        productoExistente.setPrecio(producto.getPrecio());
        productoExistente.setStock(producto.getStock());

        return productoRepository.save(productoExistente);
    }

    public void eliminarProducto(Integer id) {
        productoRepository.deleteById(id);
    }
}