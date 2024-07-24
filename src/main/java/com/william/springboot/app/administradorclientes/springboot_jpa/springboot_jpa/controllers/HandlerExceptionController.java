package com.william.springboot.app.administradorclientes.springboot_jpa.springboot_jpa.controllers;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.SQLInvalidAuthorizationSpecException;
import java.sql.SQLNonTransientException;
import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.CannotCreateTransactionException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.william.springboot.app.administradorclientes.springboot_jpa.springboot_jpa.excepcions.Error;

@RestControllerAdvice
public class HandlerExceptionController {

    @ExceptionHandler({SQLInvalidAuthorizationSpecException.class, CannotCreateTransactionException.class})
    public ResponseEntity<?> invalidAuthorization(SQLException ex){
        System.out.println("=================================================invalidAuthorization=================================================");
        Error error = new Error();
        error.setError("Error de conexión a la base de datos");
        error.setDate(new Date());
        error.setStatus(HttpStatus.UNAUTHORIZED.value());

        String mensaje = ex.getMessage() + " [sql code: " + ex.getErrorCode() + "]";
        error.setMensaje(mensaje);

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(error);
    }
}
