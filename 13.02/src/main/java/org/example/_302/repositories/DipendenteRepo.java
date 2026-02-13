package org.example._302.repositories;

import org.example._302.entities.Dipendente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DipendenteRepo extends JpaRepository<Dipendente, String> {
    Optional<Dipendente> findByUsername(String username);

    Optional<Dipendente> findByEmail(String email);
}
