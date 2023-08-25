package com.example.demo.service;

import com.example.demo.dto.ContratLocationDto;
import org.springframework.http.ResponseEntity;

public interface IContratLocationService {
    ResponseEntity<?> save(ContratLocationDto contratLocationDto);

}
