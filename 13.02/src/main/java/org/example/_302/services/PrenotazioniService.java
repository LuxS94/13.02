package org.example._302.services;

import org.example._302.repositories.PrenotazioniRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrenotazioniService {
    private final PrenotazioniRepo pr;

    @Autowired
    public PrenotazioniService(PrenotazioniRepo pr) {
        this.pr = pr;
    }
}
