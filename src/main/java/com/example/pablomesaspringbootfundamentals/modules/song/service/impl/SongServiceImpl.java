package com.example.pablomesaspringbootfundamentals.modules.song.service.impl;

import com.example.pablomesaspringbootfundamentals.exception.ResourceNotFoundException;
import com.example.pablomesaspringbootfundamentals.exception.ValidationException;
import com.example.pablomesaspringbootfundamentals.modules.album.repository.AlbumRepository;
import com.example.pablomesaspringbootfundamentals.modules.playlist.entity.Playlist;
import com.example.pablomesaspringbootfundamentals.modules.playlist.repository.PlaylistRepository;
import com.example.pablomesaspringbootfundamentals.modules.song.dto.SongInputDTO;
import com.example.pablomesaspringbootfundamentals.modules.song.dto.SongOutputDTO;
import com.example.pablomesaspringbootfundamentals.modules.song.entity.Song;
import com.example.pablomesaspringbootfundamentals.modules.song.mapper.SongMapper;
import com.example.pablomesaspringbootfundamentals.modules.song.repository.SongRepository;
import com.example.pablomesaspringbootfundamentals.modules.song.service.SongService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class SongServiceImpl implements SongService {

    private final SongRepository songRepository;
    private final SongMapper songMapper;
    private final AlbumRepository albumRepository;
    private final PlaylistRepository playlistRepository;

    @Override
    public SongOutputDTO createSong(SongInputDTO songInputDTO) {
        if (songInputDTO.getName() == null || songInputDTO.getName().isEmpty()) {
            throw new ValidationException("Song name cannot be null or empty");
        }
        Song song = songMapper.toEntity(songInputDTO);
        song.setAlbum(albumRepository.findById(songInputDTO.getAlbumId())
                .orElseThrow(() -> new ResourceNotFoundException("Album not found with id " + songInputDTO.getAlbumId())));
        return songMapper.toOutputDTO(songRepository.save(song));
    }

    @Override
    @Transactional(readOnly = true)
    public List<SongOutputDTO> getAllSongs() {
        return songMapper.toOutputDTOs(songRepository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<SongOutputDTO> getSongById(Long id) {
        return songRepository.findById(id).map(songMapper::toOutputDTO);
    }

    @Override
    public SongOutputDTO updateSong(Long id, SongInputDTO songInputDTO) {
        Song existingSong = songRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Song not found with id " + id));

        Song updatedSong = songMapper.toEntity(songInputDTO);
        updatedSong.setId(existingSong.getId());
        updatedSong.setAlbum(albumRepository.findById(songInputDTO.getAlbumId())
                .orElseThrow(() -> new ResourceNotFoundException("Album not found with id " + songInputDTO.getAlbumId())));

        return songMapper.toOutputDTO(songRepository.save(updatedSong));
    }

    @Override
    public void deleteSong(Long id) {
        Song song = songRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Song not found with id " + id));

        List<Playlist> playlists = playlistRepository.findBySongsContaining(song);
        for (Playlist playlist : playlists) {
            playlist.getSongs().remove(song);
            playlistRepository.save(playlist);
        }
        songRepository.delete(song);
    }
}