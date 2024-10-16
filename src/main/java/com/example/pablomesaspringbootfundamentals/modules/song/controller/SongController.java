package com.example.pablomesaspringbootfundamentals.modules.song.controller;

import com.example.pablomesaspringbootfundamentals.exception.ResourceNotFoundException;
import com.example.pablomesaspringbootfundamentals.modules.song.dto.SongInputDTO;
import com.example.pablomesaspringbootfundamentals.modules.song.dto.SongOutputDTO;
import com.example.pablomesaspringbootfundamentals.modules.song.service.SongService;
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

    @PostMapping
    public ResponseEntity<SongOutputDTO> createSong(@Valid @RequestBody SongInputDTO songInputDTO) {
        return new ResponseEntity<>(songService.createSong(songInputDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<SongOutputDTO>> getAllSongs() {
        return ResponseEntity.ok(songService.getAllSongs());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SongOutputDTO> getSongById(@PathVariable Long id) {
        return ResponseEntity.ok(songService.getSongById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Song not found with id " + id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SongOutputDTO> updateSong(@PathVariable Long id, @Valid @RequestBody SongInputDTO songInputDTO) {
        return ResponseEntity.ok(songService.updateSong(id, songInputDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSong(@PathVariable Long id) {
        songService.deleteSong(id);
        return ResponseEntity.noContent().build();
    }
}