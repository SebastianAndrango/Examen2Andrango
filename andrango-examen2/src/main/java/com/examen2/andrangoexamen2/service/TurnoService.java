package com.examen2.andrangoexamen2.service;

import java.sql.Date;

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
        /*
         * if (client.getBirthDate().after(new Date())) {
         * throw new RuntimeException(
         * "The date of birth cannot be greater than the current date" +
         * client.getBirthDate());
         * }
         * client.setStatus("INA");
         * client.setCreationDate(new Date());
         * 
         * Client clienteTemp = this.clientRepository
         * .findByIdentificationTypeAndIdentification(client.getIdentificationType(),
         * client.getIdentification());
         * if (clienteTemp != null) {
         * throw new RuntimeException("The client already exists");
         * }
         * this.clientRepository.save(client);
         */
    }

}
