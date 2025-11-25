package com.antonio.neaxis.dto;

import java.util.List;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record UsuarioRequest(
		@NotNull(message = "El usuario es requerido")
		String usuario,

		@NotNull(message = "La contraseña es requerida")
		String contraseña,
		
		@NotEmpty(message = "La lista de roles no puede estar vacía")
	    List<Long> idRoles
) {}
