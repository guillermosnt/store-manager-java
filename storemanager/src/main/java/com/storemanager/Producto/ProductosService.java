package com.storemanager.Producto;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class ProductosService {

    public static final Scanner es = new Scanner(System.in).useLocale(Locale.US);
    private static final List<Productos> producto = new ArrayList<>();
    private static int siguienteId = 1;

    public static void añadirProducto() {

        String nombre;
        double precio;
        int stock;

        System.out.println("\n======== AÑADIR PRODUCTO ========");
        System.out.print("- Nombre del producto: ");
        nombre = es.nextLine();
        System.out.print("- Precio del producto: ");
        precio = es.nextDouble();
        System.out.print("- Stock del producto: ");
        stock = es.nextInt();

        Productos productos = new Productos(siguienteId, nombre, precio, stock);
        producto.add(productos);
        siguienteId++;

        System.out.println("\n[✅] ¡Producto añadido correctamente!");
    }

    public static void buscarProducto() {

        int seleccion = 0;

        System.out.println("\n======== BUSCAR PRODUCTO ========");
        System.out.println("1. Buscar por ID");
        System.out.println("2. Buscar por nombre");
        System.out.println("0. Volver");
        System.out.print("\nSelecciona una opción: ");
        seleccion = es.nextInt();

        switch (seleccion) {
            case 1:
                int idBuscado = 0;

                System.out.print("\n- Introduce el id: ");
                idBuscado = es.nextInt();
                for (int i = 0; i < producto.size(); i++) {
                    if (producto.get(i).id == idBuscado) {
                        System.out.println("\n[🔘] Nombre del producto: " + producto.get(i).nombre);
                        System.out.println("[🪙]Precio del producto: " + producto.get(i).precio);
                        System.out.println("[➡️] Stock del producto: " + producto.get(i).stock);
                    }
                }
                MenuProducto.menu();

                

                //RESOLVER PROBLEMA PORQUE NO SE MUESTRA EN LA TERMINAL
            case 2:
                String nombreBuscado;

                System.out.println("\n- Introduce el nombre: ");
                nombreBuscado = es.nextLine();
                for (int i = 0; i < producto.size(); i++) {
                    if (producto.get(i).nombre.equalsIgnoreCase(nombreBuscado)) {
                        System.out.println("\n- Nombre del producto: " + producto.get(i).id);
                        System.out.println("- Precio del producto: " + producto.get(i).precio);
                        System.out.println("- Stock del producto: " + producto.get(i).stock);
                    }
                }
                MenuProducto.menu();
        }

    }
}
