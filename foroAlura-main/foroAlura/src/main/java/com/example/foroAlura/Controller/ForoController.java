package com.example.foroAlura.Controller;


import com.example.foroAlura.domain.Foro.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/topicos")
public class ForoController {

    @Autowired
    private TopicoRepository topicoRepository;

    @PostMapping
    public ResponseEntity<DatosRespuestaTopico> registrarSolicitud(@RequestBody @Valid DatosRegistroSolicitud datosRegistroSolicitud,
                                                                   UriComponentsBuilder uriComponentsBuilder){
      Topico topico= topicoRepository.save(new Topico(datosRegistroSolicitud));
      DatosRespuestaTopico datosRespuestaTopico= new DatosRespuestaTopico(topico.getIdTopico(),
              topico.getMensaje(), topico.getNombreCurso(), topico.getTitulo());

        URI url=uriComponentsBuilder.path("topicos/{id}").buildAndExpand(topico.getIdTopico()).toUri();
      return ResponseEntity.created(url).body(datosRespuestaTopico);

    }


    @GetMapping
    public ResponseEntity<Page<DatosListadoTopicos>>  listadoDeTopicos(@PageableDefault(size = 2) Pageable paginacion){
        return ResponseEntity.ok(topicoRepository.findByStatusTrue(paginacion).map(DatosListadoTopicos::new));

    }

    @PutMapping
    @Transactional
    public ResponseEntity actualizarTopico(@RequestBody @Valid DatosActualizarTopico datosActualizarTopico){
    Topico topico=topicoRepository.getReferenceById(datosActualizarTopico.idTopico());
     topico.actualizarTopicos(datosActualizarTopico);
     return  ResponseEntity.ok(new DatosRespuestaTopico(topico.getIdTopico(),
             topico.getMensaje(), topico.getNombreCurso(), topico.getTitulo()));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarTopico(@PathVariable Long id){
        Topico topico=topicoRepository.getReferenceById(id);
        topico.desactivarTopico();
        return ResponseEntity.noContent().build();
    }

    @GetMapping ("/{id}")
    public ResponseEntity<DatosRespuestaTopico> retornaDatosTopico(@PathVariable Long id){
        Topico topico=topicoRepository.getReferenceById(id);
        var datosTopico= new DatosRespuestaTopico(topico.getIdTopico(),
                topico.getMensaje(), topico.getNombreCurso(), topico.getTitulo());
        return ResponseEntity.ok(datosTopico);
    }

}
