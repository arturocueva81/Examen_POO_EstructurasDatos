package com.krakedev.peaje.servicios;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.krakedev.peaje.entidades.Conductor;
import com.krakedev.peaje.entidades.TagElectronico;
import com.krakedev.peaje.entidades.Vehiculo;

public class TestEstacionPeajeJUnit {
	//parte8 prubas unitarias
	//registrarVehiculo (4)
	
	@Test
	public void testRegistrarVehiculoTipoPesado() {
	    EstacionPeaje estacion = new EstacionPeaje();
	    Conductor conductor = new Conductor("0912345678", "Juan", "Pérez");
	    Vehiculo vehiculo = estacion.registrarVehiculo("XYZ-9999", "P", conductor, "TAG-002");
	    assertNotNull(vehiculo);
	    assertEquals("P", vehiculo.getTipo());
	}

	@Test
	public void testRegistrarVehiculoTipoInvalido() {
	    EstacionPeaje estacion = new EstacionPeaje();
	    Conductor conductor = new Conductor("0912345678", "Juan", "Pérez");
	    Vehiculo vehiculo = estacion.registrarVehiculo("AAA-0000", "X", conductor, "TAG-003");
	    assertNull(vehiculo);
	}

	@Test
	public void testRegistrarVehiculoPropietarioAsignado() {
	    EstacionPeaje estacion = new EstacionPeaje();
	    Conductor conductor = new Conductor("0912345678", "Juan", "Pérez");
	    Vehiculo vehiculo = estacion.registrarVehiculo("ABC-1234", "L", conductor, "TAG-001");
	    assertEquals("0912345678", vehiculo.getPropietario().getCedula());
	}

	@Test
	public void testRegistrarVehiculoTagAsignado() {
	    EstacionPeaje estacion = new EstacionPeaje();
	    Conductor conductor = new Conductor("0912345678", "Juan", "Pérez");
	    Vehiculo vehiculo = estacion.registrarVehiculo("ABC-1234", "L", conductor, "TAG-001");
	    assertEquals("TAG-001", vehiculo.getTag().getIdTag());
	}
	
	//recarga TAG (4)
	@Test
	public void testRecargarTagValido() {
	    EstacionPeaje estacion = new EstacionPeaje();
	    TagElectronico tag = new TagElectronico("TAG-001");
	    boolean resultado = estacion.recargarTag(10.0, tag);
	    assertTrue(resultado);
	    assertEquals(10.0, tag.getSaldo(), 0.0001);
	}

	@Test
	public void testRecargarTagAcumulado() {
	    EstacionPeaje estacion = new EstacionPeaje();
	    TagElectronico tag = new TagElectronico("TAG-001");
	    estacion.recargarTag(10.0, tag);
	    estacion.recargarTag(5.0, tag);
	    assertEquals(15.0, tag.getSaldo(), 0.0001);
	}

	@Test
	public void testRecargarTagMontoZero() {
	    EstacionPeaje estacion = new EstacionPeaje();
	    TagElectronico tag = new TagElectronico("TAG-001");
	    boolean resultado = estacion.recargarTag(0, tag);
	    assertFalse(resultado);
	    assertEquals(0.0, tag.getSaldo(), 0.0001);
	}

	@Test
	public void testRecargarTagMontoNegativo() {
	    EstacionPeaje estacion = new EstacionPeaje();
	    TagElectronico tag = new TagElectronico("TAG-001");
	    boolean resultado = estacion.recargarTag(-5.0, tag);
	    assertFalse(resultado);
	    assertEquals(0.0, tag.getSaldo(), 0.0001);
	}
	
	//cobrarPeaje (3)
	@Test
	public void testCobrarPeajeLiviano() {
	    EstacionPeaje estacion = new EstacionPeaje();
	    Conductor conductor = new Conductor("0912345678", "Juan", "Pérez");
	    Vehiculo vehiculo = estacion.registrarVehiculo("ABC-1234", "L", conductor, "TAG-001");
	    estacion.recargarTag(5.0, vehiculo.getTag());
	    boolean resultado = estacion.cobrarPeaje(vehiculo);
	    assertTrue(resultado);
	    assertEquals(4.0, vehiculo.getTag().getSaldo(), 0.0001);
	}

	@Test
	public void testCobrarPeajePesado() {
	    EstacionPeaje estacion = new EstacionPeaje();
	    Conductor conductor = new Conductor("0912345678", "Juan", "Pérez");
	    Vehiculo vehiculo = estacion.registrarVehiculo("XYZ-9999", "P", conductor, "TAG-002");
	    estacion.recargarTag(5.0, vehiculo.getTag());
	    boolean resultado = estacion.cobrarPeaje(vehiculo);
	    assertTrue(resultado);
	    assertEquals(2.5, vehiculo.getTag().getSaldo(), 0.0001);
	}

	@Test
	public void testCobrarPeajeSaldoInsuficiente() {
	    EstacionPeaje estacion = new EstacionPeaje();
	    Conductor conductor = new Conductor("0912345678", "Juan", "Pérez");
	    Vehiculo vehiculo = estacion.registrarVehiculo("ABC-1234", "L", conductor, "TAG-001");
	    boolean resultado = estacion.cobrarPeaje(vehiculo);
	    assertFalse(resultado);
	    assertEquals(0.0, vehiculo.getTag().getSaldo(), 0.0001);
	}
	
	//transfeririSaldo (4)
	@Test
	public void testTransferirSaldoValido() {
	    EstacionPeaje estacion = new EstacionPeaje();
	    TagElectronico origen = new TagElectronico("TAG-001");
	    TagElectronico destino = new TagElectronico("TAG-002");
	    estacion.recargarTag(10.0, origen);
	    boolean resultado = estacion.transferirSaldoTag(origen, destino, 4.0);
	    assertTrue(resultado);
	    assertEquals(6.0, origen.getSaldo(), 0.0001);
	    assertEquals(4.0, destino.getSaldo(), 0.0001);
	}

	@Test
	public void testTransferirSaldoExacto() {
	    EstacionPeaje estacion = new EstacionPeaje();
	    TagElectronico origen = new TagElectronico("TAG-001");
	    TagElectronico destino = new TagElectronico("TAG-002");
	    estacion.recargarTag(10.0, origen);
	    boolean resultado = estacion.transferirSaldoTag(origen, destino, 10.0);
	    assertTrue(resultado);
	    assertEquals(0.0, origen.getSaldo(), 0.0001);
	    assertEquals(10.0, destino.getSaldo(), 0.0001);
	}

	@Test
	public void testTransferirSaldoInsuficiente() {
	    EstacionPeaje estacion = new EstacionPeaje();
	    TagElectronico origen = new TagElectronico("TAG-001");
	    TagElectronico destino = new TagElectronico("TAG-002");
	    estacion.recargarTag(5.0, origen);
	    boolean resultado = estacion.transferirSaldoTag(origen, destino, 10.0);
	    assertFalse(resultado);
	    assertEquals(5.0, origen.getSaldo(), 0.0001);
	    assertEquals(0.0, destino.getSaldo(), 0.0001);
	}

	@Test
	public void testTransferirMontoNegativo() {
	    EstacionPeaje estacion = new EstacionPeaje();
	    TagElectronico origen = new TagElectronico("TAG-001");
	    TagElectronico destino = new TagElectronico("TAG-002");
	    estacion.recargarTag(10.0, origen);
	    boolean resultado = estacion.transferirSaldoTag(origen, destino, -5.0);
	    assertFalse(resultado);
	}
	

}
