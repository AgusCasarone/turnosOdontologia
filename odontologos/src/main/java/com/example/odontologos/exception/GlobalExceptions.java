package com.example.odontologos.exception;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptions {

    private static final Logger LOGGER = LogManager.getLogger(GlobalExceptions.class);

    @ExceptionHandler({ResourceNotFoundException.class})
    public ResponseEntity<String> procesoExcepcionNotFound(ResourceNotFoundException e) {
        LOGGER.error("No se encontró el recurso al que se está queriendo acceder.");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

    @ExceptionHandler({MissingValuesException.class})
    public ResponseEntity<String> procesoExcepcionMissingValues(MissingValuesException e) {
        LOGGER.error("Faltan valores en el cuerpo de la request.");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

}
