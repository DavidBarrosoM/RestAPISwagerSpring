package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repositories.RepositorioProyect;
import com.example.demo.model.Proyect;
import java.util.ArrayList;
import java.util.Optional;
@Service
public class Servicio {
	@Autowired
	RepositorioProyect repProyect;
	public ArrayList<Proyect> getAll(){
		return (ArrayList<Proyect>) repProyect.findAll();
	}
	public Proyect getById(Long id) {
		Optional<Proyect> p = repProyect.findById(id);
		if(p.isPresent()) {
			return p.get();
		}
		return null;
	}
	//public void 
}
