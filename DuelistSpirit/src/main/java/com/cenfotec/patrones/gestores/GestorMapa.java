package com.cenfotec.patrones.gestores;

import java.io.File;
import java.util.ArrayList;

import com.cenfotec.patrones.datostxt.MapaTexto;

public class GestorMapa {

	public boolean isEmpty() {
		boolean isEmpty = false;
		File f = new File("Mapa.txt");
		if (f.exists()) {
			isEmpty = true;
		}
		return isEmpty;
	}

	public String[][] obtenerMapaBase() {
		MapaTexto mapa_txt = new MapaTexto();
		String[][] mapa = mapa_txt.obtenerMapaBase();
		return mapa;
	}

	public String[][] cargarPartida(String pNombrePersonaje, int pPartida) {
		MapaTexto mapa_txt = new MapaTexto();
		String[][] mapa = mapa_txt.cargarPartida(pNombrePersonaje, pPartida);
		return mapa;
	}

	public ArrayList<String> listarCargasDisponibles(String pNombrePersonaje) {
		MapaTexto mapa_txt = new MapaTexto();
		ArrayList<String> listaCargas = mapa_txt.listaPartidas(pNombrePersonaje);
		return listaCargas;
	}

	public void guardarPartida(String pNombrePersonaje, String[][] pMapaGenerado) {
		MapaTexto mapa_txt = new MapaTexto();
		mapa_txt.guardadoPartida(pNombrePersonaje, pMapaGenerado);
	}
}
