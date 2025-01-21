package com.forohubchallenge.forohub.domain.curso;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Curso {

    private String nombreCurso;
    @Setter
    @Enumerated(EnumType.STRING)
    @Column(name = "categoriaCurso")
    private Categoria categoriaCurso;


    public Curso(DatosCurso curso) {

        this.nombreCurso = curso.nombreCurso();
        this.categoriaCurso = curso.categoriaCurso();

    }

    public Curso actualizarDatos(DatosCurso curso) {

        this.nombreCurso = curso.nombreCurso();
        this.categoriaCurso = curso.categoriaCurso();

        return this;

    }

}
