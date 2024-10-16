package com.example.pablomesaspringbootfundamentals.modules.playlist.service;

import com.example.pablomesaspringbootfundamentals.modules.playlist.dto.PlaylistInputDTO;
import com.example.pablomesaspringbootfundamentals.modules.playlist.dto.PlaylistOutputDTO;

import java.util.List;
import java.util.Optional;

public interface PlaylistService {
    PlaylistOutputDTO createPlaylist(PlaylistInputDTO playlistInputDTO);

    List<PlaylistOutputDTO> getAllPlaylists();

    Optional<PlaylistOutputDTO> getPlaylistById(Long id);

    PlaylistOutputDTO updatePlaylist(Long id, PlaylistInputDTO playlistInputDTO);

    void deletePlaylist(Long id);
}