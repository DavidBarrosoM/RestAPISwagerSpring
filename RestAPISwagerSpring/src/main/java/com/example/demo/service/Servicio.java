package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repositories.RepositorioProyect;
import com.example.demo.model.Proyect;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
@Service
public class Servicio {
	//@Autowired
	//RepositorioProyect repProyect;
	HashMap<Long,Proyect> proyectos = new HashMap<>();
	public List<Proyect> getAllProyectos() {
        return new ArrayList<>(proyectos.values());
    }
	public Proyect getById(Long id) {
		return proyectos.get(id);
		/*
		 * Optional<Proyect> p = repProyect.findById(id);
		if(p.isPresent()) {
			return p.get();
		}
		return null;
		*/
	}
	public void agregarProyecto(Proyect p) {
		proyectos.put((long)proyectos.size(),p);
	}
	public void eliminaProyecto(Long id) {
		proyectos.remove(id);
	}
}
