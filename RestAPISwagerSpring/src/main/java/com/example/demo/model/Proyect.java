package com.example.demo.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity
public class Proyect implements Serializable{
	
	@Id
	@Column(name = "ID_PROYECT")
	@Schema(name = "idProyect", example = "1", required = true)
	private long idProyect;
	@Schema(name = "description", example = "Aplicacion gubernamental", required = true)
	private String description;
	@Schema(name = "language", example = "Java", required = true)
	private String language;
	@Schema(name = "open", example = "true", required = true)
	private boolean open;
	private Set<Code> codigos = new HashSet<Code>();
	public Set<Code> getCodigos() {
		return codigos;
	}
	public boolean agregarCodigo(Code c) {
		c.setProyecto(this);
		return getCodigos().add(c);
	}
	public void eliminaCodigo(Code c) {
		getCodigos().remove(c);
	}
	public void setCodigos(Set<Code> codigos) {
		this.codigos = codigos;
	}
	public long getId() {
		return idProyect;
	}
	public void setId(long id) {
		this.idProyect = id;
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
		this.idProyect = id;
		this.description = description;
		this.language = language;
		this.open = open;
	}
	
}
