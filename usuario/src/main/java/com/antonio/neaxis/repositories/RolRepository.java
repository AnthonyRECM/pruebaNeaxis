package com.antonio.neaxis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.antonio.neaxis.entities.Rol;

@Repository
public interface RolRepository extends JpaRepository<Rol, Long>{
	
}
