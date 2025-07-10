package com.example.ProgramaONE_Challenge_ForoHub.infra.errores;

import com.example.ProgramaONE_Challenge_ForoHub.domain.shared.ApiResponse;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class TratadorDeErrores {

    @ExceptionHandler(ValidacionException.class)
    public ResponseEntity<?> manejarValidacionException(ValidacionException e){
        return ResponseEntity.badRequest().body(ApiResponse.error(e.getMessage(),null));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> manejarErrorPeticionInfoInvalida(MethodArgumentNotValidException e) {
        var errores = e.getFieldErrors().stream()
                .map(error -> new DatosErrorValidacion(error))
                .toList();
        return ResponseEntity.badRequest().body(ApiResponse.error("Algo salió mal.",errores));
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<?> manejarErrorPeticionJsonMalformado(HttpMessageNotReadableException e) {
        return ResponseEntity.badRequest().body(ApiResponse.error("JSON malformado: verifica la sintaxis del cuerpo de la solicitud.",null));
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<?> manejarErrorCredencialesEquivodadas(BadCredentialsException e){
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(ApiResponse.error("Correo o contraseña incorrectos.",null));
    }

    /*NO LO NECESITO PORQUE YA MANEJO ERRORES DE ESE TIPO EN TOPICO.SERVICE MEDIANTE MI clase ValidacionExcepction
     PERO PODRÍA USARLO EN OTROS LADOS QUE DEN ESE ERROR DE EntityNotFoundException */
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<?> manejarError404(EntityNotFoundException e){
        return ResponseEntity.notFound().build();
    }

    private record DatosErrorValidacion(String campo, String error) {
        public DatosErrorValidacion(FieldError error) {
            this(error.getField(), error.getDefaultMessage());
        }
    }

}
