package com.examen2.andrangoexamen2.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.examen2.andrangoexamen2.model.Cliente;

public interface ClienteRepository extends MongoRepository<Cliente, String> {
    Optional<Cliente> findByCedula(String cedula);
}
