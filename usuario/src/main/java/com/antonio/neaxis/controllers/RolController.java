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

import com.antonio.neaxis.dto.RolRequest;
import com.antonio.neaxis.dto.RolResponse;
import com.antonio.neaxis.services.RolService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@Validated
@AllArgsConstructor
public class RolController {
	
	private final RolService service;

	@GetMapping("/roles")
	public ResponseEntity<List<RolResponse>> obtenerTodos(){
		return ResponseEntity.ok(service.obtenerTodos());
	}
	
	@GetMapping("/roles/{id}")
	public ResponseEntity<RolResponse> obtenerPorId(@PathVariable Long id){
		return ResponseEntity.ok(service.obtenerPorId(id));
	}
	
	@PostMapping("/roles")
	public ResponseEntity<RolResponse> registrar(@Valid @RequestBody RolRequest request){
		return ResponseEntity.status(HttpStatus.CREATED).body(service.insertar(request));
	}
	
	@PutMapping("/roles/{id}")
	public ResponseEntity<RolResponse> actualizar(@PathVariable Long id, @RequestBody RolRequest request){
		return ResponseEntity.ok(service.actualizar(id, request));
	}
	
	@DeleteMapping("/roles/{id}")
	public ResponseEntity<RolResponse> eliminar(@PathVariable Long id){
		service.eliminar(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}
