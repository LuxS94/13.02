package org.example._302.repositories;

import org.example._302.entities.Viaggio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ViaggioRepo extends JpaRepository<Viaggio, String> {
}
