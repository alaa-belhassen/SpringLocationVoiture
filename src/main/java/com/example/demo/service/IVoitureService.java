package com.example.demo.service;

import com.example.demo.dto.ContratLocationDto;
import com.example.demo.dto.VoitureDto;
import org.springframework.http.ResponseEntity;


public interface IVoitureService {

    ResponseEntity<?>  getAll();

    ResponseEntity<?> save( VoitureDto voitureDto);

    ResponseEntity<?> update(final Long id,  VoitureDto voitureDto);

    ResponseEntity<?> delete(final Long id);


    }
