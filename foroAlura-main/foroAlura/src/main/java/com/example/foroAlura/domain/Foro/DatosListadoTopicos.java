package com.example.foroAlura.domain.Foro;



public record DatosListadoTopicos(
        Long idTopico,
        String mensaje,
        String nombreCurso,
        String titulo
) {
    public  DatosListadoTopicos(Topico topico){
        this(topico.getIdTopico(), topico.getMensaje(),
                topico.getNombreCurso(), topico.getTitulo());
    }
}
