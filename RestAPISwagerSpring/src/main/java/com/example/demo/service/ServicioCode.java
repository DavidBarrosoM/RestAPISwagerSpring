package com.example.demo.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.example.demo.Repositories.Repositorio;
import com.example.demo.model.Code;

public class ServicioCode implements Repositorio<Code>{
	HashMap<Long,Code> codigos = new HashMap<>();

	@Override
	public Code findById(Long id) {
		return codigos.get(id);
	}

	@Override
	public Code update(Code c, Long id) {
		if(codigos.containsKey(id)) {
			c.setId(id);
			return codigos.put(id,c);
		}
		return null;
	}

	@Override
	public boolean delete(Long id) {
		if(codigos.containsKey(id)) {
			codigos.remove(id);
			return true;
		}
		return false;
		
	}

	@Override
	public Code create(Code c) {
		return codigos.put((long)codigos.size(),c);
	}

	@Override
	public List<Code> readAll() {
		return new ArrayList<>(codigos.values());
	}
	
}
