package com.example.demo.mapper;

import com.example.demo.dto.ContratLocationDto;
import com.example.demo.dto.VoitureDto;
import com.example.demo.entity.ContratLocation;
import com.example.demo.entity.Voiture;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VoitureMapper {

    private ModelMapper modelMapper;

    public VoitureMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Autowired
    public void YourService(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public VoitureDto converteToDto(Voiture voiture) {
        return modelMapper.map(voiture, VoitureDto.class);
    }

    public Voiture converteToEntity(VoitureDto voitureDto) {
        return modelMapper.map(voitureDto, Voiture.class);
    }

    public ContratLocation convertToContractDto(ContratLocationDto contratLocationDto){
        return modelMapper.map(contratLocationDto, ContratLocation.class);
    }
}
