package com.antonio.neaxis.mappers;

import org.springframework.stereotype.Component;
import com.antonio.neaxis.clients.PersonaClient;
import com.antonio.neaxis.dto.PublicacionRequest;
import com.antonio.neaxis.dto.PublicacionResponse;
import com.antonio.neaxis.entities.Publicacion;

@Component
public class PublicacionMapper {

    private final PersonaClient persona;

    PublicacionMapper(PersonaClient persona) {
        this.persona = persona;
    }

	public PublicacionResponse entityToResponse(Publicacion entity, String persona) {
		if (entity == null) return null;
		return new PublicacionResponse(
				entity.getId(),
				persona,
				entity.getCuerpo()
				
		);
	}
	
	public Publicacion requestToEntity(PublicacionRequest request) {
		if (request == null) return null;
		Publicacion publicacion = new Publicacion();
		publicacion.setIdPersona(request.idPersona());
		publicacion.setCuerpo(request.cuerpo());
		return publicacion;
	}
}
