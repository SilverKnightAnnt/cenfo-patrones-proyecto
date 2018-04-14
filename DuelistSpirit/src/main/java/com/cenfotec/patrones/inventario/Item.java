package com.cenfotec.patrones.inventario;

public abstract class Item {
	String description = "Item desconocido";

	public String getDescription() {
		return description;
	}

	public abstract double vida();

	public abstract double ataque();

}
