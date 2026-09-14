package com.storemanager.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.storemanager.api.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {

    

}