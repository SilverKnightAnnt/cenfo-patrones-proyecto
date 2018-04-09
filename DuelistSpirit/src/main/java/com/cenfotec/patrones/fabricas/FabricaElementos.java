package com.cenfotec.patrones.fabricas;


import com.cenfotec.patrones.entidades.*;

public class FabricaElementos {

	public static Personaje crearPersonaje() {		
		return new Personaje();		
	}
	
	public static Usuario crearUsuario() {
		return new Usuario();
	}
	
	public static Raza crearRaza() {
		return new Raza();
	}
	
	public static Rol crearRol() {
		return new Rol();
	}
	
	public static Profesion crearProfesion() {
		return new Profesion();
	}
}

