package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.ServicioUser;
import com.example.demo.model.User;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "Proyectos API")
@RequestMapping("/user")
public class ControladorUser {
	@Autowired
	ServicioUser servicio;
	
	@GetMapping
	@Operation(summary = "Obten users", description = "Devuelve todos los usuarios")
	@ApiResponses(value = {
	        @ApiResponse(responseCode = "200", description = "Devuelto correctamente")
	    })
	public ResponseEntity<List<User>> findAll(){
		return ResponseEntity.ok(servicio.readAll());
	}
	
}
