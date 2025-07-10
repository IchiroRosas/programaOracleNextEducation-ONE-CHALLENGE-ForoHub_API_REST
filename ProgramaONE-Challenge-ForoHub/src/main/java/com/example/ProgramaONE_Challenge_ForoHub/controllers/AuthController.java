package com.example.ProgramaONE_Challenge_ForoHub.controllers;

import com.example.ProgramaONE_Challenge_ForoHub.domain.shared.ApiResponse;
import com.example.ProgramaONE_Challenge_ForoHub.domain.usuario.DatosAutenticacion;
import com.example.ProgramaONE_Challenge_ForoHub.domain.usuario.Usuario;
import com.example.ProgramaONE_Challenge_ForoHub.infra.security.DatosJWT;
import com.example.ProgramaONE_Challenge_ForoHub.infra.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AuthController {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private AuthenticationManager manager;

    @PostMapping
    public ResponseEntity<?> iniciarSesion(@RequestBody @Valid DatosAutenticacion datos) {
        var authenticationToken = new UsernamePasswordAuthenticationToken(datos.email(), datos.contrasenia());
        var authentication = manager.authenticate(authenticationToken);

        var tokenJWT = tokenService.generarToken((Usuario) authentication.getPrincipal());

        return ResponseEntity.ok(ApiResponse.success("Login exitoso.",new DatosJWT(tokenJWT)));
    }

}
