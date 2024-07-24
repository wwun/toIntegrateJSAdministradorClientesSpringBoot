package com.william.springboot.app.administradorclientes.springboot_jpa.springboot_jpa.services;

import java.util.List;
import java.util.Optional;

//import org.springframework.data.jpa.repository.Query;

import com.william.springboot.app.administradorclientes.springboot_jpa.springboot_jpa.entities.Empresa;

public interface EmpresaService {
    List<Empresa> findAll();
    Optional<Empresa> getById(Long id);
    Empresa save(Empresa empresa);
    Optional<Empresa> update(Long id, Empresa empresa);
    Optional<Empresa> delete(Long id);

    //@Query("SELECT emp FROM empresa emp WHERE emp.name=?1")
    Optional<Empresa> findByNombre(String nombre);
}
