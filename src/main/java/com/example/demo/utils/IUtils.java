package com.example.demo.utils;

import com.example.demo.dto.ContratLocationDto;
import com.example.demo.dto.VoitureDto;
import com.example.demo.entity.Client;
import com.example.demo.entity.Voiture;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public interface IUtils {
     VoitureDto deleteVoiture(Voiture voiture);
     ResponseEntity<String> saveLocationVoiture(ContratLocationDto contratLocationDto, Optional<Client> clientExist, Optional<Voiture> voitureExist);

     }
