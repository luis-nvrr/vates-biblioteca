package ar.edu.luis.vateslibros.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ModificarLibroRequest {
    private String titulo;
    private Long autorId;
}


