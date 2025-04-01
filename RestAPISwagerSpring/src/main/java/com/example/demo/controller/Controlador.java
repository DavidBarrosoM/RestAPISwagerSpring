package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
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

import com.example.demo.model.Proyect;

@RestController
//@Tag(name = "Products API")
public class Controlador {

    @PostMapping("/proyect")
    public ResponseEntity<Void> createProduct(@RequestBody Proyect proyecto) {
        //creation logic
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @Operation(summary = "Get a product by id", description = "Returns a product as per the id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved"), 
            @ApiResponse(responseCode = "404", description = "Not found - The product was not found")
        })
    @GetMapping("/proyect/{id}")
    public ResponseEntity<Proyect> getProduct(@PathVariable Long id) {
        //retrieval logic
        return ResponseEntity.ok(new Proyect());
    }
}