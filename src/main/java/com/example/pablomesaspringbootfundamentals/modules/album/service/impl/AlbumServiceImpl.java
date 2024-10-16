package com.example.pablomesaspringbootfundamentals.modules.album.service.impl;

import com.example.pablomesaspringbootfundamentals.exception.ResourceNotFoundException;
import com.example.pablomesaspringbootfundamentals.exception.ValidationException;
import com.example.pablomesaspringbootfundamentals.modules.album.dto.AlbumInputDTO;
import com.example.pablomesaspringbootfundamentals.modules.album.dto.AlbumOutputDTO;
import com.example.pablomesaspringbootfundamentals.modules.album.mapper.AlbumMapper;
import com.example.pablomesaspringbootfundamentals.modules.album.repository.AlbumRepository;
import com.example.pablomesaspringbootfundamentals.modules.album.service.AlbumService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AlbumServiceImpl implements AlbumService {

    private final AlbumRepository albumRepository;
    private final AlbumMapper albumMapper;

    @Override
    public AlbumOutputDTO createAlbum(AlbumInputDTO albumInputDTO) {
        if (albumInputDTO.getName() == null || albumInputDTO.getName().isEmpty()) {
            throw new ValidationException("Album name cannot be null or empty");
        }
        return albumMapper.toOutputDTO(albumRepository.save(albumMapper.toEntity(albumInputDTO)));
    }

    @Override
    public List<AlbumOutputDTO> getAllAlbums() {
        return albumMapper.toOutputDTOs(albumRepository.findAll());
    }

    @Override
    public Optional<AlbumOutputDTO> getAlbumById(Long id) {
        return albumRepository.findById(id).map(albumMapper::toOutputDTO);
    }

    @Override
    public AlbumOutputDTO updateAlbum(Long id, AlbumInputDTO albumInputDTO) {
        if (!albumRepository.existsById(id)) {
            throw new ResourceNotFoundException("Album not found with id " + id);
        }
        return albumMapper.toOutputDTO(albumRepository.save(albumMapper.toEntity(albumInputDTO)));
    }

    @Override
    public void deleteAlbum(Long id) {
        if (!albumRepository.existsById(id)) {
            throw new ResourceNotFoundException("Album not found with id " + id);
        }
        albumRepository.deleteById(id);
    }
}