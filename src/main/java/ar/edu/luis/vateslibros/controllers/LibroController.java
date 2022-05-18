package ar.edu.luis.vateslibros.controllers;

import ar.edu.luis.vateslibros.dtos.CrearLibroRequest;
import ar.edu.luis.vateslibros.dtos.ModificarLibroRequest;
import ar.edu.luis.vateslibros.entities.Libro;
import ar.edu.luis.vateslibros.services.LibroService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/libros")
public class LibroController {
    private final LibroService libroService;

    public LibroController(LibroService libroService){
        this.libroService = libroService;
    }

    @GetMapping(params = {"tipoOrdenamiento"})
    public ResponseEntity<List<Libro>> buscarOrdenados(
            @RequestParam String tipoOrdenamiento
    ) {
        if (tipoOrdenamiento.isEmpty()) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(libroService.buscarLibrosOrdenadosPorTitulo(tipoOrdenamiento));
    }

    @GetMapping(params = {"titulo"})
    public ResponseEntity<List<Libro>> buscarPorTitulo(@RequestParam String titulo) {
        if (titulo.isEmpty()) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(libroService.buscarLibrosPorTitulo(titulo));
    }

    @GetMapping
    public ResponseEntity<List<Libro>> buscarTodos() {
        return ResponseEntity.ok(libroService.buscarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Libro> buscarUno(@PathVariable Long id) {
        return ResponseEntity.ok(libroService.buscarUno(id));
    }

    @PostMapping
    public void guardarLibro(@RequestBody CrearLibroRequest request) {
        libroService.crearLibro(request);
    }

    @PutMapping("/{id}")
    public void modificarLibro(@PathVariable Long id, @RequestBody ModificarLibroRequest request) {
        libroService.modificarLibro(id, request);
    }

    @DeleteMapping("/{id}")
    public void borrarLibro(@PathVariable Long id) {
        libroService.borrarLibro(id);
    }
}
