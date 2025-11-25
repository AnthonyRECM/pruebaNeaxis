package com.antonio.neaxis.services;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.antonio.neaxis.dto.RolRequest;
import com.antonio.neaxis.dto.RolResponse;
import com.antonio.neaxis.entities.Rol;
import com.antonio.neaxis.mappers.RolMapper;
import com.antonio.neaxis.repositories.RolRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RolServiceImpl implements RolService{
	
	private final RolRepository rolRepository;
	private final RolMapper rolMapper;

	@Override
	public List<RolResponse> obtenerTodos() {
		List<RolResponse> usuarios = rolRepository.findAll().stream().map(rolMapper::entityToResponse).toList();
		return usuarios;
	}

	@Override
	public RolResponse obtenerPorId(Long id) {
		Rol rol= obtenerRolOrThrow(id);
		return rolMapper.entityToResponse(rol);
	}

	@Override
	public RolResponse insertar(RolRequest request) {
		Rol rol = rolMapper.requestToEntity(request);
		rol = rolRepository.save(rol);
		return rolMapper.entityToResponse(rol);
	}

	@Override
	public RolResponse actualizar(Long id, RolRequest request) {
		Rol rol= obtenerRolOrThrow(id);
		rol.setTipo(request.tipo());
		rol = rolRepository.save(rol);
		return rolMapper.entityToResponse(rol);
	}

	@Override
	public void eliminar(Long id) {
		Rol rol= obtenerRolOrThrow(id);
		rolRepository.deleteById(rol.getId());;
	}

	public Rol obtenerRolOrThrow(Long id) {
		return rolRepository.findById(id).orElseThrow(() -> 
		new NoSuchElementException("No se encontro el rol con id: " + id));
	}
}
