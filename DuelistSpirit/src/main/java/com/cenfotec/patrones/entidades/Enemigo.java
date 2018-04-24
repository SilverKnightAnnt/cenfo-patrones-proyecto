package com.cenfotec.patrones.entidades;

abstract public class Enemigo {

	private String tipo;
	private int hp_max, hp_actual, atk;

	public Enemigo() {

	}

	public Enemigo(String tipo, int hp_max, int hp_actual, int atk) {
		this.tipo = tipo;
		this.hp_max = hp_max;
		this.hp_actual = hp_actual;
		this.atk = atk;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
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

	public void quitarVida(int valorRemovido) {
		hp_actual = hp_actual - valorRemovido;
	}

}
