package com.example.demo.service.impl;

import com.example.demo.dto.ContratLocationDto;
import com.example.demo.entity.ContratLocation;
import com.example.demo.mapper.IMapperContrat;
import com.example.demo.repo.IContratLocationRepo;
import com.example.demo.service.IContratLocationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ContratLocationImpl implements IContratLocationService {

    private final IContratLocationRepo contratLocationRepo;

    public ContratLocationImpl(IContratLocationRepo contratLocationRepo) {
        this.contratLocationRepo = contratLocationRepo;
    }

    @Override
    public ResponseEntity<?> save(ContratLocationDto contratLocationDto) {
        try {
            ContratLocation contrat = IMapperContrat.INSTANCE.contractLocationDtoToContract(contratLocationDto);
            ContratLocation contratSaved = contratLocationRepo.save(contrat);
            return new ResponseEntity<>(IMapperContrat.INSTANCE.ContractLocationToContractLocationDto(contratSaved), HttpStatus.OK);
        } catch(Exception e) {
            return ResponseEntity.badRequest().body("Erreur creating contrat");
        }
    }
}
