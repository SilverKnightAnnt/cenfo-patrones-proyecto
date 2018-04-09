package com.cenfotec.patrones.gestores;

import java.io.*;

import com.cenfotec.patrones.datostxt.UsuarioTexto;
import com.cenfotec.patrones.entidades.Usuario;
import com.cenfotec.patrones.fabricas.FabricaTextos;

public class GestorUsuario {
	
	public void crearCuenta(Usuario pUsuario) {
		UsuarioTexto dataUsuario = FabricaTextos.crearUsuarioTexto();
		dataUsuario.añadirUsuario(pUsuario);

	}
	
	public boolean iniciarSesion(Usuario pUsuario) {
		boolean encontrado = false;
		try {
			File file = new File("Usuario.txt");
			if(file.exists()) {
				FileReader fReader = new FileReader(file);
				BufferedReader bReader = new BufferedReader(fReader);
				String linea;
				
				while ((linea = bReader.readLine()) != null) {
					String[] usuario = linea.split(" ");
					if (pUsuario.getNombreUsuario().equals(usuario[1]) && 
							pUsuario.getContrasenna().equals(usuario[2])) {
						encontrado = true;
					}
				}
				bReader.close();
			}			

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return encontrado;
	}	
	
	public boolean isEmpty() {
		boolean isEmpty = false;
		File f = new File("Usuario.txt");
		if (f.exists()) {
			isEmpty = true;
		}
		return isEmpty;
	}
	
}
