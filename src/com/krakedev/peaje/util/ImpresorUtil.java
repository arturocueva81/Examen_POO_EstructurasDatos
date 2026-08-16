package com.krakedev.peaje.util;

import com.krakedev.peaje.entidades.Vehiculo;

public class ImpresorUtil {
	
	public static void imprimirVehiculo(Vehiculo vehiculo) {
		//Parte 4 mostrar informacion de los objetos compuestos
		System.out.println("INFORMACION DEL VEHICULO");
		vehiculo.imprimir();
		vehiculo.getPropietario().imprimir();
		vehiculo.getTag().imprimir();
		System.out.println("");		
		
	}
}
