package com.forohubchallenge.forohub.controller;

import com.forohubchallenge.forohub.domain.curso.DatosCurso;
import com.forohubchallenge.forohub.domain.topico.*;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
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
@SecurityRequirement(name = "bearer-key")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;


    @PostMapping
    public ResponseEntity<DatosRespuestaTopico> registrarTopico(@RequestBody @Valid DatosRegistroTopico datosRegistroTopico, UriComponentsBuilder uriComponentsBuilder) {

        Topico nuevoTopico = new Topico(datosRegistroTopico);

        nuevoTopico.setStatus(Status.CREATED);

        Topico topico = topicoRepository.save(nuevoTopico);

        DatosRespuestaTopico datosRespuestaTopico = new DatosRespuestaTopico(

                topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFechaDeCreacion(),
                topico.getAutor(),

                new DatosCurso(

                        topico.getCurso().getNombreCurso(),
                        topico.getCurso().getCategoriaCurso()

                )

        );

        //URI url = "http://localhost:8080/topicos/" + topico.getId();
        URI url = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();

        return ResponseEntity.created(url).body(datosRespuestaTopico);

    }

    @GetMapping
    public ResponseEntity<Page<DatosListadoTopico>> listadoTopicos(@PageableDefault(size = 5) Pageable paginacion) {

        return ResponseEntity.ok(topicoRepository.findByActivoTrue(paginacion)
                .map(DatosListadoTopico::new));

    }

    @PutMapping
    @Transactional
    public ResponseEntity actualizarTopico(@RequestBody @Valid DatosActualizarTopico datosActualizarTopico) { //@RequestBody @Valid para que no de parametros nulos


        Topico topicoActualizado = topicoRepository.getReferenceById(datosActualizarTopico.id());

        topicoActualizado.setStatus(Status.UPDATED);

        topicoActualizado.actualizarDatos(datosActualizarTopico);

        return ResponseEntity.ok(new DatosRespuestaTopico(

                topicoActualizado.getId(),
                topicoActualizado.getTitulo(),
                topicoActualizado.getMensaje(),
                topicoActualizado.getFechaDeCreacion(),
                topicoActualizado.getAutor(),

                new DatosCurso(

                        topicoActualizado.getCurso().getNombreCurso(),
                        topicoActualizado.getCurso().getCategoriaCurso()

                )

        ));

    }

    //DELETE LÓGICO
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarTopico(@PathVariable/*Que la variable viene del path*/ Long id) {

        Topico topicoEliminado = topicoRepository.getReferenceById(id);

        topicoEliminado.setStatus(Status.DELETED);

        topicoEliminado.desactivarTopico();

        return ResponseEntity.noContent().build();

    }

    //DELETE EN BASE DE DATOS
    /*
    public void eliminarTopico(@PathVariable/*Que la variable viene del path Long id) {

        Topico topicoEliminadoDB = topicoRepository.getReferenceById(id);

        topicoRepository.delete(topicoEliminadoDB);

    }
    */

    @GetMapping("/{id}")
    public ResponseEntity<DatosRespuestaTopico> retornarDatosTopico(@PathVariable/*Que la variable viene del path*/ Long id) {

        Topico topico = topicoRepository.getReferenceById(id);
        var datosTopico = new DatosRespuestaTopico(

                topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFechaDeCreacion(),
                topico.getAutor(),

                new DatosCurso(

                        topico.getCurso().getNombreCurso(),
                        topico.getCurso().getCategoriaCurso()

                )

        );

        return ResponseEntity.ok(datosTopico);

    }

}
