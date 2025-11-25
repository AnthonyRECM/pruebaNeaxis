package com.antonio.neaxis.mappers;

import java.util.List;

import org.springframework.stereotype.Component;

import com.antonio.neaxis.dto.RolResponse;
import com.antonio.neaxis.dto.UsuarioRequest;
import com.antonio.neaxis.dto.UsuarioResponse;
import com.antonio.neaxis.entities.Usuario;

@Component
public class UsuarioMapper {

	public UsuarioResponse entityToResponse(Usuario usuario, List<RolResponse> roles) {
		if (usuario == null) return null;
		return new UsuarioResponse(
				usuario.getId(),
				usuario.getUsuario(),
				usuario.getContraseña(),
				usuario.getEstado(),
				roles
		);
	}
	
	public Usuario requestToEntity(UsuarioRequest request, String contraseña, String estado) {
		if (request == null) return null;
		Usuario usuario = new Usuario();
		usuario.setUsuario(request.usuario());
		usuario.setContraseña(contraseña);
		usuario.setEstado(estado);
		return usuario;
	}
}
