package com.krakedev.peaje.servicios;

import com.krakedev.peaje.entidades.Conductor;
import com.krakedev.peaje.entidades.TagElectronico;
import com.krakedev.peaje.entidades.Vehiculo;
import com.krakedev.peaje.util.ValidadorUtil;

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
	
	//Parte7: Metodos de negocio
	//registrarVehiculo
	public Vehiculo registrarVehiculo(String placa, String tipo, Conductor conductor, String idTag) {
	    ValidadorUtil validador = new ValidadorUtil();
	    boolean tipoValido = validador.esTipoValido(tipo);
	    
	    if (tipoValido == true) {
	        Vehiculo vehiculo = new Vehiculo(placa);
	        vehiculo.setTipo(tipo);
	        vehiculo.setPropietario(conductor);
	        TagElectronico tag = new TagElectronico(idTag);
	        vehiculo.setTag(tag);
	        return vehiculo;
	    } else {
	        return null;
	    }
	}
	
	//recargarTag
	public boolean recargarTag(double monto, TagElectronico tag) {
		ValidadorUtil validador = new ValidadorUtil();
	    boolean montoValido = validador.esMontoValido(monto);
	    
	    if (montoValido == true) {
	        tag.setSaldo(tag.getSaldo() + monto);
	        return true;
	    } else {
	        return false;
	    }
	}
	
	//cobrarPeaje
	public boolean cobrarPeaje(Vehiculo vehiculo) {
		ValidadorUtil validador = new ValidadorUtil();
	    boolean tipoValido = validador.esTipoValido(vehiculo.getTipo());
	    
	    if (tipoValido == false) {
	        return false;
	    }
	    
	    double tarifa;
	    
	    if (vehiculo.getTipo().equals("L")) {
	        tarifa = tarifaLiviano;
	    } else {
	        tarifa = tarifaPesado;
	    }
	    
	    boolean saldoSuficiente = vehiculo.getTag().getSaldo() >= tarifa;
	    
	    if (saldoSuficiente == true) {
	        vehiculo.getTag().setSaldo(vehiculo.getTag().getSaldo() - tarifa);
	        return true;
	    } else {
	        return false;
	    }
	}
	
	//transferirSaldoTag
	public boolean transferirSaldoTag(TagElectronico origen, TagElectronico destino, double monto) {
		ValidadorUtil validador = new ValidadorUtil();
	    boolean montoValido = validador.esMontoValido(monto);
	    
	    if (montoValido == false) {
	        return false;
	    }
	    
	    boolean saldoSuficiente = monto <= origen.getSaldo();
	    
	    if (saldoSuficiente == true) {
	        origen.setSaldo(origen.getSaldo() - monto);
	        destino.setSaldo(destino.getSaldo() + monto);
	        return true;
	    } else {
	        return false;
	    }
	}

}
