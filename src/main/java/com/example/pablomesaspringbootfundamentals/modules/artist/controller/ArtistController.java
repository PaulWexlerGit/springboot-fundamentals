package com.example.pablomesaspringbootfundamentals.modules.artist.controller;

import com.example.pablomesaspringbootfundamentals.exception.ResourceNotFoundException;
import com.example.pablomesaspringbootfundamentals.modules.artist.dto.ArtistInputDTO;
import com.example.pablomesaspringbootfundamentals.modules.artist.dto.ArtistOutputDTO;
import com.example.pablomesaspringbootfundamentals.modules.artist.service.ArtistService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${api.prefix}/artists")
@RequiredArgsConstructor
public class ArtistController {

    private final ArtistService artistService;

    /**
     * Creates a new artist.
     *
     * @param artistInputDTO the artist input data transfer object containing the details of the artist to be created
     * @return a ResponseEntity containing the created artist output data transfer object and the HTTP status code CREATED
     */
    @Operation(summary = "Creates a new artist", description = "Creates a new artist with the provided details.")
    @PostMapping
    public ResponseEntity<ArtistOutputDTO> createArtist(@Valid @RequestBody ArtistInputDTO artistInputDTO) {
        return new ResponseEntity<>(artistService.createArtist(artistInputDTO), HttpStatus.CREATED);
    }

    /**
     * Retrieves all artists.
     *
     * @return a ResponseEntity containing a list of all artist output data transfer objects and the HTTP status code OK
     */
    @Operation(summary = "Retrieves all artists", description = "Retrieves a list of all artists.")
    @GetMapping
    public ResponseEntity<List<ArtistOutputDTO>> getAllArtists() {
        return ResponseEntity.ok(artistService.getAllArtists());
    }

    /**
     * Retrieves an artist by its ID.
     *
     * @param id the ID of the artist to be retrieved
     * @return a ResponseEntity containing the artist output data transfer object and the HTTP status code OK
     * @throws ResourceNotFoundException if the artist with the specified ID is not found
     */
    @Operation(summary = "Retrieves an artist by its ID", description = "Retrieves an artist by its ID.")
    @GetMapping("/{id}")
    public ResponseEntity<ArtistOutputDTO> getArtistById(@PathVariable Long id) {
        return ResponseEntity.ok(artistService.getArtistById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Artist not found with id " + id)));
    }

    /**
     * Updates an existing artist.
     *
     * @param id             the ID of the artist to be updated
     * @param artistInputDTO the artist input data transfer object containing the updated details of the artist
     * @return a ResponseEntity containing the updated artist output data transfer object and the HTTP status code OK
     */
    @Operation(summary = "Updates an existing artist", description = "Updates an existing artist with the provided details.")
    @PutMapping("/{id}")
    public ResponseEntity<ArtistOutputDTO> updateArtist(@PathVariable Long id, @Valid @RequestBody ArtistInputDTO artistInputDTO) {
        return ResponseEntity.ok(artistService.updateArtist(id, artistInputDTO));
    }

    /**
     * Deletes an artist by its ID.
     *
     * @param id the ID of the artist to be deleted
     * @return a ResponseEntity with no content and the HTTP status code NO_CONTENT
     */
    @Operation(summary = "Deletes an artist by its ID", description = "Deletes an artist by its ID.")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteArtist(@PathVariable Long id) {
        artistService.deleteArtist(id);
        return ResponseEntity.noContent().build();
    }
}