package com.cenfotec.patrones.entidades;

public class Usuario {

	private String correo;
	private String nombreUsuario;
	private String contrasenna;
	
	public Usuario(){
		
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getContrasenna() {
		return contrasenna;
	}

	public void setContrasenna(String contrasenna) {
		this.contrasenna = contrasenna;
	}
	
	@Override
    public String toString() {		
        return correo +" "+ nombreUsuario +" "+ contrasenna;
    }
	
	
	
	
}
