package com.cenfotec.patrones.datostxt;

import com.cenfotec.patrones.entidades.Personaje;

import java.io.*;
import java.util.ArrayList;

public class PersonajeTexto {
	
	public boolean isEmptyTxt() {
		boolean isEmpty = false;
		File f = new File("Personaje.txt");
		if (f.exists()) {
			isEmpty = true;
		}
		return isEmpty;
	}
	
	public void addPersonaje(Personaje unPersonaje) {
		try {
			File myFile = new File("Personaje.txt");
			FileWriter fWriter;
			BufferedWriter bWriter;

			if (myFile.exists()) {
				fWriter = new FileWriter(myFile, true);
				bWriter = new BufferedWriter(fWriter);
				bWriter.newLine();
				bWriter.write(unPersonaje.getUsuario() + " " + unPersonaje.getNombre() + " "
						+ unPersonaje.getGenero() + " " + unPersonaje.getRaza() + " " + unPersonaje.getRol() + " "
						+ unPersonaje.getProfesion() + " " + unPersonaje.getHp_max() + " "
						+ unPersonaje.getHp_actual() + " " + unPersonaje.getAtk() + " " + unPersonaje.getNivel()
						+ " " + unPersonaje.getExp() + " ");
			} else {
				fWriter = new FileWriter(myFile, true);
				bWriter = new BufferedWriter(fWriter);
				bWriter.write(unPersonaje.getUsuario() + " " + unPersonaje.getNombre() + " "
						+ unPersonaje.getGenero() + " " + unPersonaje.getRaza() + " " + unPersonaje.getRol() + " "
						+ unPersonaje.getProfesion() + " " + unPersonaje.getHp_max() + " "
						+ unPersonaje.getHp_actual() + " " + unPersonaje.getAtk() + " " + unPersonaje.getNivel()
						+ " " + unPersonaje.getExp() + " ");
			}
			bWriter.close();
			fWriter.close();
		} catch (IOException e) {
			System.out.println("Error: Revisar PersonajeTexto" + e.getMessage());
		}
	}

	public void showPersonaje() {
		try {
			File myFile = new File("Personaje.txt");
			if (myFile.exists()) {
				FileReader fReader = new FileReader(myFile);
				BufferedReader bReader = new BufferedReader(fReader);
				String linea;

				while ((linea = bReader.readLine()) != null) {
					String[] datos_personaje = linea.split(" ");
					Personaje pos_personaje = new Personaje(datos_personaje[0], datos_personaje[1],
							datos_personaje[2], datos_personaje[3], datos_personaje[4], datos_personaje[5],
							Integer.parseInt(datos_personaje[6]),Integer.parseInt(datos_personaje[7]),
							Integer.parseInt(datos_personaje[8]), Integer.parseInt(datos_personaje[9]),
							Integer.parseInt(datos_personaje[10]));
					pos_personaje.toString();
				}
				bReader.close();
			}
		} catch (Exception e) {
			e.getMessage();
		}
	}
	
	public ArrayList<Personaje> buscarPersonajeUsuarioTxt(Personaje pPersonaje) {
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
	
	public ArrayList<Personaje> buscarPersonajeNombreTxt(Personaje pPersonaje) {
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