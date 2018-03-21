package com.cenfotec.patrones.gestores;

import java.io.File;

import com.cenfotec.patrones.Personaje;
import com.cenfotec.patrones.datostxt.PersonajeTexto;

public class GestorPersonaje {
	public GestorPersonaje() {

	}

	public void creacionPersonaje(Personaje personaje) {
		PersonajeTexto dataPersonaje = new PersonajeTexto();
		dataPersonaje.addPersonaje(personaje);

	}

	public boolean isEmpty() {
		boolean isEmpty = false;
		File f = new File("Personaje.txt");
		if (f.exists()) {
			isEmpty = true;
		}
		return isEmpty;
	}

}
