package com.storemanager;

import java.util.Scanner;

import com.storemanager.Cliente.Cliente;
import com.storemanager.Producto.MenuProducto;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {

        Scanner es = new Scanner(System.in);

        int seleccion = 0;

        System.out.println("===================");
        System.out.println("   STORE MANAGER   ");
        System.out.println("===================");
        System.out.println("1. Gestionar productos");
        System.out.println("2. Gestionar clientes");
        System.out.println("3. Registrar venta");
        System.out.println("4. Consultar ventas");
        System.out.println("5. Consultar stock");
        System.out.println("6. Ver estadísticas");
        System.out.println("0. Salir");
        System.out.print("\nSelecciona una opción: ");

        seleccion = es.nextInt();

        switch (seleccion) {
            case 1:
                MenuProducto producto = new MenuProducto();
                producto.menu();

            case 2:
                Cliente cliente = new Cliente();
                cliente.MenuCliente();

        }

    }
}
