package com.william.springboot.app.administradorclientes.springboot_jpa.springboot_jpa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.william.springboot.app.administradorclientes.springboot_jpa.springboot_jpa.entities.Cliente;
import com.william.springboot.app.administradorclientes.springboot_jpa.springboot_jpa.repositories.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService{

    @Autowired
    ClienteRepository clienteRepository;

    @Override
    @Transactional
    public Optional<Cliente> delete(Integer id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        if(cliente.isPresent()){
            clienteRepository.deleteById(id);
        }
        return cliente;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Cliente> findAll() {
        return (List<Cliente>)clienteRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Cliente> getById(Integer id) {
        return clienteRepository.findById(id);
    }

    @Override
    @Transactional
    public Cliente save(Cliente cliente) {
        clienteRepository.save(cliente);
        return null;
    }

    @Override
    @Transactional
    public Optional<Cliente> update(Cliente cliente) {
        Optional<Cliente> clienteOptional = clienteRepository.findById(cliente.getId());
        if(clienteOptional.isPresent()){
            Cliente clienteDb = clienteOptional.orElseThrow();
            clienteDb.setNombre(cliente.getNombre());
            clienteDb.setEmail(cliente.getEmail());
            clienteDb.setTelefono(cliente.getTelefono());
            clienteDb.setEmpresa(cliente.getEmpresa());
        }
        return clienteOptional;
    }
}
