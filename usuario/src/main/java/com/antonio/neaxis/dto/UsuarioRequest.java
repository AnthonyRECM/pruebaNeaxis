package com.antonio.neaxis.dto;

import jakarta.validation.constraints.NotNull;

public record UsuarioRequest(
		@NotNull(message = "El usuario es requerido")
		String usuario,

		@NotNull(message = "La contraseña es requerida")
		String contraseña
) {}
