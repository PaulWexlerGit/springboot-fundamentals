package com.example.pablomesaspringbootfundamentals.modules.playlist.controller;

import com.example.pablomesaspringbootfundamentals.exception.ResourceNotFoundException;
import com.example.pablomesaspringbootfundamentals.modules.playlist.dto.PlaylistInputDTO;
import com.example.pablomesaspringbootfundamentals.modules.playlist.dto.PlaylistOutputDTO;
import com.example.pablomesaspringbootfundamentals.modules.playlist.service.PlaylistService;
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

    @PostMapping
    public ResponseEntity<PlaylistOutputDTO> createPlaylist(@Valid @RequestBody PlaylistInputDTO playlistInputDTO) {
        return new ResponseEntity<>(playlistService.createPlaylist(playlistInputDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<PlaylistOutputDTO>> getAllPlaylists() {
        return ResponseEntity.ok(playlistService.getAllPlaylists());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlaylistOutputDTO> getPlaylistById(@PathVariable Long id) {
        return ResponseEntity.ok(playlistService.getPlaylistById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Playlist not found with id " + id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PlaylistOutputDTO> updatePlaylist(@PathVariable Long id, @Valid @RequestBody PlaylistInputDTO playlistInputDTO) {
        return ResponseEntity.ok(playlistService.updatePlaylist(id, playlistInputDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlaylist(@PathVariable Long id) {
        playlistService.deletePlaylist(id);
        return ResponseEntity.noContent().build();
    }
}