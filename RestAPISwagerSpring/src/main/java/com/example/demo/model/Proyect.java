package com.example.demo.model;

import java.io.Serializable;



import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity
public class Proyect implements Serializable{
	
	@Id
	private long id;
	private String description;
	private String language;
	private boolean open;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public boolean isOpen() {
		return open;
	}
	public void setOpen(boolean open) {
		this.open = open;
	}
	
	public Proyect(long id, String description, String language, boolean open) {
		super();
		this.id = id;
		this.description = description;
		this.language = language;
		this.open = open;
	}
	
}
