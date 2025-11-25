package com.antonio.neaxis.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Pais {
	MEXICO		(1L,  "México"),
	USA			(2L,  "USA"),
    CANADA		(3L,  "Canada"),
    ESPAÑA		(4L,  "España"),
    VENEZUELA	(5L,  "Venezuela"),
    PERU		(6L,  "Perú"),
    BRASIl		(7L,  "Brasil");
    
	private final Long codigo;
    private final String descripcion;
    
	public static Pais fromCodigo(Long codigo) {
        for (Pais info : Pais.values()) {
            if (info.getCodigo() == codigo) {
                return info;
            }
        }
        throw new IllegalArgumentException("Código del pais no es válido: " + codigo);
    }
	
	public static Pais fromDescripcion(String descripcion) {
        for (Pais info : values()) {
            if (info.descripcion.equalsIgnoreCase(descripcion)) {
                return info;
            }
        }
        throw new IllegalArgumentException("Descripción del pais no válida: " + descripcion);
    }
}
