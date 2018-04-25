package com.cenfotec.patrones.gestores;

import com.cenfotec.patrones.datostxt.UsuarioTexto;
import com.cenfotec.patrones.entidades.Usuario;
import com.cenfotec.patrones.fabricas.FabricaTextos;

public class GestorUsuario {

	public void crearCuenta(Usuario pUsuario) {
		UsuarioTexto dataUsuario = FabricaTextos.crearUsuarioTexto();
		dataUsuario.añadirUsuario(pUsuario);
	}

	public boolean iniciarSesion(Usuario pUsuario) {
		UsuarioTexto dataUsuario = FabricaTextos.crearUsuarioTexto();
		boolean encontrado = dataUsuario.iniciarSesionTxt(pUsuario);
		return encontrado;
	}

	public boolean isEmpty() {
		UsuarioTexto dataUsuario = FabricaTextos.crearUsuarioTexto();
		boolean isEmpty = dataUsuario.isEmptyTxt();
		return isEmpty;
	}
}
