package com.storemanager.Cliente;

import java.util.Scanner;

import com.storemanager.App;

public class MenuCliente {

    public static void menu() {

        Scanner es = new Scanner(System.in);

        ClientesService clienteservice = new ClientesService();

        int seleccion = 0;

        System.out.println("\n========== CLIENTES =========");
        System.out.println("1. Añadir cliente");
        System.out.println("2. Buscar cliente");
        System.out.println("3. Listar clientes");
        System.out.println("4. Modificar cliente");
        System.out.println("5. Eliminar cliente");
        System.out.println("0. Volver");
        System.out.print("\nSelecciona una opción: ");
        seleccion = es.nextInt();

        switch (seleccion) {

            case 1:
                clienteservice.añadirCliente();
                MenuCliente.menu();

            case 2:
                clienteservice.buscarCliente();
                MenuCliente.menu();

            case 3:
                clienteservice.listarClientes();
                MenuCliente.menu();

            case 4:
                clienteservice.modificarCliente();
                MenuCliente.menu();

            case 5:
                clienteservice.eliminarCliente();
                MenuCliente.menu();

            case 0:
                App.main(null);    
        }
    }
}
