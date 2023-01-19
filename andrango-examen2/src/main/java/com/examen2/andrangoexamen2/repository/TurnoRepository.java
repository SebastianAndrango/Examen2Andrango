package com.examen2.andrangoexamen2.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.examen2.andrangoexamen2.model.Turno;

public interface TurnoRepository extends MongoRepository<Turno, String> {

    List<Turno> findByNumeroTurno(Integer numeroTurno);

    Optional<Turno> findBycedula(String cedula);

}
