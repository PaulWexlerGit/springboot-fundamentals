package com.example.pablomesaspringbootfundamentals.modules.album.controller;

import com.example.pablomesaspringbootfundamentals.exception.ResourceNotFoundException;
import com.example.pablomesaspringbootfundamentals.modules.album.dto.AlbumInputDTO;
import com.example.pablomesaspringbootfundamentals.modules.album.dto.AlbumOutputDTO;
import com.example.pablomesaspringbootfundamentals.modules.album.service.AlbumService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${api.prefix}/albums")
@RequiredArgsConstructor
public class AlbumController {

    private final AlbumService albumService;

    /**
     * Creates a new album.
     *
     * @param albumInputDTO the album input data transfer object containing the details of the album to be created
     * @return a ResponseEntity containing the created album output data transfer object and the HTTP status code CREATED
     */
    @Operation(summary = "Creates a new album", description = "Creates a new album with the provided details.")
    @PostMapping
    public ResponseEntity<AlbumOutputDTO> createAlbum(@Valid @RequestBody AlbumInputDTO albumInputDTO) {
        return new ResponseEntity<>(albumService.createAlbum(albumInputDTO), HttpStatus.CREATED);
    }

    /**
     * Retrieves all albums.
     *
     * @return a ResponseEntity containing a list of all album output data transfer objects and the HTTP status code OK
     */
    @Operation(summary = "Retrieves all albums", description = "Retrieves a list of all albums.")
    @GetMapping
    public ResponseEntity<List<AlbumOutputDTO>> getAllAlbums() {
        return ResponseEntity.ok(albumService.getAllAlbums());
    }

    /**
     * Retrieves an album by its ID.
     *
     * @param id the ID of the album to be retrieved
     * @return a ResponseEntity containing the album output data transfer object and the HTTP status code OK
     * @throws ResourceNotFoundException if the album with the specified ID is not found
     */
    @Operation(summary = "Retrieves an album by its ID", description = "Retrieves an album by its ID.")
    @GetMapping("/{id}")
    public ResponseEntity<AlbumOutputDTO> getAlbumById(@PathVariable Long id) {
        return ResponseEntity.ok(albumService.getAlbumById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Album not found with id " + id)));
    }

    /**
     * Updates an existing album.
     *
     * @param id            the ID of the album to be updated
     * @param albumInputDTO the album input data transfer object containing the updated details of the album
     * @return a ResponseEntity containing the updated album output data transfer object and the HTTP status code OK
     */
    @Operation(summary = "Updates an existing album", description = "Updates an existing album with the provided details.")
    @PutMapping("/{id}")
    public ResponseEntity<AlbumOutputDTO> updateAlbum(@PathVariable Long id, @Valid @RequestBody AlbumInputDTO albumInputDTO) {
        return ResponseEntity.ok(albumService.updateAlbum(id, albumInputDTO));
    }

    /**
     * Deletes an album by its ID.
     *
     * @param id the ID of the album to be deleted
     * @return a ResponseEntity with no content and the HTTP status code NO_CONTENT
     */
    @Operation(summary = "Deletes an album by its ID", description = "Deletes an album by its ID.")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAlbum(@PathVariable Long id) {
        albumService.deleteAlbum(id);
        return ResponseEntity.noContent().build();
    }
}