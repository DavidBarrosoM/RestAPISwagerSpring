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

import com.example.demo.model.Code;
import com.example.demo.model.Proyect;
import com.example.demo.service.ServicioCode;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "Proyectos API")
@RequestMapping("/code")
public class ControladorCode {
	@Autowired
	ServicioCode servicio;
	
	@GetMapping
	@Operation(summary = "Obten codes", description = "Devuelve todos los codigos")
	@ApiResponses(value = {
	        @ApiResponse(responseCode = "200", description = "Devuelto correctamente")
	    })
	public ResponseEntity<List<Code>> findAll(){
		return ResponseEntity.ok(servicio.readAll());
	}
	
	@Operation(summary = "Borra code por id", description = "Devuelve si lo ha borrado o no")
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
    public ResponseEntity<?> createCode(@RequestBody Code codigo) {
    	if(servicio.create(codigo)!=null) {
    		return ResponseEntity.status(HttpStatus.CREATED).body(codigo);
    	}
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(codigo);
    }
	
	@GetMapping(value="/{id}", produces="application/json")
	@Operation(summary = "Obten code por id", description = "Devuelve un code por id")
	@ApiResponses(value = {
	        @ApiResponse(responseCode = "200", description = "Devuelto correctamente"),
	        @ApiResponse(responseCode = "404", description = "Not found - El code no se ha encontrado")
	    })
    public ResponseEntity<Code> getCodetById(@PathVariable("id") @Parameter(name = "id") Long id) {
        //retrieval logic
        return ResponseEntity.ok(servicio.findById(id));
    }
}
