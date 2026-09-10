package com.storemanager;

import java.util.Scanner;

import com.storemanager.Cliente.MenuCliente;
import com.storemanager.Producto.MenuProducto;
import com.storemanager.Producto.ProductosService;
import com.storemanager.Venta.VentaService;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {

        Scanner es = new Scanner(System.in);

        ProductosService productoservice = new ProductosService();
        MenuProducto producto = new MenuProducto();
        MenuCliente cliente = new MenuCliente();
        VentaService venta = new VentaService();

        int seleccion = 0;

        System.out.println("\n===================");
        System.out.println("   STORE MANAGER   ");
        System.out.println("===================");
        System.out.println("1. Gestionar productos");
        System.out.println("2. Gestionar clientes");
        System.out.println("3. Registrar venta");
        System.out.println("4. Consultar ventas");
        System.out.println("5. Consultar stock");
        System.out.println("0. Salir");
        System.out.print("\nSelecciona una opción: ");

        seleccion = es.nextInt();

        switch (seleccion) {
            case 1:
                producto.menu();
                break;

            case 2:
                cliente.menu();
                break;

            case 3:
                venta.registrarVenta();
                break;

            case 4:
                venta.consultarVentas();
                break;

            case 5:
                productoservice.consultarStock();
                break;

            case 0:
                System.out.println("\n¡Gracias por usar la aplicación!");
                break;
        }

    }
}
