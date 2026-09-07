package com.storemanager.Producto;

import java.util.Scanner;

public class MenuProducto {

    public static void menu() {

        Scanner es = new Scanner(System.in);

        ProductosService productosService = new ProductosService();

        int seleccion = 0;

        System.out.println("\n========== PRODUCTOS =========");
        System.out.println("1. Añadir producto");
        System.out.println("2. Buscar producto");
        System.out.println("3. Listar productos");
        System.out.println("4. Modificar producto");
        System.out.println("5. Eliminar producto");
        System.out.println("0. Volver");
        System.out.print("\nSelecciona una opción: ");

        seleccion = es.nextInt();

        switch (seleccion) {
            case 1:
                productosService.añadirProducto();
                MenuProducto.menu();
                
            case 2:
                productosService.buscarProducto();
                MenuProducto.menu();

            
        }

    }

}
