package ar.edu.luis.vateslibros.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CantidadDeLibrosDeAutorResponse implements Serializable {
    private String autor;
    private int cantidadDeLibros;
}
