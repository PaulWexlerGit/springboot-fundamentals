package com.example.pablomesaspringbootfundamentals.modules.song.controller;

import com.example.pablomesaspringbootfundamentals.exception.ResourceNotFoundException;
import com.example.pablomesaspringbootfundamentals.modules.song.dto.SongInputDTO;
import com.example.pablomesaspringbootfundamentals.modules.song.dto.SongOutputDTO;
import com.example.pablomesaspringbootfundamentals.modules.song.service.SongService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${api.prefix}/songs")
@RequiredArgsConstructor
public class SongController {

    private final SongService songService;

    /**
     * Creates a new song.
     *
     * @param songInputDTO the song input data transfer object containing the details of the song to be created
     * @return a ResponseEntity containing the created song output data transfer object and the HTTP status code CREATED
     */
    @Operation(summary = "Creates a new song", description = "Creates a new song with the provided details.")
    @PostMapping
    public ResponseEntity<SongOutputDTO> createSong(@Valid @RequestBody SongInputDTO songInputDTO) {
        return new ResponseEntity<>(songService.createSong(songInputDTO), HttpStatus.CREATED);
    }

    /**
     * Retrieves all songs.
     *
     * @return a ResponseEntity containing a list of all song output data transfer objects and the HTTP status code OK
     */
    @Operation(summary = "Retrieves all songs", description = "Retrieves a list of all songs.")
    @GetMapping
    public ResponseEntity<List<SongOutputDTO>> getAllSongs() {
        return ResponseEntity.ok(songService.getAllSongs());
    }

    /**
     * Retrieves a song by its ID.
     *
     * @param id the ID of the song to be retrieved
     * @return a ResponseEntity containing the song output data transfer object and the HTTP status code OK
     * @throws ResourceNotFoundException if the song with the specified ID is not found
     */
    @Operation(summary = "Retrieves a song by its ID", description = "Retrieves a song by its ID.")
    @GetMapping("/{id}")
    public ResponseEntity<SongOutputDTO> getSongById(@PathVariable Long id) {
        return ResponseEntity.ok(songService.getSongById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Song not found with id " + id)));
    }

    /**
     * Updates an existing song.
     *
     * @param id the ID of the song to be updated
     * @param songInputDTO the song input data transfer object containing the updated details of the song
     * @return a ResponseEntity containing the updated song output data transfer object and the HTTP status code OK
     */
    @Operation(summary = "Updates an existing song", description = "Updates an existing song with the provided details.")
    @PutMapping("/{id}")
    public ResponseEntity<SongOutputDTO> updateSong(@PathVariable Long id, @Valid @RequestBody SongInputDTO songInputDTO) {
        return ResponseEntity.ok(songService.updateSong(id, songInputDTO));
    }

    /**
     * Deletes a song by its ID.
     *
     * @param id the ID of the song to be deleted
     * @return a ResponseEntity with no content and the HTTP status code NO_CONTENT
     */
    @Operation(summary = "Deletes a song by its ID", description = "Deletes a song by its ID.")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSong(@PathVariable Long id) {
        songService.deleteSong(id);
        return ResponseEntity.noContent().build();
    }
}