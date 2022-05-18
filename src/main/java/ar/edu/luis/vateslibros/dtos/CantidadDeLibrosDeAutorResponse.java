package ar.edu.luis.vateslibros.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CantidadDeLibrosDeAutorResponse {
    private String autor;
    private int cantidadDeLibros;
}
