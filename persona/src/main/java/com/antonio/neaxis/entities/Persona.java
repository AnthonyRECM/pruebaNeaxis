package com.antonio.neaxis.entities;


import com.antonio.neaxis.enums.Pais;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "PERSONAS")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Persona {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "NOMBRES", nullable = false)
	@NotNull(message = "Campo nombre(s) es requerido")
	private String nombres;
	
	@Column(name = "APELLIDOS", nullable = false)
	@NotNull(message = "Campo apellido(s) es requerido")
	private String apellidos;
	
	@Column(name = "SEXO", nullable = false)
	@NotNull(message = "Campo sexo es requerido")
	private String sexo;
	
	@Column(name = "PAIS", nullable = false)
	@NotNull(message = "Campo pais es requerido")
	@Enumerated(EnumType.STRING)
	private Pais pais;
	
	@Column(name = "DIRECCION", nullable = false)
	@NotNull(message = "Campo direccion es requerido")
	private String direccion;
}
