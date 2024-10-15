//package com.example.pablomesaspringbootfundamentals.config;
//
//import com.example.pablomesaspringbootfundamentals.modules.album.entity.Album;
//import com.example.pablomesaspringbootfundamentals.modules.artist.entity.Artist;
//import com.example.pablomesaspringbootfundamentals.modules.genre.entity.Genre;
//import com.example.pablomesaspringbootfundamentals.modules.song.entity.Song;
//import com.example.pablomesaspringbootfundamentals.modules.playlist.entity.Playlist;
//import com.example.pablomesaspringbootfundamentals.modules.album.repository.AlbumRepository;
//import com.example.pablomesaspringbootfundamentals.modules.artist.repository.ArtistRepository;
//import com.example.pablomesaspringbootfundamentals.modules.genre.repository.GenreRepository;
//import com.example.pablomesaspringbootfundamentals.modules.song.repository.SongRepository;
//import com.example.pablomesaspringbootfundamentals.modules.playlist.repository.PlaylistRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//import java.time.Duration;
//import java.time.LocalDate;
//import java.util.Arrays;
//
//@Component
//@RequiredArgsConstructor
//public class DataInitializer implements CommandLineRunner {
//
//    private final GenreRepository genreRepository;
//    private final ArtistRepository artistRepository;
//    private final AlbumRepository albumRepository;
//    private final SongRepository songRepository;
//    private final PlaylistRepository playlistRepository;
//
//    @Override
//    public void run(String... args) throws Exception {
//        // Create and save genres
//        Genre rock = new Genre(null, "Rock", "Rock music", null);
//        genreRepository.save(rock);
//
//        // Create and save artists
//        Artist artist = new Artist(null, "Queen", rock, null);
//        artistRepository.save(artist);
//
//        // Create and save albums
//        Album album = new Album(null, "A Night at the Opera", LocalDate.of(1975, 11, 21), artist, null);
//        albumRepository.save(album);
//
//        // Create and save songs
//        Song song = new Song(null, "Bohemian Rhapsody", Duration.ofMinutes(6).plusSeconds(7), album, null);
//        songRepository.save(song);
//
//        // Create and save playlists
//        Playlist playlist = new Playlist(null, "My Rock Playlist", "A collection of rock songs", Arrays.asList(song));
//        playlistRepository.save(playlist);
//    }
//}