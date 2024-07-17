package com.example.foroAlura.domain.Foro;

public record DatosRespuestaTopico(
        Long idTopico,
        String mensaje,
        String nombreCurso,
        String titulo
) {
}
