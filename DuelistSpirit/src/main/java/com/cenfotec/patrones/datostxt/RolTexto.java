package com.cenfotec.patrones.datostxt;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import com.cenfotec.patrones.entidades.Rol;


public class RolTexto {
	
	public boolean isEmptyTxt() {
		boolean isEmpty = false;
		File f = new File("Rol.txt");
		if (f.exists()) {
			isEmpty = true;
		}
		return isEmpty;
	}

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
	
	public Rol buscarRolTxt(Rol nom_rol) {
		try {
			File f = new File("Rol.txt");
			if (f.exists()) {
				FileReader fReader = new FileReader(f);
				BufferedReader bReader = new BufferedReader(fReader);
				String linea;

				while ((linea = bReader.readLine()) != null) {
					String[] rol = linea.split(" ");
					if (nom_rol.getId_rol() == Integer.parseInt(rol[0])) {
						String[] datos_rol = linea.split(" ");
						Rol pos_rol = new Rol(Integer.parseInt(datos_rol[0]), datos_rol[1]);
						return pos_rol;
					}
				}
				
			}
		} catch (IOException e) {
			e.getMessage();
		}
		return nom_rol;
	}
}