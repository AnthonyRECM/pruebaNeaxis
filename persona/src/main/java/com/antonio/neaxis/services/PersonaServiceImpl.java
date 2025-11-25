package com.antonio.neaxis.services;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.antonio.neaxis.dto.PersonaRequest;
import com.antonio.neaxis.dto.PersonaResponse;
import com.antonio.neaxis.entities.Persona;
import com.antonio.neaxis.enums.Pais;
import com.antonio.neaxis.mappers.PersonaMapper;
import com.antonio.neaxis.repositories.PersonaRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PersonaServiceImpl implements PersonaService{
	
	private final PersonaRepository personaRepository;
	private final PersonaMapper personaMapper;
	
	@Override
	public List<PersonaResponse> obtenerTodos() {
		List<PersonaResponse> usuarios = personaRepository.findAll().stream()
				.map(p -> personaMapper.entityToResponse(p,p.getPais().getDescripcion()))
				.toList();
		return usuarios;
	}

	@Override
	public PersonaResponse obtenerPorId(Long id) {
		Persona persona= obtenerPersonaOrThrow(id);
		return personaMapper.entityToResponse(persona, persona.getPais().getDescripcion());
	}

	@Override
	public PersonaResponse insertar(PersonaRequest request) {
		Pais pais = Pais.fromCodigo(request.pais());
		Persona persona = personaMapper.requestToEntity(request, pais);
		persona = personaRepository.save(persona);
		return personaMapper.entityToResponse(persona, persona.getPais().getDescripcion());
	}

	@Override
	public PersonaResponse actualizar(Long id, PersonaRequest request) {
		Persona persona= obtenerPersonaOrThrow(id);
		Pais pais = Pais.fromCodigo(request.pais());
		persona.setNombres(request.nombres());
		persona.setApellidos(request.apellidos());
		persona.setSexo(request.sexo());
		persona.setPais(pais);
		persona.setDireccion(request.direccion());
		persona = personaRepository.save(persona);
		return personaMapper.entityToResponse(persona, persona.getPais().getDescripcion());
	}

	@Override
	public void eliminar(Long id) {
		Persona persona= obtenerPersonaOrThrow(id);
		personaRepository.deleteById(persona.getId());;
	}

	public Persona obtenerPersonaOrThrow(Long id) {
		return personaRepository.findById(id).orElseThrow(() -> 
		new NoSuchElementException("No se encontro la persona con id: " + id));
	}
}
