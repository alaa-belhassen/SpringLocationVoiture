package com.example.demo.controller;

import com.example.demo.dto.VoitureDto;
import com.example.demo.service.IVoitureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/api/voiture")
@RestController
public class VoitureController {

    @Autowired
    IVoitureService VoitureService;


    @GetMapping(name="/getAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> GetAll() {

        return VoitureService.getAll();
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody VoitureDto voitureDto) {
        return VoitureService.save(voitureDto);
    }

    @PutMapping(name="update/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody VoitureDto voitureDto) {
        return VoitureService.update(id, voitureDto);
    }

    ;

    @DeleteMapping(name="delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return VoitureService.delete(id);
    }

}
