package com.alura.desafio.literalura.repository;

import com.alura.desafio.literalura.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author,Long> {
    @Query("SELECT a FROM Author a WHERE a.fechaDeNacimiento <= :anio AND a.fechaDeFallecimiento>= :anio")
    Optional<List<Author>> findByYearAlive(@Param("anio") LocalDate anio);
}
