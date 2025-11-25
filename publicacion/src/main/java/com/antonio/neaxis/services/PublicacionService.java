package com.antonio.neaxis.services;

import java.util.List;

import com.antonio.neaxis.dto.PublicacionRequest;
import com.antonio.neaxis.dto.PublicacionResponse;

public interface PublicacionService {

	List<PublicacionResponse> obtenerTodos();
		
	PublicacionResponse obtenerPorId(Long id);
		
	PublicacionResponse insertar(PublicacionRequest request);
}
