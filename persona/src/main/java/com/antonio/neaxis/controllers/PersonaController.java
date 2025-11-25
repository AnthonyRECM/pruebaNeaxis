package com.antonio.neaxis.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.antonio.neaxis.dto.PersonaRequest;
import com.antonio.neaxis.dto.PersonaResponse;
import com.antonio.neaxis.services.PersonaService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@Validated
@AllArgsConstructor
public class PersonaController {
	
	private final PersonaService service;

	@GetMapping()
	public ResponseEntity<List<PersonaResponse>> obtenerTodos(){
		return ResponseEntity.ok(service.obtenerTodos());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<PersonaResponse> obtenerPorId(@PathVariable Long id){
		return ResponseEntity.ok(service.obtenerPorId(id));
	}
	
	@PostMapping()
	public ResponseEntity<PersonaResponse> registrar(@Valid @RequestBody PersonaRequest request){
		return ResponseEntity.status(HttpStatus.CREATED).body(service.insertar(request));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<PersonaResponse> actualizar(@PathVariable Long id, @RequestBody PersonaRequest request){
		return ResponseEntity.ok(service.actualizar(id, request));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<PersonaResponse> eliminar(@PathVariable Long id){
		service.eliminar(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}
