package org.example._302.entities;

import jakarta.persistence.*;

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
    @OneToOne
    @JoinColumn
    private Viaggio viaggio;

    public Prenotazioni() {
    }

    ;

    public Prenotazioni(String note, Dipendente dipendente, Viaggio viaggio) {
        this.dipendente = dipendente;
        this.viaggio = viaggio;
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