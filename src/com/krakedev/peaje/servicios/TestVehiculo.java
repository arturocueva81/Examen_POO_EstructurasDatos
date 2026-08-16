package com.krakedev.peaje.servicios;

import com.krakedev.peaje.entidades.Conductor;
import com.krakedev.peaje.entidades.TagElectronico;
import com.krakedev.peaje.entidades.Vehiculo;
import com.krakedev.peaje.util.ImpresorUtil;

public class TestVehiculo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Parte8 TestVehiculo
		//crear conductor
		Conductor conductor = new Conductor("1234567890", "Arturo", "Cueva");
        //crear vehiculo
		Vehiculo v1 = new Vehiculo("ABC-1234");
        //crear tag
		TagElectronico tag = new TagElectronico("T001");
		
		//asociar objetos mediante composición
        v1.setPropietario(conductor);
        v1.setTag(tag);
        
        //ejecutar imprimir()
        v1.imprimir();
        conductor.imprimir();
        tag.imprimir();
        
        //ejecutar ImpresorUtil
        ImpresorUtil.imprimirVehiculo(v1);
        
        //probar métodos de negocio
        EstacionPeaje estacion = new EstacionPeaje();
        
        Vehiculo v2 = estacion.registrarVehiculo("XYZ-9999", "L", conductor, "TAG-002");
        ImpresorUtil.imprimirVehiculo(v2);

        estacion.recargarTag(10.0, v2.getTag());
        System.out.println("Saldo tras recarga: " + v2.getTag().getSaldo());

        estacion.cobrarPeaje(v2);
        System.out.println("Saldo tras peaje: " + v2.getTag().getSaldo());

	}

}
