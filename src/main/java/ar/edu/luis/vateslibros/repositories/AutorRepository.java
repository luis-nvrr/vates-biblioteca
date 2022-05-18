package ar.edu.luis.vateslibros.repositories;

import ar.edu.luis.vateslibros.entities.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor, Long> {
}
