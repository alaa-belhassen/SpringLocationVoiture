package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties
public class VoitureDto implements Serializable {

    @JsonProperty("idVoiture")
    private Long idVoiture;

    @JsonProperty("couleur")
    private String couleur;

    @JsonProperty("matricule")
    private String matricule;

    @JsonProperty("disponible")
    private Boolean disponible;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("dateLocation")
    private LocalDateTime dateLocation;


}
