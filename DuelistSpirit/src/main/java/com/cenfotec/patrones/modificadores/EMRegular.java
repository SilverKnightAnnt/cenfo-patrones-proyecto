package com.cenfotec.patrones.modificadores;

import com.cenfotec.patrones.enemigoController.Enemy;

public class EMRegular {
	Enemy enemy;

	public EMRegular(Enemy enemy) {
		this.enemy = enemy;
	}

	public String getDescription() {
		return enemy.getDescription();
	}

	public double EnemigoRegualarATK() {
		return 5 + enemy.ataque();
	}

	public double EnemigoRegularVIDA() {
		return 105 + enemy.vida();
	}

}
