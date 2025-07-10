package com.example.ProgramaONE_Challenge_ForoHub.domain.topico;

import java.time.LocalDateTime;

public record DetallesRegistroTopico(
        Long id,
        String titulo,
        String mensaje,
        Long autor_id,
        String curso,
        LocalDateTime fechaCreacion,
        String estado
) {

    public DetallesRegistroTopico(Topico t) {
        this(
                t.getId(),
                t.getTitulo(),
                t.getMensaje(),
                t.getAutor_id(),
                t.getCurso(),
                t.getFechaCreacion(),
                t.getEstado()
        );
    }
}
