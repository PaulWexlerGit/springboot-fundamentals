package com.example.pablomesaspringbootfundamentals.modules.song.service;

import com.example.pablomesaspringbootfundamentals.modules.song.dto.SongInputDTO;
import com.example.pablomesaspringbootfundamentals.modules.song.dto.SongOutputDTO;

import java.util.List;
import java.util.Optional;

public interface SongService {
    SongOutputDTO createSong(SongInputDTO songInputDTO);

    List<SongOutputDTO> getAllSongs();

    Optional<SongOutputDTO> getSongById(Long id);

    SongOutputDTO updateSong(Long id, SongInputDTO songInputDTO);

    void deleteSong(Long id);
}