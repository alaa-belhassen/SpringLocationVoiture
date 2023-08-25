package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties
public class ClientDto implements Serializable {

    @JsonProperty("idclient")
    private Long idclient;

    @JsonProperty("nom")
    private String nom ;

    @JsonProperty("idVoiture")
    private VoitureDto voitureDto;
}
