package com.storemanager.api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.storemanager.api.model.Cliente;
import com.storemanager.api.service.ClienteService;

@RestController
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping("/clientes")
    public List<Cliente> obtenerClientes() {
        return clienteService.obtenerCliente();
    }

    @PostMapping("/clientes")
    public Cliente crearCliente(@RequestBody Cliente cliente) {
        return clienteService.crearCliente(cliente);
    }

    @GetMapping("/clientes/{id}")
    public Cliente obtenerClientePorId(@PathVariable Integer id) {
        return clienteService.obtenerClientePorId(id);
    }

    @PutMapping("/clientes/{id}")
    public Cliente actualizarCliente(
            @PathVariable Integer id,
            @RequestBody Cliente cliente) {

        return clienteService.actualizarCliente(id, cliente);
    }

    @DeleteMapping("/clientes/{id}")
    public void eliminarCliente(@PathVariable Integer id) {
        clienteService.eliminarCliente(id);
    }

}