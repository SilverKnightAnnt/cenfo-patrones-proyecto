package com.cenfotec.patrones.fabricas;

import com.cenfotec.patrones.gestores.*;

public class FabricaGestores {

	public static GestorMapa crearGestorMapa() {
		return new GestorMapa();
	}
	public static GestorPersonaje crearGestorPersonaje() {
		return new GestorPersonaje();
	}
	public static GestorRol crearGestorRol() {
		return new GestorRol();
	}
	public static GestorProfesion crearGestorProfesion() {
		return new GestorProfesion();
	}
	public static GestorRaza crearGestorRaza() {
		return new GestorRaza();
	}
	public static GestorUsuario crearGestorUsuario() {
		return new GestorUsuario();
	}
	
}
