package com.storemanager.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
// Nos sirve para controlar las excepciones que ocurran en mis controladores
public class ProductoExceptionHandler {

    // Cuando ocurra ProductoNoEncontradoException, devuelve HTTP 404 Not Found...
    @ExceptionHandler(ProductoNoEncontradoException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String productoNoEncontrado(ProductoNoEncontradoException ex) {
        return ex.getMessage();
    }

    @ExceptionHandler(ClienteNoEncontradoException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String clienteNoEncontrado(ClienteNoEncontradoException ex) {
        return ex.getMessage();
    }
}