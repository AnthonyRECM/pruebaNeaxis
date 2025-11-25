package com.antonio.neaxis.dto;

import jakarta.validation.constraints.NotNull;

public record PersonaRequest(
		@NotNull(message = "Campo nombre(s) es requerido")
		String nombres,
		
		@NotNull(message = "Campo apellido(s) es requerido")
		String apellidos,
		
		@NotNull(message = "Campo sexo es requerido")
		String sexo,
		
		@NotNull(message = "Campo pais es requerido")
		Long pais,
		
		@NotNull(message = "Campo direccion es requerido")
		String direccion
) {}
