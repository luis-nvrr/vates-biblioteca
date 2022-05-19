package ar.edu.luis.vateslibros.services;

import ar.edu.luis.vateslibros.dtos.CantidadDeLibrosDeAutorResponse;
import ar.edu.luis.vateslibros.dtos.CrearAutorRequest;
import ar.edu.luis.vateslibros.dtos.ModificarAutorRequest;
import ar.edu.luis.vateslibros.entities.Autor;
import ar.edu.luis.vateslibros.entities.Libro;
import ar.edu.luis.vateslibros.exceptions.AutorNotFoundException;
import ar.edu.luis.vateslibros.exceptions.InvalidAutorException;
import ar.edu.luis.vateslibros.repositories.AutorRepository;
import ar.edu.luis.vateslibros.repositories.LibroRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AutorServiceImpl implements AutorService{
    private final AutorRepository autorRepository;
    private final LibroRepository libroRepository;

    public AutorServiceImpl(AutorRepository autorRepository, LibroRepository libroRepository) {
        this.autorRepository = autorRepository;
        this.libroRepository = libroRepository;
    }

    @Override
    public List<Autor> buscarTodos() {
        return autorRepository.findAll();
    }

    @Override
    public Autor buscarUno(long autorId) {
        System.out.println(autorId);
        return autorRepository
                .findById(autorId)
                .orElseThrow(()-> new AutorNotFoundException("el autor no existe"));
    }

    @Override
    public void crearAutor(CrearAutorRequest request) {
        Autor autor = new Autor(request.getNombre());
        autorRepository.save(autor);
    }

    @Override
    public void borrarAutor(long autorId) {
       autorRepository
               .findById(autorId)
               .orElseThrow(() -> new InvalidAutorException("el autor es invalido"));
        autorRepository.deleteById(autorId);
    }

    @Override
    public void modificarAutor(long autorId, ModificarAutorRequest request) {
        Autor autor = autorRepository
                .findById(autorId)
                .orElseThrow(()-> new InvalidAutorException("el autor es invalido"));
        autor.setNombre(request.getNombre());
        autorRepository.save(autor);
    }

    @Override
    public CantidadDeLibrosDeAutorResponse contarLibrosDeAutor(long autorId) {
        Autor autor = autorRepository
                .findById(autorId)
                .orElseThrow(()-> new InvalidAutorException("el autor no existe"));

        int cantidad = (int) libroRepository
                .findAll()
                .stream()
                .filter(libro -> libro.tieneAutorConId(autorId))
                .count();
        return new CantidadDeLibrosDeAutorResponse(autor.getNombre(), cantidad);
    }

    @Override
    public List<Libro> buscarLibrosDeAutor(String nombreAutor) {
        return libroRepository
                .findAll().stream()
                .filter(libro -> libro.tieneAutorConNombre(nombreAutor))
                .collect(Collectors.toList());
    }
}
