package com.antonio.neaxis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.antonio.neaxis.entities.Persona;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long>{

}
