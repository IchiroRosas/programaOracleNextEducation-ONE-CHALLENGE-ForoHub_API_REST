package com.example.ProgramaONE_Challenge_ForoHub.domain.topico;

import java.time.LocalDateTime;

public record DatosListadoTopico(
        Long id,
        String titulo,
        String mensaje,
        LocalDateTime fecha_creacion,
        String estado,
        Long autor_id,
        String curso
) {


    public DatosListadoTopico(Topico t) {
        this(
                t.getId(),
                t.getTitulo(),
                t.getMensaje(),
                t.getFechaCreacion(),
                t.getEstado(),
                t.getAutor_id(),
                t.getCurso()
        );
    }
}
