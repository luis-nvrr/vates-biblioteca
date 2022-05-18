package ar.edu.luis.vateslibros.exceptions;

public class AutorNotFoundException extends RuntimeException{
    public AutorNotFoundException(String message) {
        super(message);
    }
}
