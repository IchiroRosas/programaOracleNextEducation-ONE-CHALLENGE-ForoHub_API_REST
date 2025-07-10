package com.example.ProgramaONE_Challenge_ForoHub.domain.topico;

import com.example.ProgramaONE_Challenge_ForoHub.infra.errores.ValidacionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicoService {

    @Autowired
    private TopicoRepository topicoRepository;

    public DetallesRegistroTopico registrar(DatosRegistroTopico datos){
        boolean duplicado = topicoRepository.existsByTituloAndMensaje(datos.titulo(), datos.mensaje());
        if (duplicado){
            throw new ValidacionException("Ya existe un tópico con el mismo título y mensaje.");
        }
        return new DetallesRegistroTopico(topicoRepository.save(new Topico(datos)));
    }

    public DatosListadoTopico detallar(Long id){
        var topico = topicoRepository.findById(id)
                .orElseThrow(() -> new ValidacionException("No se encontró tópico con ID: " + id));
        return new DatosListadoTopico(topico);
    }

    public DetallesRegistroTopico actualizar(Long id, DatosActualizarTopico datosActualizarTopico) {
        var topico = topicoRepository.findById(id)
                .orElseThrow(() -> new ValidacionException("No se encontró tópico con ID: " + id));
        boolean duplicado = topicoRepository.existsByTituloAndMensajeAndIdNot(datosActualizarTopico.titulo(), datosActualizarTopico.mensaje(), id);
        if (duplicado){
            throw new ValidacionException("Ya existe un tópico con el mismo título y mensaje.");
        }

        topico.setTitulo(datosActualizarTopico.titulo());
        topico.setMensaje(datosActualizarTopico.mensaje());
        topico.setCurso(datosActualizarTopico.curso());

        topicoRepository.save(topico);

        return new DetallesRegistroTopico(topico);
    }

    public void eliminar(Long id) {
        topicoRepository.findById(id)
                .orElseThrow(() -> new ValidacionException("No se encontró tópico con ID: " + id));
        topicoRepository.deleteById(id);
    }
}
