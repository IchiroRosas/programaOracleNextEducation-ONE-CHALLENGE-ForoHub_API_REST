package com.example.ProgramaONE_Challenge_ForoHub.domain.usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record DatosAutenticacion(
        @NotBlank @Email String email,
        @NotBlank String contrasenia
) {
}
