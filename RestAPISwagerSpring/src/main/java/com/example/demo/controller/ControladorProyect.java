package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;

import com.example.demo.Repositories.RepositorioProyect;
import com.example.demo.model.Code;
import com.example.demo.model.Proyect;
import com.example.demo.service.Servicio;
import com.example.demo.service.ServicioCode;
import com.example.demo.service.ServicioProyect;

@RestController
@RequestMapping("/proyect")
@Tag(name = "Proyectos API")
public class ControladorProyect {
	@Autowired
	ServicioProyect servicio;
	
	@Operation(summary = "Crear proyecto", description = "Devuelve el proyecto creado y el codigo de respuesta")
	@ApiResponses(value = {
	        @ApiResponse(responseCode = "201", description = "Created - Proyect creado"),
	        @ApiResponse(responseCode = "400", description = "Bad Request - Fallo de sintaxis en uno de los campos")
	    })
    @PostMapping
    public ResponseEntity<?> createProyect(@RequestBody Proyect proyecto) {
    	if(servicio.create(proyecto)!=null) {
    		return ResponseEntity.status(HttpStatus.CREATED).body(proyecto);
    	}
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(proyecto);
    }
	
	@GetMapping(value="/{id}", produces="application/json")
	@Operation(summary = "Obten proyect por id", description = "Devuelve un proyecto por id")
	@ApiResponses(value = {
	        @ApiResponse(responseCode = "200", description = "Devuelto correctamente"),
	        @ApiResponse(responseCode = "404", description = "Not found - El proyect no se ha encontrado")
	    })
    public ResponseEntity<Proyect> getProyectById(@PathVariable("id") @Parameter(name = "id") Long id) {
        //retrieval logic
        return ResponseEntity.ok(servicio.findById(id));
    }
	
	@Operation(summary = "Obten proyects", description = "Devuelve todos los proyectos")
	@ApiResponses(value = {
	        @ApiResponse(responseCode = "200", description = "Devuelto correctamente")
	    })
    @GetMapping
    public ResponseEntity<List<Proyect>> getProyectAll() {
        return ResponseEntity.ok(servicio.readAll());
    }
	
	@Operation(summary = "Actualiza proyect por id", description = "Devuelve un proyecto por id")
	@ApiResponses(value = {
	        @ApiResponse(responseCode = "200", description = "Actualizado correctamente"),
	        @ApiResponse(responseCode = "404", description = "Not found - El proyect no se ha encontrado")
	    })
	@PutMapping("/{id}")
	public ResponseEntity<?> updateProyect(@PathVariable("id") @Parameter(name = "id") Long id,@RequestBody Proyect proyecto){
		if(servicio.update(proyecto,id)!= null) {
    		return ResponseEntity.status(HttpStatus.OK).body(proyecto);
    	}
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(proyecto);
	}
	
	@Operation(summary = "Borra proyect por id", description = "Devuelve si lo ha borrado o no")
	@ApiResponses(value = {
	        @ApiResponse(responseCode = "200", description = "Borrado correctamente"),
	        @ApiResponse(responseCode = "404", description = "Not found - El proyect no se ha encontrado")
	    })
    @DeleteMapping("/{id}")
    public ResponseEntity<?> borraProyectById(@PathVariable("id") @Parameter(name="id") Long id){
		if(servicio.delete(id)) {
			return ResponseEntity.status(HttpStatus.OK).body("Borrado correctamente");
		}return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found - El proyect no se ha encontrado");
    	
	}
}