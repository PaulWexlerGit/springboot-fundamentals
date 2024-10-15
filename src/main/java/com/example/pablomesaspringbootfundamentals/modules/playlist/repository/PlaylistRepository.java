package com.example.pablomesaspringbootfundamentals.modules.playlist.repository;

import com.example.pablomesaspringbootfundamentals.modules.playlist.entity.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaylistRepository extends JpaRepository<Playlist, Long> {
}