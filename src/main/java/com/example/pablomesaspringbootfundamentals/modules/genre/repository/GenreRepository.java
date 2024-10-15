package com.example.pablomesaspringbootfundamentals.modules.genre.repository;

import com.example.pablomesaspringbootfundamentals.modules.genre.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Long> {
}