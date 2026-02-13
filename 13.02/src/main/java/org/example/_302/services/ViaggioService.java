package org.example._302.services;

import org.example._302.DTO.ViaggioDTO;
import org.example._302.entities.Stato;
import org.example._302.entities.Viaggio;
import org.example._302.excepitions.AlreadyExists;
import org.example._302.excepitions.NotFoundException;
import org.example._302.repositories.ViaggioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ViaggioService {
    private final ViaggioRepo vr;

    @Autowired
    public ViaggioService(ViaggioRepo vr) {
        this.vr = vr;
    }

    public List<Viaggio> findAll() {
        return this.vr.findAll();
    }

    public Viaggio findById(String id) {
        return this.vr.findById(id).orElseThrow(() -> new NotFoundException("Viaggio non trovato!!"));
    }

    public Viaggio saveV(ViaggioDTO payload) {
        this.vr.findByDataAndDestinazione(payload.data(), payload.destinazione()).ifPresent(v -> {
            throw new AlreadyExists("Questo viaggio è già registrato!");
        });
        Viaggio nv = new Viaggio(payload.destinazione(), payload.data());
        return this.vr.save(nv);
    }

    public Viaggio findByIdAndUpdate(String id, ViaggioDTO payload) {
        Viaggio f = findById(id);
        f.setData(payload.data());
        f.setDestinazione(payload.destinazione());
        return this.vr.save(f);
    }

    public void deleteById(String id) {
        this.vr.deleteById(id);
    }

    //metodo per cambiare lo stato del viaggio
    public Viaggio setStato(String id, Stato stato) {
        Viaggio f = findById(id);
        f.setStato(stato);
        return this.vr.save(f);
    }
}
