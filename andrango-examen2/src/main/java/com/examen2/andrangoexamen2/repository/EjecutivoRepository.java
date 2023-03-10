package com.examen2.andrangoexamen2.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.examen2.andrangoexamen2.model.Ejecutivo;

public interface EjecutivoRepository extends MongoRepository<Ejecutivo, String> {
    List<Ejecutivo> findByCodigoUsuario(String codigoUsuario);
}
