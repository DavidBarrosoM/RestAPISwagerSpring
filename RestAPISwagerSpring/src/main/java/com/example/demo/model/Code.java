package com.example.demo.model;

import java.io.Serializable;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
@Entity
public class Code implements Serializable{
	@Id
	@Column(name = "ID_CODE")
	@Schema(name = "idcode", example = "1", required = true)
	private long idCode;
	@Schema(name = "Package", example = "com.proyectname.source", required = true)
	private String Package;
	@Schema(name = "File", example = "Codigo.java", required = true)
	private String File; 
	@ManyToOne
	@JoinColumn(name = "ID_PROYECT")
	private Proyect proyecto;
	public Proyect getProyecto() {
		return proyecto;
	}
	public void setProyecto(Proyect proyecto) {
		this.proyecto = proyecto;
	}
	public long getId() {
		return idCode;
	}
	public void setId(long id) {
		this.idCode = id;
	}
	public String getPackage() {
		return Package;
	}
	public void setPackage(String package1) {
		Package = package1;
	}
	public String getFile() {
		return File;
	}
	public void setFile(String file) {
		File = file;
	}
	public Code(long idCode, String package1, String file) {
		super();
		this.idCode = idCode;
		Package = package1;
		File = file;
	}
}
