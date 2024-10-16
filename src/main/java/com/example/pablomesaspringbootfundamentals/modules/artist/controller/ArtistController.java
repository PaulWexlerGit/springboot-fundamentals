package com.example.pablomesaspringbootfundamentals.modules.artist.controller;

import com.example.pablomesaspringbootfundamentals.exception.ResourceNotFoundException;
import com.example.pablomesaspringbootfundamentals.modules.artist.dto.ArtistInputDTO;
import com.example.pablomesaspringbootfundamentals.modules.artist.dto.ArtistOutputDTO;
import com.example.pablomesaspringbootfundamentals.modules.artist.service.ArtistService;
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

    @PostMapping
    public ResponseEntity<ArtistOutputDTO> createArtist(@Valid @RequestBody ArtistInputDTO artistInputDTO) {
        return new ResponseEntity<>(artistService.createArtist(artistInputDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ArtistOutputDTO>> getAllArtists() {
        return ResponseEntity.ok(artistService.getAllArtists());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ArtistOutputDTO> getArtistById(@PathVariable Long id) {
        return ResponseEntity.ok(artistService.getArtistById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Artist not found with id " + id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ArtistOutputDTO> updateArtist(@PathVariable Long id, @Valid @RequestBody ArtistInputDTO artistInputDTO) {
        return ResponseEntity.ok(artistService.updateArtist(id, artistInputDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteArtist(@PathVariable Long id) {
        artistService.deleteArtist(id);
        return ResponseEntity.noContent().build();
    }
}