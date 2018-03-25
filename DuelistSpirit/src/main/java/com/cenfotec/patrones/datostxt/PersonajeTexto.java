package com.cenfotec.patrones.datostxt;

import com.cenfotec.patrones.entidades.Personaje;

import java.io.*;

public class PersonajeTexto {
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
			}
		} catch (Exception e) {
			e.getMessage();
		}
	}
}