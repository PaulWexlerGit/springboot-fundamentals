package com.example.pablomesaspringbootfundamentals.modules.album.service;

import com.example.pablomesaspringbootfundamentals.modules.album.dto.AlbumInputDTO;
import com.example.pablomesaspringbootfundamentals.modules.album.dto.AlbumOutputDTO;

import java.util.List;
import java.util.Optional;

public interface AlbumService {
    AlbumOutputDTO createAlbum(AlbumInputDTO albumInputDTO);

    List<AlbumOutputDTO> getAllAlbums();

    Optional<AlbumOutputDTO> getAlbumById(Long id);

    AlbumOutputDTO updateAlbum(Long id, AlbumInputDTO albumInputDTO);

    void deleteAlbum(Long id);
}