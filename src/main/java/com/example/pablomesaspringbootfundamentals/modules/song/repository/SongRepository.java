package com.example.pablomesaspringbootfundamentals.modules.song.repository;

import com.example.pablomesaspringbootfundamentals.modules.song.entity.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongRepository extends JpaRepository<Song, Long> {
}