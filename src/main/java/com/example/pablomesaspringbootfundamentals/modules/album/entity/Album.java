package com.example.pablomesaspringbootfundamentals.modules.album.entity;

import com.example.pablomesaspringbootfundamentals.modules.artist.entity.Artist;
import com.example.pablomesaspringbootfundamentals.modules.song.entity.Song;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "album")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private LocalDate releaseDate;

    @ManyToOne
    @JoinColumn(name = "artist_id")
    private Artist artist;

    @OneToMany(mappedBy = "album")
    private List<Song> songs;
}