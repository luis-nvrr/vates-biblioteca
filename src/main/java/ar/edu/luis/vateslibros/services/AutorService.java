package ar.edu.luis.vateslibros.services;

import ar.edu.luis.vateslibros.dtos.CantidadDeLibrosDeAutorResponse;
import ar.edu.luis.vateslibros.dtos.CantidadDeLibrosPorAutorResponse;
import ar.edu.luis.vateslibros.dtos.CrearAutorRequest;
import ar.edu.luis.vateslibros.dtos.ModificarAutorRequest;
import ar.edu.luis.vateslibros.entities.Autor;
import ar.edu.luis.vateslibros.entities.Libro;

import java.util.List;

public interface AutorService {
    List<Autor> buscarTodos();
    Autor buscarUno(long autorId);
    void crearAutor(CrearAutorRequest request);
    void borrarAutor(long autorId);
    void modificarAutor(long autorId, ModificarAutorRequest request);
    CantidadDeLibrosPorAutorResponse contarLibrosPorAutor();
    CantidadDeLibrosDeAutorResponse contarLibrosDeAutor(long autorId);
    List<Libro> buscarLibrosDeAutor(String nombreAutor);
}
