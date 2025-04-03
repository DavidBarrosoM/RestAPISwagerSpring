package com.example.demo.Repositories;


import java.util.List;

public interface Repositorio<T> {
	T create(T entity);
	List<T> readAll();
	T findById(Long id);
	T update(T entity, Long id);
	public boolean delete(Long id);
}
