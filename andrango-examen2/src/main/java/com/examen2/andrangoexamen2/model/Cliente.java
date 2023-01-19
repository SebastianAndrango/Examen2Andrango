package com.examen2.andrangoexamen2.model;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Document(collection = "clients")
public class Cliente {
    @Id
    private String id;
    private String cedula;
    private String nombres;
    private String apellidos;
    private LocalDateTime fechaNacimiento;
    private String direccionPrincipal;
    private String telefono;
    private String email;
    private List<Cuenta> cuenta;

    @Version
    private Long version;

}
