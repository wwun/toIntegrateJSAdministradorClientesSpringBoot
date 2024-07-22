package com.william.springboot.app.administradorclientes.springboot_jpa.springboot_jpa.services;

import java.util.List;

import com.william.springboot.app.administradorclientes.springboot_jpa.springboot_jpa.dtos.ClienteEmpresaDTO;

public interface ClienteEmpresaService {
    List<ClienteEmpresaDTO> findAllClienteEmpresa();
    boolean saveClienteEmpresa(ClienteEmpresaDTO clienteEmpresaDTO);
    boolean deleteClienteEmpresa(Integer clienteId);
    boolean updateClienteEmpresa(ClienteEmpresaDTO clienteEmpresaDTO);
}
