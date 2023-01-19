package com.examen2.andrangoexamen2.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.examen2.andrangoexamen2.model.Cliente;

public interface ClienteRepository extends MongoRepository<Cliente, String> {
    Optional<Cliente> findByCedula(String cedula);

    Cliente findByCedulaAndNombreCliente(String cedula, String nombreCliente);

    List<Cliente> findByNumeroTurnoAndCodigoUsuarioEjecutivo(String numeroTurno, String codigoUsuarioEjecutivo);

    List<Cliente> findByNumeroTurnoAndFechaHoraFinAtencion(String numeroTurno, LocalDateTime fechaHoraFinAtencion);

    List<Cliente> findByCedulaAndNumeroTurnoAndCalificacion(String cedula, String numeroTurno, Integer calificacion);
}
