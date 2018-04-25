package com.cenfotec.patrones.gestores;

import com.cenfotec.patrones.datostxt.RolTexto;
import com.cenfotec.patrones.entidades.Rol;
import com.cenfotec.patrones.fabricas.FabricaTextos;

public class GestorRol {
	public boolean isEmpty() {
		RolTexto rol_txt = FabricaTextos.crearRolTexto();
		boolean isEmpty = rol_txt.isEmptyTxt();		
		return isEmpty;
	}

	public void getRol() {
		RolTexto rol_txt = FabricaTextos.crearRolTexto();
		rol_txt.showRol();
	}

	public Rol buscarRol(Rol nom_rol) {
		RolTexto rol_txt = FabricaTextos.crearRolTexto();
		Rol rol = rol_txt.buscarRolTxt(nom_rol);
		return rol;		
	}
}