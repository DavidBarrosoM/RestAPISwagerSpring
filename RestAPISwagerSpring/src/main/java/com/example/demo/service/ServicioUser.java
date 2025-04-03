package com.example.demo.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.example.demo.Repositories.Repositorio;
import com.example.demo.model.User;

public class ServicioUser implements Repositorio<User> {
	HashMap<Long,User> usuarios = new HashMap<>();
	@Override
	public User create(User u) {
		return usuarios.put((long)usuarios.size(),u);
	}

	@Override
	public List<User> readAll() {
		return new ArrayList<>(usuarios.values());
	}

	@Override
	public User findById(Long id) {
		return usuarios.get(id);
	}

	@Override
	public User update(User u, Long id) {
		if(usuarios.containsKey(id)) {
			u.setId(id);
			return usuarios.put(id,u);
		}
		return null;
	}

	@Override
	public boolean delete(Long id) {
		if(usuarios.containsKey(id)) {
			usuarios.remove(id);
			return true;
		}
		return false;
	}

}
