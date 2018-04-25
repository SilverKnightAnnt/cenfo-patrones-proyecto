package com.cenfotec.patrones.gestores;

import com.cenfotec.patrones.datostxt.ProfesionTexto;
import com.cenfotec.patrones.entidades.Profesion;
import com.cenfotec.patrones.fabricas.FabricaTextos;

public class GestorProfesion {

	public boolean isEmpty() {
		ProfesionTexto profesion_txt = FabricaTextos.crearProfesionTexto();
		boolean isEmpty = profesion_txt.isEmptyTxt();		
		return isEmpty;
	}

	public void getProfesion() {
		ProfesionTexto profesion_txt = FabricaTextos.crearProfesionTexto();
		profesion_txt.showProfesion();
	}

	public Profesion buscarProfesion(Profesion nom_profesion) {
		ProfesionTexto profesion_txt = FabricaTextos.crearProfesionTexto();
		Profesion profesion = profesion_txt.buscarProfesionTxt(nom_profesion);
		return profesion;		
	}
}