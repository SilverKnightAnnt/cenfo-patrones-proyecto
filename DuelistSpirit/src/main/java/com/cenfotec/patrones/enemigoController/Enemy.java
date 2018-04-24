package com.cenfotec.patrones.enemigoController;

public abstract class Enemy {
	protected String description = "Enemigo desconocido";
	
	public String getDescription() {
		return description;
	}
	
	public abstract double vida();

	public abstract double ataque();
}
