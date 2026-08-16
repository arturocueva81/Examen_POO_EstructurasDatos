package com.krakedev.peaje.entidades;

public class Conductor {
	//PARTE1: atributos
	private String cedula;
	private String nombre;
	private String apellido;
	
	//PARTE1: constructor
	public Conductor(String cedula,String nombre, String apellido) {
		this.cedula=cedula;
		this.nombre=nombre;
		this.apellido=apellido;
	}
	
	
	//PART1: constructor vacio
	public Conductor() {}

	//PARTE1: getters y setters
	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	//PARTE1:metodo imprimir
	public void imprimir() {
		System.out.println("-- INFORMACION DEL CONDUCTOR --");
		System.out.println(" - Cedula: "+cedula);
		System.out.println(" - Nombre: "+nombre);
		System.out.println(" - Apellido: "+apellido);
		System.out.println(" ");
	}
	
}
