package com.biblioteca.projetoBiblioteca.repositories;

import com.biblioteca.projetoBiblioteca.models.BookModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface BookRepository extends JpaRepository<BookModel, UUID> {
}
