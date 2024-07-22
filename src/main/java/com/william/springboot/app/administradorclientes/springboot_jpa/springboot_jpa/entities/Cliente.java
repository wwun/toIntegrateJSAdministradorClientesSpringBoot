package com.william.springboot.app.administradorclientes.springboot_jpa.springboot_jpa.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    private Integer id;

    @NotBlank(message = "El nombre no puede ser vacío")
    @Size(min=1, max=200, message = "${cliente.nombre.Size}")
    private String nombre;
    //@Value se debe usar para inyectar valores de configuración: Usa @Value cuando necesites inyectar valores específicos de configuración en tus componentes de Spring, como cadenas de conexión, URLs, nombres de archivos, etc
    //y para inyectar valores por defecto: Puedes usar @Value para proporcionar valores por defecto en caso de que las propiedades no estén definidas

    @NotBlank(message = "${email.NotBlank}")
    @Email(message = "${email.Email}")
    private String email;

    @NotBlank(message = "${telefono.NotBlank}")
    @Size(min=1, max=10, message = "${cliente.telefono.Size}")
    private String telefono;

    @ManyToOne
    @JoinColumn(name = "empresa_id")    // Este es el nombre de la columna en la tabla cliente en la base de datos que actúa como clave foránea
    @JsonIgnore //se usa para evitar la serialización de campos que causan ciclos, esos ciclos infinitos cuando se llama a Cliente que muestra empresa que a su vez muestra Cliente, en este caso se usa acá porque la empresa contiene una lista de Clientes, con esta opción no se podría mostrar el nombre de la empresa poruqe el objeto empresa se omite
    //@JsonManagedReference   //otra solución es @JsonManagedReference en el lado "dueño" de la relación y @JsonBackReference en el lado inverso para evitar la serialización infinita    //esto devulve los datos de Cliente y el objeto Empresa id, nombre, email, telefono, empresa {id, nombre, direccion}, de este último objeto se debe recuperar el nombre de empresa
    //usando el DTO este problema desaparece porque no hay referencias a sí mismas defined. Como se está trabajando con esto no es necesario @JsonIgnore
    private Empresa empresa;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    
}
