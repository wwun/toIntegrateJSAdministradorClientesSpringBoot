package com.william.springboot.app.administradorclientes.springboot_jpa.springboot_jpa.services;

import java.util.List;
import java.util.Optional;

import com.william.springboot.app.administradorclientes.springboot_jpa.springboot_jpa.entities.Cliente;

public interface ClienteService {
    List<Cliente> findAll();
    Optional<Cliente> getById(Integer id);
    Cliente save(Cliente cliente);
    Optional<Cliente> update(Cliente cliente);
    Optional<Cliente> delete(Integer id);
}