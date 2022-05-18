package ar.edu.luis.vateslibros.exceptions;


public class LibroNotFoundException extends RuntimeException {
    public LibroNotFoundException(String message) {
        super(message);
    }
}
