package com.william.springboot.app.administradorclientes.springboot_jpa.springboot_jpa.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.william.springboot.app.administradorclientes.springboot_jpa.springboot_jpa.dtos.ClienteEmpresaDTO;
import com.william.springboot.app.administradorclientes.springboot_jpa.springboot_jpa.entities.Cliente;
import com.william.springboot.app.administradorclientes.springboot_jpa.springboot_jpa.entities.Empresa;

@Service
public class ClienteEmpresaServiceImpl implements ClienteEmpresaService{

    @Autowired
    ClienteService clienteService;

    @Autowired
    EmpresaService empresaService;

    @Override
    public boolean deleteClienteEmpresa(Long clienteId) {
        //devuelve boolean porque maneja dos Optional, si se elimina cuál se debería devolver? Cliente es lo más lógico pero cuando crezca la aplicación no
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
        
        if(clienteService.getById(clienteEmpresaDTO.getIdCliente()).isPresent()){
            return false;
        }

        Optional<Empresa> empresaOptional = empresaService.findByNombre(clienteEmpresaDTO.getNombreEmpresa());

        Empresa empresa;
        
        if(empresaOptional.isPresent()){
            empresa = empresaOptional.get();
        }else{
            empresa = new Empresa();
            empresa.setNombre(clienteEmpresaDTO.getNombreEmpresa());
            empresa = empresaService.save(empresa);            
        }

        Cliente cliente = new Cliente();
        
        cliente.setNombre(clienteEmpresaDTO.getNombreCliente());
        cliente.setEmail(clienteEmpresaDTO.getEmailCliente());
        cliente.setTelefono(clienteEmpresaDTO.getTelefonoCliente());
        cliente.setId(clienteEmpresaDTO.getIdCliente());
        cliente.setEmpresa(empresa);

        clienteService.save(cliente);
        return true;
    }

    @Override
    public boolean updateClienteEmpresa(Long id, ClienteEmpresaDTO clienteEmpresaDTO) {
        
        Optional<Cliente> optionalCliente = clienteService.getById(id);

        if(!optionalCliente.isPresent()){
            return false;
        }

        Optional<Empresa> optionalEmpresa = empresaService.findByNombre(clienteEmpresaDTO.getNombreEmpresa());

        Empresa empresa;
        if(!optionalEmpresa.isPresent()){
            empresa = new Empresa();
            empresa.setNombre(clienteEmpresaDTO.getNombreEmpresa());
            empresa = empresaService.save(empresa);
        }else{
            empresa = optionalEmpresa.get();
        }

        Cliente cliente = new Cliente();
        cliente.setId(id);
        cliente.setNombre(clienteEmpresaDTO.getNombreCliente());
        cliente.setEmail(clienteEmpresaDTO.getEmailCliente());
        cliente.setTelefono(clienteEmpresaDTO.getTelefonoCliente());
        cliente.setEmpresa(empresa);

        if(!clienteService.update(id, cliente).isPresent()){
            return false;
        }

        return true;
    }
}
