package com.example.ProgramaONE_Challenge_ForoHub.domain.topico;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity(name="Topico")
@Table(name="topicos")
@Getter
@AllArgsConstructor
@EqualsAndHashCode(of="id")
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100, unique = true)
    private String titulo;

    @Column(nullable = false, length = 500)
    private String mensaje;

    @Column(name = "fecha_creacion", nullable = false)
    private LocalDateTime fechaCreacion;

    @Column(nullable = false, length = 20)
    private String estado;

    @Column(nullable = false, length = 80)
    private Long autor_id;

    @Column(nullable = false, length = 200)
    private String curso;

    public Topico(){}

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public String getEstado() {
        return estado;
    }

    public Long getAutor_id() {
        return autor_id;
    }

    public String getCurso() {
        return curso;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setAutor_id(Long autor_id) {
        this.autor_id = autor_id;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public Topico(DatosRegistroTopico datos) {
        this.titulo=datos.titulo();
        this.mensaje=datos.mensaje();
        this.fechaCreacion = LocalDateTime.now();
        this.estado = "ACTIVO";
        this.autor_id =datos.autor_id();
        this.curso=datos.curso();
    }
}
