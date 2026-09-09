package com.storemanager.Cliente;

public class Cliente {
    public int id;
    public String nombre;
    public String email;
    public int telefono;

    public Cliente(String email, int id, String nombre, int telefono) {
        this.email = email;
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
    }
}
