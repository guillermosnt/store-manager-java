package com.storemanager.Venta;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.storemanager.App;
import com.storemanager.Cliente.Cliente;
import com.storemanager.Cliente.ClientesService;
import com.storemanager.Producto.Productos;
import com.storemanager.Producto.ProductosService;

public class VentaService {

    public static final Scanner es = new Scanner(System.in);

    private static final List<Venta> ventas = new ArrayList<>();
    private static int siguienteId = 1;

    public static void registrarVenta() {

        System.out.println("\n======== REGISTRAR VENTA ========");
        System.out.print("- Introduce el ID del cliente: ");
        int idCliente = es.nextInt();
        es.nextLine();

        Cliente clienteEncontrado = ClientesService.buscarClientePorId(idCliente);

        if (clienteEncontrado == null) {
            System.out.println("\n[❌] Cliente no encontrado.");
            App.main(null);
        }

        System.out.print("- Introduce el ID del producto: ");
        int idProducto = es.nextInt();
        es.nextLine();

        Productos productoEncontrado = ProductosService.buscarProductoPorId(idProducto);

        if (productoEncontrado == null) {
            System.out.println("\n[❌] Producto no encontrado.");
            App.main(null);
        }

        System.out.println("\nProducto seleccionado:");
        System.out.println("ID: " + productoEncontrado.id);
        System.out.println("Nombre: " + productoEncontrado.nombre);
        System.out.println("Precio: " + productoEncontrado.precio + "€");
        System.out.println("Stock disponible: " + productoEncontrado.stock);

        System.out.print("\n- Introduce la cantidad: ");
        int cantidad = es.nextInt();
        es.nextLine();

        if (cantidad <= 0) {
            System.out.println("\n[❌] La cantidad debe ser mayor que 0.");
            return;
        }

        if (cantidad > productoEncontrado.stock) {
            System.out.println("\n[❌] No hay suficiente stock.");
            return;
        }

        DetalleVenta detalle = new DetalleVenta(
                productoEncontrado,
                cantidad);

        List<DetalleVenta> detalles = new ArrayList<>();
        detalles.add(detalle);

        double total = detalle.subtotal;

        Venta venta = new Venta(
                siguienteId,
                clienteEncontrado,
                detalles,
                total);

        ventas.add(venta);
        siguienteId++;

        productoEncontrado.stock -= cantidad;

        System.out.println("\n[✅] ¡Venta registrada correctamente!");

        System.out.println("\n======== RESUMEN DE VENTA ========");
        System.out.println("ID de venta: " + venta.id);
        System.out.println("Cliente: " + venta.cliente.nombre);
        System.out.println("Producto: " + productoEncontrado.nombre);
        System.out.println("Cantidad: " + cantidad);
        System.out.println("Total: " + venta.total + "€");
    }

    public static void consultarVentas() {

        System.out.println("\n======== CONSULTAR VENTA ========");

        if (ventas.isEmpty()) {
            System.out.println("\n[ℹ️] No hay ventas registradas.");
            return;
        }

        System.out.print("- Introduce el ID de la venta: ");
        int idVenta = es.nextInt();
        es.nextLine();

        Venta ventaEncontrada = null;

        for (int i = 0; i < ventas.size(); i++) {

            if (ventas.get(i).id == idVenta) {
                ventaEncontrada = ventas.get(i);
                break;
            }
        }

        if (ventaEncontrada == null) {
            System.out.println("\n[❌] Venta no encontrada.");
            return;
        }

        System.out.println("\n======== DETALLES DE LA VENTA ========");

        System.out.println("ID de venta: " + ventaEncontrada.id);
        System.out.println("Cliente: " + ventaEncontrada.cliente.nombre);

        for (int i = 0; i < ventaEncontrada.detalles.size(); i++) {

            DetalleVenta detalle = ventaEncontrada.detalles.get(i);

            System.out.println("\nProducto: " + detalle.producto.nombre);
            System.out.println("Cantidad: " + detalle.cantidad);
            System.out.println("Precio: " + detalle.precio + "€");
            System.out.println("Subtotal: " + detalle.subtotal + "€");
        }

        System.out.println("\nTOTAL: " + ventaEncontrada.total + "€");
    }
}