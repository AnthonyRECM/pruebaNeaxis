package com.antonio.neaxis.dto;

import java.util.List;

public record UsuarioResponse(
		Long id,
		String nombre,
		String contraseña,
		String estado,
		List<RolResponse> roles
) {}
