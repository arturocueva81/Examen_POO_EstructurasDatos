package com.krakedev.peaje.entidades;

public class Vehiculo {
	
	//Parte 3: atributos y objetos
	private String placa;
	private String tipo;
	private Conductor propietario;
	private TagElectronico tag;
	
	//Parte3: Constructor e instancias
	public Vehiculo(String placa) {
		this.placa= placa;
		this.tipo = "L";
		this.propietario=new Conductor();
		this.tag=new TagElectronico(placa);
	}

	//Parte3: getters y setters
	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Conductor getPropietario() {
		return propietario;
	}

	public void setPropietario(Conductor propietario) {
		this.propietario = propietario;
	}

	public TagElectronico getTag() {
		return tag;
	}

	public void setTag(TagElectronico tag) {
		this.tag = tag;
	}
	
	//parte3: metodo imprimir
	public void imprimir() {
		System.out.println(" - DATOS VEHICULO --");
		System.out.println(" - Placa: "+placa);
		System.out.println(" - Tipo: "+tipo);
		System.out.println("");
	}

}
