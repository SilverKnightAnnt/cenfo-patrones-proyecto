package com.cenfotec.patrones.gestores;

import com.cenfotec.patrones.datostxt.RazaTexto;
import com.cenfotec.patrones.entidades.Raza;
import com.cenfotec.patrones.fabricas.FabricaTextos;

public class GestorRaza {
	
	public boolean isEmpty() {
		RazaTexto raza_txt = FabricaTextos.crearRazaTexto();
		boolean isEmpty = raza_txt.isEmptyTxt();		
		return isEmpty;
	}

	public void getRaza() {
		RazaTexto raza_txt = FabricaTextos.crearRazaTexto();
		raza_txt.showRaza();
	}

	public Raza buscarRaza(Raza nom_raza) {
		RazaTexto raza_txt = FabricaTextos.crearRazaTexto();
		Raza raza = raza_txt.buscarRazaTxt(nom_raza);
		return raza;		
	}
}