package org.example._302.services;

import org.example._302.DTO.DipendenteDTO;
import org.example._302.entities.Dipendente;
import org.example._302.excepitions.AlreadyExists;
import org.example._302.excepitions.NotFoundException;
import org.example._302.repositories.DipendenteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DipendenteService {
    private final DipendenteRepo dr;

    @Autowired
    public DipendenteService(DipendenteRepo dr) {
        this.dr = dr;
    }

    public List<Dipendente> findAll() {
        return this.dr.findAll();
    }

    public Dipendente saveD(DipendenteDTO payload) {
        this.dr.findByUsername(payload.username()).ifPresent(d -> {
            throw new AlreadyExists("L'username è già utilizzato");
        });
        this.dr.findByEmail(payload.email()).ifPresent(d -> {
            throw new AlreadyExists("La mail è già utilizzato");
        });
        Dipendente nDip = new Dipendente(payload.username(), payload.nome(), payload.cognome(), payload.email());
        return nDip;

    }

    public Dipendente findByUsername(String username) {
        return this.dr.findByUsername(username).orElseThrow(() -> new NotFoundException("Dipendente non trovato"));

    }

    public Dipendente findByUsernameAndUpdate(String username, DipendenteDTO payload) {
        Dipendente f = findByUsername(username);
        f.setUsername(payload.username());
        f.setNome(payload.nome());
        f.setCognome(payload.cognome());
        f.setEmail(payload.email());
        return this.dr.save(f);
    }

    public void DeleteByUsername(String username) {
        Dipendente f = findByUsername(username);
        this.dr.delete(f);
    }
}
