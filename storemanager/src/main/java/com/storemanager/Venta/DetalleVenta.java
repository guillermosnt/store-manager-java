package com.storemanager.Venta;

import com.storemanager.Producto.Productos;

public class DetalleVenta {

    public Productos producto;
    public int cantidad;
    public double precio;
    public double subtotal;

    public DetalleVenta(Productos producto, int cantidad) {

        this.producto = producto;
        this.cantidad = cantidad;
        this.precio = producto.precio;
        this.subtotal = precio * cantidad;
    }
}