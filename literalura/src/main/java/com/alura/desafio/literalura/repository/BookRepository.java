package com.alura.desafio.literalura.repository;

import com.alura.desafio.literalura.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book,Long> {
        Optional<Book> findByTituloContainsIgnoreCase(String nombre);

}
