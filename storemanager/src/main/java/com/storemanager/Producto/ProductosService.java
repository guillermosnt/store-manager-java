package com.storemanager.Producto;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import com.storemanager.App;

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

        System.out.println("\n======== BUSCAR PRODUCTO ========");
        System.out.println("1. Buscar por ID");
        System.out.println("2. Buscar por nombre");
        System.out.println("0. Volver");
        System.out.print("\nSelecciona una opción: ");

        int seleccion = es.nextInt();
        es.nextLine();

        switch (seleccion) {

            case 1:

                System.out.print("\n- Introduce el id: ");
                int idBuscado = es.nextInt();
                es.nextLine();

                for (int i = 0; i < producto.size(); i++) {

                    if (producto.get(i).id == idBuscado) {

                        System.out.println("\n[🔘] Nombre del producto: "
                                + producto.get(i).nombre);

                        System.out.println("[🪙] Precio del producto: "
                                + producto.get(i).precio);

                        System.out.println("[➡️] Stock del producto: "
                                + producto.get(i).stock);
                    }
                }

                MenuProducto.menu();
                break;

            case 2:

                System.out.print("\n- Introduce el nombre: ");
                String nombreBuscado = es.nextLine();

                for (int i = 0; i < producto.size(); i++) {

                    if (producto.get(i).nombre.equalsIgnoreCase(nombreBuscado)) {

                        System.out.println("\n[🔘] Nombre del producto: " + producto.get(i).nombre);

                        System.out.println("[🪙] Precio del producto: " + producto.get(i).precio);

                        System.out.println("[➡️] Stock del producto: " + producto.get(i).stock);
                    }
                }

                MenuProducto.menu();
                break;

            case 0:
                MenuProducto.menu();
                break;

            default:
                System.out.println("❌ Opción no válida.");
                break;
        }
    }

    public static void listarProductos() {

        System.out.println("\n======== LISTAR PRODUCTOS ========");

        for (int i = 0; i < producto.size(); i++) {
            System.out.println(
                    "ID: " + producto.get(i).id +
                            " | Nombre: " + producto.get(i).nombre +
                            " | Precio: " + producto.get(i).precio + "$" +
                            " | Stock: " + producto.get(i).stock);
        }
    }

    public static void modificarProducto() {

        System.out.println("\n======== MODIFICAR PRODUCTO ========");
        System.out.println("1. Buscar por id");
        System.out.println("2. Buscar por nombre");
        System.out.println("0. Volver");
        System.out.print("\nSelecciona una opción: ");

        int seleccion = es.nextInt();
        es.nextLine();

        Productos productoEncontrado = null;

        switch (seleccion) {

            case 1:
                System.out.print("\n- Introduce el id: ");
                int idBuscado = es.nextInt();
                es.nextLine();

                for (int i = 0; i < producto.size(); i++) {

                    if (producto.get(i).id == idBuscado) {
                        productoEncontrado = producto.get(i);
                        break;
                    }
                }

                break;

            case 2:
                System.out.print("\n- Introduce el nombre: ");
                String nombreBuscado = es.nextLine();

                for (int i = 0; i < producto.size(); i++) {

                    if (producto.get(i).nombre.equalsIgnoreCase(nombreBuscado)) {
                        productoEncontrado = producto.get(i);
                        break;
                    }
                }

                break;

            case 0:
                return;

            default:
                System.out.println("\n[❌] Opción no válida.");
                return;
        }

        if (productoEncontrado == null) {

            System.out.println("\n[❌] No se ha encontrado el producto.");
            return;
        }

        System.out.println("\n======== PRODUCTO ENCONTRADO ========");
        System.out.println("ID: " + productoEncontrado.id);
        System.out.println("Nombre: " + productoEncontrado.nombre);
        System.out.println("Precio: " + productoEncontrado.precio + "$");
        System.out.println("Stock: " + productoEncontrado.stock);

        System.out.println("\n¿Qué desea modificar?");
        System.out.println("1. Nombre del producto");
        System.out.println("2. Precio del producto");
        System.out.println("3. Stock del producto");
        System.out.println("0. Cancelar");
        System.out.print("\nSelecciona una opción: ");

        int seleccionProducto = es.nextInt();
        es.nextLine();

        switch (seleccionProducto) {

            case 1:
                System.out.print("\n[🔘] Introduce el nuevo nombre: ");
                String nuevoNombre = es.nextLine();

                productoEncontrado.nombre = nuevoNombre;

                System.out.println("\n[✅] Nombre modificado correctamente.");
                break;

            case 2:
                System.out.print("\n[🪙] Introduce el nuevo precio: ");
                double nuevoPrecio = es.nextDouble();
                es.nextLine();

                productoEncontrado.precio = nuevoPrecio;

                System.out.println("\n[✅] Precio modificado correctamente.");
                break;

            case 3:
                System.out.print("\n[➡️] Introduce el nuevo stock: ");
                int nuevoStock = es.nextInt();
                es.nextLine();

                productoEncontrado.stock = nuevoStock;

                System.out.println("\n[✅] Stock modificado correctamente.");
                break;

            case 0:
                System.out.println("\n[ℹ️] Modificación cancelada.");
                break;

            default:
                System.out.println("\n[❌] Opción no válida.");
                break;
        }
    }

    public static void eliminarProducto() {

        System.out.println("\n======== ELIMINAR PRODUCTO ========");
        System.out.println("1. Buscar por id");
        System.out.println("2. Buscar por nombre");
        System.out.println("0. Volver");
        System.out.print("\nSelecciona una opción: ");

        int seleccionEliminar = es.nextInt();
        es.nextLine();

        Productos productoEncontrado = null;

        switch (seleccionEliminar) {

            case 1:
                System.out.print("\n- Introduce el id: ");
                int idBuscado = es.nextInt();
                es.nextLine();

                for (int i = 0; i < producto.size(); i++) {

                    if (producto.get(i).id == idBuscado) {
                        productoEncontrado = producto.remove(i);
                        break;
                    }
                }

                System.out.println("\n[✅] ¡Producto eliminado correctamente!");
                break;

            case 2:
                System.out.print("\n- Introduce el nombre: ");
                String nombreBuscado = es.nextLine();
                es.nextLine();

                for (int i = 0; i < producto.size(); i++) {

                    if (producto.get(i).nombre == nombreBuscado) {
                        productoEncontrado = producto.remove(i);
                        break;
                    }
                }

                System.out.println("\n[✅] ¡Producto eliminado correctamente!");
                break;
        }
    }

    public static void consultarStock() {

        System.out.println("\n======== CONSULTAR STOCK ========");

        if (producto.isEmpty()) {
            System.out.println("\n[ℹ️] No hay productos registrados.");
            App.main(null);
        }

        for (int i = 0; i < producto.size(); i++) {
            System.out.println("\n[🆔] ID: " + producto.get(i).id);
            System.out.println("[📦] Producto: " + producto.get(i).nombre);
            System.out.println("[💰] Precio: " + producto.get(i).precio + "€");
            System.out.println("[📊] Stock: " + producto.get(i).stock);
        }
    }

    public static Productos buscarProductoPorId(int id) {

        for (int i = 0; i < producto.size(); i++) {
            if (producto.get(i).id == id) {
                return producto.get(i);
            }
        }
        return null;
    }
}
