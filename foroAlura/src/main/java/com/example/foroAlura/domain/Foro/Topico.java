package com.example.foroAlura.domain.Foro;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Table(name = "topicos")
@Entity (name = "Topicos")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")

public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTopico;
    private String mensaje;
    private String nombreCurso;
    private String titulo;
    private Boolean status;
    private LocalDateTime fecha;

    public Topico(DatosRegistroSolicitud datosRegistroSolicitud) {
        this.status=true;
        this.idTopico =datosRegistroSolicitud.idTopico();
        this.mensaje= datosRegistroSolicitud.mensaje();
        this.nombreCurso= datosRegistroSolicitud.nombreCurso();
        this.titulo= datosRegistroSolicitud.titulo();
       this.fecha= LocalDateTime.now();
    }

    public void actualizarTopicos(DatosActualizarTopico datosActualizarTopico) {
        if (datosActualizarTopico.idTopico() != null){
            this.idTopico =datosActualizarTopico.idTopico();
        }
        if (datosActualizarTopico.mensaje() != null){
            this.mensaje= datosActualizarTopico.mensaje();
        }

        if (datosActualizarTopico.nombreCurso() != null){
            this.nombreCurso= datosActualizarTopico.nombreCurso();
        }
        if (datosActualizarTopico.titulo() != null){
            this.titulo= datosActualizarTopico.titulo();
        }

    }

    public void desactivarTopico() {
        this.status=false;
    }

    public Long getIdTopico() {
        return idTopico;
    }

    public void setIdTopico(Long idTopico) {
        this.idTopico = idTopico;
    }


    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }
}
