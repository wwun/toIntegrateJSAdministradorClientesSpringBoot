package com.william.springboot.app.administradorclientes.springboot_jpa.springboot_jpa.repositories;

import org.springframework.data.repository.CrudRepository;

import com.william.springboot.app.administradorclientes.springboot_jpa.springboot_jpa.entities.Empresa;

public interface EmpresaRepository extends CrudRepository<Empresa, Integer>{

}
