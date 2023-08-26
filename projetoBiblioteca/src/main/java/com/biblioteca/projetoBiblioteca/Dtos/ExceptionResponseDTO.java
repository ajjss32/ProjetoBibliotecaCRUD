package com.biblioteca.projetoBiblioteca.Dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;
import java.util.Date;
@Getter
@AllArgsConstructor
public class ExceptionResponseDTO implements Serializable {
    private static final long serialVersionUID =1L;

    private Date timestamp;
    private String message;

}
