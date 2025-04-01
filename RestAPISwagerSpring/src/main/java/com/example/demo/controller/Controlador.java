package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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

@RestController
//@Tag(name = "Products API")
public class Controlador {
	RepositorioProyect repProyect = new RepositorioProyect() {
		
		@Override
		public <S extends Proyect> Iterable<S> saveAll(Iterable<S> entities) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public <S extends Proyect> S save(S entity) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public Optional<Proyect> findById(Long id) {
			// TODO Auto-generated method stub
			return Optional.empty();
		}
		
		@Override
		public Iterable<Proyect> findAllById(Iterable<Long> ids) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public boolean existsById(Long id) {
			// TODO Auto-generated method stub
			return false;
		}
		
		@Override
		public void deleteById(Long id) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void deleteAllById(Iterable<? extends Long> ids) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void deleteAll(Iterable<? extends Proyect> entities) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void deleteAll() {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void delete(Proyect entity) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public long count() {
			// TODO Auto-generated method stub
			return 0;
		}
		
		@Override
		public ArrayList<Proyect> findAll() {
			// TODO Auto-generated method stub
			return null;
		}
	};
    @PostMapping("/proyect")
    public ResponseEntity<Void> createProduct(@RequestBody Proyect proyecto) {
        //creation logic
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @Operation(summary = "Devuelve un proyecto por id", description = "Devuelve un proyecto por id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved"), 
            @ApiResponse(responseCode = "404", description = "Not found - El proyecto no se ha encontrado")
        })
    @GetMapping("/proyect/{id}")
    public ResponseEntity<Proyect> getProduct(@PathVariable Long id) {
        //retrieval logic
        return ResponseEntity.ok(new Proyect());
    }
    @GetMapping("/proyect")
    public ResponseEntity<ArrayList<Proyect>> buscarTodosProyectos(){
    	return ResponseEntity.ok(repProyect.findAll());
    }
}