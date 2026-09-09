package com.storemanager.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class ClientesService {

    public static final Scanner es = new Scanner(System.in).useLocale(Locale.US);
    private static final List<Cliente> clientes = new ArrayList<>();
    private static int siguienteId = 1;

    public static void añadirCliente() {

        System.out.println("\n======== AÑADIR CLIENTE ========");
        System.out.print("- Nombre del cliente: ");
        String nombre = es.nextLine();

        String email;

        do {
            System.out.print("- Email del cliente: ");
            email = es.nextLine();

            if (!email.contains("@") || !email.contains(".")) {
                System.out.println("\n[❌] Email no válido. Inténtalo de nuevo.");
            }

        } while (!email.contains("@") || !email.contains("."));

        System.out.print("- Teléfono del cliente: ");
        int telefono = es.nextInt();

        Cliente cliente = new Cliente(email, telefono, nombre, telefono);
        clientes.add(cliente);
        siguienteId++;

        System.out.println("\n[✅] ¡Cliente añadido correctamente!");
    }

    public static void buscarCliente() {

        System.out.println("\n======== BUSCAR CLIENTE ========");
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

                for (int index = 0; index < clientes.size(); index++) {
                    if (clientes.get(index).id == idBuscado) {
                        System.out.println("\n[🔘] Nombre del cliente: "
                                + clientes.get(index).nombre);

                        System.out.println("[📧] Email del cliente: "
                                + clientes.get(index).email);

                        System.out.println("[📲] Teléfono del cliente: "
                                + clientes.get(index).telefono);
                    }
                }

                MenuCliente.menu();
                break;

            case 2:
                System.out.print("\n- Introduce el nombre: ");
                String nombreBuscado = es.nextLine();
                es.nextLine();

                for (int index = 0; index < clientes.size(); index++) {
                    if (clientes.get(index).nombre == nombreBuscado) {
                        System.out.println("\n[🔘] Nombre del cliente: "
                                + clientes.get(index).nombre);

                        System.out.println("[📧] Email del cliente: "
                                + clientes.get(index).email);

                        System.out.println("[📲] Teléfono del cliente: "
                                + clientes.get(index).telefono);
                    }
                }

                MenuCliente.menu();
                break;
        }
    }

    public static void listarClientes() {

        System.out.println("\n======== LISTA DE CLIENTES ========");

        if (clientes.isEmpty()) {
            System.out.println("\n[ℹ️] No hay clientes registrados.");
            return;
        }

        for (int i = 0; i < clientes.size(); i++) {

            System.out.println("\nCliente " + (i + 1));
            System.out.println("[🆔] ID: " + clientes.get(i).id);
            System.out.println("[🔘] Nombre: " + clientes.get(i).nombre);
            System.out.println("[📧] Email: " + clientes.get(i).email);
            System.out.println("[📲] Teléfono: " + clientes.get(i).telefono);
        }
    }

    public static void modificarCliente() {

        System.out.println("\n======== MODIFICAR CLIENTE ========");
        System.out.println("1. Buscar por ID");
        System.out.println("2. Buscar por nombre");
        System.out.println("0. Volver");
        System.out.print("\nSelecciona una opción: ");

        int seleccion = es.nextInt();
        es.nextLine();

        Cliente clienteEncontrado = null;

        switch (seleccion) {

            case 1:
                System.out.print("\n- Introduce el ID: ");
                int idBuscado = es.nextInt();
                es.nextLine();

                for (int i = 0; i < clientes.size(); i++) {

                    if (clientes.get(i).id == idBuscado) {
                        clienteEncontrado = clientes.get(i);
                        break;
                    }
                }

                break;

            case 2:
                System.out.print("\n- Introduce el nombre: ");
                String nombreBuscado = es.nextLine();

                for (int i = 0; i < clientes.size(); i++) {

                    if (clientes.get(i).nombre.equalsIgnoreCase(nombreBuscado)) {
                        clienteEncontrado = clientes.get(i);
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

        if (clienteEncontrado == null) {
            System.out.println("\n[❌] No se ha encontrado el cliente.");
            return;
        }

        System.out.println("\n======== CLIENTE ENCONTRADO ========");
        System.out.println("[🆔] ID: " + clienteEncontrado.id);
        System.out.println("[🔘] Nombre: " + clienteEncontrado.nombre);
        System.out.println("[📧] Email: " + clienteEncontrado.email);
        System.out.println("[📲] Teléfono: " + clienteEncontrado.telefono);

        System.out.println("\n¿Qué desea modificar?");
        System.out.println("1. Nombre");
        System.out.println("2. Email");
        System.out.println("3. Teléfono");
        System.out.println("0. Cancelar");
        System.out.print("\nSelecciona una opción: ");

        int seleccionCliente = es.nextInt();
        es.nextLine();

        switch (seleccionCliente) {

            case 1:
                System.out.print("\n[🔘] Introduce el nuevo nombre: ");
                String nuevoNombre = es.nextLine();

                clienteEncontrado.nombre = nuevoNombre;

                System.out.println("\n[✅] Nombre modificado correctamente.");
                break;

            case 2:
                String nuevoEmail;

                do {
                    System.out.print("\n[📧] Introduce el nuevo email: ");
                    nuevoEmail = es.nextLine();

                    if (!nuevoEmail.contains("@") || !nuevoEmail.contains(".")) {
                        System.out.println("\n[❌] Email no válido. Inténtalo de nuevo.");
                    }

                } while (!nuevoEmail.contains("@") || !nuevoEmail.contains("."));

                clienteEncontrado.email = nuevoEmail;

                System.out.println("\n[✅] Email modificado correctamente.");
                break;

            case 3:
                System.out.print("\n[📲] Introduce el nuevo teléfono: ");
                int nuevoTelefono = es.nextInt();
                es.nextLine();

                clienteEncontrado.telefono = nuevoTelefono;

                System.out.println("\n[✅] Teléfono modificado correctamente.");
                break;

            case 0:
                System.out.println("\n[ℹ️] Modificación cancelada.");
                break;

            default:
                System.out.println("\n[❌] Opción no válida.");
                break;
        }
    }

    public static void eliminarCliente() {

        System.out.println("\n======== ELIMINAR CLIENTE ========");
        System.out.println("1. Eliminar por ID");
        System.out.println("2. Eliminar por nombre");
        System.out.println("0. Volver");
        System.out.print("\nSelecciona una opción: ");

        int seleccion = es.nextInt();
        es.nextLine();

        Cliente clienteEncontrado = null;

        switch (seleccion) {

            case 1:
                System.out.print("\n- Introduce el ID: ");
                int idBuscado = es.nextInt();
                es.nextLine();

                for (int i = 0; i < clientes.size(); i++) {

                    if (clientes.get(i).id == idBuscado) {
                        clienteEncontrado = clientes.get(i);
                        break;
                    }
                }

                break;

            case 2:
                System.out.print("\n- Introduce el nombre: ");
                String nombreBuscado = es.nextLine();

                for (int i = 0; i < clientes.size(); i++) {

                    if (clientes.get(i).nombre.equalsIgnoreCase(nombreBuscado)) {
                        clienteEncontrado = clientes.get(i);
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

        if (clienteEncontrado == null) {
            System.out.println("\n[❌] No se ha encontrado el cliente.");
            return;
        }

        System.out.println("\n======== CLIENTE ENCONTRADO ========");
        System.out.println("[🆔] ID: " + clienteEncontrado.id);
        System.out.println("[🔘] Nombre: " + clienteEncontrado.nombre);
        System.out.println("[📧] Email: " + clienteEncontrado.email);
        System.out.println("[📲] Teléfono: " + clienteEncontrado.telefono);

        System.out.print("\n¿Seguro que desea eliminar este cliente? (S/N): ");
        String confirmacion = es.nextLine();

        if (confirmacion.equalsIgnoreCase("S")) {
            clientes.remove(clienteEncontrado);
            System.out.println("\n[✅] Cliente eliminado correctamente.");

        } else {
            System.out.println("\n[ℹ️] Eliminación cancelada.");
        }
    }

}
