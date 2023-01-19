package com.examen2.andrangoexamen2.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examen2.andrangoexamen2.controller.dto.ClienteRS;
import com.examen2.andrangoexamen2.controller.mapper.ClienteMapper;
import com.examen2.andrangoexamen2.model.Cliente;
import com.examen2.andrangoexamen2.service.ClienteService;

@RestController
@RequestMapping(value = "api/exercise")
public class ClienteController {
    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping(value = "/{cedulaCliente}")
    public ResponseEntity<ClienteRS> obtenerClientePorId(@PathVariable("cedulaCliente") String cedulaCliente) {
        Cliente client = this.clienteService.findByCedula(cedulaCliente);
        if (client != null) {
            return ResponseEntity.ok(ClienteMapper.toClienteRS(client));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
