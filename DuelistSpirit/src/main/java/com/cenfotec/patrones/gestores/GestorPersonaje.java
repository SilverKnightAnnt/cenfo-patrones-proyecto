package com.cenfotec.patrones.gestores;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.cenfotec.patrones.datostxt.PersonajeTexto;
import com.cenfotec.patrones.datostxt.ProfesionTexto;
import com.cenfotec.patrones.entidades.Personaje;

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
	
	public void getPersonaje() {
		PersonajeTexto personaje_txt = new PersonajeTexto();
		personaje_txt.showPersonaje();
	}

	public ArrayList<Personaje> buscarPersonajeUsuario(Personaje pPersonaje) {
		ArrayList<Personaje> lista = new ArrayList<>();
		try {			
			File f = new File("Personaje.txt");
			if (f.exists()) {
				FileReader fReader = new FileReader(f);
				BufferedReader bReader = new BufferedReader(fReader);
				String linea;
				
				while ((linea = bReader.readLine()) != null) {
					String[] personaje = linea.split(" ");
					if (pPersonaje.getUsuario().equals(personaje[0].toString())) {
						String[] datos_personaje = linea.split(" ");
						Personaje pos_personaje = new Personaje(datos_personaje[0], datos_personaje[1],
								datos_personaje[2], datos_personaje[3], datos_personaje[4], datos_personaje[5],
								Integer.parseInt(datos_personaje[6]),Integer.parseInt(datos_personaje[7]),
								Integer.parseInt(datos_personaje[8]), Integer.parseInt(datos_personaje[9]),
								Integer.parseInt(datos_personaje[10]));
						lista.add(pos_personaje);	
					}
				}
				return lista;
			}
		} catch (IOException e) {
			e.getMessage();
		}
		return lista;
		
	}
	public ArrayList<Personaje> buscarPersonajeNombre(Personaje pPersonaje) {
		ArrayList<Personaje> lista = new ArrayList<>();
		try {			
			File f = new File("Personaje.txt");
			if (f.exists()) {
				FileReader fReader = new FileReader(f);
				BufferedReader bReader = new BufferedReader(fReader);
				String linea;
				
				while ((linea = bReader.readLine()) != null) {
					String[] personaje = linea.split(" ");
					if (pPersonaje.getNombre().equals(personaje[1].toString())) {
						String[] datos_personaje = linea.split(" ");
						Personaje pos_personaje = new Personaje(datos_personaje[0], datos_personaje[1],
								datos_personaje[2], datos_personaje[3], datos_personaje[4], datos_personaje[5],
								Integer.parseInt(datos_personaje[6]),Integer.parseInt(datos_personaje[7]),
								Integer.parseInt(datos_personaje[8]), Integer.parseInt(datos_personaje[9]),
								Integer.parseInt(datos_personaje[10]));
						lista.add(pos_personaje);	
					}
				}
				return lista;
			}
		} catch (IOException e) {
			e.getMessage();
		}
		return lista;
		
	}

}