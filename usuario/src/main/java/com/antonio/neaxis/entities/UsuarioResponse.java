package com.antonio.neaxis.entities;

public record UsuarioResponse(
		Long id,
		String nombre,
		String contraseña,
		String estado
) {}
