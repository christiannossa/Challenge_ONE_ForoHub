package com.forohubchallenge.forohub.domain.topico;

import com.forohubchallenge.forohub.domain.curso.DatosCurso;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DatosRegistroTopico(

        @NotBlank
        String titulo,
        @NotBlank
        String mensaje,
        LocalDateTime fechaDeCreacion,
        Status status,
        @NotBlank
        String autor,
        @NotNull
        DatosCurso curso

) {
}
