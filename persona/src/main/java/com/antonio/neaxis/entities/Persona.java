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

@Entity
@Table(name = "PERSONAS")
public class Persona {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "NOMBRES")
	@NotNull(message = "Campo nombre(s) es requerido")
	private String nombres;
	
	@Column(name = "APELLIDOS")
	@NotNull(message = "Campo nombre(s) es requerido")
	private String apellidos;
	
	@Column(name = "SEXO")
	@NotNull(message = "Campo nombre(s) es requerido")
	private String sexo;
	
	@Column(name = "PAIS")
	@NotNull(message = "Campo nombre(s) es requerido")
	@Enumerated(EnumType.STRING)
	private Pais pais;
	
	@Column(name = "DIRECCION")
	@NotNull(message = "Campo nombre(s) es requerido")
	private String direccion;
}
