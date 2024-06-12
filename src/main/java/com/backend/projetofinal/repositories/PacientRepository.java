package com.backend.projetofinal.repositories;

import com.backend.projetofinal.domain.pacient.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PacientRepository extends JpaRepository<Patient, UUID> {
}
