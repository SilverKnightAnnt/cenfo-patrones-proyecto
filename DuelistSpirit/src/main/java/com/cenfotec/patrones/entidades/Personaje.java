package com.cenfotec.patrones.entidades;

public class Personaje {

	static int armadura;
	private String usuario, nombre, genero, raza, rol, profesion;
	private int hp_max, hp_actual, atk, nivel, exp;

	public Personaje() {

	}

	public Personaje(String usuario, String nombre, String genero, String raza, String rol, String profesion,
			int hp_max, int hp_actual, int atk, int nivel, int exp) {
		super();
		this.usuario = usuario;
		this.nombre = nombre;
		this.genero = genero;
		this.raza = raza;
		this.rol = rol;
		this.profesion = profesion;
		this.hp_max = hp_max;
		this.hp_actual = hp_actual;
		this.atk = atk;
		this.nivel = nivel;
		this.exp = exp;
	}

	public void quitarVida(int valorRemovido) {
		hp_actual = hp_actual - valorRemovido;
	}

	public boolean isAlive() {
		if (hp_actual > 0) {
			return true;
		} else
			return false;
	}

	public boolean isDead() {
		if (hp_actual < 0) {
			return true;
		} else
			return false;
	}

	public void agregarInventario(int valorArmadura, int valorArma) {
		hp_actual = hp_actual + valorArmadura;
		armadura = valorArmadura;
		atk = atk + valorArma;
	}

	public void restablecerVida() {
		hp_actual = hp_actual + armadura;

	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public String getProfesion() {
		return profesion;
	}

	public void setProfesion(String profesion) {
		this.profesion = profesion;
	}

	public int getHp_max() {
		return hp_max;
	}

	public void setHp_max(int hp_max) {
		this.hp_max = hp_max;
	}

	public int getHp_actual() {
		return hp_actual;
	}

	public void setHp_actual(int hp_actual) {
		this.hp_actual = hp_actual;
	}

	public int getAtk() {
		return atk;
	}

	public void setAtk(int atk) {
		this.atk = atk;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}

	@Override
	public String toString() {
		return nombre + " " + genero + " " + raza + " " + rol + " " + profesion + " " + nivel;
	}
	
	public String estadisticas() {		
		
		return "\nNombre: " +nombre + 
				"\nGénero: " + genero + 
				"\nRaza: " + raza + 
				"\nRol: " + rol + 
				"\nProfesión: " + profesion + 
				"\nVida actual: " + hp_actual + 
				"\nAtaque: " + atk + 
				"\nNivel: " + nivel +"\n";
	}
}
