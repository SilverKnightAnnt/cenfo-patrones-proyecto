package com.cenfotec.patrones.gestores;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import com.cenfotec.patrones.datostxt.RolTexto;
import com.cenfotec.patrones.entidades.Rol;
import com.cenfotec.patrones.fabricas.FabricaTextos;

public class GestorRol {
	public boolean isEmpty() {
		boolean isEmpty = false;
		File f = new File("Rol.txt");
		if (f.exists()) {
			isEmpty = true;
		}
		return isEmpty;
	}

	public void getRol() {
		RolTexto rol_txt = FabricaTextos.crearRolTexto();
		rol_txt.showRol();
	}

	public Rol buscarRol(Rol nom_rol) {
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