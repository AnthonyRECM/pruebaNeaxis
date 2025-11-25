package com.antonio.neaxis.dto;

import jakarta.validation.constraints.NotNull;

public record RolRequest(
		@NotNull(message = "El rol es requerido")
		String tipo
) {}
