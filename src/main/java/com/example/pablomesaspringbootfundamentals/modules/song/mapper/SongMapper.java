package com.example.pablomesaspringbootfundamentals.modules.song.mapper;

import com.example.pablomesaspringbootfundamentals.modules.song.dto.SongInputDTO;
import com.example.pablomesaspringbootfundamentals.modules.song.dto.SongOutputDTO;
import com.example.pablomesaspringbootfundamentals.modules.song.entity.Song;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SongMapper {

    @Mapping(source = "album.id", target = "albumId")
    SongOutputDTO toOutputDTO(Song song);

    @Mapping(source = "albumId", target = "album.id")
    Song toEntity(SongInputDTO songInputDTO);
}