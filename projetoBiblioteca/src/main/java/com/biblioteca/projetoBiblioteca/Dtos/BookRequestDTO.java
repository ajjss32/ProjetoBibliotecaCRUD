package com.biblioteca.projetoBiblioteca.Dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookRequestDTO{
    private String bookName;
    private String bookAuthor;
    private String bookCode;
    private String releaseDate;

}