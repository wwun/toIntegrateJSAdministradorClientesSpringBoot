package com.william.springboot.app.administradorclientes.springboot_jpa.springboot_jpa.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.william.springboot.app.administradorclientes.springboot_jpa.springboot_jpa.dtos.ClienteEmpresaDTO;
import com.william.springboot.app.administradorclientes.springboot_jpa.springboot_jpa.entities.Cliente;

@Service
public class ClienteEmpresaServiceImpl implements ClienteEmpresaService{

    @Autowired
    ClienteService clienteService;

    @Autowired
    EmpresaService empresaService;

    @Override
    public boolean deleteClienteEmpresa(Integer clienteId) {
        return clienteService.delete(clienteId).isPresent() ? true : false;
    }

    @Override
    public List<ClienteEmpresaDTO> findAllClienteEmpresa() {
      List<Cliente> listaClientes = clienteService.findAll();
      List<ClienteEmpresaDTO> listaClienteEmpresaDTO = new ArrayList<>();
      listaClientes.forEach(cliente -> {
            ClienteEmpresaDTO clienteEmpresaDTO = new ClienteEmpresaDTO();
            clienteEmpresaDTO.setIdCliente(cliente.getId());    //este campo debe estar oculto
            clienteEmpresaDTO.setNombreCliente(cliente.getNombre());
            clienteEmpresaDTO.setNombreEmpresa(cliente.getEmpresa().getNombre());
            clienteEmpresaDTO.setEmailCliente(cliente.getEmail());
            clienteEmpresaDTO.setTelefonoCliente(cliente.getTelefono());
            listaClienteEmpresaDTO.add(clienteEmpresaDTO);
        });
      return listaClienteEmpresaDTO;
    }

    @Override
    public boolean saveClienteEmpresa(ClienteEmpresaDTO clienteEmpresaDTO) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean updateClienteEmpresa(ClienteEmpresaDTO clienteEmpresaDTO) {
        // TODO Auto-generated method stub
        return false;
    }
}
