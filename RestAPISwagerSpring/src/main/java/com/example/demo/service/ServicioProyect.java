package com.example.demo.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.example.demo.Repositories.Repositorio;
import com.example.demo.model.Proyect;

public class ServicioProyect implements Repositorio<Proyect>{
	HashMap<Long,Proyect> proyectos = new HashMap<>();
	@Override
	public Proyect create(Proyect p) {
		return proyectos.put((long)proyectos.size(),p);
	}

	@Override
	public List<Proyect> readAll() {
		return new ArrayList<>(proyectos.values());
	}

	@Override
	public Proyect findById(Long id) {
		return proyectos.get(id);
	}

	@Override
	public Proyect update(Proyect p, Long id) {
		if(proyectos.containsKey(id)) {
			p.setId(id);
			return proyectos.put(id,p);
		}return null;
	}

	@Override
	public boolean delete(Long id) {
		if(proyectos.containsKey(id)) {
			proyectos.remove(id);
			return true;
		}
		return false;
	}

}
