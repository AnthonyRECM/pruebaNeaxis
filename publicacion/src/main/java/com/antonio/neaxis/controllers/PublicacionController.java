package com.antonio.neaxis.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.antonio.neaxis.dto.PublicacionRequest;
import com.antonio.neaxis.dto.PublicacionResponse;
import com.antonio.neaxis.services.PublicacionService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@Validated
@AllArgsConstructor
public class PublicacionController {
	
	private final PublicacionService service;

	@GetMapping()
	public ResponseEntity<List<PublicacionResponse>> obtenerTodos(){
		return ResponseEntity.ok(service.obtenerTodos());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<PublicacionResponse> obtenerPorId(@PathVariable Long id){
		return ResponseEntity.ok(service.obtenerPorId(id));
	}
	
	@PostMapping()
	public ResponseEntity<PublicacionResponse> registrar(@Valid @RequestBody PublicacionRequest request){
		return ResponseEntity.status(HttpStatus.CREATED).body(service.insertar(request));
	}
}
