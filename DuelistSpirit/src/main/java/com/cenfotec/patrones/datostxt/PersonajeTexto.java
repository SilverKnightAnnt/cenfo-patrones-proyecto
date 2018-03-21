package com.cenfotec.patrones.datostxt;

import java.io.BufferedWriter;

import com.cenfotec.patrones.Personaje;
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
				bWriter.write(unPersonaje.getNombre() + " | " + unPersonaje.getGenero() + " | " + unPersonaje.getRaza()
						+ " | " + unPersonaje.getRol() + " | " + unPersonaje.getProfesion() + " | ");
			} else {
				fWriter = new FileWriter(myFile, true);
				bWriter = new BufferedWriter(fWriter);
				bWriter.write(unPersonaje.getNombre() + " | " + unPersonaje.getGenero() + " | " + unPersonaje.getRaza()
						+ " | " + unPersonaje.getRol() + " | " + unPersonaje.getProfesion() + " | ");
			}
			bWriter.close();
			fWriter.close();
		} catch (IOException e) {
			System.out.println("Error: Revisar PersonajeTexto" + e.getMessage());
		}
	}
}
