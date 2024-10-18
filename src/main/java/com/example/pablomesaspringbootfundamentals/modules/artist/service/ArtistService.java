package com.example.pablomesaspringbootfundamentals.modules.artist.service;

import com.example.pablomesaspringbootfundamentals.modules.artist.dto.ArtistInputDTO;
import com.example.pablomesaspringbootfundamentals.modules.artist.dto.ArtistOutputDTO;

import java.util.List;
import java.util.Optional;

public interface ArtistService {
    ArtistOutputDTO createArtist(ArtistInputDTO artistInputDTO);

    List<ArtistOutputDTO> getAllArtists();

    Optional<ArtistOutputDTO> getArtistById(Long id);

    ArtistOutputDTO updateArtist(Long id, ArtistInputDTO artistInputDTO);

    void deleteArtist(Long id);
}