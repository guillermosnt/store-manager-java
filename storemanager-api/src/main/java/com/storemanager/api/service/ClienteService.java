package com.storemanager.api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.storemanager.api.model.Cliente;
import com.storemanager.api.repository.ClienteRepository;

@Service
public class ClienteService {

    private final ClienteRepository clienterepository;

    public ClienteService(ClienteRepository clienterepository) {
        this.clienterepository = clienterepository;
    }

    public List<Cliente> obtenerCliente() {
        return clienterepository.findAll();
    }

    public Cliente crearCliente(Cliente cliente) {
        return clienterepository.save(cliente);
    }

    public Cliente obtenerClientePorId(Integer id) {
        return clienterepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
    }

    public Cliente actualizarCliente(Integer id, Cliente cliente) {
        Cliente clienteExistente = clienterepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));

        clienteExistente.setNombre(cliente.getNombre());
        clienteExistente.setEmail(cliente.getEmail());
        clienteExistente.setTelefono(cliente.getTelefono());

        return clienterepository.save(clienteExistente);
    }

    public void eliminarCliente(Integer id) {
        clienterepository.deleteById(id);
    }
}
