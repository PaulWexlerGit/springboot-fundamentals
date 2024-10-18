package com.example.pablomesaspringbootfundamentals.modules.playlist.repository;

import com.example.pablomesaspringbootfundamentals.modules.playlist.entity.Playlist;
import com.example.pablomesaspringbootfundamentals.modules.song.entity.Song;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlaylistRepository extends JpaRepository<Playlist, Long> {
    List<Playlist> findBySongsContaining(Song song);
}