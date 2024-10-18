package com.example.pablomesaspringbootfundamentals.modules.artist.service.impl;

import com.example.pablomesaspringbootfundamentals.exception.ResourceNotFoundException;
import com.example.pablomesaspringbootfundamentals.exception.ValidationException;
import com.example.pablomesaspringbootfundamentals.modules.artist.dto.ArtistInputDTO;
import com.example.pablomesaspringbootfundamentals.modules.artist.dto.ArtistOutputDTO;
import com.example.pablomesaspringbootfundamentals.modules.artist.mapper.ArtistMapper;
import com.example.pablomesaspringbootfundamentals.modules.artist.repository.ArtistRepository;
import com.example.pablomesaspringbootfundamentals.modules.artist.service.ArtistService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ArtistServiceImpl implements ArtistService {

    private final ArtistRepository artistRepository;
    private final ArtistMapper artistMapper;

    @Override
    public ArtistOutputDTO createArtist(ArtistInputDTO artistInputDTO) {
        if (artistInputDTO.getName() == null || artistInputDTO.getName().isEmpty()) {
            throw new ValidationException("Artist name cannot be null or empty");
        }
        return artistMapper.toOutputDTO(artistRepository.save(artistMapper.toEntity(artistInputDTO)));
    }

    @Override
    public List<ArtistOutputDTO> getAllArtists() {
        return artistMapper.toOutputDTOs(artistRepository.findAll());
    }

    @Override
    public Optional<ArtistOutputDTO> getArtistById(Long id) {
        return artistRepository.findById(id).map(artistMapper::toOutputDTO);
    }

    @Override
    public ArtistOutputDTO updateArtist(Long id, ArtistInputDTO artistInputDTO) {
        if (!artistRepository.existsById(id)) {
            throw new ResourceNotFoundException("Artist not found with id " + id);
        }
        return artistMapper.toOutputDTO(artistRepository.save(artistMapper.toEntity(artistInputDTO)));
    }

    @Override
    public void deleteArtist(Long id) {
        if (!artistRepository.existsById(id)) {
            throw new ResourceNotFoundException("Artist not found with id " + id);
        }
        artistRepository.deleteById(id);
    }
}