package ar.edu.luis.vateslibros.services;

import ar.edu.luis.vateslibros.dtos.CrearLibroRequest;
import ar.edu.luis.vateslibros.dtos.ModificarLibroRequest;
import ar.edu.luis.vateslibros.entities.Libro;

import java.util.List;

public interface LibroService {
    void crearLibro(CrearLibroRequest request);
    void borrarLibro(long libroId);
    void modificarLibro(long libroId, ModificarLibroRequest request);
    Libro buscarUno(long libroId);
    List<Libro> buscarTodos();
    List<Libro> buscarLibrosPorTitulo(String titulo);
    List<Libro> buscarLibrosOrdenadosPorTitulo(String tipOrdenamiento);
}

