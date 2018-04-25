package com.cenfotec.patrones.entidades;

public class Raza {
	private int id_raza;
	private String nombre;
	private int hp;
	private int atk;

	public Raza() {

	}

	public Raza(int id_raza, String nombre, int hp, int atk) {
		super();
		this.id_raza = id_raza;
		this.nombre = nombre;
		this.hp = hp;
		this.atk = atk;
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

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getAtk() {
		return atk;
	}

	public void setAtk(int atk) {
		this.atk = atk;
	}

	public void imprimirRaza() {
		System.out.println(id_raza + " " + nombre);
	}

}
