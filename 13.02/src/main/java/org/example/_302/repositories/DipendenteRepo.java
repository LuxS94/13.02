package org.example._302.repositories;

import org.example._302.entities.Dipendente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DipendenteRepo extends JpaRepository<Dipendente, String> {
}
