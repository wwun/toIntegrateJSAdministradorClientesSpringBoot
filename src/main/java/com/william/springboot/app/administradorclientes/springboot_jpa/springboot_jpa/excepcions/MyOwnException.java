package com.william.springboot.app.administradorclientes.springboot_jpa.springboot_jpa.excepcions;


public class MyOwnException extends RuntimeException{
    public MyOwnException(String mensaje){
        super(mensaje);
    }
}
