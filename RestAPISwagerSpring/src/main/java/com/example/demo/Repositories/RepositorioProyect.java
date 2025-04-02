package com.example.demo.Repositories;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Proyect;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
//import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@Repository
public interface RepositorioProyect extends CrudRepository<Proyect,Long> {
	//public ArrayList<Proyect> findAll();
}
