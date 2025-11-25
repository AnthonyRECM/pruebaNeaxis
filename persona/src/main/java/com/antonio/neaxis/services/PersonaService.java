package com.antonio.neaxis.services;

import java.util.List;

import com.antonio.neaxis.dto.PersonaRequest;
import com.antonio.neaxis.dto.PersonaResponse;

public interface PersonaService {

	List<PersonaResponse> obtenerTodos();
		
	PersonaResponse obtenerPorId(Long id);
		
	PersonaResponse insertar(PersonaRequest request);
		
	PersonaResponse actualizar(Long id, PersonaRequest request);
	
	void eliminar(Long id);
}
