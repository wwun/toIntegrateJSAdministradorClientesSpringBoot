package com.william.springboot.app.administradorclientes.springboot_jpa.springboot_jpa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.william.springboot.app.administradorclientes.springboot_jpa.springboot_jpa.entities.Empresa;
import com.william.springboot.app.administradorclientes.springboot_jpa.springboot_jpa.repositories.EmpresaRepository;

@Service
public class EmpresaServiceImpl implements EmpresaService{
    
    @Autowired
    EmpresaRepository empresaRepository;

    @Override
    @Transactional
    public Optional<Empresa> delete(Long id) {
        Optional<Empresa> empresa = empresaRepository.findById(id);
        if(empresa.isPresent()){
            empresaRepository.deleteById(id);
        }
        return empresa;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Empresa> findAll() {
        return (List<Empresa>)empresaRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Empresa> getById(Long id) {
        return empresaRepository.findById(id);
    }

    @Override
    @Transactional
    public Empresa save(Empresa empresa) {
        return empresaRepository.save(empresa);
    }

    @Override
    @Transactional
    public Optional<Empresa> update(Long id, Empresa empresa) {
        Optional<Empresa> empresaOptional = empresaRepository.findById(id);
        if(empresaOptional.isPresent()){
            Empresa empresaDb = empresaOptional.orElseThrow();
            empresaDb.setNombre(empresa.getNombre());
            empresaDb.setDireccion(empresa.getDireccion());
        }
        return empresaOptional;
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Empresa> findByNombre(String nombre){
        return empresaRepository.findByNombre(nombre);
    }

    //pendiente modificar la lista de usuarios de una empresa
}
