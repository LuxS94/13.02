package org.example._302.services;

import org.example._302.DTO.PrenotazioniDTO;
import org.example._302.entities.Prenotazioni;
import org.example._302.excepitions.GenericException;
import org.example._302.excepitions.NotFoundException;
import org.example._302.repositories.PrenotazioniRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrenotazioniService {
    private final PrenotazioniRepo pr;

    @Autowired
    public PrenotazioniService(PrenotazioniRepo pr) {
        this.pr = pr;


    }

    public List<Prenotazioni> findAll() {
        return this.pr.findAll();
    }

    public Prenotazioni findById(String id) {
        return this.pr.findById(id).orElseThrow(() -> new NotFoundException("Prenotazione non trovata"));
    }

    public Prenotazioni saveP(PrenotazioniDTO payload) {
        Prenotazioni exist = this.pr.findByDipendenteAndViaggio(payload.dipendente(), payload.viaggio());
        if (exist != null) {
            throw new GenericException("L'utente non può prenotare lo stesso viaggio per la stessa data!");
        }
        Prenotazioni nP = new Prenotazioni(payload.note(), payload.dipendente(), payload.viaggio());
        return this.pr.save(nP);
    }

    public Prenotazioni findByIdandUpdate(String id, PrenotazioniDTO payload) {
        Prenotazioni f = findById(id);
        f.setNote(payload.note());
        f.setViaggio(payload.viaggio());
        f.setDipendente(payload.dipendente());
        return this.pr.save(f);
    }

    public void deleteById(String id) {
        this.pr.deleteById(id);
    }
}
