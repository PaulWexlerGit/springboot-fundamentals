package com.example.pablomesaspringbootfundamentals.modules.playlist.controller;

import com.example.pablomesaspringbootfundamentals.exception.ResourceNotFoundException;
import com.example.pablomesaspringbootfundamentals.modules.playlist.dto.PlaylistInputDTO;
import com.example.pablomesaspringbootfundamentals.modules.playlist.dto.PlaylistOutputDTO;
import com.example.pablomesaspringbootfundamentals.modules.playlist.service.PlaylistService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${api.prefix}/playlists")
@RequiredArgsConstructor
public class PlaylistController {

    private final PlaylistService playlistService;

    /**
     * Creates a new playlist.
     *
     * @param playlistInputDTO the playlist input data transfer object containing the details of the playlist to be created
     * @return a ResponseEntity containing the created playlist output data transfer object and the HTTP status code CREATED
     */
    @Operation(summary = "Creates a new playlist", description = "Creates a new playlist with the provided details.")
    @PostMapping
    public ResponseEntity<PlaylistOutputDTO> createPlaylist(@Valid @RequestBody PlaylistInputDTO playlistInputDTO) {
        return new ResponseEntity<>(playlistService.createPlaylist(playlistInputDTO), HttpStatus.CREATED);
    }

    /**
     * Retrieves all playlists.
     *
     * @return a ResponseEntity containing a list of all playlist output data transfer objects and the HTTP status code OK
     */
    @Operation(summary = "Retrieves all playlists", description = "Retrieves a list of all playlists.")
    @GetMapping
    public ResponseEntity<List<PlaylistOutputDTO>> getAllPlaylists() {
        return ResponseEntity.ok(playlistService.getAllPlaylists());
    }

    /**
     * Retrieves a playlist by its ID.
     *
     * @param id the ID of the playlist to be retrieved
     * @return a ResponseEntity containing the playlist output data transfer object and the HTTP status code OK
     * @throws ResourceNotFoundException if the playlist with the specified ID is not found
     */
    @Operation(summary = "Retrieves a playlist by its ID", description = "Retrieves a playlist by its ID.")
    @GetMapping("/{id}")
    public ResponseEntity<PlaylistOutputDTO> getPlaylistById(@PathVariable Long id) {
        return ResponseEntity.ok(playlistService.getPlaylistById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Playlist not found with id " + id)));
    }

    /**
     * Updates an existing playlist.
     *
     * @param id the ID of the playlist to be updated
     * @param playlistInputDTO the playlist input data transfer object containing the updated details of the playlist
     * @return a ResponseEntity containing the updated playlist output data transfer object and the HTTP status code OK
     */
    @Operation(summary = "Updates an existing playlist", description = "Updates an existing playlist with the provided details.")
    @PutMapping("/{id}")
    public ResponseEntity<PlaylistOutputDTO> updatePlaylist(@PathVariable Long id, @Valid @RequestBody PlaylistInputDTO playlistInputDTO) {
        return ResponseEntity.ok(playlistService.updatePlaylist(id, playlistInputDTO));
    }

    /**
     * Deletes a playlist by its ID.
     *
     * @param id the ID of the playlist to be deleted
     * @return a ResponseEntity with no content and the HTTP status code NO_CONTENT
     */
    @Operation(summary = "Deletes a playlist by its ID", description = "Deletes a playlist by its ID.")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlaylist(@PathVariable Long id) {
        playlistService.deletePlaylist(id);
        return ResponseEntity.noContent().build();
    }
}