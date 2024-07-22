package com.william.springboot.app.administradorclientes.springboot_jpa.springboot_jpa.controllers;

import java.net.http.HttpResponse;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.william.springboot.app.administradorclientes.springboot_jpa.springboot_jpa.services.ClienteEmpresaService;
import com.william.springboot.app.administradorclientes.springboot_jpa.springboot_jpa.services.ClienteService;
import com.william.springboot.app.administradorclientes.springboot_jpa.springboot_jpa.services.EmpresaService;

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
}
