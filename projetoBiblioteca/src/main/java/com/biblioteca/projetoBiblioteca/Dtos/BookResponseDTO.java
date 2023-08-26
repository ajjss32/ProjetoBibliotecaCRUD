package com.biblioteca.projetoBiblioteca.Dtos;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.UUID;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookResponseDTO{
    private UUID id;
    private String bookName;
    private String bookAuthor;
    private String bookCode;
    private String  releaseDate;

}

