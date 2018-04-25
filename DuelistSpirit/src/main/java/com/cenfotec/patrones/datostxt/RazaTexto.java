package com.cenfotec.patrones.datostxt;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import com.cenfotec.patrones.entidades.Raza;

public class RazaTexto {
	
	public boolean isEmptyTxt() {
		boolean isEmpty = false;
		File f = new File("Raza.txt");
		if (f.exists()) {
			isEmpty = true;
		}
		return isEmpty;
	}

	public void showRaza() {
		try {
			File myFile = new File("Raza.txt");
			if (myFile.exists()) {
				FileReader fReader = new FileReader(myFile);
				BufferedReader bReader = new BufferedReader(fReader);
				String linea;

				while ((linea = bReader.readLine()) != null) {
					String[] datos_raza = linea.split(" ");
					Raza raza = new Raza(Integer.parseInt(datos_raza[0]), datos_raza[1],
							Integer.parseInt(datos_raza[2]), Integer.parseInt(datos_raza[3]));
					raza.imprimirRaza();
				}
				bReader.close();
			}
		} catch (Exception e) {
			e.getMessage();
		}
	}
	
	public Raza buscarRazaTxt(Raza nom_raza) {
		try {
			File f = new File("Raza.txt");
			if (f.exists()) {
				FileReader fReader = new FileReader(f);
				BufferedReader bReader = new BufferedReader(fReader);
				String linea;

				while ((linea = bReader.readLine()) != null) {
					String[] raza = linea.split(" ");
					if (nom_raza.getId_raza() == Integer.parseInt(raza[0])) {
						String[] datos_raza = linea.split(" ");
						Raza pos_raza = new Raza(Integer.parseInt(datos_raza[0]), datos_raza[1],
								Integer.parseInt(datos_raza[2]), Integer.parseInt(datos_raza[3]));
						return pos_raza;
					}
				}
			}
		} catch (IOException e) {
			e.getMessage();
		}
		return nom_raza;
	}
}