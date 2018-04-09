package com.cenfotec.patrones.fabricas;

import com.cenfotec.patrones.datostxt.*;

public class FabricaTextos {
	public static MapaTexto crearMapaTexto() {
		return new MapaTexto();
	}
	public static PersonajeTexto crearPersonajeTexto() {
		return new PersonajeTexto();
	}
	public static ProfesionTexto crearProfesionTexto() {
		return new ProfesionTexto();
	}
	public static RazaTexto crearRazaTexto() {
		return new RazaTexto();
	}
	public static RolTexto crearRolTexto() {
		return new RolTexto();
	}
	public static UsuarioTexto crearUsuarioTexto() {
		return new UsuarioTexto();
	}
}
