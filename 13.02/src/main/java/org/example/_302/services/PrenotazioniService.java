package org.example._302.services;

import org.example._302.DTO.PrenotazioniDTO;
import org.example._302.entities.Dipendente;
import org.example._302.entities.Prenotazioni;
import org.example._302.entities.Viaggio;
import org.example._302.excepitions.GenericException;
import org.example._302.excepitions.NotFoundException;
import org.example._302.repositories.DipendenteRepo;
import org.example._302.repositories.PrenotazioniRepo;
import org.example._302.repositories.ViaggioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PrenotazioniService {
    private final PrenotazioniRepo pr;
    private final DipendenteRepo dr;
    private final ViaggioRepo vr;

    @Autowired
    public PrenotazioniService(PrenotazioniRepo pr, DipendenteRepo dr, ViaggioRepo vr) {
        this.pr = pr;
        this.dr = dr;
        this.vr = vr;


    }

    public List<Prenotazioni> findAll() {
        return this.pr.findAll();
    }

    public Prenotazioni findById(String id) {
        return this.pr.findById(id).orElseThrow(() -> new NotFoundException("Prenotazione non trovata"));
    }

    public Prenotazioni saveP(PrenotazioniDTO payload) {
        Dipendente dipendente = dr.findById(payload.dipendente()).get();
        Viaggio viaggio = vr.findById(payload.viaggio()).get();
        Prenotazioni exist = this.pr.findByDipendenteAndViaggio(dipendente, viaggio);
        if (exist != null) {
            throw new GenericException("L'utente non può prenotare lo stesso viaggio per la stessa data!");
        }
        Prenotazioni nP = new Prenotazioni(payload.note(), dipendente, viaggio);
        if (nP.getData().isBefore(LocalDate.now())) {
            throw new GenericException("Non è possibile prenotare una data passata!");
        }
        return this.pr.save(nP);
    }

    public Prenotazioni findByIdandUpdate(String id, PrenotazioniDTO payload) {
        Prenotazioni f = findById(id);
        Dipendente dipendente = dr.findById(payload.dipendente()).get();
        Viaggio viaggio = vr.findById(payload.viaggio()).get();
        f.setNote(payload.note());
        f.setViaggio(viaggio);
        f.setDipendente(dipendente);
        return this.pr.save(f);
    }

    public void deleteById(String id) {
        this.pr.deleteById(id);
    }
}
