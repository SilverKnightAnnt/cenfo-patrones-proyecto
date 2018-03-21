package com.cenfotec.patrones.entidades;

public class Raza {
	private int id_raza;
	private String nombre;

	public Raza() {

	}

	public Raza(int id_raza, String nombre) {
		super();
		this.id_raza = id_raza;
		this.nombre = nombre;
	}

	public int getId_raza() {
		return id_raza;
	}

	public void setId_raza(int id_raza) {
		this.id_raza = id_raza;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void imprimirRaza() {
		System.out.println(id_raza + " " + nombre);
	}

}
