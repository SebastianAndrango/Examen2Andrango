package com.examen2.andrangoexamen2.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.examen2.andrangoexamen2.model.Cliente;
import com.examen2.andrangoexamen2.model.Turno;

public interface TurnoRepository extends MongoRepository<Turno, String> {
    Cliente findByCedulaAndNombreCliente(String cedula, String nombreCliente);

    List<Turno> findByNumeroTurnoAndcodigoUsuarioEjecutivo(Integer numeroTurno, String codigoUsuarioEjecutivo);

    List<Cliente> findByNumeroTurnoAndCodigoUsuarioEjecutivo(String numeroTurno, String codigoUsuarioEjecutivo);

    List<Cliente> findByNumeroTurnoAndFechaHoraFinAtencion(String numeroTurno, LocalDateTime fechaHoraFinAtencion);

    List<Cliente> findByCedulaAndNumeroTurnoAndCalificacion(String cedula, String numeroTurno, Integer calificacion);
}
