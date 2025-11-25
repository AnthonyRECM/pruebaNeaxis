package com.antonio.neaxis.services;

import java.util.List;

import com.antonio.neaxis.dto.RolRequest;
import com.antonio.neaxis.dto.RolResponse;

public interface RolService {

	List<RolResponse> obtenerTodos();
		
	RolResponse obtenerPorId(Long id);
		
	RolResponse insertar(RolRequest request);
		
	RolResponse actualizar(Long id, RolRequest request);
	
	void eliminar(Long id);
}
