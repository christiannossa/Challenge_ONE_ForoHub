package com.forohubchallenge.forohub.domain.topico;

import com.forohubchallenge.forohub.domain.curso.Curso;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Table(name = "topicos")
@Entity(name = "Topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;
    @Setter
    private LocalDateTime fechaDeCreacion;
    @Setter
    @Enumerated(EnumType.STRING)
    private Status status;
    private String autor;
    private Boolean activo;
    @Embedded
    private Curso curso;


    public Topico(DatosRegistroTopico datosRegistroTopico) {

        this.activo = true;
        this.titulo = datosRegistroTopico.titulo();
        this.mensaje = datosRegistroTopico.mensaje();
        this.fechaDeCreacion = LocalDateTime.now();
        this.autor = datosRegistroTopico.autor();
        this.curso = new Curso(datosRegistroTopico.curso());

    }

    public void actualizarDatos(DatosActualizarTopico datosActualizarTopico) {

        if (datosActualizarTopico.titulo() != null) {

            this.titulo = datosActualizarTopico.titulo();

        }

        if (datosActualizarTopico.mensaje() != null) {

            this.mensaje = datosActualizarTopico.mensaje();

        }

    }

    public void desactivarTopico() {

        this.activo = false;

    }

}
