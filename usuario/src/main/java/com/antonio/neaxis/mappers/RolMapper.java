package com.antonio.neaxis.mappers;

import org.springframework.stereotype.Component;

import com.antonio.neaxis.dto.RolRequest;
import com.antonio.neaxis.dto.RolResponse;
import com.antonio.neaxis.entities.Rol;

@Component
public class RolMapper {

	public RolResponse entityToResponse(Rol entity) {
		if (entity == null) return null;
		
		return new RolResponse(
				entity.getId(),
				entity.getTipo()
		);
	}
	
	public Rol requestToEntity(RolRequest request) {
		if (request == null) return null;
		Rol rol = new Rol();
		rol.setTipo(request.tipo());
		return rol;
	}
}
