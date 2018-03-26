package com.cenfotec.patrones.gestores;

import java.io.File;
import java.time.LocalDate;
import java.time.LocalDateTime;

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
	
	public String[][] getMapa() {
		MapaTexto mapa_txt = new MapaTexto();
		String[][] mapa = mapa_txt.showMapa();
		return mapa;
	}
	
	public void guardado(String pNombrePersonaje) {
		MapaTexto mapa_txt = new MapaTexto();
		mapa_txt.guardadoPartida(pNombrePersonaje);
	}
}
