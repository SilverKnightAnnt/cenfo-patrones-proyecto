package com.cenfotec.patrones.datostxt;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import com.cenfotec.patrones.entidades.Personaje;

public class MapaTexto {

	public String[][] obtenerMapaBase() {
		String[][] mapa = null;
		try {
			File myFile = new File("Mapa.txt");
			mapa = obtenerMapaACargar(myFile);

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
		String[][] mapa = null;
		try {
			File myFile = new File("Mapa" + pNombrePersonaje + "(" + partida + ")" + ".txt");
			mapa = obtenerMapaACargar(myFile);

		} catch (Exception e) {
			e.getMessage();
		}
		return mapa;
	}

	public String[][] obtenerMapaACargar(File pFile) {
		String[][] mapa = new String[21][21];
		try {
			if (pFile.exists()) {
				FileReader fReader = new FileReader(pFile);
				BufferedReader bReader = new BufferedReader(fReader);
				String linea;

				int x = 0;
				int y = 0;
				while ((linea = bReader.readLine()) != null) {
					String[] datosMapa = linea.split("\t");
					for (int i = 0; i < datosMapa.length; i++) {
						String value = datosMapa[i];
						mapa[x][y] = value;
						y++;
					}
					y = 0;
					x++;
				}
				bReader.close();
			}

		} catch (Exception e) {
			e.getMessage();
		}
		return mapa;
	}

	public Personaje cargarEstatusPersonaje(String pNombrePersonaje, int partida) {
		Personaje personajeEncontrado = null;
		try {
			File myFile = new File(pNombrePersonaje + "(" + partida + ")" + ".txt");
			if (myFile.exists()) {
				FileReader fReader = new FileReader(myFile);
				BufferedReader bReader = new BufferedReader(fReader);
				String linea;

				while ((linea = bReader.readLine()) != null) {
					String[] datos_personaje = linea.split(" ");
					Personaje pos_personaje = new Personaje(datos_personaje[0], datos_personaje[1], datos_personaje[2],
							datos_personaje[3], datos_personaje[4], datos_personaje[5],
							Integer.parseInt(datos_personaje[6]), Integer.parseInt(datos_personaje[7]),
							Integer.parseInt(datos_personaje[8]), Integer.parseInt(datos_personaje[9]),
							Integer.parseInt(datos_personaje[10]));
					personajeEncontrado = pos_personaje;
				}
			}
		} catch (Exception e) {
			e.getMessage();
		}
		return personajeEncontrado;
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
						bWriter.write(pMapaGenerado[k][j] + "\t");
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

	public void guardadoPersonaje(Personaje pPersonaje) {

		try {
			File myFile = new File(pPersonaje.getNombre() + "(" + auto + ")" + ".txt");
			FileWriter fWriter;
			BufferedWriter bWriter;
			if (myFile.exists()) {
				auto++;
				this.guardadoPersonaje(pPersonaje);
			} else {
				fWriter = new FileWriter(myFile, true);
				bWriter = new BufferedWriter(fWriter);
				bWriter.write(pPersonaje.getUsuario() + " " + pPersonaje.getNombre() + " " + pPersonaje.getGenero()
						+ " " + pPersonaje.getRaza() + " " + pPersonaje.getRol() + " " + pPersonaje.getProfesion() + " "
						+ pPersonaje.getHp_max() + " " + pPersonaje.getHp_actual() + " " + pPersonaje.getAtk() + " "
						+ pPersonaje.getNivel() + " " + pPersonaje.getExp() + " ");

				bWriter.close();
				fWriter.close();
			}

		} catch (IOException e) {
			System.out.println("Error: Revisar MapaTexto" + e.getMessage());
		}
	}
}
