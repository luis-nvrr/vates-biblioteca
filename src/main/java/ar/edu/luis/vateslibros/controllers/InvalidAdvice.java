package ar.edu.luis.vateslibros.controllers;

import ar.edu.luis.vateslibros.dtos.ExceptionResponse;
import ar.edu.luis.vateslibros.exceptions.InvalidAutorException;
import ar.edu.luis.vateslibros.exceptions.InvalidLibroException;
import ar.edu.luis.vateslibros.exceptions.OpcionInvalidaException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class InvalidAdvice {

    @ExceptionHandler(value = {InvalidLibroException.class, InvalidAutorException.class, OpcionInvalidaException.class})
    public ResponseEntity<ExceptionResponse> handle(RuntimeException ex) {
        ExceptionResponse response = new ExceptionResponse(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
