package com.examen2.andrangoexamen2.controller.mapper;

import com.examen2.andrangoexamen2.controller.dto.ClienteRS;
import com.examen2.andrangoexamen2.model.Cliente;

public class ClienteMapper {
    public static ClienteRS toClienteRS(Cliente cliente) {
        return ClienteRS.builder()
                .id(cliente.getId())
                .cedula(cliente.getCedula())
                .nombres(cliente.getNombres())
                .apellidos(cliente.getApellidos())
                .fechaNacimiento(cliente.getFechaNacimiento())
                .direccionPrincipal(cliente.getDireccionPrincipal())
                .telefono(cliente.getTelefono())
                .email(cliente.getEmail())
                .cuenta(cliente.getCuenta())
                .build();
    }
}
