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
import com.example.demo.model.Proyect;
import com.example.demo.service.Servicio;

@RestController
@Tag(name = "Products API")
public class Controlador {
	@Autowired
	Servicio servicio;
    @PostMapping("/proyect")
    public ResponseEntity<?> createProyect(@RequestBody Proyect proyecto) {
        //creation logic
    	servicio.agregarProyecto(proyecto);
        return ResponseEntity.status(HttpStatus.CREATED).body(proyecto);
    	//return ResponseEntity(servicio.agregarProyecto(proyecto),HttpStatus.CREATED);
    }
    /*
     * @PostMapping("")
    public ResponseEntity<?> createPelicula(@RequestBody Pelicula pelicula) {
        
        if (repositorio.findByNombre(pelicula.getNombre()).isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("NOMBRE YA EXISTENTE");
        }
        Pelicula savedPelicula = repositorio.save(pelicula);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPelicula);
    }
     * */
    @GetMapping("/proyect/{id}")
    public ResponseEntity<Proyect> getProyectById(@PathVariable("id") @Parameter(name = "id") Long id) {
        //retrieval logic
        return ResponseEntity.ok(servicio.getById(id));
    }
    @GetMapping("/proyect")
    public ResponseEntity<List<Proyect>> getProyectAll() {
        //retrieval logic
        return ResponseEntity.ok(servicio.getAllProyectos());
    }
    
    @DeleteMapping("/proyect/{id}")
    public ResponseEntity<?> borraProyectById(@PathVariable("id") @Parameter(name="id") Long id){
    	return ResponseEntity.status(HttpStatus.ACCEPTED).body("Borrado");
    }
    
    /*@Operation(summary = "Devuelve un proyecto por id", description = "Devuelve un proyecto por id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved"), 
            @ApiResponse(responseCode = "404", description = "Not found - El proyecto no se ha encontrado")
        })*/
   /* @GetMapping("/proyect/{id}")
    public ResponseEntity<Proyect> getProduct(@PathVariable Long id) {
        //retrieval logic
        return ResponseEntity.ok(new Proyect());
    }*/
   /* @GetMapping("/proyect")
    public ResponseEntity<ArrayList<Proyect>> buscarTodosProyectos(){
    	//return ResponseEntity.ok(repProyect.findAll());
    	return ResponseEntity.ok();

    }*/
}