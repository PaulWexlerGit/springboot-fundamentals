package com.example.pablomesaspringbootfundamentals.modules.song.entity;

import com.example.pablomesaspringbootfundamentals.modules.album.entity.Album;
import com.example.pablomesaspringbootfundamentals.modules.playlist.entity.Playlist;
import jakarta.persistence.*;
import lombok.*;

import java.time.Duration;
import java.util.List;

@Entity
@Table(name = "song")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Duration duration;

    @ManyToOne
    @JoinColumn(name = "album_id")
    private Album album;

    @ManyToMany(mappedBy = "songs")
    private List<Playlist> playlists;
}