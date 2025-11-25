package com.antonio.neaxis.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "PUBLICACIONES")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Publicacion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "CUERPO")
	@NotNull(message = "Campo cuerpo es requerido")
	private String cuerpo;
	
	@Column(name = "IDPERSONA")
	@NotNull(message = "La persona es requerida")
	private Long idPersona;
}
