package com.cenfotec.patrones.datostxt;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import com.cenfotec.patrones.entidades.Raza;



public class RazaTexto {


	public void showRaza() {
		try {
			File myFile = new File("Raza.txt");
			if (myFile.exists()) {
				FileReader fReader = new FileReader(myFile);
				BufferedReader bReader = new BufferedReader(fReader);
				String linea;

				while ((linea = bReader.readLine()) != null) {
					String[] datos_raza = linea.split(" ");
					Raza raza = new Raza(Integer.parseInt(datos_raza[0]), datos_raza[1]);
					raza.imprimirRaza();

				}
			}
		} catch (Exception e) {
			e.getMessage();
		}
	}

}