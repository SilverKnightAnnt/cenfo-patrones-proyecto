package com.cenfotec.patrones.datostxt;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class MapaTexto {

	public String[][] showMapa() {
		String[][] mapa = new String[5][5];
		try {
			File myFile = new File("Mapa.txt");
			if (myFile.exists()) {
				FileReader fReader = new FileReader(myFile);
				BufferedReader bReader = new BufferedReader(fReader);
				String linea;

				int x = 0;
				int y = 0;
				while ((linea = bReader.readLine()) != null) {
					String[] datos_profesion = linea.split(" ");
					for (int i = 0; i < datos_profesion.length; i++) {
						String value = datos_profesion[i];
						mapa[x][y] = value;
						y++;
					}
					y = 0;
					x++;
				}
			}

		} catch (Exception e) {
			e.getMessage();
		}
		return mapa;
	}

	static int auto = 1;
	public void guardadoPartida(String pNombrePersonaje) {
		
		try {
			File myFile = new File("Mapa" + pNombrePersonaje + "(" + auto + ")" + ".txt");
			FileWriter fWriter;
			BufferedWriter bWriter;
			if (myFile.exists()) {				
					auto++;					
					this.guardadoPartida(pNombrePersonaje);
			} else {
				myFile = new File("Mapa" + pNombrePersonaje + "(" + auto + ")" + ".txt");
				fWriter = new FileWriter(myFile, true);
				bWriter = new BufferedWriter(fWriter);
				for (int k = 0; k < showMapa().length; k++) {
					for (int j = 0; j < showMapa()[k].length; j++) {
						bWriter.write(showMapa()[k][j] + " ");
					}
					bWriter.newLine();
					
				}
				bWriter.close();
				fWriter.close();
			}

		} catch (

		IOException e) {
			System.out.println("Error: Revisar MapaTexto" + e.getMessage());
		}
	}
}
