package com.alura.desafio.literalura.repository;

import com.alura.desafio.literalura.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {

        //@Query("SELECT b FROM Book b WHERE :idioma MEMBER OF ELEMENTS(b.idioma_s)")
        //Optional<List<Book>> findByLanguage(@Param("idioma") String idioma);



}
