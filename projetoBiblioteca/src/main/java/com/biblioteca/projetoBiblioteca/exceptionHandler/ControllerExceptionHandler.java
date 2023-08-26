package com.biblioteca.projetoBiblioteca.exceptionHandler;

import com.biblioteca.projetoBiblioteca.Dtos.ExceptionResponseDTO;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.DateTimeException;
import java.util.Date;

@RestControllerAdvice
public class ControllerExceptionHandler {
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity handlingOfDuplicateValues(DataIntegrityViolationException exception){
        ExceptionResponseDTO exceptionResponse = new ExceptionResponseDTO(new Date(),"Código do livro já cadastrado");
        return ResponseEntity.badRequest().body(exceptionResponse);
    }
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity handlingOf404(EntityNotFoundException exception){
        return ResponseEntity.notFound().build();
    }
     @ExceptionHandler(DateTimeException.class)
    public ResponseEntity handlingOfIncorrectDates(DateTimeException exception){
         ExceptionResponseDTO exceptionResponse = new ExceptionResponseDTO(new Date(),"Formato de data inválida");
         return ResponseEntity.badRequest().body(exceptionResponse);
     }

}
