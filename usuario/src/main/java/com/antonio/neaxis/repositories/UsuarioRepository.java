package com.antonio.neaxis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.antonio.neaxis.entities.Usuario;
import java.util.List;
import java.util.Optional;


@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
	Optional<Usuario> findByIdAndEstado(Long id, String estado);
	
	List<Usuario> findByEstado(String estado);
}
