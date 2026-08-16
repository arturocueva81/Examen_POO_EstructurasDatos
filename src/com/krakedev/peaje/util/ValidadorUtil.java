package com.krakedev.peaje.util;

public class ValidadorUtil {
	
	//Parte5: validador de monto
	public boolean esMontoValido(double monto) {
		if(monto >0) {
		return true;
		}
		return false;
	}
	
	//Parte5: Validador de tipo L o P
	public boolean esTipoValido(String tipo) {
		if(tipo.equals("L")||tipo.equals("P")) {
			return true;
		}
		return false;
	}

}
