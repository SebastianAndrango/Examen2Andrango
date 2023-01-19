package com.examen2.andrangoexamen2.controller.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.examen2.andrangoexamen2.model.Cuenta;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClienteRS implements Serializable {
    private String id;
    private String cedula;
    private String nombres;
    private String apellidos;
    private Date fechaNacimiento;
    private String direccionPrincipal;
    private String telefono;
    private String email;
    List<Cuenta> cuenta;
}
