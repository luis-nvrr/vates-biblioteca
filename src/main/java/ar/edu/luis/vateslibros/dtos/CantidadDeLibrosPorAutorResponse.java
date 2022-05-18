package ar.edu.luis.vateslibros.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CantidadDeLibrosPorAutorResponse {
    private Map<String, Integer> cantidadDeLibrosPorAutor;
}
