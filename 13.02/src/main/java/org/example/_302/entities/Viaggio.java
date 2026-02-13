package org.example._302.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Viaggi")
public class Viaggio {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(nullable = false)
    private String destinazione;
    @Column(nullable = false)
    private LocalDate data;
    @Enumerated(EnumType.STRING)
    private Stato stato;

    public Viaggio() {
    }

    ;

    public Viaggio(String destinazione, LocalDate data) {
        this.destinazione = destinazione;
        this.data = data;
        if (data.isAfter(LocalDate.now())) {
            this.stato = Stato.IN_PROGRAMMA;
        } else {
            this.stato = Stato.COMPLETATO;
        }
        ;

    }

    public String getDestinazione() {
        return destinazione;
    }

    public void setDestinazione(String destinazione) {
        this.destinazione = destinazione;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getId() {
        return id;
    }

    public Stato getStato() {
        return stato;
    }

    public void setStato(Stato stato) {
        this.stato = stato;
    }

    @Override
    public String toString() {
        return "Viaggio{" +
                "id='" + id + '\'' +
                ", destinazione='" + destinazione + '\'' +
                ", data=" + data +
                ", stato=" + stato +
                '}';
    }
}
