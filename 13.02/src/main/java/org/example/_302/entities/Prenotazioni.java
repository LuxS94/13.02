package org.example._302.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Prenotazioni")
public class Prenotazioni {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String note;
    @ManyToOne
    @JoinColumn
    private Dipendente dipendente;
    @ManyToOne
    @JoinColumn
    private Viaggio viaggio;
    private LocalDate data;

    public Prenotazioni() {
    }

    ;

    public Prenotazioni(String note, Dipendente dipendente, Viaggio viaggio) {
        this.note = note;
        this.dipendente = dipendente;
        this.setViaggio(viaggio);
        if (viaggio != null) {
            this.data = viaggio.getData();
        }
    }

    public LocalDate getData() {
        return data;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Dipendente getDipendente() {
        return dipendente;
    }

    public void setDipendente(Dipendente dipendente) {
        this.dipendente = dipendente;
    }

    public Viaggio getViaggio() {
        return viaggio;
    }

    public void setViaggio(Viaggio viaggio) {
        this.viaggio = viaggio;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Prenotazioni{" +
                "id='" + id + '\'' +
                ", note='" + note + '\'' +
                ", dipendente=" + dipendente +
                ", viaggio=" + viaggio +
                '}';
    }
}