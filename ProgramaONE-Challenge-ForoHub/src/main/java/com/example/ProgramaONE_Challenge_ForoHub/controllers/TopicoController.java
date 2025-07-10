package com.example.ProgramaONE_Challenge_ForoHub.controllers;

import com.example.ProgramaONE_Challenge_ForoHub.domain.shared.ApiResponse;
import com.example.ProgramaONE_Challenge_ForoHub.domain.topico.*;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@SecurityRequirement(name = "bearer-key")
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    TopicoRepository topicoRepository;
    @Autowired
    TopicoService topicoService;

    @PostMapping
    @Transactional
    public ResponseEntity<ApiResponse<DetallesRegistroTopico>> registrar(@RequestBody @Valid DatosRegistroTopico datos){
        DetallesRegistroTopico detallesRegistroTopico = topicoService.registrar(datos);
        return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.success("Registro exitoso.",detallesRegistroTopico));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<DatosListadoTopico>>> listar(){
        var listado = topicoRepository.findAll().stream().map(t -> new DatosListadoTopico(t)).toList();
        return ResponseEntity.ok(ApiResponse.success("Consulta exitosa.",listado));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<DatosListadoTopico>> detallar(@PathVariable Long id) {
        var detalle = topicoService.detallar(id);
        return ResponseEntity.ok(ApiResponse.success("Consulta exitosa",detalle));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<ApiResponse<DetallesRegistroTopico>> actualizar (@PathVariable Long id, @RequestBody @Valid DatosActualizarTopico datos){
        var info = topicoService.actualizar(id, datos);
        return ResponseEntity.ok(ApiResponse.success("Actualización exitosa.",info));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> eliminar (@PathVariable Long id){
        topicoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }

}
