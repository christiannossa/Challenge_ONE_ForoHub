package com.forohubchallenge.forohub.domain.topico;

import com.forohubchallenge.forohub.domain.curso.Categoria;

import java.time.LocalDateTime;

public record DatosListadoTopico(

        Long id,
        String titulo,
        String mensaje,
        LocalDateTime fechaDeCreacion,
        String autor,
        String nombreCurso,
        Categoria categoriaCurso

) {

    public DatosListadoTopico(Topico topico) {

        this(

             topico.getId(),
             topico.getTitulo(),
             topico.getMensaje(),
             topico.getFechaDeCreacion(),
             topico.getAutor(),
             topico.getCurso().getNombreCurso(),
             topico.getCurso().getCategoriaCurso()

        );

    }

}


