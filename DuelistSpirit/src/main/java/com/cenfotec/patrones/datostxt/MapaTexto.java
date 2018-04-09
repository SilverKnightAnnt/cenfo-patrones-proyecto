package com.cenfotec.patrones.datostxt;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class MapaTexto {

	public String[][] obtenerMapaBase() {
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
					String[] datosMapa = linea.split(" ");
					for (int i = 0; i < datosMapa.length; i++) {
						String value = datosMapa[i];
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

	int auto = 1;
	ArrayList<String> lista = new ArrayList<>();

	public ArrayList<String> listaPartidas(String pNombrePersonaje) {
		File myFile = new File("Mapa" + pNombrePersonaje + "(" + auto + ")" + ".txt");
		if (myFile.exists()) {
			auto++;
			lista.add(myFile.getName().substring(0, myFile.getName().length() - 4));
			this.listaPartidas(pNombrePersonaje);
		} else {
			return null;
		}
		return lista;

	}

	public String[][] cargarPartida(String pNombrePersonaje, int partida) {
		String[][] mapa = new String[5][5];
		try {
			File myFile = new File("Mapa" + pNombrePersonaje + "(" + partida + ")" + ".txt");
			if (myFile.exists()) {
				FileReader fReader = new FileReader(myFile);
				BufferedReader bReader = new BufferedReader(fReader);
				String linea;

				int x = 0;
				int y = 0;
				while ((linea = bReader.readLine()) != null) {
					String[] datosMapa = linea.split(" ");
					for (int i = 0; i < datosMapa.length; i++) {
						String value = datosMapa[i];
						mapa[x][y] = value;
						y++;
					}
					y = 0;
					x++;
				}
			} else {
				return null;
			}

		} catch (Exception e) {
			e.getMessage();
		}
		return mapa;
	}

	public void guardadoPartida(String pNombrePersonaje, String[][] pMapaGenerado) {

		try {
			File myFile = new File("Mapa" + pNombrePersonaje + "(" + auto + ")" + ".txt");
			FileWriter fWriter;
			BufferedWriter bWriter;
			if (myFile.exists()) {
				auto++;
				this.guardadoPartida(pNombrePersonaje, pMapaGenerado);
			} else {
				myFile = new File("Mapa" + pNombrePersonaje + "(" + auto + ")" + ".txt");
				fWriter = new FileWriter(myFile, true);
				bWriter = new BufferedWriter(fWriter);
				for (int k = 0; k < pMapaGenerado.length; k++) {
					for (int j = 0; j < pMapaGenerado[k].length; j++) {
						bWriter.write(pMapaGenerado[k][j] + " ");
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
