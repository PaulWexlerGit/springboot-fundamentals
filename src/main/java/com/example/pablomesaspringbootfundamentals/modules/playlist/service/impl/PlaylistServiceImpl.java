package com.example.pablomesaspringbootfundamentals.modules.playlist.service.impl;

import com.example.pablomesaspringbootfundamentals.exception.ResourceNotFoundException;
import com.example.pablomesaspringbootfundamentals.exception.ValidationException;
import com.example.pablomesaspringbootfundamentals.modules.playlist.dto.PlaylistInputDTO;
import com.example.pablomesaspringbootfundamentals.modules.playlist.dto.PlaylistOutputDTO;
import com.example.pablomesaspringbootfundamentals.modules.playlist.mapper.PlaylistMapper;
import com.example.pablomesaspringbootfundamentals.modules.playlist.repository.PlaylistRepository;
import com.example.pablomesaspringbootfundamentals.modules.playlist.service.PlaylistService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PlaylistServiceImpl implements PlaylistService {

    private final PlaylistRepository playlistRepository;
    private final PlaylistMapper playlistMapper;

    @Override
    public PlaylistOutputDTO createPlaylist(PlaylistInputDTO playlistInputDTO) {
        if (playlistInputDTO.getName() == null || playlistInputDTO.getName().isEmpty()) {
            throw new ValidationException("Playlist name cannot be null or empty");
        }
        return playlistMapper.toOutputDTO(playlistRepository.save(playlistMapper.toEntity(playlistInputDTO)));
    }

    @Override
    public List<PlaylistOutputDTO> getAllPlaylists() {
        return playlistMapper.toOutputDTOs(playlistRepository.findAll());
    }

    @Override
    public Optional<PlaylistOutputDTO> getPlaylistById(Long id) {
        return playlistRepository.findById(id).map(playlistMapper::toOutputDTO);
    }

    @Override
    public PlaylistOutputDTO updatePlaylist(Long id, PlaylistInputDTO playlistInputDTO) {
        if (!playlistRepository.existsById(id)) {
            throw new ResourceNotFoundException("Playlist not found with id " + id);
        }
        return playlistMapper.toOutputDTO(playlistRepository.save(playlistMapper.toEntity(playlistInputDTO)));
    }

    @Override
    public void deletePlaylist(Long id) {
        if (!playlistRepository.existsById(id)) {
            throw new ResourceNotFoundException("Playlist not found with id " + id);
        }
        playlistRepository.deleteById(id);
    }
}