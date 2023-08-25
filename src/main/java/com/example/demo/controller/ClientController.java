package com.example.demo.controller;


import com.example.demo.dto.ContratLocationDto;
import com.example.demo.service.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/api/client")
@RestController
public class ClientController {

    @Autowired
    IClientService iClientService;

    @PostMapping("location/{id}")
    public ResponseEntity<?> locationVoiture(@PathVariable Long id , @RequestBody ContratLocationDto contratLocationDto){
        return iClientService.locationVoiture(id,contratLocationDto);
    }


}
