package com.cenfotec.patrones.datostxt;

import java.io.*;

import com.cenfotec.patrones.entidades.Usuario;

public class UsuarioTexto {
	
	public boolean isEmptyTxt() {
		boolean isEmpty = false;
		File f = new File("Usuario.txt");
		if (f.exists()) {
			isEmpty = true;
		}
		return isEmpty;
	}

	public void añadirUsuario(Usuario pUsuario) {
		try {
			File myFile = new File("Usuario.txt");
			FileWriter fWriter;
			BufferedWriter bWriter;

			if (myFile.exists()) {
				fWriter = new FileWriter(myFile, true);
				bWriter = new BufferedWriter(fWriter);
				bWriter.newLine();
				bWriter.write(
						pUsuario.getCorreo() + " " + pUsuario.getNombreUsuario() + 
						" " + pUsuario.getContrasenna());
			} else {
				fWriter = new FileWriter(myFile, true);
				bWriter = new BufferedWriter(fWriter);
				bWriter.write(
						pUsuario.getCorreo() + " " + pUsuario.getNombreUsuario() + 
						" " + pUsuario.getContrasenna());
			}
			bWriter.close();
			fWriter.close();
		} catch (IOException e) {
			System.out.println("Error: Revisar UsuarioTexto" + e.getMessage());
		}
	}
	
	public void mostrarUsuario() {
		try {
			File myFile = new File("Usuario.txt");
			if (myFile.exists()) {
				FileReader fReader = new FileReader(myFile);
				BufferedReader bReader = new BufferedReader(fReader);
				String linea;

				while ((linea = bReader.readLine()) != null) {
					String[] datosUsuario = linea.split(" ");
					Usuario usuario = new Usuario();
					usuario.setCorreo(datosUsuario[0]);
					usuario.setNombreUsuario(datosUsuario[1]);
					usuario.setContrasenna(datosUsuario[2]);
					usuario.toString();

				}
				bReader.close();
			}
		} catch (Exception e) {
			e.getMessage();
		}
	}
	
	public boolean iniciarSesionTxt(Usuario pUsuario) {
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
			}			

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return encontrado;
	}	
}
