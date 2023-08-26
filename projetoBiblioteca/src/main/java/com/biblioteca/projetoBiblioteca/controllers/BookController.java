package com.biblioteca.projetoBiblioteca.controllers;

import com.biblioteca.projetoBiblioteca.Dtos.BookRequestDTO;
import com.biblioteca.projetoBiblioteca.Dtos.BookResponseDTO;
import com.biblioteca.projetoBiblioteca.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping
    public ResponseEntity<List<BookResponseDTO>> getAllBooks(){
        List<BookResponseDTO> allBooks= bookService.getAllBooks();
        return ResponseEntity.status(HttpStatus.OK).body(allBooks);
    }
    @GetMapping("/{id}")
    public ResponseEntity<BookResponseDTO> getOneProduct(@PathVariable(value = "id") UUID id){
        BookResponseDTO book= bookService.finBookById(id);
        return ResponseEntity.status(HttpStatus.OK).body(book);
    }

    @PostMapping
    public ResponseEntity<BookResponseDTO> saveBook(@RequestBody  BookRequestDTO bookRequestDTO){
        BookResponseDTO bookResponseDTO = bookService.createBook(bookRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(bookResponseDTO);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity deleteBook(@PathVariable(value = "id") UUID id){
        bookService.deleteBook(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    @PutMapping
    public ResponseEntity updateBook(@RequestBody  BookResponseDTO bookResponseDTO){
        bookService.updateBook(bookResponseDTO);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
