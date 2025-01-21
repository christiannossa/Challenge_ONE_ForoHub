package com.forohubchallenge.forohub.domain.topico;

import com.forohubchallenge.forohub.domain.curso.DatosCurso;

import java.time.LocalDateTime;

public record DatosRespuestaTopico(

        Long id,
        String titulo,
        String mensaje,
        LocalDateTime fechaDeCreacion,
        String autor,
        DatosCurso curso

) {
}
