package com.antonio.neaxis.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "USUARIOS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "USUARIO", nullable = false)
	@NotNull(message = "El usuario es requerido")
	private String usuario;
	
	@Column(name = "CONTRASEÑA", nullable = false)
	@NotNull(message = "La contraseña es requerida")
	private String contraseña;
	
	@Column(name = "ESTADO", nullable = false)
	private String estado;
	
	@ManyToMany
	@JoinTable(
			name = "USUARIOROL",
			joinColumns = @JoinColumn(name = "ID_USUARIO"),
			inverseJoinColumns = @JoinColumn(name = "ID_ROL")
	)
	private List<Rol> roles;
}
