package com.example.demo.service;

import com.example.demo.dto.ContratLocationDto;
import com.example.demo.dto.VoitureDto;
import org.springframework.http.ResponseEntity;

public interface IClientService {

    ResponseEntity<?> locationVoiture(final Long idVoiture, ContratLocationDto contratLocationDto);

}
