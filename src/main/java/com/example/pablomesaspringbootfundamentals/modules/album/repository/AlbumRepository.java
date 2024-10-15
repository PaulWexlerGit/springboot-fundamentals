package com.example.pablomesaspringbootfundamentals.modules.album.repository;

import com.example.pablomesaspringbootfundamentals.modules.album.entity.Album;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepository extends JpaRepository<Album, Long> {
}