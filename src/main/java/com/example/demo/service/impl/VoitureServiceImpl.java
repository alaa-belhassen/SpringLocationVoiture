package com.example.demo.service.impl;

import com.example.demo.dto.ContratLocationDto;
import com.example.demo.dto.VoitureDto;
import com.example.demo.entity.Voiture;
import com.example.demo.mapper.VoitureMapper;
import com.example.demo.repo.IVoitureRepo;
import com.example.demo.service.IVoitureService;
import com.example.demo.utils.IUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VoitureServiceImpl implements IVoitureService {

    private final IVoitureRepo iVoitureRepo;
    private final VoitureMapper voitureMapper;
    private final IUtils utils;
    public VoitureServiceImpl(IVoitureRepo iVoitureRepo, VoitureMapper voitureMapper, IUtils utils) {
        this.iVoitureRepo = iVoitureRepo;
        this.voitureMapper = voitureMapper;
        this.utils = utils;
    }

    @Override
    public ResponseEntity<?> getAll() {
        List<VoitureDto> voituredto =  iVoitureRepo.findAll().stream().map(voitureMapper::converteToDto).collect(Collectors.toList());
        if (CollectionUtils.isEmpty(voituredto)){
            return new ResponseEntity<>("Aucune voiture trouver", HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(voituredto, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> save(VoitureDto voitureDto) {
        try {
            Voiture voiture = voitureMapper.converteToEntity(voitureDto);
            voiture.setDisponible(true);
            Voiture voitureSaved = iVoitureRepo.save(voiture);
            return new ResponseEntity<>(voitureMapper.converteToDto(voitureSaved),HttpStatus.OK);
        } catch(Exception e) {
            return ResponseEntity.badRequest().body("Erreur creating person");
        }
    }
    @Override
    public ResponseEntity<?> update(final Long id, VoitureDto voitureDto) {
        Optional<Voiture> voiture = iVoitureRepo.findById(id);
        if (voiture.isPresent()) {
            Voiture existingVoiture = voitureMapper.converteToEntity(voitureDto);
            existingVoiture.setIdVoiture(id);
            Voiture voitureUpdated = iVoitureRepo.save(existingVoiture);
            return new ResponseEntity<>(voitureMapper.converteToDto(voitureUpdated),HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * methode permet de suprimmer une voiture et de retourner le dto supprimer
     * @param id
     * @return Voituredto supprimer
     */

    @Override
    public ResponseEntity<?>  delete(final Long id) {
        Optional<Voiture> voiture = iVoitureRepo.findById(id);
        if (voiture.isPresent()){
            return new ResponseEntity<>(voiture.map(utils::deleteVoiture),HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}
