package ar.edu.luis.vateslibros.services;

import ar.edu.luis.vateslibros.dtos.CrearLibroRequest;
import ar.edu.luis.vateslibros.dtos.ModificarLibroRequest;
import ar.edu.luis.vateslibros.entities.Autor;
import ar.edu.luis.vateslibros.entities.Libro;
import ar.edu.luis.vateslibros.exceptions.InvalidAutorException;
import ar.edu.luis.vateslibros.exceptions.InvalidLibroException;
import ar.edu.luis.vateslibros.exceptions.LibroNotFoundException;
import ar.edu.luis.vateslibros.exceptions.OpcionInvalidaException;
import ar.edu.luis.vateslibros.repositories.AutorRepository;
import ar.edu.luis.vateslibros.repositories.LibroRepository;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class LibroServiceImpl implements LibroService{
    private final LibroRepository libroRepository;
    private final AutorRepository autorRepository;
    private final Map<String, Comparator<Libro>> comparatorMap;

    public LibroServiceImpl(LibroRepository libroRepository, AutorRepository autorRepository) {
        this.libroRepository = libroRepository;
        this.autorRepository = autorRepository;
        this.comparatorMap = new HashMap<>();
        Comparator<Libro> comparator = Comparator.comparing(Libro::getTitulo);
        comparatorMap.put("ASC", comparator);
        comparatorMap.put("DESC", comparator.reversed());
    }

    @Override
    public void crearLibro(CrearLibroRequest request) {
        Autor autor = autorRepository
                .findById(request.getAutorId())
                .orElseThrow(()-> new InvalidAutorException("el autor no existe"));
        Libro libro = new Libro(request.getTitulo(), autor);
        libroRepository.save(libro);
    }

    @Override
    public void borrarLibro(long libroId) {
        libroRepository
                .findById(libroId)
                .orElseThrow(() -> new InvalidLibroException("el libro no existe"));
        libroRepository.deleteById(libroId);
    }

    @Override
    public void modificarLibro(long libroId, ModificarLibroRequest request) {
        Libro libro = libroRepository
                .findById(libroId)
                .orElseThrow(()-> new InvalidLibroException("el libro no existe"));
        Autor autor = autorRepository
                .findById(request.getAutorId())
                .orElseThrow(()-> new InvalidAutorException("el autor no existe"));

        libro.setTitulo(request.getTitulo());
        libro.setAutor(autor);
        libroRepository.save(libro);
    }

    @Override
    public Libro buscarUno(long libroId) {
        return libroRepository
                .findById(libroId)
                .orElseThrow(()-> new LibroNotFoundException("el libro no existe"));
    }

    @Override
    public List<Libro> buscarTodos() {
        return libroRepository.findAll();
    }

    @Override
    public List<Libro> buscarLibrosPorTitulo(String titulo) {
        return libroRepository.findAll().stream()
                .filter(libro -> libro.tieneTitulo(titulo))
                .collect(Collectors.toList());
    }

    @Override
    public List<Libro> buscarLibrosOrdenadosPorTitulo(String tipoOrdenamiento) {
        System.out.println(tipoOrdenamiento);
        Comparator<Libro> comparator = Optional.ofNullable(comparatorMap.get(tipoOrdenamiento))
                .orElseThrow(()-> new OpcionInvalidaException("El tipo de ordenamiento no existe"));

        return libroRepository
                .findAll().stream()
                .sorted(comparator)
                .collect(Collectors.toList());
    }
}
