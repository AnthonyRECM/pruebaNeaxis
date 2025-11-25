package com.antonio.neaxis.services;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.antonio.neaxis.dto.UsuarioRequest;
import com.antonio.neaxis.entities.Usuario;
import com.antonio.neaxis.entities.UsuarioResponse;
import com.antonio.neaxis.mappers.UsuarioMapper;
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
	
	private final UsuarioMapper usuarioMapper;
	
	private final PasswordEncoder passwordEncoder;
	
	@Override
	public List<UsuarioResponse> obtenerTodos() {
		List<UsuarioResponse> usuarios = usuarioRepository.findByEstado("ACTIVO").stream().map(usuarioMapper::entityToResponse).toList();
		return usuarios;
	}

	@Override
	public UsuarioResponse obtenerPorId(Long id) {
		Usuario usuario = obtenerUsuarioOrThrow(id);
		return usuarioMapper.entityToResponse(usuario);
	}

	@Override
	public UsuarioResponse insertar(UsuarioRequest request) {
		Usuario usuario = usuarioMapper.requestToEntity(request, passwordEncoder.encode(request.contraseña()), "ACTIVO");
		usuario = usuarioRepository.save(usuario);
		return usuarioMapper.entityToResponse(usuario);
	}

	@Override
	public UsuarioResponse actualizar(Long id, UsuarioRequest request) {
		Usuario usuario = obtenerUsuarioOrThrow(id);
		usuario.setUsuario(request.usuario());
		usuario.setContraseña(request.contraseña());
		usuario = usuarioRepository.save(usuario);
		return usuarioMapper.entityToResponse(usuario);
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
}
