package com.example.pablomesaspringbootfundamentals.modules.song.mapper;

import com.example.pablomesaspringbootfundamentals.modules.song.dto.SongInputDTO;
import com.example.pablomesaspringbootfundamentals.modules.song.dto.SongOutputDTO;
import com.example.pablomesaspringbootfundamentals.modules.song.entity.Song;
import org.mapstruct.*;

import java.time.Duration;
import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE, imports = Duration.class)
public interface SongMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "album", ignore = true)
    @Mapping(target = "playlists", ignore = true)
    @Mapping(target = "duration", expression = "java(Duration.parse(songInputDTO.getDuration()))")
    Song toEntity(SongInputDTO songInputDTO);

    @Mapping(target = "albumId", source = "album.id")
    @Mapping(target = "duration", expression = "java(song.getDuration().toString())")
    SongOutputDTO toOutputDTO(Song song);

    List<SongOutputDTO> toOutputDTOs(List<Song> songs);

    @AfterMapping
    default void setAlbumId(Song song, @MappingTarget SongOutputDTO songOutputDTO) {
        if (song.getAlbum() != null) {
            songOutputDTO.setAlbumId(song.getAlbum().getId());
        }
    }

/**
 * Converts a String representation of a Duration to a Duration object.
 *
 * @param value the String representation of the Duration
 * @return the Duration object
 */
default Duration map(String value) {
    return Duration.parse(value);
}

/**
 * Converts a Duration object to its String representation.
 *
 * @param value the Duration object
 * @return the String representation of the Duration
 */
default String map(Duration value) {
    return value.toString();
}
}