package com.cenfotec.patrones.gestores;

import java.util.ArrayList;
import com.cenfotec.patrones.datostxt.PersonajeTexto;
import com.cenfotec.patrones.entidades.Personaje;
import com.cenfotec.patrones.fabricas.FabricaTextos;

public class GestorPersonaje {
	public GestorPersonaje() {
	}

	public void creacionPersonaje(Personaje personaje) {
		PersonajeTexto dataPersonaje = FabricaTextos.crearPersonajeTexto();
		dataPersonaje.addPersonaje(personaje);
	}

	public boolean isEmpty() {
		PersonajeTexto personaje_txt = FabricaTextos.crearPersonajeTexto();
		boolean isEmpty = personaje_txt.isEmptyTxt();		
		return isEmpty;
	}
	
	public void getPersonaje() {
		PersonajeTexto personaje_txt = FabricaTextos.crearPersonajeTexto();
		personaje_txt.showPersonaje();
	}

	public ArrayList<Personaje> buscarPersonajeUsuario(Personaje pPersonaje) {
		PersonajeTexto personaje_txt = FabricaTextos.crearPersonajeTexto();
		ArrayList<Personaje> lista = personaje_txt.buscarPersonajeUsuarioTxt(pPersonaje);
		return lista;
	}
	public ArrayList<Personaje> buscarPersonajeNombre(Personaje pPersonaje) {
		PersonajeTexto personaje_txt = FabricaTextos.crearPersonajeTexto();
		ArrayList<Personaje> lista = personaje_txt.buscarPersonajeNombreTxt(pPersonaje);		
		return lista;		
	}
}