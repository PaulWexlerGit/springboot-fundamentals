package com.example.pablomesaspringbootfundamentals.modules.genre.controller;

import com.example.pablomesaspringbootfundamentals.exception.ResourceNotFoundException;
import com.example.pablomesaspringbootfundamentals.modules.genre.dto.GenreInputDTO;
import com.example.pablomesaspringbootfundamentals.modules.genre.dto.GenreOutputDTO;
import com.example.pablomesaspringbootfundamentals.modules.genre.service.GenreService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${api.prefix}/genres")
@RequiredArgsConstructor
public class GenreController {

    private final GenreService genreService;

    @PostMapping
    public ResponseEntity<GenreOutputDTO> createGenre(@Valid @RequestBody GenreInputDTO genreInputDTO) {
        return new ResponseEntity<>(genreService.createGenre(genreInputDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<GenreOutputDTO>> getAllGenres() {
        return ResponseEntity.ok(genreService.getAllGenres());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GenreOutputDTO> getGenreById(@PathVariable Long id) {
        return ResponseEntity.ok(genreService.getGenreById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Genre not found with id " + id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<GenreOutputDTO> updateGenre(@PathVariable Long id, @Valid @RequestBody GenreInputDTO genreInputDTO) {
        return ResponseEntity.ok(genreService.updateGenre(id, genreInputDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGenre(@PathVariable Long id) {
        genreService.deleteGenre(id);
        return ResponseEntity.noContent().build();
    }
}