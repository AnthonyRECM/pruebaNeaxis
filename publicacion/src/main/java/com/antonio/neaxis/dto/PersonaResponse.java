package com.antonio.neaxis.dto;

public record PersonaResponse(
		Long id,
		String nombres,
		String apellidos,
		String sexo,
		String pais,
		String direccion
) {}
