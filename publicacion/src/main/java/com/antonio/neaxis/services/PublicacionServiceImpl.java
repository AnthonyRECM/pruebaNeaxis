package com.antonio.neaxis.services;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.antonio.neaxis.clients.PersonaClient;
import com.antonio.neaxis.dto.PersonaResponse;
import com.antonio.neaxis.dto.PublicacionRequest;
import com.antonio.neaxis.dto.PublicacionResponse;
import com.antonio.neaxis.entities.Publicacion;
import com.antonio.neaxis.mappers.PublicacionMapper;
import com.antonio.neaxis.repositories.PublicacionRepository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j
public class PublicacionServiceImpl implements PublicacionService{
	
	private final PublicacionRepository publicacionRepository;
	private final PublicacionMapper publicacionMapper;
	private final PersonaClient personaClient;
	
	@Override
	public List<PublicacionResponse> obtenerTodos() {
		
		List<PublicacionResponse> usuarios = publicacionRepository.findAll().stream()
				.map(p -> publicacionMapper.entityToResponse(p, nombrePersona(p.getIdPersona() ) ) )
				.toList();
		return usuarios;
	}

	@Override
	public PublicacionResponse obtenerPorId(Long id) {
		Publicacion publicacion= obtenerPublicacionOrThrow(id);
		String persona =  nombrePersona(publicacion.getIdPersona());
		return publicacionMapper.entityToResponse(publicacion, persona);
	}
	

	@Override
	public PublicacionResponse insertar(PublicacionRequest request) {
		Publicacion publicacion = publicacionMapper.requestToEntity(request);
		log.info("Buscando persona con id: "+ request.idPersona());
		personaClient.obtenerPersona(request.idPersona());
		String persona =  nombrePersona(publicacion.getIdPersona());
		
		publicacion = publicacionRepository.save(publicacion);
		return publicacionMapper.entityToResponse(publicacion, persona);
	}

	public Publicacion obtenerPublicacionOrThrow(Long id) {
		return publicacionRepository.findById(id).orElseThrow(() -> 
		new NoSuchElementException("No se encontro la publicacion con id: " + id));
	}
	
	public String nombrePersona(Long id) {
		return personaClient.obtenerPersona(id).nombres()
		+ " " + personaClient.obtenerPersona(id).apellidos();
	}
}
