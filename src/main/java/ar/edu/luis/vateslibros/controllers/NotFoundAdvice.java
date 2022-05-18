package ar.edu.luis.vateslibros.controllers;

import ar.edu.luis.vateslibros.dtos.ExceptionResponse;
import ar.edu.luis.vateslibros.exceptions.AutorNotFoundException;
import ar.edu.luis.vateslibros.exceptions.LibroNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class NotFoundAdvice {
    @ExceptionHandler(value ={LibroNotFoundException.class, AutorNotFoundException.class})
    public ResponseEntity<ExceptionResponse> handle(RuntimeException ex) {
        ExceptionResponse response = new ExceptionResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
