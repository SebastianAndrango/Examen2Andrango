package com.examen2.andrangoexamen2.model;

import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Document(collection = "turnos")
public class Turno {
    @Id
    private String id;
    private Integer numeroTurno;
    private String cedula;
    private String nombreCliente;
    private String codigoUsuarioEjecutivo;
    private String nombreEjecutivo;
    private LocalDateTime fechaHoraGeneracion;
    private LocalDateTime fechaHoraInicioAtencion;
    private LocalDateTime fechaHoraFinAtencion;
    private Integer calificacion;

    @Version
    private Long version;

}
