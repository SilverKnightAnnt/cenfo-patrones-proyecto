package com.cenfotec.patrones.logica;

public interface Entidad {
	String tipo = "";
	
	public int aumentarVida(int pvida);
	
	public int disminuirVida(int vida);
}
