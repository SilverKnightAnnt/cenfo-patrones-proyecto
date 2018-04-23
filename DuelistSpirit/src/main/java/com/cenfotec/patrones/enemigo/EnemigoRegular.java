package com.cenfotec.patrones.enemigo;

import com.cenfotec.patrones.enemigoController.Enemy;

public class EnemigoRegular extends Enemy {
	public EnemigoRegular() {
		description = "Enemigo Regular";
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
