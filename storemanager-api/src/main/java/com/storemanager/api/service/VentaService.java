package com.storemanager.api.service;

import com.storemanager.api.repository.ClienteRepository;
import com.storemanager.api.repository.VentaRepository;

public class VentaService {

    private final VentaRepository ventaRepository;

    private final ClienteRepository clienteRepository;

    public VentaService(
            VentaRepository ventaRepository,
            ClienteRepository clienteRepository) {

        this.ventaRepository = ventaRepository;
        this.clienteRepository = clienteRepository;
    }

}
