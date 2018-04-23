package com.cenfotec.patrones.enemigo;

import com.cenfotec.patrones.enemigoController.Enemy;

public class EnemigoEpico extends Enemy {
	public EnemigoEpico() {
		description = "Enemigo Epico";
	}

	@Override
	public double vida() {

		return 0;
	}

	@Override
	public double ataque() {

		return 0;
	}

}
