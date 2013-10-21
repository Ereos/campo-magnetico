package com.example.campomagnetico;


public class Componente {
	
	private String nombre;
	private String descripcion;
	private int idFoto;
	
	public Componente(String nombre, String descripcion, int idFoto) {
		this.nombre = nombre;
		this.descripcion = descripcion;
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
	public int getIdFoto() {
		return idFoto;
	}
	public void setIdFoto(int idFoto) {
		this.idFoto = idFoto;
	}
	
	
	

}
