package com.storemanager.Venta;

import java.util.List;

import com.storemanager.Cliente.Cliente;

public class Venta {

    public int id;
    public Cliente cliente;
    public List<DetalleVenta> detalles;
    public double total;

    public Venta(int id, Cliente cliente, List<DetalleVenta> detalles, double total) {
        this.id = id;
        this.cliente = cliente;
        this.detalles = detalles;
        this.total = total;
    }
}