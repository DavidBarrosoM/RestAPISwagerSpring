package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.ServicioUser;
import com.example.demo.model.User;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
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
	
	@Operation(summary = "Borra user por id", description = "Devuelve si lo ha borrado o no")
	@ApiResponses(value = {
	        @ApiResponse(responseCode = "200", description = "Borrado correctamente"),
	        @ApiResponse(responseCode = "404", description = "Not found - El proyect no se ha encontrado")
	    })
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") @Parameter(name="id") Long id){
		if(servicio.delete(id)) {
			return ResponseEntity.status(HttpStatus.OK).body("Borrado correctamente");
		}return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found - El proyect no se ha encontrado");
    	
    }
	
	@Operation(summary = "Crear código", description = "Devuelve el código creado y el código de respuesta")
	@ApiResponses(value = {
	        @ApiResponse(responseCode = "201", description = "Created - Code creado"),
	        @ApiResponse(responseCode = "400", description = "Bad Request - Fallo de sintaxis en uno de los campos")
	    })
    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody User usuario) {
    	if(servicio.create(usuario)!=null) {
    		return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
    	}
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(usuario);
    }
	
	@GetMapping(value="/{id}", produces="application/json")
	@Operation(summary = "Obten user por id", description = "Devuelve un user por id")
	@ApiResponses(value = {
	        @ApiResponse(responseCode = "200", description = "Devuelto correctamente"),
	        @ApiResponse(responseCode = "404", description = "Not found - El user no se ha encontrado")
	    })
    public ResponseEntity<User> getUsertById(@PathVariable("id") @Parameter(name = "id") Long id) {
        return ResponseEntity.ok(servicio.findById(id));
    }
}
