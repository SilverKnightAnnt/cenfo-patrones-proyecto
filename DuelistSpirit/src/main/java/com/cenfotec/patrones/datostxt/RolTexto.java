package com.cenfotec.patrones.datostxt;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import com.cenfotec.patrones.entidades.Rol;


public class RolTexto {

	public void showRol() {
		try {
			File myFile = new File("Rol.txt");
			if (myFile.exists()) {
				FileReader fReader = new FileReader(myFile);
				BufferedReader bReader = new BufferedReader(fReader);
				String linea;

				while ((linea = bReader.readLine()) != null) {
					String[] datos_rol = linea.split(" ");
					Rol rol = new Rol(Integer.parseInt(datos_rol[0]), datos_rol[1]);
					rol.imprimirRol();
				}
				bReader.close();
			}
		} catch (Exception e) {
			e.getMessage();
		}
	}

}