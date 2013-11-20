package com.example.campomagnetico;

import java.util.ArrayList;


public class Componente {
	
	private String nombre;
	private String descripcion;
	private int idFotoMini;
	private int idFoto;
	
	public Componente(String nombre, String descripcion, int idFotoMini, int idFoto) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.idFotoMini = idFotoMini;
		this.idFoto = idFoto;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getIdFotoMini() {
		return idFotoMini;
	}
	public void setIdFotoMini(int idFotoMini) {
		this.idFotoMini = idFotoMini;
	}
	
	public int getIdFoto() {
		return idFoto;
	}

	public void setIdFoto(int idFoto) {
		this.idFoto = idFoto;
	}
}
