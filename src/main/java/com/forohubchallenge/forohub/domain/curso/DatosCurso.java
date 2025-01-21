package com.forohubchallenge.forohub.domain.curso;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosCurso(

        @NotBlank
        String nombreCurso,
        @NotNull
        Categoria categoriaCurso

) {
}
