package com.storemanager.api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.storemanager.api.dto.ClienteDTO;
import com.storemanager.api.exception.ClienteNoEncontradoException;
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

    public Cliente crearCliente(ClienteDTO clienteDTO) {
        Cliente cliente = new Cliente();

        cliente.setNombre(clienteDTO.getNombre());
        cliente.setEmail(clienteDTO.getEmail());
        cliente.setTelefono(clienteDTO.getTelefono());

        return clienterepository.save(cliente);
    }

    public Cliente obtenerClientePorId(Integer id) {
        return clienterepository.findById(id)
                .orElseThrow(() -> new ClienteNoEncontradoException("Cliente no encontrado"));
    }

    public Cliente actualizarCliente(Integer id, ClienteDTO clienteDTO) {
        Cliente clienteExistente = clienterepository.findById(id)
                .orElseThrow(() -> new ClienteNoEncontradoException("Cliente no encontrado"));

        clienteExistente.setNombre(clienteDTO.getNombre());
        clienteExistente.setEmail(clienteDTO.getEmail());
        clienteExistente.setTelefono(clienteDTO.getTelefono());

        return clienterepository.save(clienteExistente);
    }

    public void eliminarCliente(Integer id) {

        Cliente cliente = clienterepository.findById(id)
                .orElseThrow(() -> new ClienteNoEncontradoException("Cliente no encontrado"));

        clienterepository.delete(cliente);
    }
}
