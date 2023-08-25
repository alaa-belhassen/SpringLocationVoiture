package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.sql.Timestamp;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties
public class ContratLocationDto {

    @JsonProperty("idContratLocation")
    private Long idContratLocation;

    @JsonProperty("datedepart")
    private Timestamp datedepart;

    @JsonProperty("dateretour")
    private Timestamp dateretour;

    @JsonProperty("clientId")
    private Long clientId;


}
