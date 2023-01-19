package com.examen2.andrangoexamen2.service;

import java.sql.Date;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.examen2.andrangoexamen2.model.Cliente;
import com.examen2.andrangoexamen2.model.Turno;
import com.examen2.andrangoexamen2.repository.TurnoRepository;

@Service
public class TurnoService {
    private TurnoRepository turnoRepository;

    public TurnoService(TurnoRepository turnoRepository) {
        this.turnoRepository = turnoRepository;
    }

    public void createTurno(Turno turno) {
        Integer numeroTurno = 0;
        turno.setNumeroTurno(numeroTurno + 1);
        turno.setCedula(turno.getCedula());
        turno.setNombreCliente(turno.getNombreCliente());
        turno.setCodigoUsuarioEjecutivo(turno.getCodigoUsuarioEjecutivo());
        turno.setNombreEjecutivo(turno.getNombreEjecutivo());
        turno.setFechaHoraGeneracion(null);
        turno.setFechaHoraInicioAtencion(null);
        turno.setFechaHoraFinAtencion(null);
        turno.setCalificacion(turno.getCalificacion());
        this.turnoRepository.save(turno);
    }

    public void calificacionTurno(String cedulaCliente, Integer calificacion) {
        Optional<Turno> opTurno = turnoRepository.findBycedula(cedulaCliente);
        if (opTurno.isPresent()) {
            Turno turno = opTurno.get();
            turno.setCalificacion(calificacion);
            this.turnoRepository.save(turno);
        } else {
            throw new RuntimeException("No se encontro el turno");
        }
    }

}
