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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> readAll() {
		return new ArrayList<>(usuarios.values());
	}

	@Override
	public User findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User update(User u, Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(Long id) {
		// TODO Auto-generated method stub
		return true;
	}

}
