package com.cenfotec.patrones.datostxt;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;

import com.cenfotec.patrones.entidades.Profesion;

public class MapaTexto {

	public void showMapa() {
		try {

			File myFile = new File("Mapa.txt");
			String[][] mapa = new String[5][5];
			if (myFile.exists()) {
				FileReader fReader = new FileReader(myFile);
				BufferedReader bReader = new BufferedReader(fReader);
				String linea;

				int x = 0;
				int y = 0;
				while ((linea = bReader.readLine()) != null) {
					String[] datos_profesion = linea.split(" ");
					for(int i = 0; i < datos_profesion.length; i++) {
						String value = datos_profesion[i];
						mapa[x][y] = value;
						y++;						
					}
					y = 0;
					x++;
				}
				for (int i = 0; i < mapa.length; i++) {
				    for (int j = 0; j < mapa[i].length; j++) {
				        System.out.print(mapa[i][j] + " ");
				    }
				    System.out.println();
				}
			}

		} catch (Exception e) {
			e.getMessage();
		}
	}
}
