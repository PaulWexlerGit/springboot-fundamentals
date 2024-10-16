package com.example.pablomesaspringbootfundamentals.modules.album.controller;

import com.example.pablomesaspringbootfundamentals.exception.ResourceNotFoundException;
import com.example.pablomesaspringbootfundamentals.modules.album.dto.AlbumInputDTO;
import com.example.pablomesaspringbootfundamentals.modules.album.dto.AlbumOutputDTO;
import com.example.pablomesaspringbootfundamentals.modules.album.service.AlbumService;
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

    @PostMapping
    public ResponseEntity<AlbumOutputDTO> createAlbum(@Valid @RequestBody AlbumInputDTO albumInputDTO) {
        return new ResponseEntity<>(albumService.createAlbum(albumInputDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<AlbumOutputDTO>> getAllAlbums() {
        return ResponseEntity.ok(albumService.getAllAlbums());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlbumOutputDTO> getAlbumById(@PathVariable Long id) {
        return ResponseEntity.ok(albumService.getAlbumById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Album not found with id " + id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AlbumOutputDTO> updateAlbum(@PathVariable Long id, @Valid @RequestBody AlbumInputDTO albumInputDTO) {
        return ResponseEntity.ok(albumService.updateAlbum(id, albumInputDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAlbum(@PathVariable Long id) {
        albumService.deleteAlbum(id);
        return ResponseEntity.noContent().build();
    }
}