package com.william.springboot.app.administradorclientes.springboot_jpa.springboot_jpa.entities;

import java.util.List;

public class Usuario {
    private Integer id;
    private String username;
    private String password;
    private String email;
    private boolean enabled;
    private List<Rol> listaRoles;
}
