package com.alura.desafio.literalura.repository;

import com.alura.desafio.literalura.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Long> {
    @Query("SELECT a FROM Author a WHERE a.fechaDeNacimiento <= :anio AND a.fechaDeFallecimiento>= :anio")
    Optional<List<Author>> findByYearAlive(@Param("anio") Integer anio);

    Optional<Author> findByNombreContainsIgnoreCase(String nombre);
}
