package com.krakedev.peaje.servicios;

public class EstacionPeaje {
	
	//Parte6: atributos con valores
	private int codigoEstacion = 500;
    private double tarifaLiviano = 1.00;
    private double tarifaPesado = 2.50;

    // Parte6: constructor vacio
    public EstacionPeaje() {
    }
    
    // Parte6: getters y seters
	public int getCodigoEstacion() {
		return codigoEstacion;
	}

	public void setCodigoEstacion(int codigoEstacion) {
		this.codigoEstacion = codigoEstacion;
	}

	public double getTarifaLiviano() {
		return tarifaLiviano;
	}

	public void setTarifaLiviano(double tarifaLiviano) {
		this.tarifaLiviano = tarifaLiviano;
	}

	public double getTarifaPesado() {
		return tarifaPesado;
	}

	public void setTarifaPesado(double tarifaPesado) {
		this.tarifaPesado = tarifaPesado;
	}

}
