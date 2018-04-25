package com.cenfotec.patrones.datostxt;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import com.cenfotec.patrones.entidades.Profesion;

public class ProfesionTexto {

	public boolean isEmptyTxt() {
		boolean isEmpty = false;
		File f = new File("Profesion.txt");
		if (f.exists()) {
			isEmpty = true;
		}
		return isEmpty;
	}

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
				bReader.close();
			}
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public Profesion buscarProfesionTxt(Profesion nom_profesion) {
		try {
			File f = new File("Profesion.txt");
			if (f.exists()) {
				FileReader fReader = new FileReader(f);
				BufferedReader bReader = new BufferedReader(fReader);
				String linea;

				while ((linea = bReader.readLine()) != null) {
					String[] profesion = linea.split(" ");
					if (nom_profesion.getId_profesion() == Integer.parseInt(profesion[0])) {
						String[] datos_profesion = linea.split(" ");
						Profesion pos_profesion = new Profesion(Integer.parseInt(datos_profesion[0]),
								datos_profesion[1]);
						return pos_profesion;
					}
				}
			}
		} catch (IOException e) {
			e.getMessage();
		}
		return nom_profesion;
	}
}