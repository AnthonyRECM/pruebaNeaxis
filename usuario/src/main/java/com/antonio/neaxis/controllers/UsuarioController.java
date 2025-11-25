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

import com.antonio.neaxis.dto.UsuarioRequest;
import com.antonio.neaxis.entities.UsuarioResponse;
import com.antonio.neaxis.services.UsuarioService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@Validated
@AllArgsConstructor
public class UsuarioController {
	
	private final UsuarioService service;

	@GetMapping()
	public ResponseEntity<List<UsuarioResponse>> obtenerTodos(){
		return ResponseEntity.ok(service.obtenerTodos());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UsuarioResponse> obtenerPorId(@PathVariable Long id){
		return ResponseEntity.ok(service.obtenerPorId(id));
	}
	
	@PostMapping()
	public ResponseEntity<UsuarioResponse> registrar(@Valid @RequestBody UsuarioRequest request){
		return ResponseEntity.status(HttpStatus.CREATED).body(service.insertar(request));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<UsuarioResponse> actualizar(@PathVariable Long id, @RequestBody UsuarioRequest request){
		return ResponseEntity.ok(service.actualizar(id, request));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<UsuarioResponse> eliminar(@PathVariable Long id){
		service.eliminar(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}
