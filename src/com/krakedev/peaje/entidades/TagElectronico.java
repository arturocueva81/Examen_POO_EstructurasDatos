package com.krakedev.peaje.entidades;

public class TagElectronico {
	
	//Parte2: atributos
	private String idTag;
	private double saldo;
	private boolean activo;
	
	//Parte2: constructor principal
	public TagElectronico(String idTag) {
		this.idTag=idTag;
		this.saldo=0.0;
		this.activo=true;
	}
	
	//Parte2: getters y setters
	public String getIdTag() {
		return idTag;
	}

	public void setIdTag(String idTag) {
		this.idTag = idTag;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	
	//Parte2: metodo imprimir
	public void imprimir() {
		System.out.println(" -- INFORMACION TAG --");
		System.out.println("- ID: "+idTag);
		System.out.println("- Saldo: "+saldo);
		System.out.println("- Tag Activo: "+activo);
		System.out.println();
	}
	
	
	
	

}
