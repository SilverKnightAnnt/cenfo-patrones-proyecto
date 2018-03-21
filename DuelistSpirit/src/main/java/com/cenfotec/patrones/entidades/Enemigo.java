package com.cenfotec.patrones.entidades;

public class Enemigo {
	private String tipo;
	private int hp_max;
	private int hp_actual;
	private int atk;
	private int exp_drop;

	public Enemigo() {

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

	public int getExp_drop() {
		return exp_drop;
	}

	public void setExp_drop(int exp_drop) {
		this.exp_drop = exp_drop;
	}

}
