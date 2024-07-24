package com.william.springboot.app.administradorclientes.springboot_jpa.springboot_jpa.entities;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "empresa")
public class Empresa {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "{nombre.NotBlank}")
    @Size(min=1, max=200, message = "{nombre.Size}")
    private String nombre;

    @Value("${empresa.direccion}")
    private String direccion;

    @OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL, orphanRemoval = true)    //'empresa' es el nombre del atributo en la entidad Cliente que maneja la relación
    //@JsonIgnore   //si se usa en cliente, ya no es necesario ponerlo acá    //si solo se anota aqí va a devolver ud, nombre, email, telefono, empresa {id, nombre, direccion}   solo 1 bucle
    //@JsonBackReference
    private List<Cliente> listaClientes;

    public Empresa() {
        this.direccion = "San Isidro";
    }

    @PostConstruct
    public void init(){ //otra opción para insertar valor por defecto
        if(this.direccion==null)
            this.direccion = "San Isidro";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public List<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(List<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }
    
}
