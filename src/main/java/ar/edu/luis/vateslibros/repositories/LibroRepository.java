package ar.edu.luis.vateslibros.repositories;

import ar.edu.luis.vateslibros.entities.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Long> {
}
