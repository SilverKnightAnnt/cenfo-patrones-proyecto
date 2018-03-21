package com.cenfotec.patrones;

public class Profesion {

	private int id_profesion;
	private String nombreProfesion;

	public Profesion() {

	}

	public Profesion(int id_profesion, String nombreProfesion) {
		super();
		this.id_profesion = id_profesion;
		this.nombreProfesion = nombreProfesion;
	}

	public int getId_profesion() {
		return id_profesion;
	}

	public void setId_profesion(int id_profesion) {
		this.id_profesion = id_profesion;
	}

	public String getNombreProfesion() {
		return nombreProfesion;
	}

	public void setNombreProfesion(String nombreProfesion) {
		this.nombreProfesion = nombreProfesion;
	}

	public void imprimirProfesion() {
		System.out.println(id_profesion + " " + nombreProfesion);
	}

}
