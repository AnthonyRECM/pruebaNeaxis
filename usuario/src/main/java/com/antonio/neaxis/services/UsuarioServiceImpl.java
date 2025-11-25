package com.antonio.neaxis.services;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.antonio.neaxis.dto.RolResponse;
import com.antonio.neaxis.dto.UsuarioRequest;
import com.antonio.neaxis.dto.UsuarioResponse;
import com.antonio.neaxis.entities.Rol;
import com.antonio.neaxis.entities.Usuario;
import com.antonio.neaxis.mappers.RolMapper;
import com.antonio.neaxis.mappers.UsuarioMapper;
import com.antonio.neaxis.repositories.RolRepository;
import com.antonio.neaxis.repositories.UsuarioRepository;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Transactional
@Slf4j
public class UsuarioServiceImpl implements UsuarioService{
	
	private final UsuarioRepository usuarioRepository;
	
	private final RolRepository rolRepository;
	
	private final UsuarioMapper usuarioMapper;
	
	private final RolMapper rolMapper;
	
	private final PasswordEncoder passwordEncoder;
	
	@Override
	public List<UsuarioResponse> obtenerTodos() {
		
		List<UsuarioResponse> usuarios = usuarioRepository.findByEstado("ACTIVO").stream()
				.map(t -> 
				usuarioMapper.entityToResponse(t, rolesUsuario(t.getRoles() ) ) ).toList();
		return usuarios;
	}

	@Override
	public UsuarioResponse obtenerPorId(Long id) {
		Usuario usuario = obtenerUsuarioOrThrow(id);
		List<RolResponse> roles = rolesUsuario(usuario.getRoles());
		return usuarioMapper.entityToResponse(usuario, roles);
	}

	@Override
	public UsuarioResponse insertar(UsuarioRequest request) {
		Usuario usuario = usuarioMapper.requestToEntity(request, passwordEncoder.encode(request.contraseña()), "ACTIVO");
		
		List<Rol> roles = rolRepository.findAllById(request.idRoles());
		if (roles.size() != request.idRoles().size()) {
	        log.error("Uno o mas ID's de rol no fueron encontrados");
	        throw new IllegalArgumentException("Uno o mas roles proporcionados no son validos");
	    }
		usuario.setRoles(roles);
		
		usuario = usuarioRepository.save(usuario);

		return usuarioMapper.entityToResponse(usuario, rolesUsuario(usuario.getRoles()));
	}

	@Override
	public UsuarioResponse actualizar(Long id, UsuarioRequest request) {
		Usuario usuario = obtenerUsuarioOrThrow(id);
		usuario.setUsuario(request.usuario());
		usuario.setContraseña(passwordEncoder.encode(request.contraseña()));
		
		List<Long> nuevosRolesIds = request.idRoles();
	    List<Rol> nuevosRoles = rolRepository.findAllById(nuevosRolesIds);
	    
	    if (nuevosRoles.size() != nuevosRolesIds.size()) {
	        log.error("Error al actualizar usuario: uno o más IDs de rol no fueron encontrados.");
	        throw new IllegalArgumentException("Uno o más roles proporcionados no son válidos.");
	    }
	    
	    usuario.setRoles(nuevosRoles);
		
		usuario = usuarioRepository.save(usuario);
		return usuarioMapper.entityToResponse(usuario, rolesUsuario(usuario.getRoles()));
	}

	@Override
	public void eliminar(Long id) {
		Usuario usuario = obtenerUsuarioOrThrow(id);
		usuario.setEstado("INACTIVO");
		usuario = usuarioRepository.save(usuario);
	}

	public Usuario obtenerUsuarioOrThrow(Long id) {
		return usuarioRepository.findByIdAndEstado(id,"ACTIVO").orElseThrow(() -> 
		new NoSuchElementException("No se encontro el usuario con id: " + id));
	}	
	
	public List<RolResponse> rolesUsuario(List<Rol> roles){
		return roles.stream()
				.map(t -> rolMapper.entityToResponse(t))
				.toList();
	}
}
