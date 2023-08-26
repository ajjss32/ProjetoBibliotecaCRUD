package com.biblioteca.projetoBiblioteca.services;

import com.biblioteca.projetoBiblioteca.Dtos.BookRequestDTO;
import com.biblioteca.projetoBiblioteca.Dtos.BookResponseDTO;
import com.biblioteca.projetoBiblioteca.models.BookModel;
import com.biblioteca.projetoBiblioteca.repositories.BookRepository;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private ModelMapper modelMapper;

    public BookResponseDTO createBook(BookRequestDTO bookDTO){
        BookModel bookModel = new BookModel();
        modelMapper.map(bookDTO,bookModel);
        bookRepository.save(bookModel);
        return modelMapper.map(bookModel,BookResponseDTO.class);
    }
    public List<BookResponseDTO> getAllBooks(){
        return bookRepository.findAll().stream()
                .map(bookModel -> modelMapper.map(bookModel,BookResponseDTO.class)).toList();
    }
    public BookResponseDTO finBookById(UUID id){
        Optional<BookModel> bookModel = bookRepository.findById(id);
        if (bookModel.isPresent()) return modelMapper.map(bookModel,BookResponseDTO.class);
        else throw new EntityNotFoundException();
    }
    public void updateBook(BookResponseDTO bookDTO){
        BookModel book = modelMapper.map(bookDTO,BookModel.class);
        Optional<BookModel> bookModel = bookRepository.findById(bookDTO.getId());
        if (bookModel.isPresent()) {
            bookModel.get().setBookName(book.getBookName());
            bookModel.get().setBookAuthor(book.getBookAuthor());
            bookModel.get().setBookCode(book.getBookCode());
            bookModel.get().setReleaseDate(book.getReleaseDate());
            bookRepository.save(bookModel.get());
        }
        else throw new EntityNotFoundException();

    }
    public void deleteBook(UUID id){
        Optional<BookModel> bookModel = bookRepository.findById(id);
        if (bookModel.isPresent()) bookRepository.delete(bookModel.get());
        else throw new EntityNotFoundException();
    }
}
