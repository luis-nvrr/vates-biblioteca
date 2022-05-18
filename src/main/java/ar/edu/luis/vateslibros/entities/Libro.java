package ar.edu.luis.vateslibros.entities;

import javax.persistence.*;
import java.util.Locale;

@Entity
@Table(name="Libros")
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="id_autor")
    private Autor autor;

    public Libro(){}
    public Libro(String titulo, Autor autor) {
        this.titulo = titulo;
        this.autor = autor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public String buscarNombreAutor() {
        return autor.getNombre();
    }

    public boolean tieneAutorConId(long id) {
        return this.autor.tieneId(id);
    }

    public boolean tieneAutorConNombre(String nombreAutor) {
        return this.autor.tieneNombre(nombreAutor);
    }

    public boolean tieneTitulo(String titulo) {
        return this.titulo.toLowerCase(Locale.ROOT).contains(titulo.toLowerCase(Locale.ROOT));
    }
}
