package com.example.pablomesaspringbootfundamentals.modules.playlist.mapper;

import com.example.pablomesaspringbootfundamentals.modules.playlist.dto.PlaylistInputDTO;
import com.example.pablomesaspringbootfundamentals.modules.playlist.dto.PlaylistOutputDTO;
import com.example.pablomesaspringbootfundamentals.modules.playlist.entity.Playlist;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PlaylistMapper {
    Playlist toEntity(PlaylistInputDTO playlistInputDTO);

    PlaylistOutputDTO toOutputDTO(Playlist playlist);

    List<PlaylistOutputDTO> toOutputDTOs(List<Playlist> playlists);
}