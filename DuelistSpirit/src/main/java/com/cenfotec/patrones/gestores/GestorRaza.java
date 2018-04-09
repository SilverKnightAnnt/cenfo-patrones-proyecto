package com.cenfotec.patrones.gestores;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import com.cenfotec.patrones.datostxt.RazaTexto;
import com.cenfotec.patrones.entidades.Raza;
import com.cenfotec.patrones.fabricas.FabricaTextos;

public class GestorRaza {
	public boolean isEmpty() {
		boolean isEmpty = false;
		File f = new File("Raza.txt");
		if (f.exists()) {
			isEmpty = true;
		}
		return isEmpty;
	}

	public void getRaza() {
		RazaTexto raza_txt = FabricaTextos.crearRazaTexto();
		raza_txt.showRaza();
	}

	public Raza buscarRaza(Raza nom_raza) {
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
						Raza pos_raza = new Raza(Integer.parseInt(datos_raza[0]), datos_raza[1]);
						return pos_raza;
					}
					bReader.close();
				}
			}
		} catch (IOException e) {
			e.getMessage();
		}
		return nom_raza;
	}
}