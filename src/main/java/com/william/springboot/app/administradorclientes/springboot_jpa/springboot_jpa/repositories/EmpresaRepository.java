package com.william.springboot.app.administradorclientes.springboot_jpa.springboot_jpa.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.william.springboot.app.administradorclientes.springboot_jpa.springboot_jpa.entities.Empresa;

public interface EmpresaRepository extends CrudRepository<Empresa, Long>{
    //@Query("SELECT emp FROM empresa emp WHERE emp.nombre=?1")   //significa que estamos buscando la entidad Empresa donde el atributo nombre coincide con el primer parámetro pasado al método
    Optional<Empresa> findByNombre(String nombre);  //se debe poner como findByNombreDeLaVariable, NombreDeLaVariable es el nombre del atributo en la entidad, luego spring busca en la base de datos con base en si se ha definido un @Column
}
