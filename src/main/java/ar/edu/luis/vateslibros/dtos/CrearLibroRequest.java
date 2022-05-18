package ar.edu.luis.vateslibros.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CrearLibroRequest implements Serializable {
    private String titulo;
    private Long autorId;
}
