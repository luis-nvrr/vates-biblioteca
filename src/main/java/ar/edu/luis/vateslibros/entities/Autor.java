package ar.edu.luis.vateslibros.entities;

import javax.persistence.*;

@Entity
@Table(name="Autores")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombre;

    public Autor(){}

    public Autor(String nombre) {
        this.nombre = nombre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean tieneId(long id) {
        return this.id == id;
    }

    public boolean tieneNombre(String nombre) {
        return this.nombre.equalsIgnoreCase(nombre);
    }
}
