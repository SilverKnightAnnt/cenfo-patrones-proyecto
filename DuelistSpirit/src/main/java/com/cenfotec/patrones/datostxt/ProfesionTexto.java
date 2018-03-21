package com.cenfotec.patrones.datostxt;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import com.cenfotec.patrones.Profesion;

public class ProfesionTexto {
	public void showProfesion() {
		try {
			File myFile = new File("Profesion.txt");
			if (myFile.exists()) {
				FileReader fReader = new FileReader(myFile);
				BufferedReader bReader = new BufferedReader(fReader);
				String linea;

				while ((linea = bReader.readLine()) != null) {
					String[] datos_profesion = linea.split(" ");
					Profesion profesion = new Profesion(Integer.parseInt(datos_profesion[0]), datos_profesion[1]);
					profesion.imprimirProfesion();
				}
			}
		} catch (Exception e) {
			e.getMessage();
		}
	}

}
