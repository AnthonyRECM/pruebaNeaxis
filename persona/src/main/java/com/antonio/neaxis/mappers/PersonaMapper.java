package com.antonio.neaxis.mappers;

import org.springframework.stereotype.Component;

import com.antonio.neaxis.dto.PersonaRequest;
import com.antonio.neaxis.dto.PersonaResponse;
import com.antonio.neaxis.entities.Persona;
import com.antonio.neaxis.enums.Pais;

@Component
public class PersonaMapper {

	public PersonaResponse entityToResponse(Persona entity, String pais) {
		if (entity == null) return null;
		return new PersonaResponse(
				entity.getId(),
				entity.getNombres(),
				entity.getApellidos(),
				entity.getSexo(),
				pais,
				entity.getDireccion()
				
		);
	}
	
	public Persona requestToEntity(PersonaRequest request, Pais pais) {
		if (request == null) return null;
		Persona persona = new Persona();
		persona.setNombres(request.nombres());
		persona.setApellidos(request.apellidos());
		persona.setSexo(request.sexo());
		persona.setPais(pais);
		persona.setDireccion(request.direccion());
		return persona;
	}
}
