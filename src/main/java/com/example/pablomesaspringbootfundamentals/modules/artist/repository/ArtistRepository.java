package com.example.pablomesaspringbootfundamentals.modules.artist.repository;

import com.example.pablomesaspringbootfundamentals.modules.artist.entity.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistRepository extends JpaRepository<Artist, Long> {
}