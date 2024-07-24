package com.william.springboot.app.administradorclientes.springboot_jpa.springboot_jpa.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.william.springboot.app.administradorclientes.springboot_jpa.springboot_jpa.dtos.ClienteEmpresaDTO;
import com.william.springboot.app.administradorclientes.springboot_jpa.springboot_jpa.services.ClienteEmpresaService;
import com.william.springboot.app.administradorclientes.springboot_jpa.springboot_jpa.services.ClienteService;
import com.william.springboot.app.administradorclientes.springboot_jpa.springboot_jpa.services.EmpresaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class ClienteEmpresaController {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private EmpresaService empresaService;

    @Autowired
    private ClienteEmpresaService clienteEmpresaService;

    @GetMapping
    public ResponseEntity<?> getClientesYEmpresas(){
        return ResponseEntity.status(HttpStatus.OK).body(clienteEmpresaService.findAllClienteEmpresa());
    }

    @PostMapping
    public ResponseEntity<?> saveClientesYEmpresa(@Valid @RequestBody ClienteEmpresaDTO clienteEmpresaDTO, BindingResult result){
        if(result.hasFieldErrors()){
            System.out.println("Error: "+result.getAllErrors());
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteEmpresaService.saveClienteEmpresa(clienteEmpresaDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateClienteYEmpresa(@Valid @RequestBody ClienteEmpresaDTO clientesEmpresaDTO, BindingResult result, @PathVariable Long id) {
        if(result.hasFieldErrors()){
            return ResponseEntity.badRequest().body(result);
        }

        //se ha almacenado la respuesta en boolean porque maneja dos Optional, la de Cliente y Empresa, si fuera solo uno se podría devolver ese optional y la respuesta sería más directa
        if(clienteEmpresaService.updateClienteEmpresa(id, clientesEmpresaDTO))
            return ResponseEntity.status(HttpStatus.CREATED).body(Optional.of(clientesEmpresaDTO).orElseThrow());
        
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteClienteYEmpresa(@PathVariable Long id){
        if(clienteEmpresaService.deleteClienteEmpresa(id))
            return ResponseEntity.ok().build();
        return ResponseEntity.badRequest().build();
    }
    
}
