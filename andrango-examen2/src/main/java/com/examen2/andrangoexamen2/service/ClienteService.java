package com.examen2.andrangoexamen2.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.examen2.andrangoexamen2.model.Cliente;
import com.examen2.andrangoexamen2.repository.ClienteRepository;

@Service
public class ClienteService {
    private ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Cliente findByCedula(String cedula) {
        Optional<Cliente> clientOpt = this.clienteRepository.findByCedula(cedula);
        if (clientOpt.isPresent()) {
            return clientOpt.get();
        } else {
            throw new RuntimeException("The client does not exist");
        }
    }

}
