package com.example.pablomesaspringbootfundamentals.modules.playlist.mapper;

import com.example.pablomesaspringbootfundamentals.modules.playlist.dto.PlaylistInputDTO;
import com.example.pablomesaspringbootfundamentals.modules.playlist.dto.PlaylistOutputDTO;
import com.example.pablomesaspringbootfundamentals.modules.playlist.entity.Playlist;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PlaylistMapper {

    PlaylistOutputDTO toOutputDTO(Playlist playlist);

    Playlist toEntity(PlaylistInputDTO playlistInputDTO);
}