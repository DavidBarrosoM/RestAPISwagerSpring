package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repositories.RepositorioProyect;
import com.example.demo.model.Code;
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
	HashMap<Long,Code> codigos = new HashMap<>();
	public List<Proyect> getAllProyectos() {
        return new ArrayList<>(proyectos.values());
    }
	public Proyect getById(Long id) {
		return proyectos.get(id);
	}
	public boolean agregarProyecto(Proyect p) {
		return proyectos.put((long)proyectos.size(),p) != null;
	}
	public boolean eliminaProyecto(Long id) {
		if(proyectos.containsKey(id)) {
			proyectos.remove(id);
			return true;
		}
		return false;
	}
	
	public boolean actualizaProyecto(Proyect p,Long id) {
		if(proyectos.containsKey(id)) {
			p.setId(id);
			return proyectos.put(id,p)!=null;
		}return false;
	}
	
	public boolean agregarCodigo(Code c) {
		return codigos.put((long)codigos.size(),c) != null;
	}
}
