package com.william.springboot.app.administradorclientes.springboot_jpa.springboot_jpa.services;

import java.util.List;
import java.util.Optional;

import com.william.springboot.app.administradorclientes.springboot_jpa.springboot_jpa.entities.Empresa;

public interface EmpresaService {
    List<Empresa> findAll();
    Optional<Empresa> getById(Integer id);
    Empresa save(Empresa empresa);
    Optional<Empresa> update(Empresa empresa);
    Optional<Empresa> delete(Integer id);
}
