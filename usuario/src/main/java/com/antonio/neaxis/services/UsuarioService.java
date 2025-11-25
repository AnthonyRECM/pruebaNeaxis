package com.antonio.neaxis.services;

import java.util.List;

import com.antonio.neaxis.dto.UsuarioRequest;
import com.antonio.neaxis.dto.UsuarioResponse;

public interface UsuarioService {
	
	List<UsuarioResponse> obtenerTodos();
	
	UsuarioResponse obtenerPorId(Long id);
	
	UsuarioResponse insertar(UsuarioRequest request);
	
	UsuarioResponse actualizar(Long id, UsuarioRequest request);
	
	void eliminar(Long id);
}
