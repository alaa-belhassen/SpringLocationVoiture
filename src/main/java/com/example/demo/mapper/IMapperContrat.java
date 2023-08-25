package com.example.demo.mapper;

import com.example.demo.dto.ContratLocationDto;
import com.example.demo.entity.ContratLocation;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface IMapperContrat {
    IMapperContrat INSTANCE = Mappers.getMapper(IMapperContrat.class);

    ContratLocation contractLocationDtoToContract(ContratLocationDto contratLocationDto);

    ContratLocationDto ContractLocationToContractLocationDto(ContratLocation contratLocation);
}
