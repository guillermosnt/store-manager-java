package com.storemanager.Cliente;

import java.util.Scanner;

public class Cliente {
    public int id;
    public String nombre;
    public String email;
    public int telefono;

    public static void MenuCliente() {

        Scanner es = new Scanner(System.in);

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

    }

}
