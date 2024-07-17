package com.example.foroAlura.domain.Foro;

import jakarta.validation.constraints.NotNull;

public record DatosActualizarTopico(
      @NotNull Long idTopico,
        String mensaje,
        String nombreCurso,
        String titulo
) {
}
