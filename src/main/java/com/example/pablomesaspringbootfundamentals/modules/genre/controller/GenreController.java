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

    /**
     * Creates a new genre.
     *
     * @param genreInputDTO the genre input data transfer object containing the details of the genre to be created
     * @return a ResponseEntity containing the created genre output data transfer object and the HTTP status code CREATED
     */
    @PostMapping
    public ResponseEntity<GenreOutputDTO> createGenre(@Valid @RequestBody GenreInputDTO genreInputDTO) {
        return new ResponseEntity<>(genreService.createGenre(genreInputDTO), HttpStatus.CREATED);
    }

    /**
     * Retrieves all genres.
     *
     * @return a ResponseEntity containing a list of all genre output data transfer objects and the HTTP status code OK
     */
    @GetMapping
    public ResponseEntity<List<GenreOutputDTO>> getAllGenres() {
        return ResponseEntity.ok(genreService.getAllGenres());
    }

    /**
     * Retrieves a genre by its ID.
     *
     * @param id the ID of the genre to be retrieved
     * @return a ResponseEntity containing the genre output data transfer object and the HTTP status code OK
     * @throws ResourceNotFoundException if the genre with the specified ID is not found
     */
    @GetMapping("/{id}")
    public ResponseEntity<GenreOutputDTO> getGenreById(@PathVariable Long id) {
        return ResponseEntity.ok(genreService.getGenreById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Genre not found with id " + id)));
    }

    /**
     * Updates an existing genre.
     *
     * @param id the ID of the genre to be updated
     * @param genreInputDTO the genre input data transfer object containing the updated details of the genre
     * @return a ResponseEntity containing the updated genre output data transfer object and the HTTP status code OK
     */
    @PutMapping("/{id}")
    public ResponseEntity<GenreOutputDTO> updateGenre(@PathVariable Long id, @Valid @RequestBody GenreInputDTO genreInputDTO) {
        return ResponseEntity.ok(genreService.updateGenre(id, genreInputDTO));
    }

    /**
     * Deletes a genre by its ID.
     *
     * @param id the ID of the genre to be deleted
     * @return a ResponseEntity with no content and the HTTP status code NO_CONTENT
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGenre(@PathVariable Long id) {
        genreService.deleteGenre(id);
        return ResponseEntity.noContent().build();
    }
}