package com.storemanager.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.storemanager.api.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
