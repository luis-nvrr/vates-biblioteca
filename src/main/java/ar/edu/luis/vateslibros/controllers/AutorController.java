package ar.edu.luis.vateslibros.controllers;

import ar.edu.luis.vateslibros.dtos.CantidadDeLibrosDeAutorResponse;
import ar.edu.luis.vateslibros.dtos.CrearAutorRequest;
import ar.edu.luis.vateslibros.dtos.ModificarAutorRequest;
import ar.edu.luis.vateslibros.entities.Autor;
import ar.edu.luis.vateslibros.entities.Libro;
import ar.edu.luis.vateslibros.services.AutorService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/autores")
public class AutorController {
    private final AutorService autorService;

    public AutorController(AutorService autorService) {
        this.autorService = autorService;
    }

    @GetMapping
    public ResponseEntity<List<Autor>> buscarTodos() {
        return ResponseEntity.ok(autorService.buscarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Autor> buscarUno(@PathVariable long id) {
        return ResponseEntity.ok(autorService.buscarUno(id));
    }

    @PostMapping
    public void guardarAutor(@RequestBody CrearAutorRequest request) {
        autorService.crearAutor(request);
    }

    @PutMapping("/{id}")
    public void modificarAutor(@PathVariable long id, @RequestBody ModificarAutorRequest request) {
        autorService.modificarAutor(id, request);
    }

    @DeleteMapping("/{id}")
    public void borrarAutor(@PathVariable long id) {
        autorService.borrarAutor(id);
    }

    @GetMapping(value="/libros", params = {"nombreAutor"})
    public ResponseEntity<List<Libro>> buscarLibrosDeAutor(
            @RequestParam(required = false) String nombreAutor) {
        if(nombreAutor.isEmpty()) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(autorService.buscarLibrosDeAutor(nombreAutor));
    }

    @GetMapping(value="/{id}/libros", params ={"contar"})
    public ResponseEntity<CantidadDeLibrosDeAutorResponse> contarLibrosDeAutor(
            @PathVariable long id,
            @RequestParam boolean contar
    ) {
        if(!contar) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(autorService.contarLibrosDeAutor(id));
    }
}
