package com.example.demo.utils.impl;

import com.example.demo.dto.ContratLocationDto;
import com.example.demo.dto.VoitureDto;
import com.example.demo.entity.Client;
import com.example.demo.entity.ContratLocation;
import com.example.demo.entity.Voiture;
import com.example.demo.mapper.VoitureMapper;
import com.example.demo.repo.IClientRepo;
import com.example.demo.repo.IContratLocationRepo;
import com.example.demo.repo.IVoitureRepo;
import com.example.demo.utils.IUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Optional;

@Component
public class UtilsImpl implements IUtils {

    private final IVoitureRepo iVoitureRepo;
    private final VoitureMapper voitureMapper;
    private final IClientRepo clientRepo;
    private final IVoitureRepo voitureRepo;
    private final IContratLocationRepo contratRepo;
    public UtilsImpl(IVoitureRepo iVoitureRepo, VoitureMapper voitureMapper, IClientRepo clientRepo, IVoitureRepo voitureRepo, IContratLocationRepo contratRepo) {
        this.iVoitureRepo = iVoitureRepo;
        this.voitureMapper = voitureMapper;
        this.clientRepo = clientRepo;
        this.voitureRepo = voitureRepo;
        this.contratRepo = contratRepo;
    }

    @Override
    public VoitureDto deleteVoiture(Voiture voiture) {
        iVoitureRepo.delete(voiture);
        return voitureMapper.converteToDto(voiture);
    }

    @Override
    public ResponseEntity<String> saveLocationVoiture(ContratLocationDto contratLocationDto, Optional<Client> clientExist, Optional<Voiture> voitureExist) {
        if (Objects.isNull(clientExist.get().getVoiture()) &&  clientExist.isPresent() && voitureExist.isPresent() && voitureExist.get().getDisponible()==true ){
            clientExist.get().setVoiture(voitureExist.get());
            voitureExist.get().setDisponible(false);
            clientRepo.save(clientExist.get());
            ContratLocation contrat = voitureMapper.convertToContractDto(contratLocationDto);
            //save contrat rapport
            contrat.setClient(clientExist.get());
            contratRepo.save(contrat);
            voitureExist.get().setContrat(contrat);
            voitureRepo.save(voitureExist.get());
            return new ResponseEntity<>("voiture louer", HttpStatus.OK);
        }
        return null;
    }

    ;
}
