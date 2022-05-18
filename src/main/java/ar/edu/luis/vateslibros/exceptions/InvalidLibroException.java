package ar.edu.luis.vateslibros.exceptions;

public class InvalidLibroException extends RuntimeException{
    public InvalidLibroException(String message) {
        super(message);
    }
}
