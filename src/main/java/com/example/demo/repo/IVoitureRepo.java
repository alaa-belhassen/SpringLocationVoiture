package com.example.demo.repo;

import com.example.demo.entity.Voiture;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IVoitureRepo extends JpaRepository<Voiture,Long> {

}
