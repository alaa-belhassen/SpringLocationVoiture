package com.example.demo.service.impl;

import com.example.demo.dto.ContratLocationDto;
import com.example.demo.entity.Client;
import com.example.demo.entity.Voiture;
import com.example.demo.mapper.VoitureMapper;
import com.example.demo.repo.IClientRepo;
import com.example.demo.repo.IContratLocationRepo;
import com.example.demo.repo.IVoitureRepo;
import com.example.demo.service.IClientService;
import com.example.demo.service.IContratLocationService;
import com.example.demo.utils.IUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientServeImpl implements IClientService {

    private final IClientRepo clientRepo;
    private final IVoitureRepo voitureRepo;
    private final IContratLocationRepo contratRepo;
    private final VoitureMapper voitureMapper;
    private final IUtils utils;
    public ClientServeImpl(IClientRepo clientRepo, IVoitureRepo voitureRepo, IContratLocationService contratService, IContratLocationRepo contratRepo, VoitureMapper voitureMapper, IUtils utils) {
        this.clientRepo = clientRepo;
        this.voitureRepo = voitureRepo;
        this.contratRepo = contratRepo;
        this.voitureMapper = voitureMapper;
        this.utils = utils;
    }


    @Override
    public ResponseEntity<?> locationVoiture(Long idvoiture, ContratLocationDto contratLocationDto) {
        Optional<Client> clientExist = clientRepo.findById(contratLocationDto.getClientId());
        Optional<Voiture> voitureExist = voitureRepo.findById(idvoiture);
        ResponseEntity<String> OK = utils.saveLocationVoiture(contratLocationDto, clientExist, voitureExist);
        if (OK != null) return OK;
        return ResponseEntity.badRequest().body("Erreur de location");
    }


}
