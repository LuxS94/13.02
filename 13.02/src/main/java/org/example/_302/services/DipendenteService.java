package org.example._302.services;

import org.example._302.repositories.DipendenteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DipendenteService {
    private final DipendenteRepo dr;

    @Autowired
    public DipendenteService(DipendenteRepo dr) {
        this.dr = dr;
    }
    
}
