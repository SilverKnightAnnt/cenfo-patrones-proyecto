package com.cenfotec.patrones.enemigo;

import com.cenfotec.patrones.enemigoController.Enemy;

public class EnemigoLegendario extends Enemy {
	public EnemigoLegendario() {
		description = "Enemigo Legendario";
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
