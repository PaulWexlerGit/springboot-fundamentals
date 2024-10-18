package com.example.pablomesaspringbootfundamentals.modules.genre.service;

import com.example.pablomesaspringbootfundamentals.modules.genre.dto.GenreInputDTO;
import com.example.pablomesaspringbootfundamentals.modules.genre.dto.GenreOutputDTO;

import java.util.List;
import java.util.Optional;

public interface GenreService {
    GenreOutputDTO createGenre(GenreInputDTO genreInputDTO);

    List<GenreOutputDTO> getAllGenres();

    Optional<GenreOutputDTO> getGenreById(Long id);

    GenreOutputDTO updateGenre(Long id, GenreInputDTO genreInputDTO);

    void deleteGenre(Long id);
}