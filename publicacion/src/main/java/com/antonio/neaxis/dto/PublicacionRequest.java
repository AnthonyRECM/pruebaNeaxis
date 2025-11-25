package com.antonio.neaxis.dto;

import jakarta.validation.constraints.NotNull;

public record PublicacionRequest(
		@NotNull(message = "Campo persona es requerido")
		Long idPersona,
	
		@NotNull(message = "Campo nombre(s) es requerido")
		String cuerpo
) {}
