package com.storemanager.api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.storemanager.api.dto.ProductoDTO;
import com.storemanager.api.exception.ProductoNoEncontradoException;
import com.storemanager.api.model.Producto;
import com.storemanager.api.repository.ProductoRepository;

@Service
public class ProductoService {

    // Hibernate

    private final ProductoRepository productoRepository;

    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    public List<ProductoDTO> obtenerProductos() {
        return productoRepository.findAll()
                .stream()
                // Por cada Producto que venga de la base de datos, utiliza mi método
                // convertirADTO().
                .map(this::convertirADTO)
                .toList();
    }

    public Producto crearProducto(ProductoDTO productoDTO) {

        Producto producto = new Producto();

        producto.setNombre(productoDTO.getNombre());
        producto.setPrecio(productoDTO.getPrecio());
        producto.setStock(productoDTO.getStock());

        return productoRepository.save(producto);
    }

    public ProductoDTO obtenerProductoPorId(Integer id) {
        Producto producto = productoRepository.findById(id)
                .orElseThrow(() -> new ProductoNoEncontradoException("Producto no encontrado"));

        return convertirADTO(producto);
    }

    public Producto actualizarProducto(Integer id, ProductoDTO productoDTO) {

        Producto productoExistente = productoRepository.findById(id).orElse(null);

        if (productoExistente == null) {
            throw new ProductoNoEncontradoException("Producto no encontrado");
        }

        productoExistente.setNombre(productoDTO.getNombre());
        productoExistente.setPrecio(productoDTO.getPrecio());
        productoExistente.setStock(productoDTO.getStock());

        return productoRepository.save(productoExistente);
    }

    public void eliminarProducto(Integer id) {
        productoRepository.deleteById(id);
    }

    private ProductoDTO convertirADTO(Producto producto) {
        ProductoDTO dto = new ProductoDTO();

        dto.setNombre(producto.getNombre());
        dto.setPrecio(producto.getPrecio());
        dto.setStock(producto.getStock());

        return dto;
    }
}