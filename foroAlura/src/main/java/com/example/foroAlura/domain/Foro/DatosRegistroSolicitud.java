package com.example.foroAlura.domain.Foro;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DatosRegistroSolicitud(
               Long idTopico,
    @NotBlank  String mensaje,
    @NotBlank  String nombreCurso,
    @NotBlank  String titulo

) {
}
