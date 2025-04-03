package com.example.demo.model;

import java.io.Serializable;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity
public class User implements Serializable{
	@Id
	@Schema(name = "idUser", example = "1", required = true)
	private Long idUser;
	private String nick;
	private String name;
	public Long getId() {
		return idUser;
	}
	public void setId(Long id) {
		this.idUser = id;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public User(Long idUser, String nick, String name) {
		super();
		this.idUser = idUser;
		this.nick = nick;
		this.name = name;
	}
	
}
