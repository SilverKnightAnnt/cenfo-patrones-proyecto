package com.cenfotec.patrones.gestores;

import java.io.File;

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
	
	public void getMapa() {
		MapaTexto mapa_txt = new MapaTexto();
		mapa_txt.showMapa();
	}
}
